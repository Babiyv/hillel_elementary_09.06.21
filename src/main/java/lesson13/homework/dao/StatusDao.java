package lesson13.homework.dao;

import lesson12.database.Database;
import lesson13.homework.entity.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*2. Создать сервисы для своих сущностей: ClientDao, StatusDao, AccountDao, у каждого из которых
реализовать CRUD методы для полного сохранения/обновления/получения списка/удаления сущностей соответствующих;*/
public class StatusDao {
    private static final String INSERT_STATUS = "INSERT INTO statuses (alias, description) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE statuses SET alias=?, description=? WHERE id=?";
    private static final String STATUSES = "SELECT * FROM statuses";
    private static final String DELETE_STATUS = "DELETE FROM statuses WHERE id=?";

    //     сохранение "сущности":
    public void save (Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(INSERT_STATUS)) {
            prepStatement.setString(1, status.getAlias());
            prepStatement.setString(2, status.getDescription());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //     обновление "сущности":
    public void update(Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(UPDATE)) {
            prepStatement.setString(1, status.getAlias());
            prepStatement.setString(2, status.getDescription());
            prepStatement.setInt(3, status.getId());
            prepStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //     получение списка "сущностей":
    public List<Status> getAllStatuses() {
        List<Status> resultList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(STATUSES);
            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setAlias(resultSet.getString("alias"));
                status.setDescription(resultSet.getString("description"));
                resultList.add(status);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }

    //     удаление "сущности":
    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_STATUS)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}