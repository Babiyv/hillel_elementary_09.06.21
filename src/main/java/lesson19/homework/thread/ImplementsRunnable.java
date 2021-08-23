package lesson19.homework.thread;

import lesson19.homework.utils.ExtraClass;

//        1. Создайте 3 класс для работы в многопоточном режиме. Реализовать классы для работы с потоками тремя разными способами:
//        3. В методах потоков задать свои имена для идентификации и написать логику циклического прохождения (1000 итераций)
//      и вызова дополнительного метода описанного ранее;
public class ImplementsRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Inside thread ImplementsRunnable " + i);
            System.out.println(ExtraClass.readThreadNameReturnIncrementedVariable());
        }
    }
}
