package org.example.springmongo.controllers;

import org.bson.types.ObjectId;
import org.example.springmongo.model.News;
import org.example.springmongo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping
    public List<News> getNews() {
        return newsService.getAllNews();
    }

    @GetMapping("{id}")
    public News getNewsById(@PathVariable ObjectId id) {
        return newsService.getNewsById(id).orElse(null);
    }

    @PostMapping
    public News createNews(@RequestBody News news) {
        return newsService.saveNews(news);
    }

    @DeleteMapping("{id}")
    public void deleteNews(@PathVariable ObjectId id) {
        newsService.deleteNews(id);
    }

    @PutMapping("{id}")
    public News updateNews(@PathVariable ObjectId id, @RequestBody News news) {
        return newsService.updateNews(id, news);
    }

}
