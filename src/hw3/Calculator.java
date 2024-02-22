package hw3;

public class Calculator {

    public static <T1 extends Number, T2 extends Number> T2 sum(T1 value1, T2 value2){
        double res = value1.doubleValue() + value2.doubleValue();
        return findCast(res, value2);

    }

    public static <T1 extends Number, T2 extends Number> T2 multiply(T1 value1, T2 value2){
        double res = value1.doubleValue() * value2.doubleValue();
        return findCast(res, value2);
    }

    public static <T1 extends Number, T2 extends Number> T2 divide(T1 value1, T2 value2){
        if (value2.doubleValue() != 0 ){
            double res = value1.doubleValue() / value2.doubleValue();
            return findCast(res, value2);
        } else {
            throw new ArithmeticException("/ by Zero");
        }
    }

    public static <T1 extends Number, T2 extends Number> T2 subtract(T1 value1, T2 value2){
        double res = value1.doubleValue() - value2.doubleValue();
        return findCast(res, value2);
    }

    private static <T2> T2 findCast(double operation, T2 value){
        if (value instanceof Double) {
            return (T2) Double.valueOf(operation);
        } else if (value instanceof Float) {
            return (T2) Float.valueOf((float) operation);
        } else if (value instanceof Long) {
            return (T2) Long.valueOf((long) operation);
        } else {
            return (T2) Integer.valueOf((int) operation);
        }
    }

}
