import java.util.List;
import java.util.ArrayList;

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
        
        System.out.println(nestedList);
        
        Flattener flattener = new Flattener();
        System.out.println(list);
        System.out.println(flattener.flatten(list));
    }

    List<Object> flatten(List<Object> nestedList) {
        List<Object> flatList = new ArrayList<Object>();
        search(flatList, nestedList);
        return flatList;
    }

    @SuppressWarnings("unchecked")
    private void search(List<Object> flatList, List<Object> nestedList) {
        for (Object element : nestedList) {
            if (element == null) {
                continue;
            } else if (element instanceof List) {
                search(flatList, (List<Object>) element);
            } else {
                flatList.add(element);
            }
        }
    }
}