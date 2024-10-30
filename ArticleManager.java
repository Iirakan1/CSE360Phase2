package main.java.com.example.cse360;

import java.util.*;

public class ArticleManager {
    private Map<String, List<HelpArticle>> groups;

    public ArticleManager() {
        groups = new HashMap<>();
    }

    public void addArticleToGroup(String groupName, HelpArticle article) {
        groups.computeIfAbsent(groupName, k -> new ArrayList<>()).add(article);
    }

    public List<HelpArticle> getArticlesByGroup(String groupName) {
        return groups.getOrDefault(groupName, new ArrayList<>());
    }

    public void updateArticle(String groupName, long articleId, HelpArticle updatedArticle) {
        List<HelpArticle> articles = groups.get(groupName);
        if (articles != null) {
            for (int i = 0; i < articles.size(); i++) {
                if (articles.get(i).getId() == articleId) {
                    articles.set(i, updatedArticle);
                    return;
                }
            }
        }
    }

    public void deleteArticle(String groupName, long articleId) {
        List<HelpArticle> articles = groups.get(groupName);
        if (articles != null) {
            articles.removeIf(article -> article.getId() == articleId);
        }
    }

    public void listArticles(String groupName) {
        List<HelpArticle> articles = getArticlesByGroup(groupName);
        if (articles.isEmpty()) {
            System.out.println("No articles found in group: " + groupName);
        } else {
            articles.forEach(System.out::println);
        }
    }
}
