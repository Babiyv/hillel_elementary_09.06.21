package lesson5;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("name");
        Client client1 = new Client("name");
        Client client2 = new Client("name1");
        Class<?> classClient = client.getClass();
        System.out.println(client.getClass());

        System.out.println(client.hashCode()); // hashCode - уникальный идентификатор;
        System.out.println(client1.hashCode());
    }
}
