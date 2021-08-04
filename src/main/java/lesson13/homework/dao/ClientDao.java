package lesson13.homework.dao;

import lesson13.homework.database.Database;
import lesson13.homework.entity.Client;
import lesson13.homework.entity.ClientStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*2. Создать сервисы для своих сущностей: ClientDao, StatusDao, AccountDao, у каждого из которых
реализовать CRUD методы для полного сохранения/обновления/получения списка/удаления сущностей соответствующих;*/
public class ClientDao {
    // dao (data access object) - общее название с точки зрения паттерна проектирования для сервисов взаимодействия с сущностями из баз данных;
    private static final String INSERT_CLIENT = "INSERT INTO clients (name, email, phone, about, age) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE clients SET name=?, email=?, phone=?, about=?, age=? WHERE id=?";
    private static final String CLIENTS = "SELECT * FROM clients";
    private static final String DELETE_CLIENT = "DELETE FROM clients WHERE id=?";
    private static final String CLIENT_BY_PHONE = "SELECT * FROM clients WHERE phone=?";
    private static final String CLIENTS_BY_ACCOUNTS = "SELECT * FROM clients INNER JOIN accounts ON clients.id = accounts.client_id";
    private static final String CLIENTS_NAME_EMAIL_ALIAS = "SELECT name, email, alias FROM client_status AS cs " +
                    "JOIN clients AS c ON cs.client_id = c.id JOIN statuses AS s ON cs.status_id = s.id WHERE age>18";
    private static final String CLIENT_BY_ID = "SELECT * FROM clients WHERE id=?";

    //    метод добавленные для избежания дублированивания кода (даже сама идея ругалась):
    private Client generateClient(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getInt("id"));
        client.setName(resultSet.getString("name"));
        client.setEmail(resultSet.getString("email"));
        client.setPhone(resultSet.getLong("phone"));
        client.setAbout(resultSet.getString("about"));
        return client;
    }

    //     сохранение "сущности":
    public void save (Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(INSERT_CLIENT)) { // PreparedStatement - интерфейс можно передать параметр, в отличии от стейтмент обычного
            prepStatement.setString(1, client.getName());
            prepStatement.setString(2, client.getEmail());
            prepStatement.setLong(3, client.getPhone());
            prepStatement.setString(4, client.getAbout());
            prepStatement.setInt(5, client.getAge());
            prepStatement.execute();
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
            prepStatement.setInt(5, client.getAge());
            prepStatement.setInt(6, client.getId());
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
                resultList.add(generateClient(resultSet));
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
                return generateClient(resultSet);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    //    6. Добавить метод для получения всех Clients где id клиент = client_id таблицы сущности Accounts;
    public List<Client> getAllClientsWhereIdEqualsAccountsClientId() {
        List<Client> resultList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(CLIENTS_BY_ACCOUNTS);
            while (resultSet.next()) {
                resultList.add(generateClient(resultSet));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }

/*        7. Добавить запрос для получения значений clients.name, clients.email, statuses.alias
        из таблицы клиентов(Clients) и из таблицы статусов(Statuses) используя join 3х таблиц и где возраст пользователей старше 18 лет.
        (Если возраста нет, надо что-то сделать чтобы был)*/
    public List<ClientStatus> getClientsNameEmailAlias() {
        List<ClientStatus> resultList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(CLIENTS_NAME_EMAIL_ALIAS)) {
            while (resultSet.next()) {
                ClientStatus clientStatus = new ClientStatus();
                clientStatus.setName(resultSet.getString("name"));
                clientStatus.setEmail(resultSet.getString("email"));
                clientStatus.setAlias(resultSet.getString("alias"));
                resultList.add(clientStatus);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }

    //    в задании не было, но добавил для более удобного обновления и пр. с уже существующим конкретным клиентом:
    public Client getById(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(CLIENT_BY_ID)) {
            prepStatement.setInt(1, id);
            ResultSet resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
                generateClient(resultSet);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}