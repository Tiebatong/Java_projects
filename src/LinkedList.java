class LinkedList {

    class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    private Node head = null;

    void prepend(int value) {
        Node newHead = new Node(value, this.head);
        this.head = newHead;
    }

    @Override
    public String toString() {
        String result = "";
        Node currentElement = this.head;
        while (currentElement != null) {
        result += currentElement.data + " -> ";
            currentElement = currentElement.next;
        }
        return result;
    }

    int indexOf(int find) {
        int index = 0;
        if (head == null) {
            return -1;
        }
        Node current = head;
        while (current.data != find) {
            if (current.next == null) {
                return -1;
            }
            current = current.next;
            index++;
        }
        return index;
    }

    int at(int index) {
        if (head == null) {
            IndexOutOfBoundsException E = new IndexOutOfBoundsException("empty list");
            throw E;
        }
        int in = 0;
        Node current = head;
        while(in < index) {
            if (current.next == null) {
                IndexOutOfBoundsException I = new IndexOutOfBoundsException();
                throw I;
            }
            current = current.next;
            in++;
        }
        return current.data;
    }

    void delete (int value) {

        if (head == null) {
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }
        Node current = head;

        while (current.next.data != value) {
            current = current.next;
            if (current.next == null) {
                return;
            }
        }
        current.next = current.next.next;
    }
}








