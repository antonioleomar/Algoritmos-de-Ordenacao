package algoritmos;

public class SelectionSort {
	
	public static void main(String[] args) {
		
		int[] vetor = new int[] { 5, 3, 6, 7, 1 };
		
		selectionSort(vetor);
		imprimirVetor(vetor);
		
		
	}//fim do main
	
	//Algoritmo Selection Sort
	public static void selectionSort(int[] vetor) {
		
		//Encontra o índice do menor elemento
		for(int i = 0; i < vetor.length; i++) {			
			int indexMenor = i;
			for(int j = i+1; j < vetor.length; j++) {
				if(vetor[j] < vetor[indexMenor]) {
					indexMenor = j;
				}
			}
			//troca de valores
			int aux = vetor[i];
			vetor[i] = vetor[indexMenor];
			vetor[indexMenor] = aux;
		}		
	}
	
	//Imprimir vetor
		public static void imprimirVetor(int[] vetor) {
			for(int i=0; i<vetor.length;i++) {
				System.out.print(vetor[i]+" ");
			}
		}

}//fim da classe
