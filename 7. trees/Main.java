class Main {
    public static void main(String[] args) {
        Tree<String> test_tree = new Tree<>();
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