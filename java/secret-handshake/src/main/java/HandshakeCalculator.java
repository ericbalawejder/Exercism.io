import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        final List<Signal> secretHandshake = Arrays.stream(Signal.values())
                .filter(signal -> (number & (int) Math.pow(2, signal.ordinal())) > 0)
                .collect(Collectors.toUnmodifiableList());

        return (number & (int) Math.pow(2, Signal.values().length)) > 0 ?
                Collections.unmodifiableList(reverse(secretHandshake)) : secretHandshake;
    }

    // https://medium.com/javarevisited/interview-question-reversing-an-immutable-list-in-java-57a891a521c5
    private List<Signal> reverse(List<Signal> list) {
        return new AbstractList<>() {
            @Override
            public Signal get(int index) {
                return list.get(list.size() - 1 - index);
            }
            @Override
            public int size() {
                return list.size();
            }
        };
    }

}
