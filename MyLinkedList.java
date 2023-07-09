public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T element;
        Node next;
        Node previous;

        Node(T element) {
            this.element = element;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    public void add(T item) {
        add(item, size);
    }
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(item);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.previous = newNode;
            } else {
                tail = newNode;
            }
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            Node current = getNode(index);
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
        }
        size++;
    }
    public boolean remove(T item) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(item)) {
                removeNode(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }
    private void removeNode(Node node) {
        if (node == head) {
            head = node.next;
        } else {
            node.previous.next = node.next;
        }
        if (node == tail) {
            tail = node.previous;
        } else {
            node.next.previous = node.previous;
        }
        node.next = null;
        node.previous = null;
        size--;
    }
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node nodeToRemove = getNode(index);
        removeNode(nodeToRemove);
        return nodeToRemove.element;
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).element;
    }
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }
    public int indexOf(Object o) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    public int lastIndexOf(Object o) {
        Node current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            current = current.previous;
            index--;
        }
        return -1;
    }
    public void sort() {
        Node current = head;
        Node index = null;
        T temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if (current.element.compareTo(index.element) > 0) {
                        temp = current.element;
                        current.element = index.element;
                        index.element = temp;
                    }

                    index = index.next;
                }

                current = current.next;
            }
        }
    }

}
