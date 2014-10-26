package TestQos;

import java.util.Random;



public class Bbox {
	private final int xmin;
	private final int xmax;
	private final int ymin;
	private final int ymax;
	private final int zoom_min;
	private final int zoom_max;
	private final String EPSG;

	public Bbox(int xmin, int xmax,int ymin,int ymax,int zoom_min,int zoom_max,String EPSG){		
		this.xmin=xmin;
		this.xmax=xmax;
		this.ymin=ymin;
		this.ymax=ymax;
		this.zoom_min=zoom_min;
		this.zoom_max=zoom_max;
		this.EPSG=EPSG;

	}

	public String GetEPSG(){
		return EPSG;
	}

	@Override
	public String toString() {

		String s = "bbox="+xmin+","+xmax+","+ymin+","+ymax;
		return s;
	}

	public Bbox BBoxRandom(){
		int dif_xminmax=xmax-xmin;
		int dif_yminymax=ymax-ymin;
		Random rand = new Random();
		int newxmin = rand.nextInt(xmax - xmin + 1) + xmin;
		int zoom= rand.nextInt(zoom_max-zoom_min+1)+zoom_min;
		int newxmax= newxmin+(dif_xminmax/(2*zoom));
		int newymin=rand.nextInt(ymax - ymin + 1) + ymin;
		int newymax= newymin+(dif_yminymax/(2*zoom));
		Bbox newBBOX= new Bbox(newxmin, newxmax, newymin, newymax, zoom_min,zoom_max, EPSG);
		return newBBOX;

	}


}
