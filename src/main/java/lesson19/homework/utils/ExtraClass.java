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
}
