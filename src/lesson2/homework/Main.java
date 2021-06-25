package lesson2.homework;

import java.util.*;

/*3. В классе Main создайте еще один дополнительный внутренний метод, который на вход будет принимать 2 параметра
(1- список из любых оберток примитивов(Byte, Integer….), тут необходимо подумать про wildcards;
2-полученная переменная “Information”), и возвращать он будет обработанный “Information”. В этом методе необходимо написать следующую логику:
3.1. Пройтись по всему списку переданному и преобразовав значение в строку записать в список псевдонимов пользователя;
3.2. Далее к данному значению добавить какое-нибудь заданное значение(например: @mail.ua)
и записать в набор почт пользователя и Мапу их соотношения;
3.3. Так же необходимо реализовать проверку уже существующей почты в наборе и не записывать данное значение в случае совпадения

4. В этом же классе Main в методе запуска программы необходимо написать логику работы всей системы:
4.1. вызовите InitializationData, который в свою очередь создаст, наполнит и вернет объект Information со всеми значениями;
4.2. Далее создайте Список с какими-то обертками примитивов(пару значений достаточно);
4.3. Вызовите дополнительный созданный метод Main и передайте все необходимое - убедитесь что все работает.
4.4. Выведите полученный результат в консоль.*/
public class Main {
    public static void main(String[] args) {

//        4.1. *сразу проинициализировал новый объект, чтобы в 4.4 вызвать его на консоль:
        Information information1 = InitializationData.testerOfFunctionality();

//        4.2:
        List<Integer> lisOfIntegers = new ArrayList<>();
        lisOfIntegers.add(1);
        lisOfIntegers.add(2);

//        4.3:
        Set<String> email = new LinkedHashSet<>();
        List<String> nickname = new ArrayList<>();
        Map<String, String> emailNickname = new LinkedHashMap<>();
        Information information2 = new Information(nickname, email, emailNickname);
        extraMethod(lisOfIntegers, information2);

//        4.4:
        System.out.println(information1);
        System.out.println("\n" + information2);
    }

    private static Information extraMethod(List<? extends Number> listOfWraps, Information information) {
        for (Number listOfWrap : listOfWraps) {
            String nickname = listOfWrap.toString();
            String email = listOfWrap.toString().concat("@gmail.com");
            information.getUsersNicknameList().add(nickname);

            if (!information.getUsersEmailSet().contains(email)) {
                information.getUsersEmailSet().add(email);
            }

            if (!information.getEmailToNicknameMap().containsKey(email)) {
                information.getEmailToNicknameMap().put(email, nickname);
            }
        }
        return information;
    }
}