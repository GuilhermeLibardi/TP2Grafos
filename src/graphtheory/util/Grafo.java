package graphtheory.util;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices;

    public Grafo(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }
    
    public int getOrdem(){
        return vertices.size();
    }
    
}
