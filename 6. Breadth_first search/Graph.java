import java.util.LinkedList;
import java.util.Queue;

/**
 * Graph
 */
public class Graph {
    // The max vertices of the graph. 6 = x:6, y:6.
    private int node_count;
    // LinkedList array, an array of linked lists.
    private LinkedList<Integer> adjacency_list[];

    // Generates the adjacency or neigthbor list.
    /*
     * node_count = 3
     * [0] = new linkedlist
     * [1] = new linkedlist
     * [3] = new linkedlist
     */
    @SuppressWarnings("unchecked")
    Graph(int node_count) {
        this.node_count = node_count;
        adjacency_list = new LinkedList[node_count];
        for(int i=0; i < node_count; i++) {
            adjacency_list[i] = new LinkedList<>();
        }
    }

    // Adds the neighbor to the specified node.
    void add_edge(int node, int neighbor) {
        adjacency_list[node].add(neighbor);
    }

    // Breadth-first search
    /*
     * Generates a list based on proximity to the start_node.
     * [0] = {1,3}
     * [1] = {}
     * [3] = {2}
     * 1 and 3 are first generation.
     * 2 is second generation.
     * result list would be 0, 1, 3, 2
     */
    void BFS(int start_node) {
        // Queue to track the next node to search.
        Queue<Integer> queue = new LinkedList<Integer>();
        // Boolean array to track the visited nodes.
        boolean visited[] = new boolean[node_count];

        // Sets the start node to true.
        visited[start_node] = true;
        // Adds the starting node to the queue.
        queue.add(start_node);

        while (queue.size() != 0) {
            // Sets the current_node equal to the top of the queue and pops it from the queue.
            int current_node = queue.poll();
            System.out.print(current_node + "");

            /*
             * Loops through the adjacency list
             *  if the neghbor hasn't been visited
             *      set visited array indice to true
             *      add the neighbor to the queue.
             */
            for(int neighbor : adjacency_list[current_node]) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
