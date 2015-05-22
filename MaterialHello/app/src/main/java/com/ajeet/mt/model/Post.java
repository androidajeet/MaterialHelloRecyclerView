package com.ajeet.mt.model;

public class Post {
    private int postId;
    private String postText;
    private String postedBy;
    private int likes;
    private String createdDate;
    private String lastUpdatedDate;

    public Post(String postText, String postedBy) {
        // TODO Auto-generated constructor stub
        this.postText = postText;
        this.postedBy = postedBy;
    }

    public Post() {
        // TODO Auto-generated constructor stub
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

}
