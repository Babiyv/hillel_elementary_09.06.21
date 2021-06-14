package lesson1.intr;

public class Cat implements AnimalInterface {

    @Override
    public void run() {
        System.out.println("Cat run");
    }

    @Override
    public void voice() {
        System.out.println("Cat voice");
    }
}
