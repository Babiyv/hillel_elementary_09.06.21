package lesson16.homework;

import lesson16.homework.intr.*;
import lesson16.homework.utils.EmbeddedFunctionalInterfaces;
import lesson16.homework.utils.Helper;

import java.util.Optional;
import java.util.function.Predicate;

// 4. В классе Main реализовать вызов всех возможных вызовов;
public class Main {
    public static void main(String[] args) {

//         4. В классе Main реализовать вызов всех возможных вызовов;
    // вызов статиков сразу напрямую:
        TestInterface1.staticMethodFromInterface1();
        TestInterface2.staticMethodFromInterface2();
        TestInterface3.staticMethodFromInterface3();
        TestInterface4.staticMethodFromInterface4();
        System.out.println("------------------------------------------------------");

        // традиционный способ:
        TestInterface1 testInterface1 = new TestInterfaceImpl1();
        testInterface1.sameDefaultMethod();
        testInterface1.firstContractMethodFromTestInterface1();
        testInterface1.secondContractMethodFromTestInterface1();
        System.out.println("------------------------------------------------------");

        TestInterface2 testInterface2 = new TestInterfaceImpl1();
        testInterface2.sameDefaultMethod();
        testInterface2.firstContractMethodFromTestInterface2();
        testInterface2.secondContractMethodFromTestInterface2();
        System.out.println("------------------------------------------------------");

        TestInterface3 testInterface3 = new TestInterfaceImpl2();
        testInterface3.sameDefaultMethod();
        testInterface3.firstContractMethodFromTestInterface3();
        testInterface3.secondContractMethodFromTestInterface3();
        System.out.println("------------------------------------------------------");

        TestInterface4 testInterface4 = new TestInterfaceImpl2();
        testInterface4.sameDefaultMethod();
        testInterface4.firstContractMethodFromTestInterface4();
        testInterface4.secondContractMethodFromTestInterface4();
        System.out.println("------------------------------------------------------");

        // еще возможные вызовы:
        TestInterfaceImpl1 testInterfaceImpl1 = new TestInterfaceImpl1();
        testInterfaceImpl1.firstContractMethodFromTestInterface1();
        testInterfaceImpl1.secondContractMethodFromTestInterface1();
        testInterfaceImpl1.firstContractMethodFromTestInterface2();
        testInterfaceImpl1.secondContractMethodFromTestInterface2();
        System.out.println("------------------------------------------------------");

        TestInterfaceImpl2 testInterfaceImpl2 = new TestInterfaceImpl2();
        testInterfaceImpl2.firstContractMethodFromTestInterface3();
        testInterfaceImpl2.secondContractMethodFromTestInterface3();
        testInterfaceImpl2.firstContractMethodFromTestInterface4();
        testInterfaceImpl2.secondContractMethodFromTestInterface4();
        System.out.println("------------------------------------------------------");

        Helper helper = new Helper();
//        6. Вызвать в классе Main этот хелпер передав валидное значение и получить его;
        Optional validEmail = helper.emailChecker("qee@gmail.com");
        System.out.println(validEmail.get()); // - соответсвует и возвращается Optional с этой строкой;

//        7. Вызвать в классе Main этот хелпер передав не валидное значение и вызвать ошибку используя Optional функции;
        Optional invalidEmail = helper.emailChecker(null);
        // *** закоментировал после того как проверил, чтобы не мешало выполнять остальной код ***
//        System.out.println(invalidEmail.get());  // - передаем null и получаем ошибку;

//        8. Используя функциональные интерфейсы написать следующие функции:
//        8.1. Predicate: метод, который на вход принимает дробное значение зарплаты. Если это значение больше 1500.0, то возвращает значение true;
        double salary = 1600.00;
        Predicate<Double> isBiggerThan1500 = var -> var > 1500.00; // Предикат - функциональный интерфейс Predicate<T> проверяется соблюдение условия, если соблюдается, то возвращает true.
        System.out.println(isBiggerThan1500.test(salary));

        // остальные методы попробовал спрятать в отдельный класс, для лаконичности:
        EmbeddedFunctionalInterfaces.consumer("a1b2c3");
        System.out.println(EmbeddedFunctionalInterfaces.function(5));
        System.out.println(EmbeddedFunctionalInterfaces.supplier());






    }
}
