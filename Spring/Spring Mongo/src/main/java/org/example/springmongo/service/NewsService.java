package org.example.springmongo.service;

import org.bson.types.ObjectId;
import org.example.springmongo.model.News;
import org.example.springmongo.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class NewsService {
    @Autowired
    NewsRepository repo;

    public List<News> getAllNews() {
        return repo.findAll();
    }

    public Optional<News> getNewsById(ObjectId id) {
        return repo.findById(id);
    }

    public News saveNews(News news) {
        news.setDate(LocalDateTime.now());
        return repo.save(news);
    }

    public void deleteNews(ObjectId id) {
        repo.deleteById(id);
    }

    public News updateNews(ObjectId id, News news) {
        Optional<News> newsOptional = repo.findById(id);
        News newNews;
        if (newsOptional.isPresent()) {
            newNews = newsOptional.get();
            newNews.setId(news.getId());
            if(!news.getTitle().isEmpty()) newNews.setTitle(news.getTitle());
            if(!news.getContent().isEmpty()) newNews.setContent(news.getContent());
        }

        return repo.save(news);
    }



}
