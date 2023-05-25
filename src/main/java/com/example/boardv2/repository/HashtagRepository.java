package com.example.boardv2.repository;

import com.example.boardv2.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface HashtagRepository extends
        JpaRepository<Hashtag, Long>,
        QuerydslPredicateExecutor<Hashtag> {
}
