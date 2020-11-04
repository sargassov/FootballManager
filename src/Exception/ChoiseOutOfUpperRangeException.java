package Exception;

public class ChoiseOutOfUpperRangeException extends Exception {
    public ChoiseOutOfUpperRangeException(String message, int minimal){
        super(message);
    }
}
