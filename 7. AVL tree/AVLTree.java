import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class AVLTree<E extends Comparable<E>> {
    public TreeNode<E> root;
    public AVLTree() { this.root = null; }

    public AVLTree<E> insert(E data) {
        root = insert(root, data);
        return this;
    }

    private TreeNode<E> insert(TreeNode<E> tree_node, E data) {

        // If tree_node is null, return the new node.
        if(tree_node == null) {
            return new TreeNode<>(data);
        }

        // If data < tree_node data, set it to the left.
        if(data.compareTo(tree_node.get_data()) < 0) {
            tree_node.set_left_child(insert(tree_node.get_left_child(), data));

        // If data > tree_node data, set it to the right.
        } else if(data.compareTo(tree_node.get_data()) > 0) {
            tree_node.set_right_child(insert(tree_node.get_right_child(), data));
        } else {
        // Return the root back to the base case (root).
        // Also returns the recursive case (leaves).  
        return tree_node;
        }
        update_height(tree_node);
        return apply_rotation(tree_node);
    }

    private TreeNode<E> delete(E data, TreeNode<E> tree_node) {
        if(tree_node == null) {
            return null;
        }
        if(data.compareTo(tree_node.get_data()) < 0) {
            tree_node.set_left_child(delete(data, tree_node.get_left_child()));
        } else if(data.compareTo(tree_node.get_data()) > 0) {
            tree_node.set_right_child(delete(data, tree_node.get_right_child()));
        } else {
            if(tree_node.get_left_child() == null) {
                return tree_node.get_right_child();
            } else if(tree_node.get_right_child() == null) {
                return tree_node.get_left_child();
            }
            tree_node.set_data(get_max(tree_node.get_left_child()));
            tree_node.set_left_child(delete(tree_node.get_data(), tree_node.get_left_child()));
        }
        update_height(tree_node);
        return apply_rotation(tree_node);
    }
    private void update_height(TreeNode<E> node) {
        int max_height = Math.max(height(node.get_left_child()), height(node.get_right_child()));
        node.setHeight(max_height + 1);
    }
    private int height(TreeNode<E> node) {
        int height = 0;
        if(node!=null) {
            height = node.getHeight();
        }
        return height;
    }
    private int balance(TreeNode<E> node) {
        int height = 0;
        if(node != null) {
            height = height(node.get_left_child()) - height(node.get_right_child());
        }
        return height;
    }
    private TreeNode<E> apply_rotation(TreeNode<E> node) {
        int balance = balance(node);
        if(balance > 1) {
            if(balance(node.get_left_child()) < 0) {
                node.set_left_child(rotate_left(node.get_left_child()));
            }
            return rotate_right(node);
        }
        if(balance < -1) {
            if(balance(node.get_right_child()) > 0) {
                node.set_right_child(rotate_right(node.get_right_child()));
            }
            return rotate_left(node);
        }
        return node;
    }
    private TreeNode<E> rotate_left(TreeNode<E> node) {
        TreeNode<E> right_node = node.get_right_child();
        TreeNode<E> center_node = right_node.get_left_child();
        right_node.set_left_child(node);
        node.set_right_child(center_node);
        update_height(node);
        update_height(right_node);
        return right_node;
    }

    private TreeNode<E> rotate_right(TreeNode<E> node) {
        TreeNode<E> left_node = node.get_left_child();
        TreeNode<E> center_node = left_node.get_right_child();
        left_node.set_right_child(node);
        node.set_left_child(center_node);
        update_height(node);
        update_height(left_node);
        return left_node;
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

    //private Boolean is_empty() { return root == null; }
    
    
    /*private E get_min() {
        if(is_empty()) { return null; }
        get_min(root);
    }
    private E get_min(TreeNode<E> current_node) {
        if(current_node.get_left_child() != null) {
            return get_min(current_node.get_left_child());
        }
        return current_node.get_data();
    }*/

    /*private E get_max() {
        if(is_empty()) { return null;}
        get_max(root);
    }*/
    private E get_max(TreeNode<E> current_node) {
        if(current_node.get_right_child() != null) {
            return get_max(current_node.get_right_child());
        }
        return current_node.get_data();
    }

}