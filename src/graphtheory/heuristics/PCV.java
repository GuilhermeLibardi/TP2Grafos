package graphtheory.heuristics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import graphtheory.util.Grafo;
import graphtheory.util.Vertice;

public class PCV {
	private Grafo grafo;

    public PCV(Grafo grafo) {
        this.grafo = grafo;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Vertice> Nearestneighbor() {
		ArrayList<Vertice> naoVisitados = (ArrayList<Vertice>) this.grafo.getVertices().clone();
        Vertice u = naoVisitados.get(0), v;
        ArrayList<Vertice> S = new ArrayList<>();

        while (!naoVisitados.isEmpty()) {
            v = this.MenorDistanciaNaoVisitado(naoVisitados, u);
            S.add(v);
            naoVisitados.remove(naoVisitados.indexOf(v));
            u = v;
        }
        S.add(S.get(0));
        return S;
    }

    @SuppressWarnings("unchecked")
	public ArrayList<Vertice> Twoopt(ArrayList<Vertice> S, int time) {
        Random r = new Random();
        ArrayList<Vertice> S2;
        int i1, i2;

        long inicio = System.currentTimeMillis();
        while ((int) ((System.currentTimeMillis() - inicio) / 1000) - time < 0) {
            i1 = r.nextInt(this.grafo.getOrdem());
            i2 = r.nextInt(this.grafo.getOrdem());

            if (i1 != i2) {
                S2 = (ArrayList<Vertice>) S.clone();
                Collections.swap(S, i1, i2);
                if (this.Avalia(S2) < this.Avalia(S)) {
                    S = (ArrayList<Vertice>) S2.clone();
                }
            }
        }
        return S;
    }
    
    private Vertice MenorDistanciaNaoVisitado(ArrayList<Vertice> naoVisitados, Vertice u) {
        Vertice retorno = naoVisitados.get(0);
        for (Vertice v : naoVisitados) {
            if (Vertice.DistanciaEntre2Vertices(u, v) < Vertice.DistanciaEntre2Vertices(u, retorno)) {
                retorno = v;
            }
        }
        return retorno;
    }

    private double Avalia(ArrayList<Vertice> S) {
        double custo = 0;
        Vertice u, v;
        for (int i = 0; i < S.size() - 1; i++) {
            u = S.get(i);
            v = S.get(i + 1);
            custo += Vertice.DistanciaEntre2Vertices(u, v);
        }
        return custo;
    }
}
