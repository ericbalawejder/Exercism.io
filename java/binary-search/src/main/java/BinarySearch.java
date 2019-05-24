import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinarySearch<T extends Comparable<? super T>> {

    private final List<T> sortedList;

    BinarySearch(final List<T> sortedList) {
        this.sortedList = Collections.unmodifiableList(new ArrayList<T>(sortedList));
    }

    int indexOf(T target) throws ValueNotFoundException {
        return indexOf(target, 0, sortedList.size() - 1);
    }

    private int indexOf(T target, int low, int high) throws ValueNotFoundException {
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
