package com.CandySurvey_BE.service;

import com.CandySurvey_BE.domain.Item;
import com.CandySurvey_BE.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {
    final ItemRepository itemRepository;

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    public List<Item> findItemByQuestionId(Long question_id){
        return itemRepository.findItemByQuestion(question_id);
    }

    public void deleteItemsByQuestionId(Long question_id){
        itemRepository.deleteItemsByQuestion(question_id);
    }
}
