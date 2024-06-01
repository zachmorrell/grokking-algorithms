public class TreeNode<T> {
    private T data;
    private TreeNode<T> left_child, right_child;
    private int height;

    public TreeNode(T data) {
        this.data = data;
        left_child = null;
        right_child = null;
        height = 1;
    }
    // Get the data from the node.
    public T get_data() {
        return this.data;
    }

    // Set the data on this node.
    public void set_data(T data) {
        this.data = data;
    }

    // Get left child
    public TreeNode<T> get_left_child() {
        return left_child;
    }
    // Set left child
    public void set_left_child(TreeNode<T> left) {
        this.left_child = left;
    }
    // Get right child
    public TreeNode<T> get_right_child() {
        return right_child;
    }
    // Set right child
    public void set_right_child(TreeNode<T> right) {
        this.right_child = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
