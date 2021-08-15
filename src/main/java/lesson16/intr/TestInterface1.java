package lesson16.intr;

public interface TestInterface1 {
//    создаем такой же дефоултный метод с таким же названием как и в TestInterface для примера множественного наследования:
    default void run() {
        System.out.println("test TestInterface1");
    }
}
