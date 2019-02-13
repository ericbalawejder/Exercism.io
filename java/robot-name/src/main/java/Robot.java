import java.util.Set;
import java.util.HashSet;

class Robot {

    private String name;
    private static Set<Robot> robots = new HashSet<>();

    public static void main(String... args) {

        for (int i = 0; i < 70; i++) {
            Robot robot = new Robot();
        }
        System.out.println(robots);
    }

    Robot() {
        this.name = generateRobotName();
        robots.add(this);
    }

    String generateRobotName() {
        return twoRandomCharacters() + threeDigitRandomInteger();
    }

    String threeDigitRandomInteger() {
        Integer randomInteger = 100 + (int) (Math.random() * 900);
        return randomInteger.toString();
    }

    String twoRandomCharacters() {
        String characters = "";
        for (int i = 0; i < 2; i++) {
            Character randomCharacter = 
                    (char) ((int) 'A' + (int) (Math.random() * (int) ('Z' - 'A' + 1)));
            characters += randomCharacter;
        }
        return characters;
    }

    Robot reset() {
        robots.remove(this);
        this.name = generateRobotName();
        robots.add(this);
        return this;
    }

    String getName() {
        return name;
    }

    boolean isCollision() {
        return robots.contains(this);
    }

    @Override
    public String toString() {
        return name;
    }

}
