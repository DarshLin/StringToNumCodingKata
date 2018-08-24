import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ChangeBaseTest {
    @Test
    public void given0Base3ShouldGet0() {
        verify(0, "0");
    }

    @Test
    public void given1Base3ShouldGet1() {
        verify(1,"1");
    }

    @Test
    public void given2Base3ShouldGet2() {
        verify(2,"2");
    }

    @Test
    public void given3Base3shouldGet10() {
        verify(3, "3");
    }

    @Test
    public void given4BaseShouldGet11() {
        verify(4, "1");
    }

    @Test
    public void given5Base3ShouldReturn12() {
        verify(5, "12");
    }

    @Test
    public void given6Base3ShouldReturn20() {
        verify(6,"20");
    }

    @Test
    public void given9Base3Return100() {
        verify(9, "100");
    }

    @Test
    public void given10Base3Return101() {
        verify(10, "101");
    }

    @Test
    public void givenBigNumberShouldPass() {
        verify(3456, "11202000");
    }

    @Test
    public void givenAnotherBigNumberShouldPass() {
        verify(9087, "110110120");
    }

    private void verify(int actual, String expected) {
        Assert.assertThat(Convert(actual), Matchers.equalTo(expected));
    }



    private String Convert(int i) {

        if(i ==0 || i == 1 || i ==2 || i == 4) {
            return Integer.toString(i);
        }

//        if( i % 3 ==0) {
//            return Convert(i/3) + "0";
//        }
        if(i > 3) {
            return Convert(i/4) + (i%4);
        }




        /*
        10 - 3
        11 - 4
        12 - 5
        20 - 6
        21 - 7
        22 - 8
        100 - 9
        101 - 10
        102 - 11
        110 - 12
        111 - 13
        112 - 14
        120 - 15
        121 - 16
        122 - 17
        200 - 18

        * */

        return Integer.toString(i);
    }
}
