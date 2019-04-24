import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinarySearch<T extends Comparable<? super T>> {

    private final List<T> sortedList;

    BinarySearch(final List<T> sortedList) {
        this.sortedList = Collections.unmodifiableList(new ArrayList<T>(sortedList));
    }

    int indexOf(T target) throws ValueNotFoundException {
        int low = 0;
        int high = sortedList.size() - 1;
        return indexOf(target, low, high);
    }

    private int indexOf(T target, int low, int high) throws ValueNotFoundException {
        if (low > high) {
            throw new ValueNotFoundException("Value not in array");
        }
        int mid = (low + high) / 2;
        int comparisionValue = target.compareTo(sortedList.get(mid));

        return comparisionValue < 0 
                ? indexOf(target, low, mid - 1) : comparisionValue == 0 
                ? mid : indexOf(target, mid + 1, high);
    }

}
