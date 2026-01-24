import java.util.NoSuchElementException;

class BinTree {
    private class BinaryNode {
        private BinaryNode left;
        private BinaryNode right;
        private int element;

        private BinaryNode(int element) {
            this.element = element;
        }
    }

    private BinaryNode root;

    void insert(int new_number) {
        if (root == null) {
            root = new BinaryNode(new_number);
            return;
        }
        BinaryNode current = root;
        while (true) {
            if (new_number > current.element) {
                if (current.right == null) {
                    current.right = new BinaryNode(new_number);
                    return;
                }
                current = current.right;
            } else if (new_number < current.element) {
                if (current.left == null) {
                    current.left = new BinaryNode(new_number);
                    return;
                }
                current = current.left;
            } else {
                //already in tree
                return;
            }
        }

    }

    void delete_min() {
        if (root == null) {
            return;
        }

        if (root.left == null) {
            // Wurzel ist minimum
            root = root.right;
            return;
        }

        BinaryNode current = root;
        while (current.left.left != null) {
            current = current.left;
        }
        current.left = current.left.right;


    }

    int size() {
        return  size(root);
    }

    private int size (BinaryNode subtree_node) {
        if (subtree_node == null) {
            return 0;
        }

        return 1 + size(subtree_node.left) + size(subtree_node.right);
    }
    boolean contains(int needle) {

        BinaryNode current = root;

        while (current != null) {
            if (current.element == needle) {
                return true;
            } else if (current.element < needle) {
                current = current.right;
            } else if (current.element > needle) {
                current = current.left;
            }
        }
        return false;
    }

    int min() {
        if (root == null) {
            throw new NoSuchElementException("empty tree");
        }
        BinaryNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.element;

    }

    @Override

    public String toString() {

        return toString(root);
    }

    private String toString(BinaryNode subtree_root) {
        if (subtree_root == null) {
            return "";
        }

        return toString(subtree_root.left) + subtree_root.element + "," +
        toString(subtree_root.right);
    }
}
















