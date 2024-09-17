package controllerCorrida;

import java.util.concurrent.Semaphore;

public class Carro extends Thread{
	
	int escuderia;
	int numCarro;
	Semaphore semaforo;
	static int[] volta = new int[14];
	static int cont = 0;
	
	public Carro(int escuderia, int numCarro, Semaphore semaforo) {
		this.escuderia = escuderia;
		this.numCarro = numCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		for(int x = 0; x < 7; x++) {
			if(x == this.escuderia) {
				try {
					semaforo.acquire();
					entrar();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}finally {
					semaforo.release();
					volta();
				}
			}
		}
	}
	
	public void entrar() {
		System.out.println("O carro #"+numCarro+" da escuderia #"+escuderia+" entrou");
	}
	
	public void volta() {
		int cont = 1;
		while(cont <= 3) {
			int inicio = (int)System.nanoTime();
			int fim = (int)System.nanoTime();
			cont++;
			volta[this.cont] = fim - inicio;
			this.cont = this.cont + 1;
			if(this.cont == 13) {
				sort(this.volta);
			}
		}
	}
	
	public void sort(int[] vetor) {
		int tamanho = vetor.length;
		for(int x = 0; x < tamanho; x++) {
			for(int y = 0; y < tamanho; y++) {
				if(vetor[x] > vetor[y]) {
					int aux = vetor[x];
					vetor[x] = vetor[y];
					vetor[y] = aux;
				}
			}
		}
		for(int x = 0; x < tamanho; x++) {
			System.out.println(vetor[x]);
		}
	}
	
}
