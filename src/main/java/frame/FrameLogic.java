package frame;

import java.util.ArrayList;
import java.util.List;

public class FrameLogic {

    public List<Frame> rollsToFrames(int[] listOfRolls) {
        List<Frame> listOfFrames = new ArrayList();
        int pointer = 0;
        while (pointer < listOfRolls.length) {
            int one = listOfRolls[pointer];
            int two = 0;
            if (one < 10) {
                two = listOfRolls[pointer + 1];
                pointer++;
            }
            Frame frame = new Frame(one, two);
            listOfFrames.add(frame);
            pointer++;

            if (listOfFrames.size() == 9) {
                Frame finalFrame = new Frame(listOfRolls[pointer], listOfRolls[pointer+1]);
                pointer += 2;
                if (finalFrame.strike || finalFrame.spare) {
                    finalFrame.rollThree = listOfRolls[pointer];
                }
                listOfFrames.add(finalFrame);
                break;
            }
        }
        return listOfFrames;
    }
}
