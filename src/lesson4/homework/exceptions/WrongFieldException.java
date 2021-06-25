package lesson4.homework.exceptions;

/*3.2. WrongFieldException(должна быть Checked);*/
public class WrongFieldException extends Exception {
    public WrongFieldException() {
        super("Checked WrongFieldException");
    }
}