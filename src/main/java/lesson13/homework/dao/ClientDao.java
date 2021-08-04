package lesson13.homework.dao;

import lesson12.database.Database;
import lesson13.homework.entity.Account;
import lesson13.homework.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*2. Создать сервисы для своих сущностей: ClientDao, StatusDao, AccountDao, у каждого из которых
реализовать CRUD методы для полного сохранения/обновления/получения списка/удаления сущностей соответствующих;*/
public class ClientDao {
    // dao (data access object) - общее название с точки зрения паттерна проектирования для сервисов взаимодействия с сущностями из баз данных;
    private static final String INSERT_CLIENT = "INSERT INTO clients (name, email, phone, about) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE clients SET name=?, email=?, phone=?, about=? WHERE id=?";
    private static final String CLIENTS = "SELECT * FROM clients";
    private static final String DELETE_CLIENT = "DELETE FROM clients WHERE id=?";
    private static final String CLIENT_BY_PHONE = "SELECT * FROM clients WHERE phone=?";

    //     сохранение "сущности":
    public void save (Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(INSERT_CLIENT)) { // PreparedStatement - интерфейс можно передать параметр, в отличии от стейтмент обычного
            prepStatement.setString(1, client.getName());
            prepStatement.setString(2, client.getEmail());
            prepStatement.setLong(3, client.getPhone());
            prepStatement.setString(4, client.getAbout());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //     обновление "сущности":
    public void update(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(UPDATE)) {
            prepStatement.setString(1, client.getName());
            prepStatement.setString(2, client.getEmail());
            prepStatement.setLong(3, client.getPhone());
            prepStatement.setString(4, client.getAbout());
            prepStatement.setInt(5, client.getId());
            prepStatement.execute(); // - команда выполнить;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //     получение списка "сущностей":
    public List<Client> getAllClients() {
        List<Client> resultList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(CLIENTS);
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                resultList.add(client);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }

    //     удаление "сущности":
    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //    4. Добавить метод для поиска Client по номеру телефона в соответствующий dao;
    public Client findByPhoneNumber(Long phoneNumber) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(CLIENT_BY_PHONE)) {
            prepStatement.setLong(1, phoneNumber);
            ResultSet resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                return client;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}