package algoritmos;

public class BubleSort {

	public static void main(String[] args) {

		int[] vetor = new int[] { 5, 3, 6, 7, 1 };

		bubleSort(vetor);
		imprimirVetor(vetor);

	}// fim do main

	//Algoritmo Buble Sort
	public static void bubleSort(int[] vetor) {

		int indexUltimo = (vetor.length) - 1;

		while (indexUltimo > 0) {
			for (int j = 0; j < indexUltimo; j++) {
				if (vetor[j + 1] < vetor[j]) {
					int aux = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = aux;
					imprimirVetor(vetor);
					System.out.println("");
				}
			}
			indexUltimo -= 1;
		}
	}
	
	//Imprimir vetor
			public static void imprimirVetor(int[] vetor) {
				for(int i=0; i<vetor.length;i++) {
					System.out.print(vetor[i]+" ");
				}
			}

}// fim da classe
