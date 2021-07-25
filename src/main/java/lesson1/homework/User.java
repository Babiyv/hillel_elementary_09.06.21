package lesson1.homework;

public class User extends Person {
    public User(String name, String surname, int age, String email, String password) {
        super(name, surname, age, email, password, Role.USER);
    }
}
