package lesson19.homework;

import lesson19.homework.thread.ExtendsThread;
import lesson19.homework.thread.ImplementsCallable;
import lesson19.homework.thread.ImplementsRunnable;
import lesson19.homework.utils.ExtraClass;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        4. В классе Main создать Наших три потока и запустить.
//        Вывести в консоль результат вернувшегося значения потока, которые позволяет получить результат выполнения своего потока;

        // 1 из 3:
        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.start();
        extendsThread.join();

        // 2 из 3:
        Thread implementsRunnable = new Thread(new ImplementsRunnable());
        implementsRunnable.start();
        implementsRunnable.join();

        // 3 из 3:
        FutureTask<String> futureTask = new FutureTask<>(new ImplementsCallable());
        Thread implementsCallable = new Thread(futureTask);
        implementsCallable.start();
        System.out.println(futureTask.get());
        implementsCallable.join();

//        5. Запустить программу несколько раз - возможно, вернувшееся значение переменной, которую получит поток будет разным.
//        Результатом программы прикрепить либо к решению, либо в коде комментарием следующие варианты:

//        5.1. Какой диапазон результатов переменной возвращает поток после выполнения если программу запустить несколько раз? (пример 3000-3000);
//        Ответ: запускал 10 раз, всегда последним значением было 3000 (проверил даже с циклом на 10тыс, а не на 1тыс);

//        5.2. Какой диапазон результатов переменной возвращает поток после выполнения
//        если предварительно методу дополнительного класса, который вызывают все потоки добавить синхронизацию и запустить программу несколько раз?
//        (пример 2980-3000);
//        Ответ: рзультат не изменился, запускал 5 раз, всегда последним значением было 3000;

//        5.3. Какой диапазон результатов переменной возвращает поток после выполнения
//        если после КАЖДОГО запуска потока (start()) указывать остальным, чтобы ждали его выполнения (join())
//        и программу запустить несколько раз? (пример 2500-2900);
//        Ответ: a) если метод в доп классе все еще synchronized: 3000; б) если метод в доп классе НЕ synchronized: 3000.

//        6. Создать пример своего Deadlock-а;


    }
}
