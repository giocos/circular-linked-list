import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/**
 * @param <T>
 * @author Giovanni
 */
public class CircularLinkedList<T> implements Iterable<T>,
        RandomAccess, Cloneable, Serializable {

    private static final int DEFAULT_CAPACITY = 0;
    private static final Object[] DEFAULT_EMPTY_ELEMENTS = {};

    // private T element;
    private int capacity;
    private int size = 0;
    private Node<T>[] nodes;

    private class CircularLinkedListItr implements Iterator<T> {

        private int index = 0;

        protected CircularLinkedListItr() {
        }

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public T next() {
            if (index < size)
                return nodes[index++].getElement();
            throw new NoSuchElementException();
        }
    }

    public CircularLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
        this.nodes = (Node<T>[]) DEFAULT_EMPTY_ELEMENTS;
    }


    public CircularLinkedList(int capacity) {
        this.capacity = capacity;
        init();
    }

    public void add(final T element) {
        if (size == capacity)
            nodes = resize();
        nodes[size].setElement(element);
        nodes[size].setNext(nodes[0]); // set current pointer to first node
        if (size > 0)
            nodes[size - 1].setNext(nodes[size]); // reset previous pointer to last node
        size++;
    }

    public Node<T> get(final int index) {
        if (index >= 0 && index < size)
            return nodes[index];
        throw new IndexOutOfBoundsException();
    }

    public int size() {
        return size;
    }

    private void init() {
        this.nodes = (Node<T>[]) new Node[capacity];
        for (int i = 0; i < capacity; ) {
            nodes[i++] = new Node<T>();
        }
    }

    private Node<T>[] resize() {
        final Node<T> first = nodes[0];
        final Node<T>[] newNodes = (Node<T>[]) new Node[capacity += 1];
        for (int index = 0; index < nodes.length; ) {
            newNodes[index] = nodes[index++];
        }
        newNodes[newNodes.length - 1] = new Node<T>(); // null value
        return newNodes;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularLinkedListItr();
    }
}
