package studyjavatest;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testAppHasGretting() {
        App classUnderTest = new App();
        assertNotNull("App should hava a greeting", classUnderTest.getGretting());
    }
}
