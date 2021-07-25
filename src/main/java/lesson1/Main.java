package lesson1;

public final class Main extends Animal { // final - если использует как модификатор доступа для класса, то от этого класса нельзя наследоваться;
    @Override // - можно переопределить метод, так как он не стоит с модификатором доступа final в классе Animal;
    public int getHeight() {
        return 2;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();

        animal.variable1 = 0; // модификатор protected;
        animal.getVariable2 = 0; // модификатор public;

        animal.voice();

        Animal cat = new Cat();
        cat.voice();

        // поскольку у нас main static то мы не можем легко вызвать НЕ static  метод;
        Main main = new Main();
        main.test(cat);

    }

    // instanceof - относится к
    public void test (Animal animal) {
        if (animal instanceof Cat){
            System.out.println("this is cat");
        }
        if (animal instanceof Animal) {
            System.out.println("this is plain animal");
        }
    }


    // Интерфейс - контракт для классов (объект класса обязан содержать)

}
