package me.sscc.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.sscc.springbootdeveloper.domain.Article;
import me.sscc.springbootdeveloper.dto.request.AddArticleRequest;
import me.sscc.springbootdeveloper.dto.request.UpdateArticleRequest;
import me.sscc.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BlogService {

    private final BlogRepository blogRepository;
    @Transactional
    public Article save(AddArticleRequest dto){
        return blogRepository.save(dto.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(Long id){
        return blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("대상 게시글 조회 실패" +id));
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("대상 게시글 조회 실패" +id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }

    @Transactional
    public void delete(Long id){
        blogRepository.deleteById(id);
    }
}
