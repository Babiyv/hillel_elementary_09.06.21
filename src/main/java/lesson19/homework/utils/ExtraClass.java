package lesson19.homework.utils;

/*2. Создайте дополнительный класс с одной переменной и одним методом, который будет вызываться без создания экземпляра данного класса.
Этот метод должен считывать имя потока, который его обрабатывает и выводить сообщение в консоль с именем этого потока
и значением переменной данного класса, после чего инкрементировать эту переменную и отправлять результат вызывающей стороне.*/
public class ExtraClass {
    static int counter = 0;

    public synchronized static int readThreadNameReturnIncrementedVariable() {
            // Считываем и выводим на консоль имя потока в котором выполняется метод:
            System.out.println("Running by thread named: ".concat(Thread.currentThread().getName()));
            // выводим на консоль переменную этого класса:
            System.out.println(counter);
            // инкрементируем переменную и отправляем результат вызывающей стороне
            return ++counter;
    }


    // попробовал второй вариант с синхронизацией по объекту (но не подпадает под условие, что должна быть только одна переменная,
/*    static final String objectForSynchronization = "lock";
    static final ExtraClass objectForSynchronization1 = new ExtraClass();
    static int counter = 0;

    public static int readThreadNameReturnIncrementedVariable() {
        synchronized (objectForSynchronization) {
            // Считываем и выводим на консоль имя потока в котором выполняется метод:
            System.out.println("Running by thread named: ".concat(Thread.currentThread().getName()));
            // выводим на консоль переменную этого класса:
            System.out.println(counter);
            // инкрементируем переменную и отправляем результат вызывающей стороне
            return ++counter;
        }
    }*/

    // третий вариант:
/*    public static int readThreadNameReturnIncrementedVariable() {
        synchronized (String.valueOf(counter)) {
            // Считываем и выводим на консоль имя потока в котором выполняется метод:
            System.out.println("Running by thread named: ".concat(Thread.currentThread().getName()));
            // выводим на консоль переменную этого класса:
            System.out.println(counter);
            // инкрементируем переменную и отправляем результат вызывающей стороне
            return ++counter;
        }
    }*/




}
