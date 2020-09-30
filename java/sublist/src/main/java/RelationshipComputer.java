import java.util.List;

class RelationshipComputer<T> {

    Relationship computeRelationship(final List<T> list1, final List<T> list2) {
        if (list1.equals(list2)) {
            return Relationship.EQUAL;
        } else if (isSublist(list1, list2)) {
            return Relationship.SUBLIST;
        } else if (isSublist(list2, list1)) {
            return Relationship.SUPERLIST;
        } else {
            return Relationship.UNEQUAL;
        }
    }

    private boolean isSublist(final List<T> list1, final List<T> list2) {
        if (list1.size() > list2.size()) {
            return false;
        }
        final int contiguousSublists = list2.size() - list1.size() + 1;

        for (int i = 0; i < contiguousSublists; i++) {
            if (list2.subList(i, i + list1.size()).equals(list1)) {
                return true;
            }
        }
        return false;
    }
}