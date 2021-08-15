package lesson16.intr;

// в Java ЗАПРЕЩЕННО множественное наследование КЛАССОВ, но с 8-ой Java РАЗРШЕНО множественное наследование ИНТЕРФЕЙСОВ (так как в ней появились дефоултные методы).
public interface TestInterface {
//    раньше создавали интерфейс с методами который должны быть заоверрайджены в классе который имплементирует этот интерфейс (TestInterface):
    void runOld();
    int swim();

//    в Java 8 добавилась возможность что  тут можно создавать точно так же как и в классе
    static void runStatic() {
        System.out.println("test runStatic");
    }

//    и так же добавилась дефоултная реализация методов (что-то вроде абстрактного метода/класса):
    default void run() {
        System.out.println("test default method interface");
    }
}
