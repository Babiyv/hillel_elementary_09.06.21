package lesson6.homework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*5. Создать класс-помощник, внутри которого реализовать 3 метода для проверки параметров:
5.1. Номер телефона(Украинский формат);
5.2. Почта;
5.3. Дата рождения.
 */
public class ValidationHelper {

    //    5.1. Номер телефона(Украинский формат);
    public void cellPhoneNumberValidation(String phoneNumber) {
        Pattern pattern = Pattern.compile("^(\\+380)[0-9]{9}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            System.out.println("Phone number is valid");
        } else {
            System.out.println("Phone number isn`t valid");
        }
    }

    //    5.2. Почта;
    public void emailValidation(String email) {
//        Дикая(всестороняя) проверка почты "передающаяся на форумах из уст в уста" (оставил как записки на будующее):
//        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])\n");
        Pattern pattern = Pattern.compile("([a-zA-Z0-9]+)([\\_\\.\\-{1}])?([a-zA-Z0-9]+)\\@([a-z0-9]+)([\\.])([a-z\\.]+)");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("Email is valid");
        } else {
            System.out.println("Email isn`t valid");
        }
    }

    //    5.3. Дата рождения.
    public void birthDateValidation(String date) {
        Pattern pattern = Pattern.compile("((0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d{2}))");
        Matcher matcher = pattern.matcher(date);

        if (matcher.matches()) {
            System.out.println("Date is valid");
        } else {
            System.out.println("Date isn`t valid");
        }
    }
}
