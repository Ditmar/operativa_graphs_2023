package graph.path;

import graph.Graph;
import graph.Tag;
import graph.Vertex;

public class Dijkstra {
    private Vertex source;
    private Graph graph;

    public Dijkstra(Vertex source, Graph graph) {
        this.source = source;
        this.graph = graph;
    }

    public void apply() {
        this.source.setTag(new Tag(0, null));
        this.source.setVisited(true);
        while (this.areVertexHasPermanentTags()) {
            // all code down corresponds to index a
            this.setTags();
            // all code down corresponds to index b
            this.source = seekMinimusVertex();
            this.source.setVisited(true);
        }
    }
    public void printTags() {
        for (Vertex vertex : this.source.getNeighbors()) {
            System.out.println(" [ " + vertex.getTag().getWeight() + ", " + vertex.getTag().getParent().getLabel() + "]");
        }
    }

    private void setTags() {
        for (Vertex vertex : this.source.getNeighbors()) {
            Integer newWeight = this.source.getTag().getWeight() +
                    this.source.getHashByKey(vertex.getLabel()).getWeight();
            if (vertex.getTag() == null) {
                vertex.setTag(new Tag(newWeight, this.source));
            } else if (vertex.getTag().getWeight() < newWeight && !vertex.isVisited()) {
                vertex.getTag().updateTag(newWeight, this.source);
            }
        }
    }

    private Vertex seekMinimusVertex() {
        Integer minWeight = 99999;
        Vertex candidate = null;
        for (Vertex vertex : this.graph.getVertex()) {
            if (vertex.getTag() != null && !vertex.isVisited()) {
                if (vertex.getTag().getWeight() < minWeight) {
                    minWeight = vertex.getTag().getWeight();
                    candidate = vertex;
                }
            }
        }
        return candidate;
    }

    private Boolean areVertexHasPermanentTags() {
        for (Vertex vertex : this.graph.getVertex()) {
            if (vertex.isVisited() == false) {
                return false;
            }
        }
        return true;
    }
}
