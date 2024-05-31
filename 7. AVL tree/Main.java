class Main {
    public static void main(String[] args) {
        AVLTree<String> test_tree = new AVLTree<>();
        test_tree.insert("Natalie");
        test_tree.insert("Zachary");
        test_tree.insert("Bear");
        test_tree.insert("Sylvester");
        test_tree.insert("Leo");
        test_tree.insert("Reynolds");
        test_tree.bfs(true);
        test_tree.dfs();
    }

}