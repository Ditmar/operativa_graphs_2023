package graph;

import java.util.ArrayList;
import java.util.HashMap;

import graph.path.Dijkstra;
import graph.path.Prim;
public class Graph {
    private ArrayList<Vertex> vertex;
    private HashMap<String, Edges> connections;
    //private ArrayList<Edges> edges;
    public Graph() {
        this.vertex = new ArrayList<Vertex>();
        this.connections = new HashMap<>();
        //edges = new ArrayList<Edges>();
    }
    public void buildGraph() {
        // this is an example graph
        Vertex v1 = new Vertex("v1", false, this);
        Vertex v2 = new Vertex("v2", false, this);
        Vertex v3 = new Vertex("v3", false, this);
        Vertex v4 = new Vertex("v4", false, this);
        Vertex v5 = new Vertex("v5", false, this);
        Vertex v6 = new Vertex("v6", false, this);
        this.vertex.add(v1);
        this.vertex.add(v2);
        this.vertex.add(v3);
        this.vertex.add(v4);
        this.vertex.add(v5);
        this.vertex.add(v6);
        v1.addNeighbour(v3, 3);
        v1.addNeighbour(v2, 10);
        v2.addNeighbour(v5, 3);
        v3.addNeighbour(v2, 2);
        v3.addNeighbour(v4, 10);
        v4.addNeighbour(v2, 1);
        v4.addNeighbour(v6, 3);
        v5.addNeighbour(v4, 5);
        v5.addNeighbour(v6, 20);

        // v1.addNeighbour(v2, 5);
        // v2.addNeighbour(v3, 3);
        // v2.addNeighbour(v1, 5);
        // v3.addNeighbour(v4, 1);
        // v3.addNeighbour(v5, 5);
        // v5.addNeighbour(v1, 3);
        // v5.addNeighbour(v2, 3);
        //# test 1 bfs 
        // Path path = new Path(v1);
        // path.bfs();
        // Path path = new Path();
        // path.dfs(v1);
        // test another graph
        // v1.addNeighbour(v3, 1);
        // v1.addNeighbour(v2, 5);
        // v2.addNeighbour(v1, 5);
        // v2.addNeighbour(v3, 3);
        // v2.addNeighbour(v6, 6);
        // v3.addNeighbour(v4, 10);
        // v3.addNeighbour(v5, 3);
        // v4.addNeighbour(v2, 5);
        // v5.addNeighbour(v3, 3);
        // v5.addNeighbour(v4, 1);
        // v5.addNeighbour(v6, 4);

    }
    public void prim () {
        Prim prim = new Prim(this.vertex.get(4), this);
        prim.apply();
        prim.print();
    }
    public void dijkstra() {
        Dijkstra dijkstra = new Dijkstra(this.vertex.get(0), this);
        dijkstra.apply();
        dijkstra.printTags();
    }
    public void setConnections(String key, Edges edges) {
        if (this.connections.get(key) == null) {
            this.connections.put(key, edges);
        } 
    }
    public Edges getEdge(String key) {
        return this.connections.get(key);
    }
    public ArrayList<Vertex> getVertex() {
        return this.vertex;
    }
}
