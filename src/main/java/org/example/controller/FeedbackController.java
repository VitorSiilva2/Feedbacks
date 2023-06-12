package org.example.controller;

import org.example.model.Feedbacks;
import org.example.service.FeedbackService;

import java.util.List;

public class FeedbackController {
        private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }


    public void addFeedbacks(int collaboratorId, String feedbackText) {
            feedbackService.addFeedbacks(collaboratorId, feedbackText);
        }

        public List<Feedbacks> getFeedbackByPeople(int collaboratorId) {
            return feedbackService.getFeedbackByPeople(collaboratorId);
        }
    }
