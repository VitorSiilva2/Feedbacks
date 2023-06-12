package org.example.repositories;

import org.example.model.Feedbacks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackRepository {
    private final Connection connection;


    public FeedbackRepository(Connection connection) {
        this.connection = connection;
    }

    public void addFeedback(int collaboratorId, String feedbackText) {
        String sql = "INSERT INTO feedbacks (CollaboratorId, FeedbacksText) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, collaboratorId);
            statement.setString(2, feedbackText);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar feedback: " + e.getMessage());
        }
    }
    public List<Feedbacks> getFeedbacksByCollaborator(int collaboratorId) {
        List<Feedbacks> feedbacks = new ArrayList<>();
        String sql = "SELECT * FROM feedbacks WHERE CollaboratorId = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, collaboratorId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String feedbackText = resultSet.getString("FeedbacksText");

                Feedbacks feedback = new Feedbacks(id, collaboratorId, feedbackText);
                feedbacks.add(feedback);
            }

            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter feedbacks do colaborador: " + e.getMessage());
        }

        return feedbacks;
    }

    public Feedbacks getFeedbacksById(int collaboratorId, int FeedbackId) {
        String sql = "SELECT * FROM feedbacks WHERE CollaboratorId = ? AND Id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, collaboratorId);
            statement.setInt(2, FeedbackId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String feedbackText = resultSet.getString("FeedbacksText");
                return new Feedbacks(FeedbackId, collaboratorId, feedbackText);
            }

            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter feedbacks do colaborador: " + e.getMessage());
        }

        return null;
    }
}
