package lesson16.homework.utils;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*8. Используя функциональные интерфейсы написать следующие функции:*/
public class EmbeddedFunctionalInterfaces {

//    8.1. Predicate: метод, который на вход принимает дробное значение зарплаты. Если это значение больше 1500.0, то возвращает значение true;
    public static Predicate predicate (double salary) {
        // Предикат - функциональный интерфейс Predicate<T> проверяется соблюдение условия, если соблюдается, то возвращает true.
        Predicate<Double> isBiggerThan1500 = var -> var > 1500.00;
//        System.out.println(isBiggerThan1500.test(salary));
        return isBiggerThan1500;
    }

//    8.2. Consumer: метод, который на вход принимает строку, преобразует ее в массив символов и
//    потом печатает эти символы в консоль в виде символов, а не строки;
    public static void consumer (String str) {
//        Consumer<String> stringToCharsArray = (string) -> System.out.println(string.toCharArray()); // - специально закоментировал и оставил два вывода, чтобы не было вопросов "точно ли это чары, а не стркоа";
        Consumer<String> stringToCharsArray = (string) -> printAsCharsArray(string.toCharArray());
        stringToCharsArray.accept(str);
    }

    private static void printAsCharsArray(char[] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + ", ");
        }
        System.out.print("\n");
    }

//    8.3. Function: метод, который на вход принимает целое число от 1 до 10, а возвращает строку в соответствии этому числу, только словом.
//    Например: 3 -> “three”. Если число вне диапазона, то возвращать слово “unknown”;
    public static String function (int number) {
        switch (number) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "fife";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            default:
                return "unknown";
        }
    }

//    8.4. Supplier: метод, который возвращает любое значение на Ваше усмотрение;
    public static LocalDateTime supplier() {
        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        return s.get();
    }

}
