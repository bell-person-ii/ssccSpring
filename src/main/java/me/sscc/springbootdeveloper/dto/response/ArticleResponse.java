package me.sscc.springbootdeveloper.dto.response;

import lombok.Getter;
import me.sscc.springbootdeveloper.domain.Article;

@Getter
public class ArticleResponse {
    private String title;
    private String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
