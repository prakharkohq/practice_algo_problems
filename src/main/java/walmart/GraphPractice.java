package walmart;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class GraphPractice {

    int V, count;
    LinkedList[] adj;

    GraphPractice(int V) {
        this.V = V;
        count = 0;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void dfs(GraphPractice g) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(i, g, visited);
                count++;
            }
        }
        System.out.println(count);
    }

    void DFS(int i, GraphPractice g, boolean[] visited) {
        visited[i] = true;
        int j;
        Iterator<Integer> it = adj[i].iterator();
        while (it.hasNext()) {
            j = it.next();
            if (!visited[j]) {
                DFS(j, g, visited);
            }
        }
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int V, E;
        for (int i = 0; i < test; i++) {
            V = sc.nextInt();
            GraphPractice g = new GraphPractice(V);
            E = sc.nextInt();
            for (int j = 0; j < E; j++) {
                int n1, n2;
                n1 = sc.nextInt();
                n2 = sc.nextInt();
                g.addEdge(n1, n2);
            }
            g.dfs(g);
        }
    }
}