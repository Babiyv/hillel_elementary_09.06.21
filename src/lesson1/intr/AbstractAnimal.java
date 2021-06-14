package lesson1.intr;

public abstract class AbstractAnimal implements AnimalInterface { // - поскольку это абстрактный класс, то не нужно переопределеять все методы интрефейса

    @Override
    public void run() {
        System.out.println("run");
    }
}
