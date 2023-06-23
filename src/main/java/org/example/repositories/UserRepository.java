package org.example.repositories;

import org.example.db.DbException;
import org.example.model.User;

import java.sql.*;

public class UserRepository {

    private final Connection connection;


    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public void addUser (User user){
        PreparedStatement st;

        try {
            st = connection.prepareStatement(
                    "INSERT INTO user"
                            + "(Email, Password)"
                            + "VALUES "
                            + "(?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, user.getEmail());
            st.setString(2, user.getPassword());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    user.setId(id);
                }
                rs.close();
            } else {
                throw new DbException("No rows affected! ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getUserById (int id){

    }

    public User findByEmail (String email) {
        String sql = "SELECT * FROM user WHERE Email = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("Id");
            String password = resultSet.getString("Password");

            return new User(id, email, password);
        }
        resultSet.close();

    } catch (SQLException e) {
            throw new RuntimeException("Error find user by email");
        }

        return null;
    }

    public void updateUser(User user) {

    }

    public void deleteUser (int Id) {

    }

}
