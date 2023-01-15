package com.survey_backend.service;

import com.survey_backend.domain.Item;
import com.survey_backend.repository.ItemRepository;
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
        return itemRepository.findItemByQuestion_id(question_id);
    }

    public void deleteItemsByQuestionId(Long question_id){
        itemRepository.deleteItemsByQuestion_id(question_id);
    }
}
