package controler;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class AviaoThread extends Thread {
	
	private int idAviao;
	private Semaphore pistaSul;
	private Semaphore pistaNorte;
	private String pista;
	
	public AviaoThread(int idAviao, Semaphore pistaSul, Semaphore pistaNorte) {
		this.idAviao=idAviao;
		this.pistaNorte=pistaNorte;
		this.pistaSul=pistaSul;
	}
	
	
	@Override
	public void run() {
		Random random = new Random();
		int pista=random.nextInt(2);
		switch(pista) {
		case 0: 
			this.pista="Norte";
			try {
				this.pistaNorte.acquire();
				manobrar();
				taxiar();
				decolar();
				liberar();
			} catch (InterruptedException e) {
			
				e.printStackTrace();	
			}finally {
				this.pistaNorte.release();
			}
			break;
		case 1:
			this.pista="Sul";
			try {
			this.pistaSul.acquire();
			manobrar();
			taxiar();
			decolar();
			liberar();
		} catch (InterruptedException e) {
		
			e.printStackTrace();	
		}finally {
			this.pistaSul.release();
		}
		break;
		}
	}
	
	private void manobrar() {
		System.out.println("O aviao "+ idAviao +" foi para a pista "+ pista);
		Random random= new Random();
		int tempom = random.nextInt(4)+3;
		tempom=tempom*1000;
		try {
			sleep(tempom);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("o Temmpo que o aviao "+ idAviao +" levou "+(tempom/1000)+" segundo para manobrar");
	}
	
	
	private void taxiar() {
		Random random = new Random();
		int tempot = random.nextInt(5)+5;
		tempot=tempot*1000;
		try {
			sleep(tempot);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("o Temmpo que o aviao " +idAviao+ " levou "+(tempot/1000)+" segundo para taixar");
	}
	
	
	private void decolar() {
		Random random = new Random();
		int tempod = random.nextInt(3)+1;
		tempod=tempod*1000;
		try {
			sleep(tempod);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
			
		}
		System.out.println("o Temmpo que o aviao " +idAviao +" levou " +(tempod/1000)+ " segundo para decolar");
	}
	
	
	private void liberar() {
		Random random = new Random();
		int tempol = random.nextInt(5)+3;
		tempol=tempol*1000;
		try {
			sleep(tempol);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		System.out.println("o Temmpo que o aviao " +idAviao+ " levou "+ (tempol/1000) +" segundo para liberar");
		
	}
}
