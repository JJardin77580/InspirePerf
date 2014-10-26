package TestQos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class Main {
	private static Object lock= new Object();
	private static ArrayList<String> l= new ArrayList<String>();
	public static void Message( ) throws InterruptedException, IOException{
		synchronized (lock) {

			HttpGet h = new HttpGet("http://test");
			int compteur=0;
			while(compteur<=59){
				//System.out.println("Le test se passe bien");
				l.add(h.sendHttp());
				compteur++;
				lock.wait(1000);

			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		List<Thread> t = new ArrayList<Thread>();
		for (int i=0;i<=19;i++)
		{
			Runnable t1= ()->{try {
				Message();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}};


			Thread tmp= new Thread(t1);
			t.add(tmp);


		}

		for (Thread thread : t) {
			thread.start();
		}




		boolean allinterupted=false;

		while(!allinterupted)
		{
			allinterupted=true;
			for (Thread thread : t) {
				allinterupted=(!thread.isAlive())&allinterupted;
			}
		}
		System.out.println("nous avons eu" + l.size() + "requetes");
	}
}
