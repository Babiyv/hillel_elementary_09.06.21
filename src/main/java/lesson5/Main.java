package lesson5;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("name");
        Client client1 = new Client("name");
        Client client2 = new Client("name1");

//        .getClass:
        Class<?> classClient = client.getClass();
        System.out.println(classClient);
        System.out.println(client.getClass());

//        .hashCode:
        System.out.println(client.hashCode()); // hashCode - уникальный идентификатор;
        System.out.println(client1.hashCode()); // идентификаторы были разные, до того как переопределили метод hashCode в классе Client;
        System.out.println(client2.hashCode());

//        Client client = new Client("Andrew", "NotAndrew");
//        Client client1 = new Client("NotAndrew", "Andrew");

//        Integer integer1 = new Integer(1);
//        Integer integer2 = new Integer(1);
//        Class<?> classClient = client.getClass();
//        System.out.println(client.getClass());

//        System.out.println(client.hashCode());
//        System.out.println(client1.hashCode());

//        client.setName("drew");

//        System.out.println(client.hashCode());
//        System.out.println(client1.hashCode());

//        HashSet<Integer> integers = new HashSet<>();
//        integers.add(integer1);
//        integers.add(integer2);
//
//        System.out.println(integers);

//        HashSet<Client> clients = new HashSet<>();
//        clients.add(client);
//        clients.add(client1);
//
//        System.out.println(clients);

//        Client client2 = new Client("Andrew", "NotAndrew");
//        Client client3 = new Client("NotAndrew", "NotAndrew");
//
//        System.out.println(client2.equals(client3));
//        System.out.println(client2 == client3);

//        Client client = new Client("Andrew", "NotAndrew");
//        System.out.println(client.getName());
//        System.out.println(client.getSurname());
//        test(client);
//        System.out.println(client.getName());
//        System.out.println(client.getSurname());

//        int i = 10;
//        test2(i);
//        System.out.println(i);
    }

    public static void test(Client client) {
        client.setName("NNNT");
    }

    public static void test2(int i) {
        i = 5;
    }
}
