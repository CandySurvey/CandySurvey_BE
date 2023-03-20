package com.CandySurvey_BE.Controller;

import com.CandySurvey_BE.domain.Enum.Required;
import com.CandySurvey_BE.domain.Enum.Type;
import com.CandySurvey_BE.domain.Member;
import com.CandySurvey_BE.service.MemberService;
import com.google.gson.Gson;
import com.CandySurvey_BE.domain.Item;
import com.CandySurvey_BE.domain.Question;
import com.CandySurvey_BE.domain.Survey;
import com.CandySurvey_BE.service.ItemService;
import com.CandySurvey_BE.service.QuestionService;
import com.CandySurvey_BE.service.SurveyService;

import org.json.JSONArray;
import org.json.JSONObject;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/survey")
public class SurveyController {
    private final SurveyService surveyService;
    private final QuestionService questionService;
    private final ItemService itemService;
    private final MemberService memberService;

    //목록

    //survey 저장
    @PostMapping("/survey/create")
    public void saveSurvey(HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();

        Member owner = memberService.findMember(session.getAttribute("email").toString(), session.getAttribute("email").toString());

        try{
            ServletInputStream inputStream = request.getInputStream();
            String json = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

            JSONObject jsonObject = new JSONObject(json);
            String surveyTitle = jsonObject.getString("title");
            String surveyDetail = jsonObject.getString("detail");
            String surveyHash = jsonObject.getString("hash");
            String surveyStatus = jsonObject.getString("status");

            Survey savedSurvey = new Survey(surveyTitle, surveyDetail, surveyHash, owner, surveyStatus);
            surveyService.saveSurvey(savedSurvey);

            JSONArray questions = jsonObject.getJSONArray("questions");
            for(int i=0; i<questions.length(); i++){
                JSONObject question = questions.getJSONObject(i);
                String questionTitle = question.getString("questionTitle");
                String questionDetail = question.getString("questionDetail");
                String questionType = question.getString("questionType");
                String questionRequire = question.getString("questionRequire");

                Question savedQuestion = new Question(questionTitle, questionDetail, Required.valueOf(questionRequire), Type.valueOf(questionType), surveyHash);
                questionService.saveQuestion(savedQuestion);

                JSONArray questionItems = question.getJSONArray("items");
                for(int j=0; j<questionItems.length(); j++){
                    JSONObject item = questionItems.getJSONObject(j);

                    Item savedItem = new Item(item.getString("item"), Long.valueOf(j), savedQuestion.getId());
                    itemService.saveItem(savedItem);
                }
            }
        }catch(IllegalStateException e){

        }
    }

    //survey 불러오기
    @GetMapping("/survey/{code}")
    public String loadSurvey(@RequestParam String code){
        String survey = "";
        Optional<Survey> findSurvey = surveyService.findSurveyByHash(code);
        List<Question> findQuestion = questionService.findQuestionBySurveyHash(code);
        //반복문 이용해서 항목 불러오는 코드 가져오기
        survey = survey + "{ " + //survey {
                "\"surveyTitle\":" + "\"" + findSurvey.get().getTitle() + "\"" + ",\n" +
                "\"surveyDetail\":" + "\"" + findSurvey.get().getDetail() + "\"" + ",\n" +
                "\"surveyType\":" + "\"" + findSurvey.get().getStatus() + "\"" + ",\n" +
                "\"question\":[\n"; //question List {
        var questionNum=0;
        while(findQuestion.isEmpty()){
           survey = survey +
                   "\"question" + "\"" + ":" +
                   "{\n" + //each question {
                   "\"questionTitle\":" + "\"" + findQuestion.get(questionNum).getTitle() + "\"" + ",\n" +
                   "\"questionDetail\":" + "\"" + findQuestion.get(questionNum).getDetail() + "\"" + ",\n" +
                   "\"questionType\":" + "\"" + findQuestion.get(questionNum).getType() + "\"" + ",\n" +
                   "\"Items\"" + ":" +
                   "[\n"; //items {
           List<Item> findItem = itemService.findItemByQuestionId(findQuestion.get(questionNum).getId());
           var itemNum=0;
           while(findItem.isEmpty()) {
               survey = survey +
                       "{\"item" + "\"" + ":" + "\"" + findItem.get(itemNum).getLine() + "\"}" + ",\n";
               findItem.remove(itemNum);
               itemNum++;
           }
           survey = survey + "]\n"; //items }
           questionNum++;
           survey = survey + "}\n"; //each question }
        }
        survey = survey + "]\n"; //question List }
        survey = survey + "}\n"; //survey }

        String json = new Gson().toJson(survey);

        return json;
    }

}

