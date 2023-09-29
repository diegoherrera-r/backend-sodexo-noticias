package com.sodexo.newsplatform.interfaces;

import com.sodexo.newsplatform.entities.News;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface INewsService {

    ResponseEntity<List<News>> findAll();

    ResponseEntity<News> addNews(News news);

    ResponseEntity<String> deleteById(Long id);
}
