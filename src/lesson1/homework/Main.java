package lesson1.homework;

import java.io.IOException;

/* 4. После того как все классы написаны, в классе Main запустить программу с определенной логикой:
    4.1. Создать 2 разных сущности User & Admin.
    4.2. С любым из сущностей вызвать UserService(Записать данные пользователя) - убедиться, что наш запрет работает и выводиться нужное сообщение.
    4.3. С каждой из сущностей вызвать AdminService(Записать данные пользователя) - сохранить данные в файлик.
    4.4. С сущностью Admin вызвать сервис UserService(Проверить пользователя) - убедиться что данный пользователь есть в файлике.
    4.5. С сущностью User вызвать сервис AdminService(Проверить пользователя) - убедиться что данный пользователь есть в файлике.*/
public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH_TO_DATAFILE = "C:\\Users\\Admin\\IdeaProjects\\hillel_elementary_09.06.21\\src\\resources\\lesson1_homework_datafile.txt";

//      4.1. Создать 2 разных сущности User & Admin.
        Admin admin = new Admin("Andrey", "Yashin", 22, "a.yashin@gmail.com", "0000");
        User user = new User("User", "Userovich", 28, "user@mail.com", "0000");

//      4.2. С любым из сущностей вызвать UserService(Записать данные пользователя) - убедиться, что наш запрет работает и выводиться нужное сообщение.
        UserService userService = new UserService();
        userService.WriteEntityDataToFile(admin, PATH_TO_DATAFILE);
        userService.WriteEntityDataToFile(user, PATH_TO_DATAFILE);

//      4.3. С каждой из сущностей вызвать AdminService(Записать данные пользователя) - сохранить данные в файлик.
        AdminService adminService = new AdminService();
        adminService.WriteEntityDataToFile(admin, PATH_TO_DATAFILE);
        adminService.WriteEntityDataToFile(user, PATH_TO_DATAFILE); // ВОПРОС: почему-то записало в файл без разрыва с верхней записью (а если выводить просто на консоль, то разрыв есть);

//      4.4. С сущностью Admin вызвать сервис UserService(Проверить пользователя) - убедиться что данный пользователь есть в файлике.
        System.out.println(userService.checkUser(admin, PATH_TO_DATAFILE));

//      4.5. С сущностью User вызвать сервис AdminService(Проверить пользователя) - убедиться что данный пользователь есть в файлике.
        System.out.println(adminService.checkUser(user, PATH_TO_DATAFILE));
    }
}