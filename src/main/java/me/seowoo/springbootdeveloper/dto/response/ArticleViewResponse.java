package me.seowoo.springbootdeveloper.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.seowoo.springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
    }

}
