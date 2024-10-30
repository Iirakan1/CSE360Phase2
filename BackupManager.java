package main.java.com.example.cse360;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BackupManager {
    private List<HelpArticle> articles; // List to hold the current help articles

    public BackupManager(List<HelpArticle> articles) {
        this.articles = articles;
    }

    // Backup the current articles to a specified file
    public void backupArticles(String filename, List<Long> groupIds) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            List<HelpArticle> backupArticles = new ArrayList<>();
            for (HelpArticle article : articles) {
                if (groupIds.contains(article.getGroupId()) || groupIds.isEmpty()) {
                    backupArticles.add(article);
                }
            }
            oos.writeObject(backupArticles); // Serialize the articles
        }
    }

    // Restore articles from a specified file
    public void restoreArticles(String filename, boolean merge) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<HelpArticle> backupArticles = (List<HelpArticle>) ois.readObject();

            if (merge) {
                for (HelpArticle backupArticle : backupArticles) {
                    if (!articles.stream().anyMatch(article -> article.getId() == backupArticle.getId())) {
                        articles.add(backupArticle); // Only add if the ID does not exist
                    }
                }
            } else {
                articles.clear(); // Clear existing articles if not merging
                articles.addAll(backupArticles); // Add all backup articles
            }
        }
    }

    // Method to list all help articles
    public List<HelpArticle> getArticles() {
        return articles;
    }
}
