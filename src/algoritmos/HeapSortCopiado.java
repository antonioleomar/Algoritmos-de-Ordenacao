package algoritmos;

public class HeapSortCopiado {
	

   // Declara��o de "vari�veis globais" para utilizar em qualquer fun��o
   private static int tam;
   private static int[] vetor;
   
   // Fun��o do Heapsort
   // Essa fun��o provoca o desequilibrio do Max-Heap.
   // Ela faz com que o maior valor, que est� no topo, seja trocado pelo �ltimo valor do Max-Heap.
   // Ap�s a troca, diminui o valor de 'tam' para que o valor mais alto permane�a na �ltima posi��o.
   // Ent�o � chamada a fun��o maxHeapifica para o novo valor que est� no topo.
   public static void heapsort(int[] array) {
       vetor = array;          // vetor global recebe o vetor passado como par�metro
       tam = vetor.length - 1;     // o tamanho deste vetor � armazenado em 'tam', que tamb�m � global
       
       // Chama a fun��o para construir um Max-Heap
       constroiHeap();
       
       // Assim que a Max-Heap foi criada, o processo de ordena��o pode come�ar.
       // Atrav�s desse loop que a troca do valor do topo com o valor da �ltima posi��o da Heap � feita
       for (int i = tam; i > 0; i--) {
           troca(0, tam);      // Troca a posi��o
           tam -= 1;           // Diminui 'tam' para n�o alterar a posi��o do maior valor nas pr�ximas itera��es
           maxHeapifica(0);    // Como existe um valor menor no topo, � necess�rio heapificar novamente a �rvore inteira
       }
   }
   
   // Fun��o que constr�i o Max-Heap
   private static void constroiHeap() {
       // Como o �ltimo n�vel da �rvore n�o tem filhos, a constru��o se inicia no �ltimo elemento da pen�ltima.
       // Esse elemento se encontra bem no meio do vetor, ou seja, tam/2:
       int meio = (int) (tam/2);
       
       // Para cada elemento do pen�ltimo n�vel, chama o maxHeapifica, ou seja
       // encontra o maior elemento e coloca como pai
       for (int i = meio - 1; i >= 0; i--) {
           maxHeapifica(i);
       }
   }
   
   // Fun��o de troca
   // � uma fun��o simples de swap, para auxiliar na troca de posi��o dos valores
   private static void troca(int i, int j) {
       int aux;

       aux = vetor[i];
       vetor[i] = vetor[j];
       vetor[j] = aux;
   }
   
   // Fun��o maxHeapifica
   // Essa fun��o � o core do algoritmo.
   // Ela faz a compara��o entre os valores de um Heap e ao encontrar o maior, o coloca como pai da Heap.
   // Isso faz com que qualquer Heap se torne um Max-Heap.
   private static void maxHeapifica(int pai) {
       int maior = pai,            // O maior elemento � o pai, at� que se prove o contr�rio.
           esquerda = 2 * pai + 1,     // Pega a posi��o do filho da esquerda
           direita = 2 * pai + 2;  // e a do filho da direita.
       
       // Se o filho da esquerda existe, ou seja, se ele est� dentro do intervalo verific�vel do array E
       // Se este filho � maior que o pai (que no momento � o 'maior')
       if (esquerda <= tam && vetor[esquerda] > vetor[maior])
           maior = esquerda;
       
       // Se o filho da direita existe, ou seja, se ele est� dentro do intervalo verific�vel do array E
       // Se este filho � maior que o 'maior' (que no momento pode ser o 'pai' ou o 'esquerda')
       if (direita <= tam && vetor[direita] > vetor[maior])
           maior = direita;
       
       // Se ao chegar at� aqui o 'pai' deixou de ser o 'maior' valor
       if (maior != pai) {
           troca(pai, maior);      // Faz a troca de posi��es
           maxHeapifica(maior);    // Continua heapificando com o valor que foi trocado
       }
   }
   
   // Fun��o main
   // Exemplo de uso
   public static void main(String[] args) {
       int[] vetorDesordenado = {9, 1, 8, 3, 7, 4, 6, 5,88};
       
       // Chama a fun��o de ordena��o
       heapsort(vetorDesordenado);
       
       String saida = "";
       
       // Se tudo deu certo, o vetor deve estar ordenado
       for(int valor : vetorDesordenado) {
           saida += valor + " ";
       }
       
       System.out.println(saida);
   }

}
