# TenPinBowling
Game for American Ten Pin Bowling

Instructions:
Assuming user has openJDK11 and Maven setup, run:

> mvn clean package

to build game

> java -jar target/bowling-1.0-jar-with-dependencies.jar {list of rolls}

to run game

> mvn clean test

to run unit tests

An example run would be:
> java -jar target/bowling-1.0-jar-with-dependencies.jar 3 5 10 8 2 2 7 9 0 2 3 5 4 6 0 10 10 10 10


Things to keep in mind:
- Game does not error handle
    - assumes inputs are correct
    - assumes all rolls are correct
    - assumes there are enough rolls to complete all 10 frames
    - disregards any rolls after 10 frames are completed
- Only provides final score