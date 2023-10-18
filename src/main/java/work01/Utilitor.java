package work01;

public class Utilitor {
    public static String testString(String value) {
        if (value == null) {
            throw new NullPointerException("This value is null");
        } else if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("This value is a empty string");
        }
        return value;
    }
 
    public static double testPositive(double value) {
        if (value <= 0)
            throw new IllegalArgumentException("This value is not a positive number");
        return value;
        }

    public static long computeIsbn10(long isbn10) {
        long l = Long.toString(isbn10).length();
        long sum = 0;
        long digit = isbn10 % 10;
        for(int i = 10;i >= 2; i++){
            sum += digit*i;
            isbn10/=10;
        }
        return isbn10%11;
    }


}
