package lesson16.homework.intr;

// 1. Создать 4 интерфейса...
public interface TestInterface3 {

    // ...с одинаковым методом по-умолчанию, но с различными реализациями.
    default void sameDefaultMethod() {
        System.out.println("The same default method from TestInterface3");
    }

    // Также добавить в каждый по-одному статическому методу...
    static void staticMethodFromInterface3() {
        System.out.println("Static method from TestInterface3");
    }

    // ...и по 2 метода-контракта
    void firstContractMethodFromTestInterface3();
    void secondContractMethodFromTestInterface3();



}
