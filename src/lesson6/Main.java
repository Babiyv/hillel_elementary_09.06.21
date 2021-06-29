package lesson6;

import lesson5.Client;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String USER_STATUS_INFO = "User with id=%d has status %s";

    public static void main(String[] args) {
        Client client1 = new Client("name", "surname");
        Client client2 = new Client("name", "surname");

        Map<Client, String> map = new HashMap<>();

//        String:
        map.put(client1, "test");
        System.out.println(map);
        System.out.println(map.get(client2)); // выведет на консоль данные клиента1, потому что у них одинаковый хешкод;

        client1.setName("name1");
        System.out.println(map.get(client2)); // после того как изменили имя у нас стал разный хешкоды у клиент1 и клиент2, а поскольку мы не добавляли клиент2 в мапу, то его не выведет на консоль;

        String test = "test";
        System.out.println(test.replace('t', 'a')); // ' ' - одиночные скобочки используются для одного символа char;
        System.out.println(test);

//        String methods:
        String testString = "    _tEst StRIng_    ";
        System.out.println(".length(): " + testString.length()); // - показывает длину строки;
        System.out.println(".toCharArray(): " + testString.toCharArray()); // - преобразовует строку в массив символов;
        System.out.println(".trim(): " + testString.trim()); // - обрезает пробела в начале и ко4нце строки;
        System.out.println(".isEmpty(): " + testString.isEmpty()); // - проеверка на пустоту строки;
        System.out.println("String.valueOf(1): " + String.valueOf(1)); // - преобразует объект в строку;
        System.out.println(".charAt(5): " + testString.charAt(5)); // - возвращает символ по индексу;
        System.out.println(".concat(\"concat\"): " + testString.concat("concat")); // - объединяет строки;
        System.out.println(".equals(test): " + testString.equals(test)); // - сравнивает строки (само значение внутри, а не ссылки в случае с "==");
        System.out.println(".equalsIgnoreCase(test): " + testString.equalsIgnoreCase(test)); // - сравнивает строки игнорируя регистр букв;
        System.out.println(".substring(3): " + testString.substring(3)); // - обрезает от индекса до конца;
        System.out.println(".substring(3, 6): " + testString.substring(3, 6)); // - обрезает от индекса до ирндекса;
        System.out.println(".toLowerCase(): " + testString.toLowerCase()); // - преобразовывает все буквы в нижний регистр;
        System.out.println(".toUpperCase(): " + testString.toUpperCase()); // - преобразовывает все буквы в верхний регистр;

        // String.format:
        System.out.println(String.format("User with id=%d has status %s%n", 1231, "active"));
        System.out.printf(USER_STATUS_INFO, 1231, "active\n"); // * Ctrl + Alt + C - хоткей быстро вывести выделенные текст в константу;

//        RegEx (регулярные выражения):
//        Regex pattern:
        Pattern pattern = Pattern.compile("\\d"); // <- "\d" - ищем целочисленное число но только в строке из одной цифры;
        Matcher matcher0 = pattern.matcher("1"); // то в чем будем искать;
        Matcher matcher00 = pattern.matcher("12"); // то в чем будем искать;
        System.out.println("Pattern.compile(\"\\\\d\"). Matcher matcher = pattern.matcher(\"1\");");
        System.out.println("matcher0.matches()); " + matcher0.matches()); // проверяет всю строку "вся ли строка целое число"
        System.out.println("matcher0.find()); " + matcher0.find());
        System.out.println("Matcher matcher0 = pattern.matcher(\"12\");");
        System.out.println("matcher00.matches()); " + matcher00.matches()); // проверяет всю строку "вся ли строка искомое число"
        System.out.println("matcher00.find());" + matcher00.find());

        Pattern patternD1 = Pattern.compile("\\d+"); // <- "\d+" - ищем целочисленное число в строке из нескольких цифр;
        Matcher matcher1 = patternD1.matcher("1");
        Matcher matcher11 = patternD1.matcher("12");
        System.out.println("Pattern.compile(\"\\\\d+\"). Matcher matcher1 = patternD1.matcher(\"1\");");
        System.out.println("matcher1.matches()); " + matcher1.matches());
        System.out.println("matcher1.find()); " + matcher1.find());
        System.out.println("matcher11.matches()); " + matcher11.matches());
        System.out.println("matcher11.find()); " + matcher11.find());

    }
}
