package lesson16.classwork.intr;

public class TestInterfaceImpl implements TestInterface, TestInterface1 {

//    нужно оверрайдить только те методы, которые у нас не определены в классе/интерфейся TestInterface:
    @Override
    public void runOld() {
        System.out.println("override in TestInterfaceImpl (implements TestInterface)");
    }

    @Override
    public int swim() {
        return 0;
    }

//    пришлось оверрайдить, так как мы имплементируем два класса в которых есть дефоултные методы с одинаковыми названиями:
    @Override
    public void run() {
        System.out.println("override default method in TestInterfaceImpl, because implemented two classes with same default methods names inside");
    }
}