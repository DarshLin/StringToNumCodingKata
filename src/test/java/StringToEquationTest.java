import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class StringToEquationTest {
    @Test
    public void shouldfReturnNullGivenNullString() {

        verify(null, null);
    }

    @Test
    public void shouldReturnNullGivenEmptyString() {

        verify(null, "");
    }

    @Test
    public void shouldReturn0Given0() {
        verify("0", "0");
    }

    @Test
    public void shouldReturn2Given1Plus1() {
        verify("2", "1+1");
    }

    @Test
    public void shouldReturn23Given11Plus12() {
        verify("23", "11+12");
    }

    private void verify(String expected, String input) {
        assertThat(calculate(input), equalTo(expected));
    }

    private String calculate(String input) {
        if(input != null && input.length() > 0 ) {
            if(input.length() > 1) {
                String[] operators = input.split("\\+");
                Integer sum = Integer.parseInt(operators[0]) + Integer.parseInt(operators[1]);
                return sum.toString();
            }
            return input;
        }
        return null;
    }
}
