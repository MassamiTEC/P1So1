package view;

import java.util.concurrent.Semaphore;

import controler.AviaoThread;

public class Main {

	public static void main(String[] args) {
		Semaphore pistaNorte=new Semaphore (1);
		Semaphore pistaSul=new Semaphore (1);
		for (int i=1;i<=12;i++) {
			Thread tAviao=new AviaoThread(i,pistaSul,pistaNorte);
			tAviao.start();
		}
		
	}

}
