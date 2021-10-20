import java.util.Objects;

class Triplet<A, B, C> {

    private final A first;
    private final B second;
    private final C third;

    Triplet(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    A getFirst() {
        return this.first;
    }

    B getSecond() {
        return this.second;
    }

    C getThird() {
        return this.third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triplet<?, ?, ?> triplet = (Triplet<?, ?, ?>) o;
        return first.equals(triplet.first) && second.equals(triplet.second) && third.equals(triplet.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

}
