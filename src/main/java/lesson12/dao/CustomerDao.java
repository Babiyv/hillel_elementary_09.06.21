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

    public List<Customer> findAllCustomers() {
        List<Customer> resultList = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

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

    public void save (Customer customer) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(INSERT_CUSTOMERS)) { // PreparedStatement - интерфейс можно передать параметр, в отличии от стейтмент обычного
            prepStatement.setString(1, customer.getName());
            prepStatement.setString(2, customer.getSurname());
            prepStatement.setString(3, customer.getEmail());
            prepStatement.setInt(4, customer.getAge());
            prepStatement.setString(5, customer.getPassword());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}