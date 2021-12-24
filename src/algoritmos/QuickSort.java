package algoritmos;

import java.util.Arrays;

//Implementação do algortimo QuickSort
//Melhor e médio caso: nlogn
//Pior caso: n²
//Não é estável
//É in-place

public class QuickSort {

	public static void main(String[] args) {

		int[] vetor = new int[] { 88,32,67,59,16,2,100,36,82,18,99,65,56,68,62,76,64,69,6,75 };

		int inicio = 0;
		int fim = vetor.length - 1;

		imprimirVetor(vetor);
		quickSort(vetor, inicio, fim);
		System.out.println();
		imprimirVetor(vetor);

	}// fim do main

	public static void quickSort(int[] vetor, int inicio, int fim) {

		if (inicio < fim) {
			//Escolher entre particionamento: Lomuto ou Hoare
			//int indicePivot = particionamentoLomuto(vetor, inicio, fim);
			 int indicePivot = particionamentoHoare(vetor, inicio, fim);
			
			quickSort(vetor, inicio, indicePivot - 1);
			quickSort(vetor, indicePivot + 1, fim);
		}
	}

	public static int particionamentoLomuto(int[] vetor, int inicio, int fim) {

		// Escolher tipo de seleção do pivot:
		// int pivot = vetor[left];
		// int pivot = pivotRandom(vetor, left, right);
		//int pivot = pivotMediana(vetor);
		int pivot = pivotMedianaDe3(vetor, inicio, fim);		
		
		// Trocar posição do pivot com o primeiro elemento (vetor[0])
		int indexPivot = indexPivot(vetor, pivot);
		int aux = pivot;
		vetor[indexPivot] = vetor[inicio];
		vetor[inicio] = aux;

		//Lomuto
		int i = inicio;

		for (int j = inicio + 1; j <= fim; j++) {
			if (vetor[j] <= pivot) {
				i++;
				int aux2 = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux2;
			}
		}
		// troca pivot com i
		int aux3 = vetor[inicio];
		vetor[inicio] = vetor[i];
		vetor[i] = aux3;

		return i;
	}// fim do particionamento Lomuto

	public static int particionamentoHoare(int[] vetor, int inicio, int fim) {

		// Escolher tipo de seleção do pivot:
		// int pivot = vetor[left];
		// int pivot = pivotRandom(vetor, left, right);
		int pivot = pivotMediana(vetor, inicio, fim);
		//int pivot = pivotMedianaDe3(vetor, inicio, fim);		

		int indexPivot = indexPivot(vetor, pivot);		

		// Trocar posição do pivot com o último elemento (posição right)
		int aux = pivot;
		vetor[indexPivot] = vetor[fim];
		vetor[fim] = aux;

		// Hoare
		int x = vetor[fim];
		int i = inicio - 1;
		for (int j = inicio; j < fim; j++) {
			if (vetor[j] <= x) {
				i++;
				int aux2 = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux2;
			}
		}
		// Trocar pivot na ultima posição por posição certa
		int aux3 = vetor[i + 1];
		vetor[i + 1] = vetor[fim];
		vetor[fim] = aux3;

		return i + 1;
	}// fim do particionamento Hoare

	public static int pivotRandom(int[] vetor, int inicio, int fim) {

		// Escolhendo Pivot Aleatoriamente
		// tamanho do array
		int range = (fim - inicio) + 1;
		// valores entre left e rigth aleatório
		int indicePivotRandon = (int) (Math.random() * range) + inicio;
		// Valor do pivot
		int valorPivot = vetor[indicePivotRandon];

		return valorPivot;

	}

	public static int pivotMedianaDe3(int[] vetor, int inicio, int fim) {

		// Escolhendo Pivot da mediana de 3: valor intermediário dentre o inicio, meio e fim
		int valorPivot;
		int meio = (inicio + fim) / 2;
		int[] sorted = { vetor[inicio], vetor[meio], vetor[fim] };
		Arrays.sort(sorted);
		if (sorted[1] == vetor[fim]) {

			valorPivot = vetor[fim];

		} else if (sorted[1] == vetor[meio]) {

			valorPivot = vetor[meio];
			
		} else {
			valorPivot = vetor[inicio];
		}
		return valorPivot;
	}
	
	public static int pivotMediana(int[] vetor, int inicio, int fim) {
		// Escolhendo Pivot da mediana (m) = (Maior valor + Menor valor) / 2
		int valorPivot = vetor[inicio];
		int menorValor = vetor[inicio];
		int maiorValor = vetor[inicio];
		
		for(int i = inicio; i <= fim; i++) {
			if(vetor[i] < menorValor) {
				menorValor = vetor[i];		
			}
		}		
		
		for(int i = inicio; i <= fim; i++) {
			if(vetor[i] > maiorValor) {
				maiorValor = vetor[i];				
			}
		}		
		
		int mediana = (maiorValor + menorValor)/2;		
		int diferenca = mediana - vetor[inicio];
		if(diferenca < 0) {
			diferenca = (diferenca) * (-1);
		}		
		
		for(int i = inicio; i <= fim; i++) {
			int diferencaAtual = mediana - vetor[i];
			if(diferencaAtual < 0) {
				diferencaAtual = (diferencaAtual) * (-1);
			}
			
			if(diferencaAtual < diferenca) {
				diferenca = diferencaAtual;				
				valorPivot = vetor[i];
			}
		}		
	
		return valorPivot;
	}
	

	public static int indexPivot(int[] vetor, int pivot) {
		int indexPivot = -1;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == pivot) {
				indexPivot = i;
			}
		}
		return indexPivot;
	}

	public static void imprimirVetor(int[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + "|");
		}
	}

}// fim da classe
