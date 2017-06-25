import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestFuck extends AbstractTest{

    @Test
    public void firstTest() {

        SoftAssert sf = new SoftAssert();

        sf.assertEquals(1,3,"fuck1111111");
        sf.assertEquals(2,2 );
        sf.assertEquals(5,3,"ebati");

        sf.assertAll();

    }

    @Test
    public void secondTest() {
        Assert.assertEquals(1,1);
    }
}
