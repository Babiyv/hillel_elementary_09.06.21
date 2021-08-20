package lesson19.classwork.deadlock;

public class SecondClass {
    private FirstClass firstClass;

    public FirstClass getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(FirstClass firstClass) {
        this.firstClass = firstClass;
    }

    public synchronized String getString() {
        return "Hello from second class";
    }

    public synchronized String getStringFromFirstClass() {
        return firstClass.getString();
    }
}
