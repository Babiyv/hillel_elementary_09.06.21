package lesson4.homework.utils;

import lesson4.homework.exceptions.UserExpectedError;
import lesson4.homework.exceptions.WrongFieldException;
import lesson4.homework.exceptions.WrongSumException;

/*4. В папке ‘utils’ создать Класс-хелпер для проверки параметров:
4.1. Метод 1: Входящим параметром принимает Идентификатор Аккаунта клиента и ничего не возвращает.
 Проверяет, чтобы размер переданного параметра был равен 10, в случае несоответствия бросал ошибку WrongFieldException;
4.2. Метод 2: На вход принимает Сумму и ничего не возвращает. Если переданная сумма больше 1000, то бросает ошибку WrongSumException;
4.3. Метод 3: На вход принимает 2 параметра
 (Идентификатор Аккаунта клиента который отправляет и Идентификатор Аккаунта клиента которому отправляют перевод) и ничего не возвращает.
 Если эти два параметра между собой равны, то бросаем ошибку UserExpectedError(сделано для упрощения логики).
*4.4. Данные методы не знают как обрабатывать эти ошибки*/
public class Helper {

    private static final double MAX_SUM = 1000;
    private static final int MANDATORY_ACCOUNT_ID_LENGTH = 10;

    public static double getMaxSum() {
        return MAX_SUM;
    }

    public static int getMandatoryAccountIdLength() {
        return MANDATORY_ACCOUNT_ID_LENGTH;
    }

    //    4.1:
    public static void checkClientAccountIdSize(String clientAccountId) throws WrongFieldException {
        if (clientAccountId.length() != MANDATORY_ACCOUNT_ID_LENGTH) {
            throw new WrongFieldException();
        }
    }

    //    4.2:
    public static void checkTheSum(Double sum) throws WrongSumException { // добавил бы еще чтобы принимал сумму ограничения, чтобы если она менялась (например законодательно), то можно было бы это легко править в самой программе;
        if (sum > MAX_SUM) {
            throw new WrongSumException();
        }
    }

    //    4.3:
    public static void checkTransactionClientsAccountsId(String senderClientAccountId, String recipientClientAccountId) {
        if (senderClientAccountId.equals(recipientClientAccountId)) {
            throw new UserExpectedError();
        }
    }
}
