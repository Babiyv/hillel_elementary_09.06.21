package lesson4.homework;

import lesson4.homework.entities.Client;
import lesson4.homework.exceptions.WrongFieldException;
import lesson4.homework.exceptions.WrongSumException;
import lesson4.homework.services.TransactionService;
import lesson4.homework.utils.Helper;

import java.util.Arrays;
import java.util.Scanner;

/*6. Далее создаем класс Main (параллельно созданным ранее папкам) и прописываем следующую логику:
6.1. С помощью класса Scanner, который помогает ввести данные с клавиатуры, попросить пользователя ввести Идентификатор Аккаунта клиента.
После чего вызвать Класс-хелпер(метод 1) и передать этот параметр для валидации.
Обработать потенциальную ошибку и в случае ошибки уведомить, что данные введены не корректно и попросить ввести значение снова.
Пока клиент не введет корректное значение, программа должна его запрашивать. (Это поле нашего Клиента: Идентификатор Аккаунта клиента);

6.2. Далее схожим образом попросить пользователя ввести Идентификатор Аккаунта клиента, на который потенциально будет выполняться перевод,
так же провалидировать, отреагировать на ошибку и запрашивать пока данные не будут введены корректно.
(Это Идентификатор Аккаунта клиента, который будет передан далее отдельно);

6.3. И третьим параметром просить ввести сумму перевода, вызвать Класс-хелпер(метод 2) для проверки суммы перевода и передать параметр суммы.
Обработать схожим образом потенциальную ошибку и запрашивать ввести корректное значение пока пользователь не введет необходимое.
(Это поле Клиента: Сумма);

6.4. И финально вызвать ранее созданные класс Сервиса с методом Передачи Денег.
Обрабатывать ошибку не надо, в случае ошибки программа просто должна падать с ранее созданной ошибкой UserExpectedError.
После вызова уведомить об успешном переводе средств.*/
public class Main {
    public static void main(String[] args) throws WrongFieldException {
        Scanner sc = new Scanner(System.in);

//        6.1
        System.out.print("Please enter your account ID: ");
        String inputSenderAccountId = sc.nextLine();
        inputSenderAccountId = checkAccountIdLength(inputSenderAccountId, sc); // *вынес отдельным методом, чтобы не дублировать код в 6.2

//        6.2
        System.out.print("Please enter recipient account ID: ");
        String inputRecipientAccountId = sc.nextLine();
        inputRecipientAccountId = checkAccountIdLength(inputRecipientAccountId, sc);

//        6.3
        System.out.print("Sum of transaction: ");
        Double sumOfTransaction = sc.nextDouble();
        sumOfTransaction = checkTheSumOfTransaction(sumOfTransaction, sc); // *хоть и не дублируется, но вынес отдельным методом, потому что помню как говорили на паре о том, что код удобнее читать и фиксить когда он разбит на методы;

//        6.4
        Client clientSender = new Client("14", "clientSurname", inputSenderAccountId, sumOfTransaction);
        TransactionService.moneyTransaction(clientSender, inputRecipientAccountId);
        System.out.println("Money transaction is successful!");
        sc.close();
    }

    private static Double checkTheSumOfTransaction(Double sumOfTransaction, Scanner sc) {
        while (sumOfTransaction > 1000) {
            try {
                Helper.checkTheSum(sumOfTransaction);
            } catch (WrongSumException e) {
                e.printStackTrace(); // *Специально оставил два разных варианта как шпаргалку на будущее. Предыдущий вариант писал ручками, а тут автоматом сгенерировало чуть иначе, но вроде тоже самое (только другим цветом);
            }
            System.out.print("Sorry, but you can`t send more than 1000. \nPlease enter sum less than 1000: ");
            sumOfTransaction = sc.nextDouble();
        }
        return sumOfTransaction;
    }

    private static String checkAccountIdLength(String inputClientAccountId, Scanner sc) throws WrongFieldException {
        while (inputClientAccountId.length() != 10) {
            try {
                Helper.checkClientAccountIdSize(inputClientAccountId);
            } catch (WrongFieldException wfe) {
                System.out.println(wfe);
                System.out.println(Arrays.toString(wfe.getStackTrace())); // .getStackTrace() - отображает более глубинно и подробно откуда вылазит ошибка;
            }
            System.out.print("Please enter correct your account ID. It must contain 10 symbols: ");
            inputClientAccountId = sc.nextLine();
        }
        return inputClientAccountId;
    }
}