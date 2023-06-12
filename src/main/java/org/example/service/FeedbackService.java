package org.example.service;

import org.example.model.Feedbacks;
import org.example.repositories.FeedbackRepository;

import java.util.List;

public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }


    public void addFeedbacks(int collaboratorId, String feedbackText) {
        feedbackRepository.addFeedback(collaboratorId, feedbackText);
    }

    public List<Feedbacks> getFeedbackByPeople(int collaboratorId) {
        return feedbackRepository.getFeedbacksByCollaborator(collaboratorId);
    }

    public Feedbacks getFeedbacksById(int collaboratorId, int id) {
        return feedbackRepository.getFeedbacksById(collaboratorId, id);
    }
}