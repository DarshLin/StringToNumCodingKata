import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringToNumberConverterTestII {
//    Double.ParseInt("anyDoubleString")
//    given emptyString return null
//    given string 0 return Double 0
//    given string one should return Double 1
//    double digit string should return double digit Double
//    negative should return negative int
//    Exception for non number chars
//    decimal points Double.ParseDouble("anyStringDouble")


    @Test
    public void givenEmptyStringShouldReturnNULL() {
        verifyConversion("", null);
    }

    @Test
    public void given0StringShouldReturn0Double() {
        verifyConversion("0", 0.0);
    }

    @Test
    public void givenStringOneShouldReturnDoubleOne() {
        verifyConversion("1", 1.0);
    }

    @Test
    public void givenString26ShouldReturnDouble26() {
        verifyConversion("26",  26.0);
    }

    @Test
    public void givenAnyNegativeStringShouldReturnNegativeInt() {
        verifyConversion("-1", -1.0);
    }

    @Test (expected = NumberFormatException.class)
    public void givenNonNumberStringShouldThrowException() {
        verifyConversion("Hello World", 1.0);
    }

    @Test
    public void GivenStringNumberWithDecimalPointShouldReturnDoubleWithDecimalPoint() {
        verifyConversion("12.23", 12.23);
    }

    private void verifyConversion(String input, Double expected) {
        assertEquals(expected, convertString(input));
    }

    private Double convertString(String input) {
        if (input.length() > 0) {
            double sum = 0;
            int negativeMultiplier = 1;

            if(input.charAt(0) == '-') {
                negativeMultiplier = -1;
                input = input.substring(1);
            }
            int multiplicationPower = input.length();
            if(input.split("\\.").length > 1) {
                multiplicationPower = input.indexOf('.');
            }
            for (char ch: input.toCharArray()) {
                final int convertedChar = ch;
                if(ch == '.') {
                    continue;
                }
                if (ch < 48 || ch > 57)
                    throw new NumberFormatException();
                multiplicationPower--;
                sum += (convertedChar - 48) * (Math.pow(10, multiplicationPower));
            }
            return Math.round((sum * negativeMultiplier)*100.0)/100.0;
        }

        return null;
    }


}
