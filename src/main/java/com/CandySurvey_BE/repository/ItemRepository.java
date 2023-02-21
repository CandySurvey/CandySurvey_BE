package com.CandySurvey_BE.repository;

import com.CandySurvey_BE.domain.Item;
import com.CandySurvey_BE.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findItemByQuestion_id(Long question_id);

    void deleteItemsByQuestion_id(Long question_id);
}
