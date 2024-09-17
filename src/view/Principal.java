package view;

import java.util.concurrent.Semaphore;

import controllerCorrida.Carro;

public class Principal {
	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for(int x = 0; x < 7; x++) {
			Carro carro1 = new Carro(x, 1, semaforo);
			Carro carro2 = new Carro(x, 2, semaforo);
			carro1.start();
			carro2.start();
		}
	}
}
