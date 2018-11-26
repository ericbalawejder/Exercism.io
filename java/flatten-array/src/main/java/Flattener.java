import java.util.List;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class Flattener {

    public static void main(String...args) {
        List<Object> list = asList(0, 
                                  '2', 
                                  asList(asList(2, "three"), 
                                        '8', 
                                        100, 
                                        "four",
                                        singletonList(singletonList((singletonList(50)))), "-2"));

        List<List<?>> nestedList = asList(
                        asList("one"),
                        asList(3, 4),
                        singletonList(singletonList(singletonList(2))),
                        asList(asList("two", 'd', "5656")),
                        asList("three", "three:two", "three:three", "three:four"));

        List<Object> treeList = a(a(1), 2, a(a(3, 4), 5), a(a(a())), a(a(a(6))), 7, 8, a());

        Flattener flattener = new Flattener();

        System.out.println(treeList);
        System.out.println(flattener.flatten(treeList));

        System.out.println(list);
        System.out.println(flattener.flatten(list));

        System.out.println(nestedList);
        System.out.println(flattener.flatten(nestedList));
    }

    List<Object> flatten(List<?> nestedList) {
        List<Object> flatList = new ArrayList<>();
        flatten(nestedList, flatList);
        return flatList;
    }

    private void flatten(List<?> nestedList, List<Object> flatList) {
        for (Object element : nestedList) {
            if (element instanceof List<?>) {
                flatten((List<?>) element, flatList);
            } else if (element != null) {
                flatList.add(element);
            }
        }
    }

    private static List<Object> a(Object... a) {
        return asList(a);
    }
}