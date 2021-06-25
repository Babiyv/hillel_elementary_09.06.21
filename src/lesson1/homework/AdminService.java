package lesson1.homework;

import java.io.FileWriter;
import java.io.IOException;

/* 3.2. "Записать данные пользователя": Метод принимает входящим параметром пользователя(User или Admin) - как метод выше.
В ходе выполнения вычитывает все данные по переданному пользователю и записывает в файлик(для удобства каждое значение с новой строки).
И ничего не возвращает в ответ.
Данный метод доступен только в AdminService, в UserService просто выводить сообщение о недоступности данного метода в сервисе.*/
public class AdminService extends GeneralService{

//    лажа в том, что метод будет записывать каждый раз при выполнении кода, за счет чего можно наплодить дубликатов :(
    @Override
    public void writeEntityDataToFile(Person person, String pathToFile) throws IOException {
        FileWriter fileWriter = new FileWriter(pathToFile, true); // - булевое значение true вписали для того, чтобы строка добавлялась в существующий файл, иначе он каждый раз будет удаляться и создавться новый со всеми строками;
        fileWriter.write(person.toString());
        fileWriter.close();
    }
}
