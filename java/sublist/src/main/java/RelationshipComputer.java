import java.util.List;
import java.util.stream.IntStream;

class RelationshipComputer<T extends Comparable> {

    Relationship computeRelationship(final List<T> list1, final List<T> list2) {
        if (list1.equals(list2)) {
            return Relationship.EQUAL;
        } else if (isContiguousSublist(list1, list2)) {
            return Relationship.SUBLIST;
        } else if (isContiguousSublist(list2, list1)) {
            return Relationship.SUPERLIST;
        } else {
            return Relationship.UNEQUAL;
        }
    }

    private boolean isContiguousSublist(final List<T> list1, final List<T> list2) {
        return IntStream.range(0, list2.size() - list1.size() + 1)
                .mapToObj(value -> list2.subList(value, value + list1.size()))
                .anyMatch(list1::equals);
    }
}