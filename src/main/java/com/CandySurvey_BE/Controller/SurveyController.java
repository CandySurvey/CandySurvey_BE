package com.CandySurvey_BE.Controller;

import com.google.gson.Gson;
import com.CandySurvey_BE.domain.Item;
import com.CandySurvey_BE.domain.Question;
import com.CandySurvey_BE.domain.Survey;
import com.CandySurvey_BE.service.ItemService;
import com.CandySurvey_BE.service.QuestionService;
import com.CandySurvey_BE.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class SurveyController {
    private final SurveyService surveyService;
    private final QuestionService questionService;
    private final ItemService itemService;

    @PostMapping("/create_survey")
    public void saveSurvey(HttpServletRequest request) throws IOException {
        try{
            ServletInputStream inputStream = request.getInputStream();
            String json = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        }catch(IllegalStateException e){

        }




    }

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
                "\"question\":{\n"; //question List {
        var questionNum=0;
        while(findQuestion.isEmpty()){
           survey = survey +
                   "\"question" + questionNum + "\"" + ":" +
                   "{\n" + //each question {
                   "\"questionTitle\":" + "\"" + findQuestion.get(questionNum).getTitle() + "\"" + ",\n" +
                   "\"questionDetail\":" + "\"" + findQuestion.get(questionNum).getDetail() + "\"" + ",\n" +
                   "\"questionType\":" + "\"" + findQuestion.get(questionNum).getType() + "\"" + ",\n" +
                   "\"Items\"" + ":" +
                   "{\n"; //items {
           List<Item> findItem = itemService.findItemByQuestionId(findQuestion.get(questionNum).getId());
           var itemNum=0;
           while(findItem.isEmpty()) {
               survey = survey +
                       "\"item" + itemNum + "\"" + ":" + "\"" + findItem.get(itemNum).getLine() + "\"" + ",\n";
               findItem.remove(itemNum);
               itemNum++;
           }
           survey = survey + "}\n"; //items }
           questionNum++;
           survey = survey + "}\n"; //each question }
        }
        survey = survey + "}\n"; //question List }
        survey = survey + "}\n"; //survey }

        String json = new Gson().toJson(survey);



        return json;
    }

}

