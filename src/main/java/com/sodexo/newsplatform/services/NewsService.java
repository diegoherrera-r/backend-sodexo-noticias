package com.sodexo.newsplatform.services;

import com.sodexo.newsplatform.dao.INewsRepository;
import com.sodexo.newsplatform.entities.News;
import com.sodexo.newsplatform.interfaces.INewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService implements INewsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsService.class);

    private final INewsRepository newsRepository;

    public NewsService(INewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public ResponseEntity<List<News>> findAll() {
        try {
            List<News> news = (List<News>) newsRepository.findAll();
            if (news.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(news, HttpStatus.OK);
        }
        catch (Exception ex) {
            LOGGER.error("Error en la consulta:: ".concat(ex.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<News> addNews(News news) {
        try {
            Optional<News> optNews = newsRepository.findById((long) news.getId());
            if (optNews.isEmpty()) {
                news.setCreated_at(LocalDateTime.now());
                newsRepository.save(news);
                return new ResponseEntity<>(news,HttpStatus.CREATED);
            }
            else {
                LOGGER.error("Error en la consulta:: Articulo ya existe");
                return new ResponseEntity<>(optNews.get() ,HttpStatus.CONFLICT);
            }
        }
        catch (Exception ex) {
            LOGGER.error("Error en la consulta:: ".concat(ex.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        try {
            Optional<News> optNews = newsRepository.findById(id);
            if (optNews.isPresent()) {
                newsRepository.deleteById(id);
                return new ResponseEntity<>("Articulo eliminado exitosamente",HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("No existe registro del articulo",HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception ex) {
            LOGGER.error("Error en la consulta:: ".concat(ex.getMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
