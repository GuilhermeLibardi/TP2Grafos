package graphtheory.util;

import java.io.IOException;	
import java.util.ArrayList;

import graphtheory.heuristics.PCV;

public class Main {

	public static void main(String[] args) {
		try {
			Leitura leitura = new Leitura();
            Grafo grafo = leitura.lerArquivo("Datasets/cv/xql662.txt");
            PCV c = new PCV(grafo);
            double custo = 0;
            ArrayList<Vertice> caminho = c.Nearestneighbor();
            for (int i = 0; i < caminho.size() - 1; i++) {
				custo += Vertice.DistanciaEntre2Vertices(caminho.get(i), caminho.get(i + 1));
			}
            System.out.println("Custo 1: " + custo);
            c.Twoopt(caminho, 100);
            custo = 0;
            for (int i = 0; i < caminho.size() - 1; i++) {
				custo += Vertice.DistanciaEntre2Vertices(caminho.get(i), caminho.get(i + 1));
			}
            System.out.println("Custo 2	: " + custo);
    
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}

}
