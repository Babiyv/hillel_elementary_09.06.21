package lesson13.homework.entity;

import lombok.Data;

/*3. Создать сущности для этих daos, опираясь на поля таблиц из ДЗ_11 по работе с SQL; */
@Data
public class Account {
    private int id;
    private int clientId;
    private String number;
    private double value;
}
