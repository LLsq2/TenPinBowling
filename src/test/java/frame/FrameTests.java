package frame;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTests {

    @Test
    public void spare() {
        Frame frame = new Frame(5,5);
        Assert.assertEquals(frame.spare, true, "Spare boolean");
        Assert.assertEquals(frame.strike, false, "Strike boolean");
    }

    @Test
    public void strike() {
        Frame frame = new Frame(10,0);
        Assert.assertEquals(frame.spare, false, "Spare boolean");
        Assert.assertEquals(frame.strike, true, "Strike boolean");
    }
}
