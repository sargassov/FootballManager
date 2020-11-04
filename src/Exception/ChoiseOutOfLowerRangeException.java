package Exception;

public class ChoiseOutOfLowerRangeException extends Exception {
    public ChoiseOutOfLowerRangeException(String message, int minimal){
        super(message);
    }
}
