package lesson1;

public class Cat extends Animal{
    // Переопределение метода (меняем логику метода из родительского класса):
    @Override // override - переопределение метода;
    public void voice() {
        super.voice(); // super - значает, что вызываем метод как описано в родителе
        System.out.println("may may");
    }



    // Перезагрущзка метода (одно и то же название, но разна логика и принимаемые значения):
    private void voice(int i){
        System.out.println("Cat");
    }

}
