package lesson19.classwork.thread;

// варианты создания потоков:
// 2. implements Runnable -> run(){...} - интерфейс Runnable
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("MyRunnable" + i);
        }
    }
}
