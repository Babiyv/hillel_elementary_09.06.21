package lesson2.homework;

import java.util.*;

/*2. Создать класс “InitializationData” и метод внутри него, который будет предоставлять/наполнять данные для теста функционала.
Этот класс в итоге должен вернуть объект класса “Information”, с наполненными данными. Условия наполнения:
2.1. Наполнить тридцатью уникальными значениями каждое из 3х полей класса “Information” (можно автоматически в цикле);
2.2. Добавить в каждое поле класса “Information” 10 одинаковых значений
(Будьте внимательны при наполнении Списка псевдонимов пользователя, так как эта коллекция не гарантирует уникальность значений);
2.3. При отдаче сущности “Information” созданного класса “InitializationData”
необходимо чтобы размер 3х полей был одинаковым(List.size() == Set.size() = Map.size()).
Для данной проверки и корректировки, возможно, Вам понадобиться дополнительный внутренний(private) метод.*/
public class InitializationData {

    public static Information testerOfFunctionality() { // - не сказано, что метод должен что-то принимать (хотя изначально принимал), но в 4.1. сказано: создаст, заполнит и вернет объект Information со всеми значениями;
        Set<String> email = new LinkedHashSet<>();
        List<String> nickname = new ArrayList<>();
        Map<String, String> emailNickname = new LinkedHashMap<>();
        Information information = new Information(nickname, email, emailNickname);

        fillThirtyUniques(information); // <- 2.1.
        fillTenSames(information); // <- 2.2.
        clearNotUniques(information); // <- 2.3.
        return information;
    }

    private static void clearNotUniques(Information object) {
        Set<String> cleaningSet = new LinkedHashSet<>(object.getUsersNicknameList());
        object.getUsersNicknameList().clear();
        object.getUsersNicknameList().addAll(cleaningSet);
    }

    private static void fillTenSames(Information object) {
        String nickname = "sameNickname";
        String email = "sameNickname@gmail.com";
        for (int i = 0; i < 10; i++) {
            object.getUsersNicknameList().add(nickname);
            object.getUsersEmailSet().add(email);
            object.getEmailToNicknameMap().put(email, nickname);
        }
    }

    private static void fillThirtyUniques(Information object) {
        for (int i = 0; i < 30; i++) {
            String nickname = "uniqueNickname" + (i + 1);
            String email = "uniqueNickname" + (i + 1) + "@gmail.com";
            object.getUsersNicknameList().add(nickname);
            object.getUsersEmailSet().add(email);
            object.getEmailToNicknameMap().put(email, nickname);
        }
    }
}
