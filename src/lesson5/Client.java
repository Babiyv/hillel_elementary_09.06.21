package lesson5;

import java.util.Objects;

public class Client { // любой класс по дефоулту extends Object
    private String name;

    public Client(String name) {
        this.name = name;
    }

//    после того как заоверрайдили equals и hashCode, то объекты с одинаковыми параметрами (в классе main с одинаковыми name) будут иметь одинаковый идентификатор;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
