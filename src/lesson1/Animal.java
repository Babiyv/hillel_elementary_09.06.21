package lesson1;

public class Animal {

/*
    Инкапсуляция - сокрытие части данных и кода от других пользователей (можно привести аналогию с капсулой)
*/

    private static final String VARIABLE = "CONST";

    private int height; // - видимость только внутри класса;
    int weight; // default (не указывается при объявлении переменной) (private package) - видимость внутри класса или пакета;
    protected int variable1; // - видимость внутри класса, пакета либо для наследников;
    public  int getVariable2; // - открыта видимость для всех;

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() { // - можно поставить модификатор доступа final, чтобы метод нельзя переопределить;
        return height;
    }


//    Полиморфизм - один интерфейс и множемство реализаций
    public void voice() {
        System.out.println("gav gav");
    }

}
