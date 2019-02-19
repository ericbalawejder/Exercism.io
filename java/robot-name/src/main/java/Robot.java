import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Random;

class Robot {

    private String name;
    private Random random = new Random();
    private static final int ROBOT_PERMUTATIONS = 26 * 26 * 1000;
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
        return randomLetters(2) + randomNumbers(3);
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

    private String randomLetters(int quantity) {
        return random.ints('A', 'Z' + 1)
                .limit(quantity)
                .mapToObj(i -> Character.toString((char)i))
                .collect(Collectors.joining());
    }

    private String randomNumbers(int quantity) {
        return random.ints(0, 10)
                .limit(quantity)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
    }

    private static boolean isCollision(Robot robot) {
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
