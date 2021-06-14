package lesson1.intr;

public class Parrot implements AnimalInterface{
    @Override
    public void run() {
        System.out.println("Run parrot");
    }

    @Override
    public void voice() {
        System.out.println("Voice parrot");
    }
}
