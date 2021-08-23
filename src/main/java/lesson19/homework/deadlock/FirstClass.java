package lesson19.homework.deadlock;

public class FirstClass {
    private SecondClass secondClass;

    public SecondClass getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(SecondClass secondClass) {
        this.secondClass = secondClass;
    }

    public static synchronized void printToConsole() {
        System.out.println("PrintToConsole from First class for deadlock");
    }

    public static synchronized void tryToRunInFirstClass() {
        SecondClass.printToConsole();
    }
}
