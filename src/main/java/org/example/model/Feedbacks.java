package org.example.model;

public class Feedbacks {

    private Integer id;
    private Integer CollaboratorID;
    private String FeedbacksText;

    public Feedbacks() {
    }

    public Feedbacks(Integer id, Integer collaboratorID, String feedbacksText) {
        this.id = id;
        CollaboratorID = collaboratorID;
        FeedbacksText = feedbacksText;
    }

    @Override
    public String toString() {
        return "Feedbacks{" +
                "id=" + id +
                ", CollaboratorID=" + CollaboratorID +
                ", FeedbacksText='" + FeedbacksText + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCollaboratorID() {
        return CollaboratorID;
    }

    public void setCollaboratorID(Integer collaboratorID) {
        CollaboratorID = collaboratorID;
    }

    public String getFeedbacksText() {
        return FeedbacksText;
    }

    public void setFeedbacksText(String feedbacksText) {
        FeedbacksText = feedbacksText;
    }
}
