import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinarySearch<T> {

    private final List<T> sortedList;

    BinarySearch(final List<T> sortedList) {
        this.sortedList = Collections.unmodifiableList(new ArrayList<T>(sortedList));
    }

    int indexOf(Comparable<T> target) throws ValueNotFoundException {
        int low = 0;
        int high = sortedList.size() - 1;
        return indexOf(target, low, high);
    }

    private int indexOf(Comparable<T> target, int low, int high) throws ValueNotFoundException {
        if (low > high) {
            throw new ValueNotFoundException("Value not in array");
        }
        int mid = (low + high) / 2;

        if (target.compareTo(sortedList.get(mid)) == 0) {
            return mid;
        } else if (target.compareTo(sortedList.get(mid)) < 0) {
            return indexOf(target, low, mid - 1);
        } else {
            return indexOf(target, mid + 1, high);
        }
    }

}
