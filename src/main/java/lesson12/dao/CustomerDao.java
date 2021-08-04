package lesson12.dao;

import lesson12.database.Database;
import lesson12.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// dao - data access object (название с точки зрения паттерна проектирования);
public class CustomerDao {
    private static  final String INSERT_CUSTOMERS =
            "INSERT INTO customers (name, surname, email, age, password) VALUES (?, ?, ?, ?, ?)";
    private static final String CUSTOMERS = "SELECT * FROM customers";
    private static final String CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id=?";
    private static final String DELETE_CUSTOMER = "DELETE FROM customers WHERE id=?";
    private static final String UPDATE =
            "UPDATE customers SET name=?, surname=?, email=?, age=?, password=? WHERE id=?";

    public List<Customer> findAllCustomers() {
        List<Customer> resultList = new ArrayList<>();

//        обычный вариант написания "try":
        /*try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");*/
//        вариант написания "try with resources":
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(CUSTOMERS);

            while (resultSet.next()) { // .next - если есть следующее значение, то "тру"
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setAge(resultSet.getInt("age"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));

                resultList.add(customer);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }

    public Customer findById(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(CUSTOMER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setAge(resultSet.getInt("age"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));

                return customer;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public void save (Customer customer) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(INSERT_CUSTOMERS)) { // PreparedStatement - интерфейс можно передать параметр, в отличии от стейтмент обычного
            prepStatement.setString(1, customer.getName());
            prepStatement.setString(2, customer.getSurname());
            prepStatement.setString(3, customer.getEmail());
            prepStatement.setInt(4, customer.getAge());
            prepStatement.setString(5, customer.getPassword());
            prepStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void update(Customer customer) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.setString(3, customer.getEmail());
            statement.setInt(4, customer.getAge());
            statement.setString(5, customer.getPassword());
            statement.setInt(6, customer.getId());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}