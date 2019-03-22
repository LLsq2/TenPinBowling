package frame;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class FrameLogicTests {

    @Test
    public void perfectFinalFrame() {
        int[] rolls = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,10,10};
        FrameLogic logic = new FrameLogic();
        List<Frame> frames = logic.rollsToFrames(rolls);
        Frame finalFrame = frames.get(9);

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(finalFrame.rollOne, 10, "Roll 1 failed");
        sa.assertEquals(finalFrame.rollTwo, 10, "Roll 2 failed");
        sa.assertEquals(finalFrame.rollThree, 10, "Roll 3 failed");

        sa.assertAll();
    }

    @Test
    public void spareFinalFrame() {
        int[] rolls = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,5,10};
        FrameLogic logic = new FrameLogic();
        List<Frame> frames = logic.rollsToFrames(rolls);
        Frame finalFrame = frames.get(9);

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(finalFrame.rollOne, 5, "Roll 1 failed");
        sa.assertEquals(finalFrame.rollTwo, 5, "Roll 2 failed");
        sa.assertEquals(finalFrame.rollThree, 10, "Roll 3 failed");

        sa.assertAll();
    }

    @Test
    public void noThirdRollFinalFrame() {
        int[] rolls = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,4,4,4,4};
        FrameLogic logic = new FrameLogic();
        List<Frame> frames = logic.rollsToFrames(rolls);
        Frame finalFrame = frames.get(9);

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(finalFrame.rollOne, 5, "Roll 1 failed");
        sa.assertEquals(finalFrame.rollTwo, 4, "Roll 2 failed");
        sa.assertEquals(finalFrame.rollThree, 0, "Roll 3 failed");

        sa.assertAll();
    }

    @Test
    public void consecutiveStrikeFrames() {
        int[] rolls = {10,10,10,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0};
        FrameLogic logic = new FrameLogic();
        List<Frame> frames = logic.rollsToFrames(rolls);
        Frame frame1 = frames.get(0);
        Frame frame2 = frames.get(1);
        Frame frame3 = frames.get(2);
        Frame frame4 = frames.get(3);

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(frame1.rollOne, 10, "Roll 1 failed");
        sa.assertEquals(frame1.rollTwo, 0, "Roll 2 failed");
        sa.assertEquals(frame1.rollThree, 0, "Roll 3 failed");
        sa.assertEquals(frame2.rollOne, 10, "Roll 1 failed");
        sa.assertEquals(frame2.rollTwo, 0, "Roll 2 failed");
        sa.assertEquals(frame2.rollThree, 0, "Roll 3 failed");
        sa.assertEquals(frame3.rollOne, 10, "Roll 1 failed");
        sa.assertEquals(frame3.rollTwo, 0, "Roll 2 failed");
        sa.assertEquals(frame3.rollThree, 0, "Roll 3 failed");
        sa.assertEquals(frame4.rollOne, 1, "Roll 1 failed");
        sa.assertEquals(frame4.rollTwo, 2, "Roll 2 failed");
        sa.assertEquals(frame4.rollThree, 0, "Roll 3 failed");

        sa.assertAll();
    }

    @Test
    public void alternateStrikeFrames() {
        int[] rolls = {10,3,4,10,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0};
        FrameLogic logic = new FrameLogic();
        List<Frame> frames = logic.rollsToFrames(rolls);
        Frame frame1 = frames.get(0);
        Frame frame2 = frames.get(1);
        Frame frame3 = frames.get(2);
        Frame frame4 = frames.get(3);

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(frame1.rollOne, 10, "Roll 1 failed");
        sa.assertEquals(frame1.rollTwo, 0, "Roll 2 failed");
        sa.assertEquals(frame1.rollThree, 0, "Roll 3 failed");
        sa.assertEquals(frame2.rollOne, 3, "Roll 1 failed");
        sa.assertEquals(frame2.rollTwo, 4, "Roll 2 failed");
        sa.assertEquals(frame2.rollThree, 0, "Roll 3 failed");
        sa.assertEquals(frame3.rollOne, 10, "Roll 1 failed");
        sa.assertEquals(frame3.rollTwo, 0, "Roll 2 failed");
        sa.assertEquals(frame3.rollThree, 0, "Roll 3 failed");
        sa.assertEquals(frame4.rollOne, 1, "Roll 1 failed");
        sa.assertEquals(frame4.rollTwo, 2, "Roll 2 failed");
        sa.assertEquals(frame4.rollThree, 0, "Roll 3 failed");

        sa.assertAll();
    }

    @Test
    public void ZeroTenSpareFrame() {
        int[] rolls = {0,0,0,10,3,4,10,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0};
        FrameLogic logic = new FrameLogic();
        List<Frame> frames = logic.rollsToFrames(rolls);
        Frame frame1 = frames.get(0);
        Frame frame2 = frames.get(1);
        Frame frame3 = frames.get(2);

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(frame1.rollOne, 0, "Roll 1 failed");
        sa.assertEquals(frame1.rollTwo, 0, "Roll 2 failed");
        sa.assertEquals(frame1.rollThree, 0, "Roll 3 failed");
        sa.assertEquals(frame2.rollOne, 0, "Roll 1 failed");
        sa.assertEquals(frame2.rollTwo, 10, "Roll 2 failed");
        sa.assertEquals(frame2.rollThree, 0, "Roll 3 failed");
        sa.assertEquals(frame3.rollOne, 3, "Roll 1 failed");
        sa.assertEquals(frame3.rollTwo, 4, "Roll 2 failed");
        sa.assertEquals(frame3.rollThree, 0, "Roll 3 failed");

        sa.assertAll();
    }
}
