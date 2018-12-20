package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.Article;
import cn.com.taiji.actual.domain.Comment;
import cn.com.taiji.actual.service.ArticleService;
import cn.com.taiji.actual.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

/**
 * @author Barry
 * @version v1.0
 * @description
 * @date created on 2018/12/20 9:19
 */

@Controller
public class ArticleController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ArticleService articleServiceImpl;
    private CommentService commentServiceImpl;

    @Autowired
    public ArticleController(ArticleService articleServiceImpl,
                             CommentService commentServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
        this.commentServiceImpl = commentServiceImpl;
    }

    @GetMapping("/article")
    public String article() {
        return "public/article";
    }

    @GetMapping("/addArticle")
    @ResponseBody
    public void addArticle(Article article, @RequestParam("content") String content) {
        articleServiceImpl.addArticle(article, content);
    }

    @GetMapping("/findArticle")
    public String findArticle(Article article, Model model) {
        Article articleInfo = articleServiceImpl.findArticleByAName(article.getAName());
        String content = new String(articleInfo.getAContent(), StandardCharsets.UTF_8);
        logger.info("content is {}", content);
        model.addAttribute("article", articleInfo);
        model.addAttribute("articleAuthor", "ce");
        model.addAttribute("content", content);
        model.addAttribute("comments", commentServiceImpl.findAllComment(articleInfo));
        return "public/article-content";
    }

    @GetMapping("/addComment")
    @ResponseBody
    public String addComment(Comment comment, @RequestParam("articleName") String articleName) {
        commentServiceImpl.addComment(comment, articleName);
        return "yes";
    }
}
