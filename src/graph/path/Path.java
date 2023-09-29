package graph.path;

import java.util.ArrayList;

import graph.Vertex;
public class Path {
    private Vertex source;
    public Path(Vertex source) {
        this.source = source;
    }
    public Path() {
        
    }
    public void bfs() {
        ArrayList<Vertex> queue = new ArrayList<>();
        queue.add(source);
        source.setVisited(true);
        while(queue.size() > 0) {
            Vertex vertex = queue.get(0);
            queue.remove(vertex);
            // process
            System.out.println("Label visitado " + vertex.getLabel());
            vertex.getNeighbors().forEach((item) -> {
                if (!item.isVisited()) {
                    queue.add(item);
                    item.setVisited(true);
                }
            });
        }
    }
    public void dfs (Vertex vertex) {
        System.out.println("Label visitado " + vertex.getLabel());
        vertex.setVisited(true);
        for (Vertex item : vertex.getNeighbors()) {
            if (!item.isVisited()) {
                this.dfs(item);
            }
        }
    }
}
