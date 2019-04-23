import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BinarySearch {

    public static void main(String[] args) throws ValueNotFoundException {
        List<Integer> sortedList = Collections.unmodifiableList(Arrays.asList(1, 3, 4, 6, 8, 9, 11));

        BinarySearch searchDeezNutz = new BinarySearch(sortedList);

        System.out.println(searchDeezNutz.indexOf(11));
    }

    private final List<Integer> sortedList;

    BinarySearch(final List<Integer> sortedList) {
        this.sortedList = Collections.unmodifiableList(new ArrayList<Integer>(sortedList));
    }

    int indexOf1(int target) throws ValueNotFoundException {
        int high = sortedList.size() - 1;
        int low = 0;

        while (high >= low) {
            int mid = (high + low) / 2;

            if (target == sortedList.get(mid)) {
                return mid;
            } else if (target < sortedList.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        throw new ValueNotFoundException("Value not in array");
    }

    int indexOf(int target) throws ValueNotFoundException {
        int low = 0;
        int high = sortedList.size() - 1;
        return indexOf(target, low, high);
    }

    private int indexOf(int target, int low, int high) throws ValueNotFoundException {
        if (low > high) {
            throw new ValueNotFoundException("Value not in array");
        }
        int mid = (low + high) / 2;

        if (target == sortedList.get(mid)) {
            return mid;
        } else if (target < sortedList.get(mid)) {
            return indexOf(target, low, mid - 1);
        } else {
            return indexOf(target, mid + 1, high);
        }
    }

}
