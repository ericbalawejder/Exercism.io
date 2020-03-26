import java.lang.reflect.Array;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {

    private Node<T> head;
    private int size = 0;

    SimpleLinkedList() {
    }

    SimpleLinkedList(T[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            push(array[i]);
        }
    }

    void push(T value) {
        Node<T> newNode = new Node<>(value);
        this.size++;
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    T pop() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.data;
        head = head.next;
        this.size--;
        return data;
    }

    void reverse() {
        Node<T> current = head;
        Node<T> next;
        Node<T> previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    int size() {
        return this.size;
    }

    T[] asArray(Class<T> componentType) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(componentType, size());
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            Array.set(array, index, current.data);
            current = current.next;
            index++;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> current = head;
        if (head != null) {
            while (current != null) {
                builder.append(current.data).append(", ");
                current = current.next;
            }
            builder.delete(builder.length() - 2, builder.length());
        }
        builder.append("]");
        return builder.toString();
    }

    private static final class Node<T> {
        private final T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

}
