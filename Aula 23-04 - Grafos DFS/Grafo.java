import java.util.*;

public class Grafo {
    private int V; // Número de vértices do grafo
    private LinkedList<Integer>[] adj; // Array de listas de adjacência (uma lista para cada vértice)

    // Construtor que inicializa o grafo com V vértices
    public Grafo(int V) {
        this.V = V;
        adj = new LinkedList[V]; // Cria o array com V posições

        // Inicializa cada lista de adjacência como uma nova LinkedList
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Método para adicionar uma aresta do vértice 'origem' para 'destino'
    public void adicionarAresta(int origem, int destino) {
        adj[origem].add(destino); // Adiciona 'destino' à lista de adjacência de 'origem'
        // Como o grafo é não-direcionado, adicionamos também a aresta de volta
        adj[destino].add(origem);
    }

    public void dfs(int inicio) {
        // - Crie um vetor booleano chamado "visitado" que indique se um vértice já foi explorado ou não.
        // - Crie uma estrutura de pilha (Stack<Integer>) que será usada para controlar a ordem de visitação dos vértices.
        // - Insira (empilhe) o vértice inicial na pilha. No exercício, o ponto de partida é o vértice 0.

        // - Enquanto a pilha não estiver vazia (ou seja, ainda há vértices a explorar):
        //     - Remova (desempilhe) o vértice do topo da pilha e armazene-o como "vértice atual".
        //     - Verifique se esse vértice atual já foi visitado:
        //         - Se ainda não foi:
        //             - Marque o vértice atual como visitado no vetor "visitado".
        //             - Imprima o valor do vértice atual — esse é o momento em que ele é visitado.
        //             - Acesse a lista de vizinhos do vértice atual (na lista de adjacência).
        //                 - Para cada vizinho:
        //                     - Verifique se ele já foi visitado.
        //                     - Se ainda não foi visitado:
        //                         - Adicione (empilhe) esse vizinho na pilha para ser processado futuramente.
        //                         - Isso garante que ele será visitado quando for o próximo topo da pilha.

    }

    public static void main(String[] args) {
        // Lê o número de vértices a partir do primeiro argumento
        int numVertices = Integer.parseInt(args[0]);

        // Cria o grafo com o número de vértices informado
        Grafo grafo = new Grafo(numVertices);

        // Lê os pares de vértices (arestas) dos argumentos restantes e adiciona a aresta no grafo
        for (int i = 1; i < args.length - 1; i += 2) {
            int origem = Integer.parseInt(args[i]);
            int destino = Integer.parseInt(args[i + 1]);
            grafo.adicionarAresta(origem, destino);
        }

        System.out.println("DFS a partir do vértice 0:");

        // Executa a DFS a partir do vértice 0
        grafo.dfs(0);
    }
}

// Exemplo de execução para a entrada:
// java Grafo 6 0 1 0 2 1 3 2 4 4 5

// Vamos simular o algoritmo DFS iniciando pelo vértice 0

// ----------------------------
// Etapa 0: Inicialização
// ----------------------------
// Pilha:         [0]
// visitado:      [false, false, false, false, false, false]
// Saída parcial: ---

// Explicação:
// - Iniciamos a DFS empilhando o vértice inicial (0).
// - Nenhum vértice foi visitado ainda.

// ----------------------------
// Etapa 1: Visitando o vértice 0
// ----------------------------
// Vértice atual: 0 (desempilhado)
// Pilha:         []
// visitado:      [true, false, false, false, false, false]
// Saída parcial: 0
// Vizinho empilhado: 1, 2
// Pilha:         [1, 2]

// Explicação:
// - Visitamos o vértice 0 e marcamos como visitado.
// - Seus vizinhos são 1 e 2, que ainda não foram visitados, então empilhamos ambos.

// ----------------------------
// Etapa 2: Visitando o vértice 2 (topo da pilha)
// ----------------------------
// Vértice atual: 2
// Pilha:         [1]
// visitado:      [true, false, true, false, false, false]
// Saída parcial: 0 2
// Vizinho empilhado: 4
// Pilha:         [1, 4]

// Explicação:
// - 2 é desempilhado, visitado e marcado.
// - Seus vizinhos são 0 (já visitado) e 4 (não visitado).
// - Apenas o 4 é empilhado.

// ----------------------------
// Etapa 3: Visitando o vértice 4
// ----------------------------
// Vértice atual: 4
// Pilha:         [1]
// visitado:      [true, false, true, false, true, false]
// Saída parcial: 0 2 4
// Vizinho empilhado: 5
// Pilha:         [1, 5]

// Explicação:
// - 4 é visitado e marcado.
// - Vizinho 2 já foi visitado, então empilhamos apenas o 5 (não visitado).

// ----------------------------
// Etapa 4: Visitando o vértice 5
// ----------------------------
// Vértice atual: 5
// Pilha:         [1]
// visitado:      [true, false, true, false, true, true]
// Saída parcial: 0 2 4 5
// Vizinho: 4 (já visitado)
// Pilha:         [1]

// Explicação:
// - 5 é visitado e marcado.
// - Seu único vizinho (4) já foi visitado, então nada novo é empilhado.

// ----------------------------
// Etapa 5: Visitando o vértice 1
// ----------------------------
// Vértice atual: 1
// Pilha:         []
// visitado:      [true, true, true, false, true, true]
// Saída parcial: 0 2 4 5 1
// Vizinho empilhado: 3
// Pilha:         [3]

// Explicação:
// - 1 é visitado e marcado.
// - Vizinho 0 já visitado, mas o 3 ainda não — então empilhamos o 3.

// ----------------------------
// Etapa 6: Visitando o vértice 3
// ----------------------------
// Vértice atual: 3
// Pilha:         []
// visitado:      [true, true, true, true, true, true]
// Saída parcial: 0 2 4 5 1 3

// Explicação:
// - 3 é visitado e marcado.
// - Seu único vizinho (1) já foi visitado, então a pilha esvazia.

// ----------------------------
// Fim da execução
// ----------------------------
// Todos os vértices alcançáveis a partir do vértice 0 foram visitados.