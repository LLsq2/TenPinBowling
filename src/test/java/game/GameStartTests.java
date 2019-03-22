package game;

import org.testng.annotations.Test;

public class GameStartTests {

    @Test
    public void passingInNonNumeric() {
        String[] testArray = {"1", "2", "a"};
        GameStart.main(testArray);
    }
}
