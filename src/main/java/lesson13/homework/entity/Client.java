package lesson13.homework.entity;

import lombok.Data;

@Data // - анотация "создающая под капотом" геттеры, сеттеры и ту стринг (без неодбходимости прописывать вручную). Часть подключенной библиотеки lombok (внутри pom.xml).
public class Client {
    private int id;
    private String name;
    private String email;
    private long phone;
    private String about;
    private int age;
}
