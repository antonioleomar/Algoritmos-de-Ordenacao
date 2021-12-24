package algoritmos;

public class HeapSort {

	public static void main(String[] args) {

		int[] vetor = new int[] { 5, 3, 6, 7, 1, 78 };

		
		imprimirVetor(vetor);
		System.out.println();
		imprimirVetor(heapSort(vetor));

	}// fim do main

	public static int[] maxHeapify(int[] heapVetor, int i, int tam) {

		int indexMaior = i;
		int indexEsquerda = (2 * i) + 1;
		int indexDireita = (2 * i) + 2;
		
		System.out.println("indexMaior: " + indexMaior);

		if (indexEsquerda <= tam && heapVetor[indexEsquerda] > heapVetor[i]) {
			indexMaior = indexEsquerda;
		}
		
		if (indexDireita <= tam && heapVetor[indexDireita] > heapVetor[i]) {
			indexMaior = indexDireita;
		}
		if (indexMaior != i) {
			System.out.println("indexMaior2: " + indexMaior);
			int aux = heapVetor[i];
			heapVetor[i] = heapVetor[indexMaior];
			heapVetor[indexMaior] = aux;
			maxHeapify(heapVetor, indexMaior, tam);
		}		

		return heapVetor;
	}// fim do método maxHeapify
	
	

	public static int[] buildMaxHeap(int[] vetor, int tam) {
		
		int meio = (int)tam/2;

		for(int i = meio-1; i >= 0; i--) {
			maxHeapify(vetor, i, tam);
		}

		return vetor;
	}//fim do método buildMaxHeap
	
	

	public static int[] heapSort(int[] vetor) {
		
		int tam = vetor.length-1;	
		buildMaxHeap(vetor, tam);
		
		imprimirVetor(vetor);
		System.out.println();
		
		for(int i = tam; i>=1; i--) {
			int aux = vetor[0];
			vetor[0] = vetor[tam];
			vetor[tam] = aux;
						
			tam -= 1;
			
			maxHeapify(vetor,0, tam);
			imprimirVetor(vetor);
			System.out.println();
		}
		
		return vetor;
	}//fim do método heapSort
	
	

	// Imprimir vetor
	public static void imprimirVetor(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}

}// fim da classe
