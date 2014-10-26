package TestQos;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

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




}
