package lesson19.classwork.thread;

// варианты создания потоков:
// 1. extends Thread -> run(){...} - спец. класс в джаве от которого можно наследоваться и создать свой отдельный поток;
public class MyThread extends Thread{
/*    private final int testInt = 0;
    private final String test;

    public MyThread(String test) {
        this.test = test;
    }*/

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("MyThread " + i);
        }
    }

/*    private void test() {
        synchronized (test) {
            for (int i = 0; i < 10000; i++) {
                ++TEST;
            }
        }
    }*/
}
