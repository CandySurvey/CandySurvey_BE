package com.survey_backend.repository;

import com.survey_backend.domain.Item;
import com.survey_backend.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findItemByQuestion_id(Long question_id);
}
