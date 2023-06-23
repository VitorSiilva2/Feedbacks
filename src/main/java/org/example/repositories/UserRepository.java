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
        PreparedStatement st = null;

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

    public void getUserByEmail (String email){

    }

    public void updateUser(User user) {

    }

    public void deleteUser (int Id) {

    }

}
