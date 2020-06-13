
package homeworkPackage;

import java.util.*;

class Graph {
    private int Vertices;
    private LinkedList<Integer> linkedList[];

    Graph(int v) {
        Vertices = v;
        InitLinkedList(v);

    }
    void InitLinkedList(int v){
        linkedList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            linkedList[i] = new LinkedList();
    }

    // To add an edge in the graph
    void addEdge(int v, int w) {
        linkedList[v].add(w);
    }

    void FindDegreeOfVertex(int s){
        Iterator<Integer> i = linkedList[s].listIterator();
        int  degree = 0;
        while(i.hasNext()){
            degree++;
            i.next();
        }
        System.out.println(s+".Vertex degree is:"+degree);

    }

    // To do DFS traversal
    void DFS(int v)
    {
        // Mark all the vertices
        boolean marked[] = new boolean[this.Vertices];

        // Call the recursive helper function to print DFS traversal
        RecursioNOfDFS(v, marked);
    }

    void RecursioNOfDFS(int v,boolean marked[])
    {
        System.out.print(v+" ");
        // Mark the current node as marked and print it
        marked[v] = true;

        // Recursion for all the vertices linkedlist to this vertex
        Iterator<Integer> i = linkedList[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!marked[n])
                RecursioNOfDFS(n, marked);
        }
    }


    // prints BFS traversal from a given source s 
    void BFS(int source) {
        // Mark all the vertices as not marked
        boolean visited[] = new boolean[this.Vertices];

        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it 
        visited[source] = true;
        queue.add(source);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it 
            source = queue.poll();
            System.out.print(source + " ");

            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> iterator = linkedList[source].listIterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}