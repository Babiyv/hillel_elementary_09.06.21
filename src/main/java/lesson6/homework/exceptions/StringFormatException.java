package lesson6.homework.exceptions;

/*2. В папке exceptions создаем свою проверяемую ошибку StringFormatException;*/
public class StringFormatException extends Exception {
    public StringFormatException(String s) {
        super(s);
    }
}
