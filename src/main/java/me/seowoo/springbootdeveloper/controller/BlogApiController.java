package me.seowoo.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.seowoo.springbootdeveloper.domain.Article;
import me.seowoo.springbootdeveloper.dto.request.AddArticleRequest;
import me.seowoo.springbootdeveloper.dto.request.UpdateArticleRequest;
import me.seowoo.springbootdeveloper.dto.response.ArticleResponse;
import me.seowoo.springbootdeveloper.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.save(request));
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        return ResponseEntity.ok().body(blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList());
    }

    @GetMapping("/api/article/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        return ResponseEntity.ok().body(new ArticleResponse(blogService.findById(id)));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        return ResponseEntity.ok().body(blogService.update(id, request));
    }

}
