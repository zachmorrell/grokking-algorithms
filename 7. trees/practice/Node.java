public class Node<T> {
    T data;
    private int height = 1;
    Node<T> left_child, right_child;

    public Node(T data) {
        this.data = data;
        left_child = null;
        right_child = null;
    }

    public T get_data() {
        return data;
    }
    public void set_data(T data) {
        this.data = data;
    }

    public int height() {
        return height;
    }
    public void set_height(int height) {
        this.height = height;
    }

    public Node<T> get_left_child() {
        return left_child;
    }
    public void set_left_child(Node<T> node) {
        this.left_child = node;
    }
    public Node<T> get_right_child() {
        return right_child;
    }
    public void set_right_child(Node<T> node) {
        this.right_child = node;
    }

}