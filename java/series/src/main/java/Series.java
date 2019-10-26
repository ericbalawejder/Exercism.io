import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Series {

    private final String series;

    Series(String series) {
        this.series = series;
    }

    List<String> slices(int size) {
        if (size > series.length()) {
            throw new IllegalArgumentException("Slice size is too big.");
        } else if (size <= 0) {
            throw new IllegalArgumentException("Slice size is too small.");
        } else {
            return IntStream.rangeClosed(0, series.length() - size)
                    .mapToObj(i -> series.substring(i, i + size))
                    .collect(Collectors.collectingAndThen(
                            Collectors.toList(), Collections::unmodifiableList));
        }
    }

    List<String> slicesImperative(int size) {
        if (size > series.length()) {
            throw new IllegalArgumentException("Slice size is too big.");
        } else if (size <= 0) {
            throw new IllegalArgumentException("Slice size is too small.");
        } else {
            List<String> sequences = new ArrayList<>();
            for (int i = 0; i <= series.length() - size; i++) {
                String term = series.substring(i, i + size);
                sequences.add(term);
            }
            return Collections.unmodifiableList(sequences);
        }
    }

}
