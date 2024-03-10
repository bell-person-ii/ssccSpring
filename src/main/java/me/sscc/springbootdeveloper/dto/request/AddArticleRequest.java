package me.sscc.springbootdeveloper.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sscc.springbootdeveloper.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
