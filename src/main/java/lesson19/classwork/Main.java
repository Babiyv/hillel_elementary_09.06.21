package lesson19.classwork;

import jdk.internal.dynalink.beans.StaticClass;
import lesson19.classwork.deadlock.FirstClass;
import lesson19.classwork.deadlock.SecondClass;
import lesson19.classwork.thread.MyCallable;
import lesson19.classwork.thread.MyRunnable;
import lesson19.classwork.thread.MyThread;
import sun.management.snmp.jvminstr.JvmOSImpl;

import java.util.concurrent.FutureTask;

public class Main {
    static Integer TEST = 0;
    public static void main(String[] args) throws Exception {
        // варианты создания потоков:

        // 1. extends Thread -> run(){...} - спец. класс в джаве от которого можно наследоваться и создать свой отдельный поток;
        MyThread myThread = new MyThread(); // - создали объект класса
//        myThread.run(); // НЕ вызываем метод run напрямую, так как он выполниться в обычной однопоточной среде;
        myThread.start(); // - запускаем логику в отдельном созданом потоке, и вывод на консоль будет происходить в отдельном потоке;

        while (myThread.isAlive()){ // очень грязный способ, как заставить вначале отработать первый поток и только потом переходить к следующим (потому что застрянет на цикле while пока не выполнится логика в потоке myThread (после чего он сам закроется/"уничтожиться");
        }

        // 2. implements Runnable -> run(){...} - интерфейс Runnable
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        // 2.1 альтернативный вариант используя лямбда-выражения для лаконичности и можно не создавать класс MyRunnable:
        // *но если это будет выполняться несколько раз, то воизбежания дублирвоания лучше все же вынести в отдельынй класс*
        new Thread(() -> { // создали новый Thread и сразу же вызвали в нем .start определенной логики;
            for (int i = 0; i < 50; i++) {
                System.out.println("new MyRunnable thread via lambda in class Main " + i);
            }
        }).start();
        // *расшифровка лямба-выражения выше:
/*        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("new MyRunnable thread via lambda in class Main " + 1);
                }
            }
        }).start();*/
        // *второй вариант расшифвроки лямба-выражения выше:
/*        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("new MyRunnable thread via lambda in class Main " + 1);
            }
        });
        thread1.start();*/


//      *выполняется в "основном" потоке Main:
        for (int i = 0; i < 50; i++) { //*быстрое создание цикла (ввод с клавиатуры): 50.fori;
            System.out.println("END *in main"); // - вывод на консоль происзодит в основном потоке Main;
        }


        // 3. implements Callable <-> call(){...} - отличие от предыдущих двух, то что после создания потока будет ждать результат работы;
        // отличается метод создания, так как мы ожидаем какой-то возвращаемый объект
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable()); // обертка(по типу Optional) в которую поток вставит свое значение когда закончит работу. Имеет много различных методов;
        Thread thread1 = new Thread(futureTask);
        thread1.start();
        System.out.println(futureTask.get());

        // просто сам попробовал создать обычным способом (вроде сработало):
/*        MyCallable myCallable = new MyCallable();
        myCallable.call();*/

//------------------------------------------------------------------------------------------

        // Методы для работы с потоками:
//        myThread.start(); // - запуск выполнения потока;
//        System.out.println(myThread.isAlive()); // - проверяет работает ли все еще поток, возвращает значение boolean;
//        System.exit(0); // - просто вышел с потока (не метод "потоков");
//        myThread.interrupt(); // - дать совет планировщику потоков завершить выбранный поток;
//        System.out.println(myThread.isInterrupted()); // - узнать остановлен ли поток (*странно рабоатет);
//        System.out.println(myThread.getName()); // - узнать имя потока;
//        myThread.setName(".setName of myThread"); // - установить имя потока;
//        myThread.setPriority(Thread.MAX_PRIORITY); // - установить приоритет (MIN, NORMAL, MAX);
//        myThread.setPriority(10); // - установить приоритет (1 - min, 10 - max);
//        System.out.println(myThread.getPriority()); // - узнать приоритет потока;
//        Thread.sleep(10000); // - задержка выполнения потока (можно применять c хаком с while(myThread.isAlive){Thread.sleep(100)};
//        Thread.yield(); // - "заставляет" уйти с текущего потока и переклються на другие;
//        myThread.join(); // - "заставляет" ждать выполнение текущего потока(можно указать время ожидания в милисекундах);
//        System.out.println(Thread.currentThread()); // - получить текущий выполняемый поток;


//------------------------------------------------------------------------------------------

//         Synchronized - синхронизирует не паралельность работы, а очередность (нужно применять чтобы была корректная запись данных, иначе может записать не 1000(в сумме), а 700(потому что несколько потоков будут одновременно считывать еще не измененную переменную), например);
        // варианты применения:

        // 1):
//        public void synchronized syncMethod(){...}

        // 2) Non static method:
/*        public void syncMethod(){
            synchronized (this) {...}
        }*/

        // 3) Static method:
/*        public static void syncMethod() {
            synchronized (StaticClass.class) {...}
        }*/

        Thread thread2 = new Thread(() -> method("thread2"));
        Thread thread3 = new Thread(() -> method("thread3"));

        thread2.start();
        thread3.start();

//------------------------------------------------------------------------------------------


//        Deadlock - замкнутый круг/петля (стопается программа), когда объект/монитрр из одого метода в одном потоке пытается обратиться ко второму объекту/монитору в другом потоке и наоборот. Получается что те объекты как раз выполняются в своих потоках и за счет того, что к ним нельзя обратиться, то программа зависает.
        FirstClass firstClassOfDeadlock = new FirstClass();
        SecondClass secondClassOfDeadlock = new SecondClass();

        firstClassOfDeadlock.setSecondClass(secondClassOfDeadlock);
        secondClassOfDeadlock.setFirstClass(firstClassOfDeadlock);

        Thread first = new Thread(() -> System.out.println(firstClassOfDeadlock.getStringFromSecondClass()));
        Thread second = new Thread(() -> System.out.println(secondClassOfDeadlock.getStringFromFirstClass()));

        first.start();
        second.start();


    }



    // 3) Static method:
    private static synchronized void method(String thread) { // synchronized - синхронизация потоков, заставляет потоки выполняться поочередно (вначале полностью отработает поток thread2 а потом thread3, если без этого, то потоки будут выполняться паралельно и вывод на консоль будет в перемешку;
        for (int i = 0; i < 10; i++) {
            ++TEST;
            System.out.println(thread);
        }
    }
}
