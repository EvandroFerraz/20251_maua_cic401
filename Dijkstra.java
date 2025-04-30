import java.util.*; // Importa as classes utilitárias (List, ArrayList, etc.)

// Classe que representa o grafo
class Grafo {

    // Vetor que guarda os vértices do grafo
    private final Vertice[] vertices;
    // Lista de adjacência: cada índice contém a lista de arestas do vértice correspondente
    private List<List<Aresta>> adjacencias;

    // Construtor do grafo que recebe os nomes dos vértices
    Grafo(String[] nomesVertices) { // Exemplo: {S, T, Y, X, Z}
        // Inicializa a lista principal de adjacências
        this.adjacencias = new ArrayList<>();
        // Cria o vetor de vértices
        this.vertices = new Vertice[nomesVertices.length];

        for (int i = 0; i < nomesVertices.length; i++) {
            // Inicializa a lista de vizinhos para cada vértice
            this.adjacencias.add(new ArrayList<>());
            // Cria cada vértice com nome e índice
            this.vertices[i] = new Vertice(nomesVertices[i], i);
        }
    }

    // Método para adicionar uma aresta direcionada ao grafo
    public void adicionarAresta(int origem, int destino, int peso) {
        // Adiciona uma nova aresta à lista de vizinhos do vértice de origem
        adjacencias.get(origem).add(new Aresta(destino, peso));
    }

    // Retorna a lista de arestas/vizinhos de um vértice dado pelo índice
    public List<Aresta> vizinhos(int u) {
        return adjacencias.get(u);
    }

    // Retorna o vetor de vértices do grafo
    public Vertice[] getVertices() {
        return vertices;
    }

    // Retorna a quantidade de vértices do grafo
    public int quantidadeVertices() {
        return vertices.length;
    }

    // Classe interna que representa um vértice do grafo
    static class Vertice {
        String nome; // Nome do vértice (ex: "s", "t", etc.)
        int indice; // Índice do vértice no vetor
        int distancia; // Distância estimada a partir da origem (inicialmente infinita)
        Vertice predecessor; // Predecessor no caminho mínimo

        // Construtor de vértice
        Vertice(String nome, int indice) {
            this.nome = nome;
            this.indice = indice;
            this.distancia = Integer.MAX_VALUE; // Inicia com "infinito"
            this.predecessor = null; // Sem predecessor inicialmente
        }
    }

    // Classe interna que representa uma aresta do grafo
    static class Aresta {
        int destino; // Índice do vértice de destino
        int peso;    // Peso da aresta

        // Construtor de aresta
        Aresta(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
}

// Classe que implementa o algoritmo de Dijkstra
public class Dijkstra {
    // inicializar()
    // relaxar()
    // extrairMin()
    // executar()

    public static void main(String[] args){

    }
}
