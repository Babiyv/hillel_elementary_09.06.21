package lesson4.homework.services;

import lesson4.homework.entities.Client;
import lesson4.homework.utils.Helper;

/*5. В папке ‘services’ создаем класс Сервис Транзакций, внутри которого создаем один метод:
Передача Денег. Этот метод на вход принимает 2 параметра (сущность Клиент и Идентификатор Аккаунта клиента) и ничего не возвращает.
Внутри идет вызов созданного Класса-хелпера, метода 3.*/
public class TransactionService {
    public void moneyTransaction(Client client, String clientAccountId) {
        Helper helper = new Helper();
        helper.checkTransactionClientsAccountsId(client.getClientAccountId(), clientAccountId);
    }
}