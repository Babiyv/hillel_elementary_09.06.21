package lesson1.homework;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;
    private Role role;

    public Person(String name, String surname, int age, String email, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "{Person" +
                " name = " + name +
                "; \nsurname = " + surname +
                "; \nage = " + age +
                "; \nemail = " + email +
                "; \npassword = " + password +
                "; \nrole = " + role +
                '}' + '\n';
    }
}
