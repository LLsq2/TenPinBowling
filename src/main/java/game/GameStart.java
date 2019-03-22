package game;

import frame.Frame;
import frame.FrameLogic;
import scoring.ScoringRules;

import java.util.List;

public class GameStart {

    public static void main(String[] args) {
        int[] rolls = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            rolls[i] = Integer.parseInt(args[i]);
        }
        FrameLogic logic = new FrameLogic();
        List<Frame> list = logic.rollsToFrames(rolls);

        ScoringRules scoring = new ScoringRules();
        int score = scoring.countScore(list);

        System.out.println("You scored " + score + " in this game.");
    }
}
