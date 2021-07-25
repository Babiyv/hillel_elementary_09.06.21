package lesson5;

import java.util.Objects;

public class Client { // любой класс по дефоулту extends Object
    private String name;
    private String surname;
    private String fsurname;

    public Client(String name) {
        this.name = name;
    }
    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
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

    public String getFsurname() {
        return fsurname;
    }

    public void setFsurname(String fsurname) {
        this.fsurname = fsurname;
    }

    //    после того как заоверрайдили equals и hashCode, то объекты с одинаковыми параметрами (в классе main с одинаковыми name) будут иметь одинаковый идентификатор;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || !(o instanceof Client)) return false;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        return surname != null ? surname.equals(client.surname) : client.surname == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
