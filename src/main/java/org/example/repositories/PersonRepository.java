package org.example.repositories;

import org.example.db.DbException;
import org.example.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private final Connection connection;


    public PersonRepository(Connection connection) {
        this.connection = connection;
    }

    public void addPerson(Person person) {

        PreparedStatement st = null;


        try {
            st = connection.prepareStatement(
                    "INSERT INTO collaborators"
                            + "(Name, Email, Office, UserId)"
                            + "VALUES "
                            + "(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, person.getName());
            st.setString(2, person.getEmail());
            st.setString(3, person.getOffice());
            st.setInt(4, person.getUserId());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    person.setId(id);
                }
                rs.close();
            } else {
                throw new DbException("No rows affected!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> getAllPerson() {
        List<Person> people = new ArrayList<>();
        String sql = "SELECT * FROM collaborators";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                String office = resultSet.getString("Office");
                Integer userId = resultSet.getInt("UserId");

                Person person = new Person(id, name, email, office, userId);
                people.add(person);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

        return people;
    }

    public Person getPeopleById(int id) {
        String sql = "SELECT * FROM collaborators WHERE Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                String office = resultSet.getString("Office");
                Integer userId = resultSet.getInt("UserId");
                return new Person(id, name, email, office, userId);
            }

            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter feedbacks do colaborador: " + e.getMessage());
        }

        return null;
    }

    public void updatePerson(Person person) {
        String sql = "UPDATE collaborators SET Name = ?, Email = ?, Office = ? WHERE Id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getEmail());
            statement.setString(3, person.getOffice());
            statement.setInt(4, person.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePerson(Integer id) {
        String sql = "DELETE FROM collaborators WHERE Id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
