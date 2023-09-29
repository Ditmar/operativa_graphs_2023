package graph.path;

import java.util.ArrayList;

import graph.Edges;
import graph.Graph;
import graph.Vertex;

public class Prim {
    private Vertex source;
    private ArrayList<Vertex> connected;
    private ArrayList<Vertex> noConnected;
    private Graph graph;
    public Prim(Vertex source, Graph graph) {
        this.graph = graph;
        this.source = source;
        // step 0
        this.connected = new ArrayList<>();
        this.noConnected = new ArrayList<>();
        this.init();
    }
    private void init () {
        for(Vertex vertex : this.graph.getVertex()) {
            this.noConnected.add(vertex);
        }
    }
    // aqui es donde aplicamos el algoritmo prim
    public void apply() {
        // step 1
        this.connected.add(this.source);
        this.noConnected.remove(this.source);
        while (this.noConnected.size() > 0) {
            Vertex minVertex = getMinVertex();
            this.connected.add(minVertex);
            this.noConnected.remove(minVertex);
        }

    }
    public void print() {
        for (Vertex results : this.connected) {
            System.out.print(results.getLabel() + ",");
        }
        System.out.println();
    }
    private Vertex getMinVertex() {
        Integer min = 9999;
        Vertex candidate = null;
        for(Vertex connectedVertex : this.connected) {
            for (Vertex noConnectedVertex : this.noConnected) {
                String key = connectedVertex.getLabel() + "_" + noConnectedVertex.getLabel();
                Edges edge = this.graph.getEdge(key);
                if (edge != null && edge.getWeight() < min) {
                    min = edge.getWeight();
                    candidate = noConnectedVertex;
                }
            }
        }
        return candidate;
    }
}
