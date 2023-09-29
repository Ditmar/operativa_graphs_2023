import graph.Graph;

public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph();
        graph.buildGraph();
        //graph.prim();
        graph.dijkstra();
    }
}
