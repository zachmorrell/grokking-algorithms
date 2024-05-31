import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Tree<E extends Comparable<E>> {
    public TreeNode<E> root;
    private int size = 0;
    public Tree() { this.root = null; }

    public void insert(E data) {
        size++;
        if(root == null) {
            TreeNode<E> temp = new TreeNode<>(data);
            root = temp;
        } else {
            insert(root,data);
        }
    }

    public void insert(TreeNode<E> tree_node, E data) {
        TreeNode<E> insertion_node = new TreeNode<>(data);
        if(root.get_data().compareTo(data) <= -1) {
            if(tree_node.get_left_child() == null) {
                tree_node.set_left_child(insertion_node);
            } else {
                insert(tree_node.get_left_child(), data);
            }
        } else {
            if(tree_node.get_right_child() == null) {
                tree_node.set_right_child(insertion_node);
            } else {
                insert(tree_node.get_right_child(), data);
            }
        }
    }

    public void print() {
        print(root);
    }

    public void print(TreeNode<E> current_node) {
        if(current_node.get_data() == null) { return; }

        System.out.println(current_node.get_data());
        if(current_node.get_left_child() != null) {
            print(current_node.get_left_child());
        }
        if(current_node.get_right_child() != null) {
            print(current_node.get_right_child());
        }
    }

    public Queue<TreeNode<E>> bfs(boolean print) {
        if(print) {
            System.out.println("Breadth-First Search:");
        }
        Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
        Map<TreeNode<E>, Integer> visited = new HashMap<>();
        Queue<TreeNode<E>> results = new LinkedList<>();
        TreeNode<E> current_node = root;
        int insert = 0;
        queue.add(current_node);
        while (queue != null && current_node != null || current_node == root) {
            
            if(!visited.containsKey(current_node)) {
                if(print) {
                    System.out.println(current_node.get_data());
                }
                visited.put(current_node, insert);
                results.add(current_node);
                insert++;
            }

            if(current_node.get_left_child() != null && !queue.contains(current_node.get_left_child())) {
                queue.add(current_node.get_left_child());
            }
            if(current_node.get_right_child() != null && !queue.contains(current_node.get_right_child())) {
                queue.add(current_node.get_right_child());
            }
            if(current_node == root) {
                queue.poll();
            }
            current_node = queue.poll();
        }
        return results;
    }

    public void dfs() {
        System.out.println("\nDepth-First Search: ");
        Queue<TreeNode<E>> bfs = bfs(false);
        Stack<TreeNode<E>> stack = new Stack<>();
        while (bfs.size() > 0) {
            stack.add(bfs.poll());
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop().get_data());
        }
    }
}
