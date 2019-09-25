import java.util.NoSuchElementException;

class DoublyLinkedList<T extends Comparable<? super T>> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    void push(T value) {
        if (isEmpty()) {
            addFront(value);
        } else {
            last.next = new Node<T>(last, value, null);
            last = last.next;
        }
        size++;
    }

    T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        final T value = last.data;
        last = last.previous;
        if (last != null) {
            last.next = null;
        } else {
            first = last;
        }
        size--;
        return value;
    }

    T shift() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        final T value = first.data;
        first = first.next;
        if (first != null) {
            first.previous = null;
        } else {
            last = first;
        }
        size--;
        return value;
    }

    void unshift(T value) {
        if (isEmpty()) {
            addFront(value);
        } else {
            first.previous = new Node<T>(null, value, first);
            first = first.previous;
        }
        size++;
    }

    private void addFront(T value) {
        first = new Node<T>(value);
        last = first;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        Node<T> current = first;
        StringBuilder builder = new StringBuilder("[");
        if (first != null) {
            while (current != null) {
                builder.append(current.data).append(",");
                current = current.next;
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append("]");
        } else {
            builder.append("]");
        }
        return builder.toString();
    }

    private static final class Node<T> {
        private final T data;
        private Node<T> previous;
        private Node<T> next;

        Node(T data) {
            this(null, data, null);
        }

        Node(Node<T> previous, T data, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

}
