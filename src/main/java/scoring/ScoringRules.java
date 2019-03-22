package scoring;

import frame.Frame;

import java.util.List;

public class ScoringRules {

    public int countScore(List<Frame> frames) {
        int score = 0;

        for (int i=0; i<frames.size()-1; i++) {
            Frame frame = frames.get(i);
            score = score + frame.rollOne + frame.rollTwo;
            if (frame.spare) {
                score = score + frames.get(i+1).rollOne;
            }
            if (frame.strike) {
                if (!frames.get(i+1).strike || i == 8) {
                    score = score + frames.get(i+1).rollOne + frames.get(i+1).rollTwo;
                } else {
                    score = score + frames.get(i+1).rollOne + frames.get(i+2).rollOne;
                }
            }
        }
        int frameTen = frames.get(9).rollOne + frames.get(9).rollTwo + frames.get(9).rollThree;
        return score + frameTen;
    }


}
