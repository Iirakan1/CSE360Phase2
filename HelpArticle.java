package main.java.com.example.cse360;

import java.io.Serializable;
import java.util.List;

public class HelpArticle implements Serializable {
    private static final long serialVersionUID = 1L; // Serialization ID
    private long id; // Unique identifier
    private String header;
    private String title;
    private String shortDescription;
    private String body;
    private List<String> keywords;
    private long groupId; // Group identifier for categorization

    // Constructor
    public HelpArticle(long id, String header, String title, String shortDescription, String body, List<String> keywords, long groupId) {
        this.id = id;
        this.header = header;
        this.title = title;
        this.shortDescription = shortDescription;
        this.body = body;
        this.keywords = keywords;
        this.groupId = groupId;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getBody() {
        return body;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public long getGroupId() {
        return groupId;
    }

    // Setters
    public void setHeader(String header) {
        this.header = header;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "HelpArticle{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", body='" + body + '\'' +
                ", keywords=" + keywords +
                ", groupId=" + groupId +
                '}';
    }
}
