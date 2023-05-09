package com.example.boardv2.repository;

import com.example.boardv2.config.JpaConfig;
import com.example.boardv2.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("testdb")
@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
        @Autowired ArticleRepository articleRepository,
        @Autowired ArticleCommentRepository articleCommentRepository
    ) {
         this.articleRepository = articleRepository;
         this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        // Given

        // When
        List<Article> articles = articleRepository.findAll();
        // Then
        assertThat(articles)
                .isNotNull()
                .hasSize(0);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {
        // Given
        long previousCount = articleRepository.count();
        // When
        Article savedArticle = articleRepository.save(Article.of("new article", "new content", "#spring"));
        // Then
        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorkFine() {
        // Given
        Article savedArticle = articleRepository.save(Article.of("new article", "new content", "#spring"));
        //Article article = articleRepository.findById(1L).orElseThrow();


        // When
        //savedArticle = articleRepository.save(savedArticle);
        articleRepository.save(savedArticle);
        String updatedHashtag = "#springboot";
        savedArticle.setHashtag(updatedHashtag);
        articleRepository.saveAndFlush(savedArticle);
        // Then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);
    }
}