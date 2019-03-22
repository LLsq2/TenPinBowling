package frame;

public class Frame {

    public boolean spare = false;
    public boolean strike = false;
    public int rollOne = 0;
    public int rollTwo = 0;
    public int rollThree = 0;

    public Frame(int one, int two) {
        rollOne = one;
        rollTwo = two;
        strike = rollOne == 10;
        spare = !strike && rollOne + rollTwo == 10;
    }
}
