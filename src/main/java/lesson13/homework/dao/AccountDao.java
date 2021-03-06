package lesson13.homework.dao;

import lesson12.database.Database;
import lesson13.homework.entity.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*2. Создать сервисы для своих сущностей: ClientDao, StatusDao, AccountDao, у каждого из которых
реализовать CRUD методы для полного сохранения/обновления/получения списка/удаления сущностей соответствующих;*/
public class AccountDao {
    // dao (data access object) - общее название с точки зрения паттерна проектирования для сервисов взаимодействия с сущностями из баз данных;
     private static final String INSERT_ACCOUNT = "INSERT INTO accounts (client_id, number, value) VALUES (?, ?, ?)";
     private static final String UPDATE = "UPDATE accounts SET client_id=?, number=?, value=? WHERE id=?";
     private static final String ACCOUNTS = "SELECT * FROM accounts";
     private static final String DELETE_ACCOUNT = "DELETE FROM accounts WHERE id=?";
     private static final String ACCOUNT_BY_ID = "SELECT * FROM accounts WHERE id=?";
     private static final String ACCOUNT_BY_VALUE = "SELECT number FROM accounts WHERE value>?";

//     сохранение "сущности":
    public void save (Account account) {
            try (Connection connection = Database.getConnection();
                 PreparedStatement prepStatement = connection.prepareStatement(INSERT_ACCOUNT)) { // PreparedStatement - интерфейс можно передать параметр, в отличии от стейтмент обычного
                prepStatement.setInt(1, account.getClientId());
                prepStatement.setString(2, account.getNumber());
                prepStatement.setDouble(3, account.getValue());
                prepStatement.execute();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

//     обновление "сущности":
    public void update(Account account) {
            try (Connection connection = Database.getConnection();
                 PreparedStatement prepStatement = connection.prepareStatement(UPDATE)) {
                prepStatement.setInt(1, account.getClientId());
                prepStatement.setString(2, account.getNumber());
                prepStatement.setDouble(3, account.getValue());
                prepStatement.setInt(4, account.getId());
                prepStatement.execute(); // - команда выполнить;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

//     получение списка "сущностей":
    public List<Account> getAllAccounts() {
            List<Account> resultList = new ArrayList<>();
            // вариант написания "try with resources":
            try (Connection connection = Database.getConnection(); Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(ACCOUNTS);
                while (resultSet.next()) { // .next - если есть следующее значение, то "тру"
                    Account account = new Account();
                    account.setId(resultSet.getInt("id"));
                    account.setClientId(resultSet.getInt("client_id"));
                    account.setNumber(resultSet.getString("number"));
                    account.setValue(resultSet.getDouble("value"));
                    resultList.add(account);
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            return resultList;
        }

//     удаление "сущности":
    public void delete(Integer id) {
            try (Connection connection = Database.getConnection();
                 PreparedStatement prepStatement = connection.prepareStatement(DELETE_ACCOUNT)) {
                prepStatement.setInt(1, id);
                prepStatement.execute();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

//     5. Добавить метод для получения number из Account, где value > переданного значения;
    public List<String> findNumberByValue(Double minValue) {
        List<String> resultList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(ACCOUNT_BY_VALUE)) {
            prepStatement.setDouble(1, minValue);
            ResultSet resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
                resultList.add(resultSet.getString("number"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }


//     получение конкретной "сущности" из таблицы (по заданию не нужно, просто оставил на заметку):
    public Account getById(Integer id) {
            try (Connection connection = Database.getConnection();
                 PreparedStatement prepStatement = connection.prepareStatement(ACCOUNT_BY_ID)) {
                prepStatement.setInt(1, id);
                ResultSet resultSet = prepStatement.executeQuery();
                while (resultSet.next()) {
                    Account account = new Account();
                    account.setId(resultSet.getInt("id"));
                    account.setClientId(resultSet.getInt("client_id"));
                    account.setNumber(resultSet.getString("number"));
                    account.setValue(resultSet.getDouble("value"));
                    return account;
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            return null;
        }
}
