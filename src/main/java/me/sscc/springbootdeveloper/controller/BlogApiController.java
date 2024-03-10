package me.sscc.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.sscc.springbootdeveloper.domain.Article;
import me.sscc.springbootdeveloper.dto.request.AddArticleRequest;
import me.sscc.springbootdeveloper.dto.request.UpdateArticleRequest;
import me.sscc.springbootdeveloper.dto.response.ArticleResponse;
import me.sscc.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articleResponseList = blogService.findAll().stream().map(ArticleResponse::new).toList();
        return ResponseEntity.ok(articleResponseList);
    }

    @PatchMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id,@RequestBody UpdateArticleRequest request){
        Article updateArticle = blogService.update(id,request);
        return ResponseEntity.ok(updateArticle);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }
}
