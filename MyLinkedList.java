public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T element;
        Node next;
        Node previous;

        Node(T element) {
            this.element = element;
        }
    }

}
