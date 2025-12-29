class Liste {

    private class Node {
        private int value;
        private Node next;

        private Node(int element, Node next) {
            this.value = element;
            this.next = next;
        }
    }

    private Node head;

    Liste() {
        head = null;
    }

    void add(int value) {
        Node newElement = new Node(value, null);

        if(head == null) {
            head = newElement;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newElement;
        }


    }

    int get(int needle) {

        if (head == null) {
            throw new IndexOutOfBoundsException("empty list");
        }

        if (needle < 0) {
            throw new IndexOutOfBoundsException("invalid Index" + needle);
        }
        Node current = head;
        for (int i = 0; i < needle && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index too big" + needle);
        }

        return current.value;

    }

    int length() {

    }

}
