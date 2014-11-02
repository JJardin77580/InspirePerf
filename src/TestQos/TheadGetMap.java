package TestQos;

import java.io.IOException;

import java.net.URL;
import java.util.concurrent.ThreadFactory;


public class TheadGetMap implements ThreadFactory {

	private final WmsRequest w;
	private final CounterWmsRequestTime count;
	public TheadGetMap(WmsRequest w,CounterWmsRequestTime t){
		this.w=w;
		this.count=t;
	}


	public Runnable getUrlRunnable(){
		Runnable r = new Runnable() {
			@Override
			public void run() {
				URL url=w.WmsRequesttoUrlGetMap();
				try {
					URL url2 = new URL("http://test.fr");
					HttpGet h = new HttpGet(url2);
					long time =h.sendHttp();
					//System.out.println(url.toString());
					count.inc(time);
				
				} catch (IOException e) {
					return;
				}
			
				//h.sendHttp();
			}};

			return r;
	}


	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r);
	}

}
