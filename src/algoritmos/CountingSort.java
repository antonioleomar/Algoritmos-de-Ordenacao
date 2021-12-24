package algoritmos;

public class CountingSort {

	public static void main(String[] args) {

		int[] vetor = new int[] { 5, 3, 6, 7, 1 };

		imprimirVetor(vetor);
		System.out.println();
		imprimirVetor(countingSort(vetor));

	}// fim do main

	public static int[] countingSort(int[] A) {
		
		int k = maiorValorArray(A);

		int[] C = new int[k];

		// frequência
		for (int i = 0; i < A.length; i++) {
			C[A[i] - 1] += 1;
		}

		// cumulativa
		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}

		int[] B = new int[A.length];

		for (int i = A.length - 1; i >= 0; i--) {
			B[C[A[i] - 1] - 1] = A[i];
			C[A[i] - 1] -= 1;
		}

		return B;

	}// fim do método countigSort

	
	//Determinar maior valor do array
	public static int maiorValorArray(int[] vetor) {
		int maior = vetor[0];
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] > maior) {
				maior = vetor[i];
			}
		}
		return maior;
	}

	// Imprimir vetor
	public static void imprimirVetor(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}

}// fim da classe
