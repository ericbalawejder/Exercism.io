import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinarySearchTree<T extends Comparable<? super T>> {

    public static void main(String... args) {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();

        List<String> expected = Collections.unmodifiableList(Arrays.asList("1", "2", "3", "5", "6", "7"));

        List<String> treeData = Collections.unmodifiableList(Arrays.asList("2", "1", "3", "6", "7", "5"));

        treeData.forEach(binarySearchTree::insert);

        List<String> actual = binarySearchTree.getAsSortedList();

        System.out.println(binarySearchTree.getAsSortedList());
        System.out.println(binarySearchTree.getAsLevelOrderList());

        System.out.println(binarySearchTree);
        System.out.println(binarySearchTree.getRoot());
    }

    private Node<T> root;
    private int size = 0;

    void insert(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            insert(root, value);
        }
        size++;
    }

    List<T> getAsSortedList() {
        List<T> sortedList = new ArrayList<>(getSize());
        getAsSortedList(root, sortedList);
        return Collections.unmodifiableList(sortedList);
    }

    List<T> getAsLevelOrderList() {
        List<T> levelOrderList = new ArrayList<>(getSize());
        getAsLevelOrderList(root, levelOrderList);
        return Collections.unmodifiableList(levelOrderList);
    }

    Node<T> getRoot() {
        return clone(root);
    }

    int getSize() {
        return this.size;
    }

    private Node<T> clone(Node<T> node) {
        if(node == null) {
            return null;
        } else {
            return new Node<>(node.data, clone(node.left), clone(node.right));
        }
    }

    private void insert(Node<T> node, T value) {
        if (value.compareTo(node.getData()) <= 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<>(value));
            } else {
                insert(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node<>(value));
            } else {
                insert(node.getRight(), value);
            }
        }
    }

    private void getAsSortedList(Node<T> node, List<T> list) {
        if (node == null || list == null) {
            return;
        }
        if (node.getLeft() != null) {
            getAsSortedList(node.getLeft(), list);
        }
        list.add(node.getData());
        if (node.getRight() != null) {
            getAsSortedList(node.getRight(), list);
        }
    }

    private void getAsLevelOrderList(Node<T> node, List<T> list) {
        if (node == null || list == null) {
            return;
        }
        final Queue<Node<T>> queue = new LinkedList<>();
        Node<T> myNode;
        Node<T> left;
        Node<T> right;
        queue.add(node);
        while (!queue.isEmpty()) {
            myNode = queue.poll();
            list.add(myNode.getData());
            left = myNode.getLeft();
            right = myNode.getRight();
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root = " + root +
                ", size = " + size +
                '}';
    }
    //------------------------------------------------------------

    static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        Node (T value) {
            this(value, null, null);
        }

        Node (T value, Node<T> left, Node<T> right) {
            this.data = value;
            this.left = left;
            this.right = right;
        }

        Node<T> getLeft() {
            //return clone(left);
            return left;
        }

        void setLeft(Node<T> left) {
            this.left = left;
        }

        Node<T> getRight() {
            //return clone(right);
            return right;
        }

        void setRight(Node<T> right) {
            this.right = right;
        }

        T getData() {
            T data = this.data;
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data = " + data +
                    ", left = " + left +
                    ", right = " + right +
                    '}';
        }

        private Node<T> clone(Node<T> node) {
            if(node == null) {
                return null;
            } else {
                return new Node<>(node.data, clone(node.left), clone(node.right));
            }
        }
    }
}
