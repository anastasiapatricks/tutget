package com.tutget.main.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

@MappedSuperclass
public class QnaPost {
    @Id
    private String id;

    private String qnaString;
    private int upvotes;
    private int downvotes;
    private LocalDate postDate;
    private String posterId;
    private String posterName;
    private String acadLvl;
    private String acadSubj;


    public QnaPost() {}

    public QnaPost(String qnaString, String posterId, String posterName, String acadLvl, String acadSubj) {
        this.qnaString = qnaString;
        this.upvotes = 0;
        this.downvotes = 0;
        this.postDate = LocalDate.now();
        this.posterId = posterId;
        this.posterName = posterName;
        this.acadLvl = acadLvl;
        this.acadSubj = acadSubj;
    }

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setQnaString(String qnaString) {
        this.qnaString = qnaString;
    }

    public String getQnaString() {
        return qnaString;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public String getPosterId() {
        return posterId;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setAcadLvl(String acadLvl) {
        this.acadLvl = acadLvl;
    }

    public String getAcadLvl() {
        return acadLvl;
    }

    public void setAcadSubj(String acadSubj) {
        this.acadSubj = acadSubj;
    }

    public String getAcadSubj() {
        return this.acadSubj;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof QnaPost)) {
            return false;
        }
         
        QnaPost othQnaPost = (QnaPost) o;
         
        return othQnaPost.getId().equals(this.getId());
    }
}