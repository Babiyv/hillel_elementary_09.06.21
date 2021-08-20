package lesson19.classwork.deadlock;

public class FirstClass {
    private SecondClass secondClass;

    public SecondClass getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(SecondClass secondClass) {
        this.secondClass = secondClass;
    }

    public synchronized String getString() {
        return "Hello from first class";
    }

    public synchronized String getStringFromSecondClass() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return secondClass.getString();
    }
}
