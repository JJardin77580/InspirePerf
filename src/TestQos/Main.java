package TestQos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {


	public static void main(String[] args) throws InterruptedException, IOException {

		Bbox b = new Bbox(102438,6709004,348383,6878675,1,1,"2154");
	WmsRequest wms = new WmsRequest(".fr","geoserver","", b);
		URL u=wms.WmsRequesttoUrlGetMap();
		//System.out.println(u.toString());
		CounterWmsRequestTime count= new CounterWmsRequestTime();
		TheadGetMap r = new TheadGetMap(wms,count);

		final ScheduledExecutorService pool = Executors.newScheduledThreadPool(18,r);
		long time= System.currentTimeMillis();
		for(int i=0;i<18;i++){
			pool.scheduleAtFixedRate(r.getUrlRunnable(),0,1,TimeUnit.SECONDS);
		}
		while(System.currentTimeMillis()-time<60000){
		}
		pool.shutdown();
		while (!pool.isTerminated()) {

		}
		System.out.println(count.get());
		{
			PrintWriter filestat;
			filestat =  new PrintWriter(new BufferedWriter
					(new FileWriter("stat.txt")));

			long tab[]= count.getStat();

			filestat.println("temps de réponse \n");
			for (long stat : tab) {
				
				filestat.println(stat);

			}
			filestat.close();

		}
	}}
