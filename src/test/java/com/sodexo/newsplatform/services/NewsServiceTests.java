package com.sodexo.newsplatform.services;

import com.sodexo.newsplatform.dao.INewsRepository;
import com.sodexo.newsplatform.entities.News;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NewsServiceTests {

    @Mock
    private INewsRepository newsRepository;

    @InjectMocks
    private NewsService newsService;

    @Test
    public void NewsService_findAll_ReturnsAllNews() {
        List<News> news = Collections.singletonList(Mockito.mock(News.class));

        when(newsRepository.findAll()).thenReturn(news);

        List<News> savedNews = newsService.findAll().getBody();

        Assertions.assertThat(savedNews).isNotNull();

    }

    @Test
    public void NewsService_addNews_ReturnsNews() {
        News news = News.builder()
                .id(1000)
                .title("title")
                .url("url")
                .image_url("img_url")
                .news_site("site")
                .summary("summary")
                .created_at(LocalDateTime.now())
                .published_at(LocalDateTime.now())
                .updated_at(LocalDateTime.now())
                .featured(false)
                .build();

        when(newsRepository.save(Mockito.any(News.class))).thenReturn(news);

        News savedNews = newsService.addNews(news).getBody();

        Assertions.assertThat(savedNews).isNotNull();
    }

    @Test
    public void NewsService_deleteNewsById_ReturnsNotNull() {
        News news = News.builder()
                .id(1000)
                .title("title")
                .url("url")
                .image_url("img_url")
                .news_site("site")
                .summary("summary")
                .created_at(LocalDateTime.now())
                .published_at(LocalDateTime.now())
                .updated_at(LocalDateTime.now())
                .featured(false)
                .build();

        when(newsRepository.findById(news.getId_article())).thenReturn(Optional.of(news));

        Assertions.assertThat(newsService.deleteById(news.getId_article())).isNotNull();
    }

}
