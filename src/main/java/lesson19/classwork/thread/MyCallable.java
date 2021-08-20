package lesson19.classwork.thread;

import java.util.concurrent.Callable;

// варианты создания потоков:
// 3. implements Callable <-> call(){...} - отличие от предыдущих двух, то что после создания потока будет ждать результат работы;
public class MyCallable implements Callable<String> { // - сразу в дженерике указываем какой тип данных хотим вернуть;
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 50; i++) {
            System.out.println("MyCallable " + i);
        }
        return "MyCallable is finished";
    }
}
