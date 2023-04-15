package util.exceptions;

public class ExceptionDemo {
    public static double generalException(int number, int divisor) {
        return (float) number / divisor;
    }
    public static double userException(int number, int divisor) throws DivideByZeroException {
        if(divisor == 0) throw new DivideByZeroException("Divided " + number + " by " + divisor);
        return (float) number / divisor;
    }
}

class DivideByZeroException extends Exception {
    public DivideByZeroException(String errorMessage) {
        super(errorMessage);
    }
}
