package lesson6.homework.utils;

import lesson6.homework.exceptions.StringFormatException;

/*3. В utils создаем класс-помощник StringHelper(например), В котором реализовываем один метод.
Принимающие параметры метода: Строка и Массив Символов. Возвращаемый параметр: Строка.
Логика метода:
3.1. Массив символов преобразовать в строку, предварительно проверив чтобы массив не был null.
Если массив null, то бросить ошибку NullPointerException с текстом об отсутствии массива символов;
3.2. Выполнить проверку не пустые ли эти строки(если строка состоит из пробелов, табуляций и прочих пустых символов - также считать пустой строкой).
В случае, если одна из строк оказывается пустой, бросать свою созданную ошибку;
3.3. Если обе строки не пустые, то первую строку привести в верхнему регистру, вторую - к нижнему;
3.4. Обрезать возможные пробелы в конце и вначале каждой строки;
3.5. Выполнить конкатенацию строк разделив их между собой пробелом;
3.6. Зная длину сформированной строки вырезать центральный 1-2 символа(зависит от четности/нечетности длины) и вернуть вызывающей стороне;*/
public class StringHelper {

    public String concatAndSubstring(String string, char[] charsArray) throws StringFormatException { // не пришлось пробрасывать NullPointerException потому что она относится к RuntimeException;
//        3.1:
        if (charsArray == null) {
            throw new NullPointerException("Array of chars is null");
        }
        String newString = String.valueOf(charsArray);

//        3.2:
        if (string.trim().isEmpty() || newString.trim().isEmpty()) {
            throw new StringFormatException("One of strings is empty");
        }

//        3.3
        string = string.toUpperCase();
        newString = newString.toLowerCase();

//        3.4
        string = string.trim();
        newString = newString.trim();

//        3.5
        newString = string.concat(" ".concat(newString));

//        3.6
        if (newString.length() % 2 == 0) {
            newString = newString.substring(newString.length() / 2 - 1, newString.length() / 2 + 1); // 1 символ если четная длина;
        } else {
            newString = newString.substring(newString.length() / 2, newString.length() / 2 + 1); // 2 символа если не четная длина;
        }

        return newString;
    }
}