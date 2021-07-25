package lesson1.homework;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*3. Дальше необходимо создать 2 сервиса: UserService & AdminService.
У обоих этих классов полиморфное поведением прописанных далее методов.
Чтобы выполнить полиморфизм в данном случае необходимо заключить контракт (Подсказка: применить Interface).

 Контракт состоит из следующих методов:
3.1. "Проверить пользователя": Метод принимает входящим параметром пользователя(User или Admin).
В ходе выполнения данного метода идет вычитка из файлика данных и сверка есть ли в этом файлике почта,как у пользователя которого передали в этот метод.
(Файлик с данными необходимо подготовить самостоятельно заранее. Для удобства каждое значение пишите с новой строки в файлике).
Подсказка: Чтобы вычитать данные из файла используем FileReader. И после проверки метод возвращает нашел или нет (true/false).
Данная логика одинакова как для UserService, так и для AdminService.

3.2. "Записать данные пользователя": Метод принимает входящим параметром пользователя(User или Admin) - как метод выше.
В ходе выполнения вычитывает все данные по переданному пользователю и записывает в файлик(для удобства каждое значение с новой строки).
И ничего не возвращает в ответ.
Данный метод доступен только в AdminService, в UserService просто выводить сообщение о недоступности данного метода в сервисе.
*/
public class GeneralService implements Service{
    @Override
    public boolean checkUser(Person person, String pathToFile) throws IOException {
        FileReader fileReader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(fileReader);
        boolean isContain = false;
        while (scanner.hasNextLine()){
            String fileString = scanner.nextLine();
            if (fileString.contains(person.getEmail())) {
                isContain = true;
            }
        }
        fileReader.close();
        scanner.close();
        return isContain;
    }

    /* ВОПРОС: учили что лучше использоовать "concat" вместо "+", нормально ли писать как в данном случае?
        *нарошно сделал такую кракозябру*/
    @Override
    public void writeEntityDataToFile(Person person, String pathToFile) throws IOException {
        System.out.println("Извините, данное действие доступно только для ".concat(Role.ADMIN.toString()).concat(", а ваш статус ").concat(Role.USER.toString()));
    }
}
