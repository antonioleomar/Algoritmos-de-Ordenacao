package algoritmos;

public class MergeSort {
	
	public static void main(String[]args) {
		
		int[] vetor = new int[] {7,15,4,19,21,1,5,9,3,11};
		
		int left = 0;
		int rigth = vetor.length - 1;
		mergeSort(vetor, left, rigth);
		imprimirVetor(vetor);
		
	}//fim do main
	
	public static void mergeSort(int[]v, int left, int rigth) {
			
		if(left >= rigth) {	
			return;
		}
		
		else {
			int middle = (int)(left + rigth)/2;
			
			mergeSort(v, left, middle);	
			mergeSort(v, middle+1, rigth);
			merge(v, left, middle, rigth);
		}
	}
	
	public static void merge(int[]v, int left, int middle, int rigth) {		
		
		int[] vetorAux = new int[v.length];
		for(int i = left; i<v.length; i++) {
			vetorAux[i] = v[i];
		}
		
		int i = left;
		int j = middle + 1;
		int k = left;
		
		while(i<=middle && j<=rigth) {
			if(vetorAux[i] < vetorAux[j]) {
				v[k] = vetorAux[i];
				i++;
				k++;
			}
			else {
				v[k] = vetorAux[j];
				j++;
				k++;
			}
		}
		
		while(i <= middle) {
			v[k] = vetorAux[i];
			i++;
			k++;
		}
		
		while(j <= rigth) {
			v[k] = vetorAux[j];
			j++;
			k++;
		}
		
	}//fim do método merge
	
	public static void imprimirVetor(int[]v) {
		for(int i = 0; i<v.length; i++) {
			System.out.print(v[i] + " ");
		}
	}

}//fim da classe
