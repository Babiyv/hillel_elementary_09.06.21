package lesson4;

public class Main {
    public static void main(String[] args) {
        try {
            throw new MyException();
        } catch (MyException exception) {
            exception.printStackTrace();
        }
    }
}
