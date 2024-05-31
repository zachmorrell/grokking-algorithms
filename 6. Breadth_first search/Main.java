public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
 
        graph.add_edge(0, 1);
        graph.add_edge(0, 3);
        graph.add_edge(0, 4);
        graph.add_edge(4, 5);
        graph.add_edge(3, 5);
        graph.add_edge(1, 2);
        graph.add_edge(1, 0);
        graph.add_edge(2, 1);
        graph.add_edge(4, 1);
        graph.add_edge(3, 1);
        graph.add_edge(5, 4);
        graph.add_edge(5, 3);
 
        System.out.println("The Breadth First Traversal of the graph is as follows :");
 
        graph.BFS(1);

    }
    
}
