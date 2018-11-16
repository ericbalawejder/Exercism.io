import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Matrix {

    private final List<List<Integer>> values;

    Matrix(final List<List<Integer>> values) {
        this.values = Collections.unmodifiableList(new ArrayList<List<Integer>>(values));
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        final Set<MatrixCoordinate> result = new HashSet<>();

        if (values.isEmpty()) {
            return result;
        }

        List<Integer> columnMins = IntStream
            .range(0, values.get(0).size())
            .map(column -> getColumnMin(column))
            .boxed()
            .collect(Collectors.toList());

        for (int row = 0; row < values.size(); row++) {
            for (int column = 0; column < values.get(0).size(); column++) {
                final int coordinateValue = values.get(row).get(column);

                if (coordinateValue == getRowMax(row) && coordinateValue == columnMins.get(column)) {
                    result.add(new MatrixCoordinate(row, column));
                }
            }
        }
        return result;
    }

    private int getRowMax(final int row) {
        return Collections.max(values.get(row));
    }

    private int getColumnMin(final int column) {
        return values
            .stream()
            .mapToInt(row -> row.get(column))
            .min()
            .orElseThrow(() -> new IllegalArgumentException("Column cannot be empty"));
    }
}
