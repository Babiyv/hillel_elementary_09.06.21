package lesson16.homework.intr;

// 1. Создать 4 интерфейса...
public interface TestInterface1 {

    // ...с одинаковым методом по-умолчанию, но с различными реализациями.
    default void sameDefaultMethod() {
        System.out.println("The same default method from TestInterface1");
    }

    // Также добавить в каждый по-одному статическому методу...
    static void staticMethodFromInterface1() {
        System.out.println("Static method from TestInterface1");
    }

    // ...и по 2 метода-контракта
    void firstContractMethodFromTestInterface1();
    void secondContractMethodFromTestInterface1();



}
