/**
 * @param <T>
 * @author Giovanni
 */
public class Node<T> {

    private Node<T> next;
    private T element;

    public Node() {
        next = null;
        element = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "[" + element.toString() + "]";
    }
}

