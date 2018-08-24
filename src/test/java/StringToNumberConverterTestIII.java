import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringToNumberConverterTestIII {
//    Double.ParseInt("anyDoubleString")
//    given emptyString return null
//    given string 0 return Double 0
//    given string one should return Double 1
//    double digit string should return double digit Double
//    negative should return negative int
//    Exception for non number chars
//    decimal points Double.ParseDouble("anyStringDouble")


    @Test
    public void givenEmptyStringShouldReturnNull() {
        verifyConvertedDouble("", null);
    }

    @Test
    public void givenString0ShouldReturnDouble0() {
        verifyConvertedDouble("0", 0.0);
    }

    @Test
    public void givenStringNumberOneShouldRetunDoubleOne() {
        verifyConvertedDouble("1", 1.0);
    }

    @Test
    public void givenDoubleDigitStringShouldReturnDoubleDigitInt() {
        verifyConvertedDouble("29", 29.0);
    }

    @Test
    public void givenNegativeStringNumberShouldReturnNegativeDouble() {
        verifyConvertedDouble("-1", -1.0);
    }

    @Test (expected = NumberFormatException.class)
    public void givenNonNumberStringsShouldThrowNUmberFormatException() {
        verifyConvertedDouble("Maya", 1.0);
    }

    @Test
    public void StringNumberWithDecimalPointShouldReturnItdEquvalentDoubleNumber() {
        verifyConvertedDouble("0.5", 0.5);
    }

    @Test
    public void shouldReturnDecimalGivenFraction() {
        verifyConvertedDouble("1/2", 0.5);
    }

    private void verifyConvertedDouble(String input, Double expected) {
        assertEquals(expected, convertStringNumberToDouble(input));
    }

    private Double convertStringNumberToDouble(String input) {
        if (input.length() > 0) {
            double sum = 0;
            int negativeMultiplier = 1;
            if(input.charAt(0) == '-') {
                negativeMultiplier = -1;
                input = input.substring(1);
            }
            String[] substrings = input.split("\\/");
            if(substrings.length > 1) {
                double firstElement = (int) (substrings[0].charAt(0)) - 48;
                double secondElement = (int) (substrings[1].charAt(0)) - 48;
                double result = firstElement/ secondElement;
                input = "" + result;
            }
            int powerMultiplier = input.length();
            if(input.split("\\.").length > 1) {
                powerMultiplier = input.indexOf('.');
            }
            for (char ch: input.toCharArray()) {
                if(ch == '.') {
                    continue;
                }
                if (ch < 48 || ch > 57)
                    throw  new NumberFormatException();
                final int convertedChar = ch;
                powerMultiplier--;
                sum += (convertedChar -48) * Math.pow(10, powerMultiplier);
            }
            double v = sum * negativeMultiplier;
            return Math.round(v * 100.0)/100.0;

        }
        return null;
    }
}
