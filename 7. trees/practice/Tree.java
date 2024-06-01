public class Tree<T extends Comparable<T>> {
    Node<T> root;

    public Tree() {
        this(null);
    }
    public Tree(T data) {
        root = (data==null) ? null : new Node<T>(data);
    }

    public void insert(T data) {
        System.out.println("inserting: " + data);
        root = insert(data, root);
    }
    private Node<T> insert(T data, Node<T> node) {
        if(node == null) { return new Node<T>(data); }

        if(data.compareTo(node.get_data()) < 0) {
            node.set_left_child(insert(data, node.get_left_child()));
        } else if(data.compareTo(node.get_data()) > 0) {
            node.set_right_child(insert(data, node.get_right_child()));
        } else {
            return node;
        }
        update_height(node);
        return apply_rotation(node);
    }

    private void update_height(Node<T> node) {
        node.set_height(Math.max(height(node.get_left_child()), height(node.get_right_child())) + 1);
    }
    private int height(Node<T> node) {
        return (node != null) ? node.height() : 0;
    }

    private Node<T> apply_rotation(Node<T> node) {
        int balance = balance(node);
        if(balance > 1) {
            if(balance(node.get_left_child()) < 0) {
                node.set_left_child(rotate_left(node.get_left_child()));
            }
            return rotate_right(node);
        } else if( balance < -1) {
            if(balance(node.get_right_child()) > 0) {
                node.set_right_child(rotate_right(node.get_right_child()));
            }
            return rotate_left(node);
        }
        return node;
    }

    private int balance(Node<T> node) {
        return (node!=null) ? height(node.get_left_child()) - height(node.get_right_child()) : 0;
    }

    private Node<T> rotate_left(Node<T> node) {
        Node<T> right_node = node.get_right_child();
        Node<T> center_node = right_node.get_left_child();
        right_node.set_left_child(node);
        node.set_right_child(center_node);
        update_height(node);
        update_height(right_node);
        return right_node;
    }
    private Node<T> rotate_right(Node<T> node) {
        Node<T> left_node = node.get_left_child();
        Node<T> center_node = left_node.get_right_child();
        left_node.set_right_child(node);
        node.set_left_child(center_node);
        update_height(node);
        update_height(left_node);
        return left_node;
    }

    public void print() {
        print(root);
    }
    private void print(Node<T> node) {
        if(node == null) { return; }
        print(node.get_left_child());
        System.out.println(node.get_data());
        print(node.get_right_child()); 
    }
}
