package lesson6.homework;

import lesson6.homework.exceptions.StringFormatException;
import lesson6.homework.utils.StringHelper;
import lesson6.homework.utils.ValidationHelper;

/**/
public class Main {
    public static void main(String[] args) throws StringFormatException {

//        4. В Main классе выполнить тестовый вызов и вывести результат выполнения (3. В utils создаем класс-помощник StringHelper...):
        StringHelper stringHelper = new StringHelper();
        char[] charsArray = {'n', 'E', 'w', ' ', 'S', 't', 'R', 'I', 'n', 'g'};
        System.out.println("\"" + stringHelper.concatAndSubstring("str", charsArray) + "\"");

//        6. В Main также вызвать для проверки (5. Создать класс-помощник, внутри которого реализовать 3 метода для проверки параметров.):
        ValidationHelper validationHelper = new ValidationHelper();

//        Проверка номера телефона (5.1):
        String phoneNumber = "+380123456789";
        validationHelper.cellPhoneNumberValidation(phoneNumber);

//        Проверка почты (5.2):
        String email = "andrey.yashin1@gamil.com";
        validationHelper.emailValidation(email);

//        Проверка даты рождения (5.3):
        validationHelper.birthDateValidation("01.02 2021"); // *специально пропустил не ставил одну точку
    }
}
