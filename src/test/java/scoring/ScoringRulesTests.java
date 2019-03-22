package scoring;

import frame.Frame;
import frame.FrameLogic;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ScoringRulesTests {

    @Test
    public void spareScore() {
        int[] rolls = {0,0,5,5,3,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        FrameLogic logic = new FrameLogic();
        List<Frame> frames = logic.rollsToFrames(rolls);
        ScoringRules scoring = new ScoringRules();
        int score = scoring.countScore(frames);

        Assert.assertEquals(score, 21);
    }

    @Test
    public void strikeScore() {
        int[] rolls = {0,0,10,3,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        FrameLogic logic = new FrameLogic();
        List<Frame> frames = logic.rollsToFrames(rolls);
        ScoringRules scoring = new ScoringRules();
        int score = scoring.countScore(frames);

        Assert.assertEquals(score, 26);
    }

    @Test
    public void perfectFinal() {
        int[] rolls = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,10,10};
        FrameLogic logic = new FrameLogic();
        List<Frame> frames = logic.rollsToFrames(rolls);
        ScoringRules scoring = new ScoringRules();
        int score = scoring.countScore(frames);

        Assert.assertEquals(score, 30);
    }

    @Test
    public void spareFinal() {
        int[] rolls = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,4,10};
        FrameLogic logic = new FrameLogic();
        List<Frame> frames = logic.rollsToFrames(rolls);
        ScoringRules scoring = new ScoringRules();
        int score = scoring.countScore(frames);

        Assert.assertEquals(score, 20);
    }

    @Test
    public void turkey() {
        int[] rolls = {10,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        FrameLogic logic = new FrameLogic();
        List<Frame> frames = logic.rollsToFrames(rolls);
        ScoringRules scoring = new ScoringRules();
        int score = scoring.countScore(frames);

        Assert.assertEquals(score, 60);
    }
}
