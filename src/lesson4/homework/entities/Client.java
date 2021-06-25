package lesson4.homework.entities;

/*2. В папке ‘entities’ создать один класс-сущность: Клиент. И прописать поля:
2.1. Строковое значение: идентификатор клиента;
2.2. Строковое значение: Фамилия;
2.3. Строковое значение: Идентификатор Аккаунта клиента;
2.4. Дробное значение: Сумма*/
public class Client {
    private String clientId;
    private String surnameClient;
    private String clientAccountId;
    private double sum;

    public Client(String clientId, String surnameClient, String clientAccountId, double sum) {
        this.clientId = clientId;
        this.surnameClient = surnameClient;
        this.clientAccountId = clientAccountId;
        this.sum = sum;
    }

    public String getIdClient() {
        return clientId;
    }

    public void setIdClient(String idClient) {
        this.clientId = idClient;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public void setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
    }

    public String getClientAccountId() {
        return clientAccountId;
    }

    public void setClientAccountId(String clientAccountId) {
        this.clientAccountId = clientAccountId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", surnameClient='" + surnameClient + '\'' +
                ", idClientAccount='" + clientAccountId + '\'' +
                ", sum=" + sum +
                '}';
    }
}