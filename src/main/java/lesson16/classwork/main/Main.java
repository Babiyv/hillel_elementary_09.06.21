package lesson16.classwork.main;

import lesson16.classwork.intr.TestInterface;
import lesson16.classwork.intr.TestInterfaceImpl;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//       статик метод можем вызвать сразу без создания объекта класса (используется достаточно редко, в отличии от дефоултных методов):
        TestInterface.runStatic();

//       "традиционный" вариант вызова метода - вначале создаем объект класса и затем вызываем метод:
        TestInterface testInterface = new TestInterfaceImpl();
        testInterface.run(); // <- дефоултный метод, не оверрайдили, вызвали сразу
        testInterface.runOld(); // <- обычный метод, оверрайдили в TestInterfaceImpl


//        Optional.of(T value); - обертка с объектом внутри;
//        Optional.empty(); - обертка с null внутри;
//        Optional.ofNullable(); - обертка с чем-то внутри (используем когда мы возможно можем получить null);

//        optional.isPresent(); - есть ли что-то внутри обертки, если null - false, иначе - true;
//        optional.ifPresent(); - если есть что-то внутри обертки, если null - false, иначе - true;
//        optional.get(); - достанет то, что внутри, используется вместе с isPresent;
//        optional.orElse(Object o); - достанет то, что внутри,но если там null то вернет объект;
//        optional.orElseThrow(Supplier<?> exception); - достанет то, что внутри или бросит ошибку;
//        optional.filter(); / map(); / ifPresent(); - позволяет сразу выполнить действия над объектом;

//        calculate1(null);
        calculate1(Optional.of("null"));

        calculate().ifPresent(System.out::println); // ifPresent - если содержит, то выведи это на консоль;

//        пробуем с Optional (заменяет if-else):
        String result = calculate().orElse("result after return Optional.empty()"); // orElse - метод возвращающий то что в обертке, либо то что передадим в скобочках;
        System.out.println(result.toCharArray());

//        пробуем аналогичное, но уже без Optional (по старинке):
/*        String result1 = calculateWithoutOptional();
        if (result1 != null)
            System.out.println(result1.toCharArray());
        else
            System.out.println("result".toCharArray());*/


//        isPresent:
/*          Optional<String> result2 = calculate();
//          вот  это ... :
            if (result2.isPresent()) {
            System.out.println(result2.get());
        }
//        ...равноценно вот этому:
//        ifPresent:result2.ifPresent(System.out::println);*/


//         Анонимный класс сразу создали класс и его объект, и там же написали реализацию его метода (например если нам нужно использовать его только в одном месте):
/*        MyFunctIntr myFunctIntr = new MyFunctIntr() { // условно говоря создали класс и тут же
            @Override
            public int run(String first, String second) {
                System.out.println(first + second);
                return first.length() + second.length();
            }
        };*/
//        Лямба-выражение как аналог записи выше (создание анонимного класса):
//        MyFunctIntr myFunctIntrWithLambda = (a, b) -> a.length() + b.length();

//        Пример лямба выражений №2:
//        MyFunctIntr myFunctIntrWithLambda1 = (a, b) -> concat(a,b);
        // обычная запись (аналогичная верхней по сути):
/*        System.out.println(myFunctIntr1.run("asdas", "asdasd"));
        myFunctIntrWithLambda1.run("asdas", "asdasd");*/

//        Пример лямба-выражения №3:
        // обычная запись:
/*        public int calculate (int a, int b) {
            return a + b;
        }*/
        // лямбда-выражение:
//        (a, b) -> (a + b); // вначале описываем параметры, а потом то, что мыс ними делаем. "->" - символ лямбда-выражения;


//        Предикат - функциональный интерфейс Predicate<T> проверяется соблюдение условия, если соблюдается, то возвращает true.
//        Predicate<List> predicate = (first) -> first.isEmpty();
//        predicate.test(new ArrayList());


//        Function<T, R> - принимает одно и трансформирует в другое ((R apply T t););
//        Consumer<T> - принимает объект, потом может выполнить с ним какие-то действия, но ничего не возвращает;
//        Supplier<T> - ничего не принимает, только возвращает (T get(););

//        BiPredicate<T, U> - принимает два параметра (boolean test(T t, U u););
//        BiConsumer<T, U> - void accept (T t, U u);
//        BiFunction<T, U, R> - R apply(T t, U u);
    }

    private static int concat(String first, String second) {
        System.out.println(first + second);
        return first.length() + second.length();
    }

//    Optional - вспомогательный класс обертка над тем, что в нее положили; отлавливает "null" и помогает избежать ошибки "Null pointer exception":
    public static void calculate1(Optional<String> myString){ // обезопашиваем себя от того, что в метод может прийти "null";
        myString.ifPresent(System.out::println); // ifPresent - если null, то сделай *это*
        System.out.println(myString);
    }

    public static Optional<String> calculate() {
        return Optional.empty();
//        return Optional.of("String Optional.of(String)");
    }

    public static Optional<String> calculate(Optional<String> myString) { // в принимающем типе данных прописываем Optional чтобы не пришел "null", а в возвращаемом чтобы не отдать "null";
/*        String result = calculateWithoutOptional();
        return Optional.ofNullable(result);*/ //ofNullable - желательно использовать в тех случаях когда неизвестно придет ли нам null;
//        return Optional.of(null);
        return Optional.of("1");
//        return myString;
    }

    public static String calculateWithoutOptional() {
        return null;
    }
}
