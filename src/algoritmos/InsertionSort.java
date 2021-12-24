package algoritmos;

public class InsertionSort {

	public static void main(String[] args) {

		int[] vetor = new int[] { 5, 3, 6, 7, 1 };
		
		insertionSortCrescente(vetor);

		imprimirVetor(vetor);

	}// fim do main
	
	
	//Algoritmo Insertion Sort
	public static void insertionSortCrescente(int[] vetor) {

		for (int i = 1; i < vetor.length; i++) {

			int j = i;
			while (j > 0 && vetor[j] < vetor[j - 1]) {
				int aux = vetor[j];
				vetor[j] = vetor[j - 1];
				vetor[j - 1] = aux;
				j -= 1;
			}
		}
	}
	
	//Imprimir vetor
	public static void imprimirVetor(int[] vetor) {
		for(int i=0; i<vetor.length;i++) {
			System.out.print(vetor[i]+" ");
		}
	}
	
	
}// fim da classe
