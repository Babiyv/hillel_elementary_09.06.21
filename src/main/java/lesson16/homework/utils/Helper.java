package lesson16.homework.utils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*5. Создать класс-хелпер, который будет иметь один метод:
5.1. входящим параметром будет строка;
5.2. метод будет возвращать Optional;
5.3. если строка null/пустая/или не является email - возвращать пустой Optional;
5.4. если строка соответствует регулярному выражению(задать на свое усмотрение)
и является email, то возвращать Optional с этой строкой;*/
public class Helper {

    public Optional emailChecker (String str) { // хотел завернуть входящую строку тоже в Optional, чтобы больше обезопасить, но в условии четко сказано про строку;
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9]+)([\\_\\.\\-{1}])?([a-zA-Z0-9]+)\\@([a-z0-9]+)([\\.])([a-z\\.]+)");
        if (str != null) { // если бы принимал строку в обертке Optional, то наверное могли бы проверять через is.Present;
            Matcher matcher = pattern.matcher(str);
            while (!matcher.matches() || str.isEmpty()) {
                return Optional.empty(); // - обертка с null внутри;
            }
        }
        return Optional.ofNullable(str); // - обертка с чем-то внутри (используем когда мы возможно можем получить null);
    }
}
