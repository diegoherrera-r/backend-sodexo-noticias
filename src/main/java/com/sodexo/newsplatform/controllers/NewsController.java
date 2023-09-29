package com.sodexo.newsplatform.controllers;

import com.sodexo.newsplatform.entities.News;
import com.sodexo.newsplatform.interfaces.INewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class NewsController {

    private final INewsService newsService;

    NewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<News>> all() {
        return newsService.findAll();
    }

    @PostMapping("/favorites")
    public ResponseEntity<News> addNews(@RequestBody News news) {
        return newsService.addNews(news);
    }

    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<String> deleteNews(@PathVariable Long id) {
        return newsService.deleteById(id);
    }
}
