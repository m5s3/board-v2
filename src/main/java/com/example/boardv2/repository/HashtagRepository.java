package com.example.boardv2.repository;

import com.example.boardv2.domain.Hashtag;
import com.example.boardv2.repository.querydsl.HashtagRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RepositoryRestResource
public interface HashtagRepository extends
        JpaRepository<Hashtag, Long>,
        HashtagRepositoryCustom,
        QuerydslPredicateExecutor<Hashtag> {
    List<Hashtag> findByHashtagNameIn(Set<String> hashtagNames);
    Optional<Hashtag> findByHashtagName(String hashtagName);

}
