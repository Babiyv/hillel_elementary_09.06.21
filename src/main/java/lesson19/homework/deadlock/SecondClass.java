package lesson19.homework.deadlock;

public class SecondClass {
    private FirstClass firstClass;

    public FirstClass getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(FirstClass firstClass) {
        this.firstClass = firstClass;
    }

    public static synchronized void printToConsole() {
        System.out.println("PrintToConsole from Second class for deadlock");
    }

    public static synchronized void tryToRunInSecondClass() {
        FirstClass.printToConsole();
    }
}
