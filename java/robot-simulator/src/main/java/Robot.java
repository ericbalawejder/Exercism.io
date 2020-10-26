class Robot {

    private GridPosition gridPosition;
    private Orientation orientation;

    Robot(GridPosition initialGridPosition, Orientation initialOrientation) {
        this.gridPosition = initialGridPosition;
        this.orientation = initialOrientation;
    }

    void turnRight() {
        Orientation direction = getOrientation();
        int currentIndex = direction.ordinal();
        int index = Math.floorMod(currentIndex + 1, Orientation.values().length);
        setOrientation(Orientation.values()[index]);
    }

    void turnLeft() {
        Orientation direction = getOrientation();
        int currentIndex = direction.ordinal();
        int index = Math.floorMod(currentIndex - 1, Orientation.values().length);
        setOrientation(Orientation.values()[index]);
    }

    void advance() {
        Orientation direction = getOrientation();
        if (direction.equals(Orientation.NORTH)) {
            gridPosition.setY(gridPosition.getY() + 1);
        } else if (direction.equals(Orientation.EAST)) {
            gridPosition.setX(gridPosition.getX() + 1);
        } else if (direction.equals(Orientation.SOUTH)) {
            gridPosition.setY(gridPosition.getY() - 1);
        } else {
            gridPosition.setX(gridPosition.getX() - 1);
        }
    }

    void simulate(String instructions) {
        char[] symbols = instructions.toCharArray();
        for (char symbol : symbols) {
            if (symbol == 'L') {
                turnLeft();
            } else if (symbol == 'R') {
                turnRight();
            } else if (symbol == 'A'){
                advance();
            } else {
                throw new IllegalArgumentException("Bad instruction format");
            }
        }
    }

    GridPosition getGridPosition() {
        return this.gridPosition;
    }

    Orientation getOrientation() {
        return this.orientation;
    }

    void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "gridPosition=" + gridPosition +
                ", orientation=" + orientation +
                '}';
    }
}