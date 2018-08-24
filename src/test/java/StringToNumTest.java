import org.junit.Assert;
import org.junit.Test;

public class StringToNumTest {
    @Test
    public void shouldReturnNullGivenNothing() {
        verify("", null);
    }


    @Test
    public void shouldReturnDouble0GivenString0() {
        verify("0", 0.0);
    }

    @Test
    public void shouldReturnDouble1GivenString1() {
        verify("1", 1.0);
    }

    @Test
    public void shouldReturn23GivenString23() {
        verify("23", 23.0);
    }

    @Test
    public void shouldReturnNegativeNumberGivenNegativeString() {
        verify("-1",-1.0);
    }

    @Test (expected = NumberFormatException.class)
    public void shouldThrowExceptionGivenNonNumbers() {
        verify("Darsh", 1.0);
    }

    @Test
    public void shouldReturnDecimalDoubleGivenDecimalString() {
        verify("12.236665", 12.236665);
    }

    private void verify(String input, Double expected) {
        Assert.assertEquals(expected, StringToNum(input));
    }

    private Double StringToNum(String input) {
        if (input.length() > 0) {
            int negativeMultiplier = 1;
            int roundFactor = 1;
            if(input.charAt(0) == '-') {
                negativeMultiplier = -1;
                input = input.substring(1);
            }
            int power = input.length();
            double sum = 0;
            if(input.split("\\.").length > 1) {
                power = input.indexOf('.');
                roundFactor = input.split("\\.")[1].length();
            }

            for (char ch : input.toCharArray()) {
                int convertedInt = ch;
                if(ch == '.') {
                    continue;
                }
                if(convertedInt < 48 || (convertedInt > 57)) {
                    throw new NumberFormatException();
                }
                power--;
                sum += (convertedInt - 48) * Math.pow(10, power);
            }

            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '.') {
                    continue;
                }
                if((int)input.charAt(i) < 48 || (int)input.charAt(i) > 57) {
                    throw new NumberFormatException();
                }
                power--;
                sum += ((int)input.charAt(i) - 48) * Math.pow(10, power);
            }

            double result = sum * negativeMultiplier;
            double pow = Math.pow(10.0, roundFactor);
            return Math.round(result * pow)/ pow;
        }
        return null;
    }
}
