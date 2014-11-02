package TestQos;

public class CounterWmsRequestTime {

	private final Object lock = new Object();
	private int counter=0;
	private long requetewms[]=new long[1020];
	public void inc(long time){
		synchronized (lock) {
			requetewms[counter]=time;
			counter++;
		}
	}
	
	public int get(){
		synchronized (lock) {
			return counter;
		}
	}
	
	public long[] getStat(){
		synchronized (lock) {
			return this.requetewms;
		}
		
	}
}
