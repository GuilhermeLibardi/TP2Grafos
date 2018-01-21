package graphtheory.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura {
	private File arquivo;

    public Grafo lerArquivo(String nomeArquivo) throws IOException{
        ArrayList<Vertice> vertices = new ArrayList<>();
        this.arquivo = new File(nomeArquivo);
        FileReader leitura = new FileReader(this.arquivo);
        BufferedReader armazenar = new BufferedReader(leitura);
        
        //Lê o cabeçalho do arquivo
        String[] linha;
        int numVertices;
        
        numVertices = Integer.parseInt(armazenar.readLine());
        for (int i = 0; i < numVertices; i++) {
            linha = armazenar.readLine().split(" ");
            Vertice v = new Vertice(Integer.parseInt(linha[0]), Double.parseDouble(linha[1]), Double.parseDouble(linha[2]));
            vertices.add(v);
        }
        
        Grafo grafo = new Grafo(vertices);
        armazenar.close();
        leitura.close();
        return grafo;
    }
}
