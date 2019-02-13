import java.util.Set;
import java.util.HashSet;

class Robot {

    private String name;
    private static final int ROBOT_PERMUTATIONS = 26 * 26 * 900;
    private static Set<Robot> robots = new HashSet<>();

    Robot() {
        do {
            if (robots.size() < ROBOT_PERMUTATIONS) {
                this.name = generateRobotName();
            } else {
                throw new RuntimeException("Maximum number of Robots has been reached.");
            }
        } while (isCollision(this));
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
            Character randomCharacter = // x <= character < x + y
                    (char) ((int) 'A' + (int) (Math.random() * (int) ('Z' - 'A' + 1)));
            characters += randomCharacter;
        }
        return characters;
    }

    Robot reset() {
        robots.remove(this);
        do {
            this.name = generateRobotName();
        } while (isCollision(this));
        robots.add(this);
        return this;
    }

    String getName() {
        return name;
    }

    static boolean isCollision(Robot robot) {
        return robots.contains(robot);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Robot other = (Robot) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
