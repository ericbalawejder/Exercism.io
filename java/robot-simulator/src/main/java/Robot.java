class Robot {

    private GridPosition gridPosition;
    private Orientation orientation;

    Robot(GridPosition initialGridPosition, Orientation initialOrientation) {
        this.gridPosition = initialGridPosition;
        this.orientation = initialOrientation;
    }

    void turnRight() {
        final int currentIndex = getOrientation().ordinal();
        final int newIndex = Math.floorMod(currentIndex + 1, Orientation.values().length);
        setOrientation(Orientation.values()[newIndex]);
    }

    void turnLeft() {
        final int currentIndex = getOrientation().ordinal();
        final int newIndex = Math.floorMod(currentIndex - 1, Orientation.values().length);
        setOrientation(Orientation.values()[newIndex]);
    }

    void advance() {
        switch (getOrientation()) {
            case NORTH:
                setGridPosition(new GridPosition(gridPosition.getX(), gridPosition.getY() + 1));
                break;
            case EAST:
                setGridPosition(new GridPosition(gridPosition.getX() + 1, gridPosition.getY()));
                break;
            case SOUTH:
                setGridPosition(new GridPosition(gridPosition.getX(), gridPosition.getY() - 1));
                break;
            case WEST:
                setGridPosition(new GridPosition(gridPosition.getX() - 1, gridPosition.getY()));
                break;
        }
    }

    void simulate(String instructions) {
        instructions.chars()
                .mapToObj(c -> (char) c)
                .forEach(this::parseSymbols);
    }

    GridPosition getGridPosition() {
        return this.gridPosition;
    }

    void setGridPosition(GridPosition gridPosition) {
        this.gridPosition = gridPosition;
    }

    Orientation getOrientation() {
        return this.orientation;
    }

    void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    private void parseSymbols(char character) {
        switch (character) {
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            case 'A':
                advance();
                break;
            default:
                throw new IllegalArgumentException("Bad instruction format");
        }
    }
}