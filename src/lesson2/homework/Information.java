package lesson2.homework;

import java.util.*;

/*1. Создайте класс “Information”, у которого будет 3 переменных:
1.1. Список псевдонимов пользователя(List) - тут будет храниться список строковых значений;
1.2. Набор почт пользователя(Set) - тут будет храниться набор почт потенциальных пользователей.
Данная коллекция обеспечит уникальность записей без дублей. Так же строковое значение;
1.3. Мапа соотношений “почта-псевдоним” - тут будет записываться соотношение какой почте соответствует какой псевдоним. Почта является ключом Мапы!*/
public class Information {
    private List<String> usersNicknameList;
    private Set<String> usersEmailSet;
    private Map<String, String> emailToNicknameMap;

    public Information(List<String> usersNicknameList, Set<String> usersEmailSet, Map<String, String> emailToNicknameMap) {
        this.usersNicknameList = usersNicknameList;
        this.usersEmailSet = usersEmailSet;
        this.emailToNicknameMap = emailToNicknameMap;
    }

    public List<String> getUsersNicknameList() {
        return usersNicknameList;
    }

    public void setUsersNicknameList(List<String> usersNicknameList) {
        this.usersNicknameList = usersNicknameList;
    }

    public Set<String> getUsersEmailSet() {
        return usersEmailSet;
    }

    public void setUsersEmailSet(Set<String> usersEmailSet) {
        this.usersEmailSet = usersEmailSet;
    }

    public Map<String, String> getEmailToNicknameMap() {
        return emailToNicknameMap;
    }

    public void setEmailToNicknameMap(Map<String, String> emailToNicknameMap) {
        this.emailToNicknameMap = emailToNicknameMap;
    }

    @Override
    public String toString() {
        return "Information{" +
                "\nusersNicknameList=" + usersNicknameList +
                ". \nusersEmailSet=" + usersEmailSet +
                ". \nemailToNicknameMap=" + emailToNicknameMap +
                '}';
    }
}
