package TestQos;

import java.net.MalformedURLException;
import java.net.URL;


public class WmsRequest {
	private final String serveur;
	private final String depot;
	private final String layer;
	private  final Bbox BBox;
	
	public WmsRequest(String serveur,String depot,String layer,Bbox BBox)
	{
		this.serveur=serveur;
		this.depot=depot;
		this.layer=layer;
		this.BBox=BBox;
	}
	
	public URL WmsRequesttoUrlGetMap() {
		
		String url_spec="http://"+serveur+"/"+depot+"?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&LAYERS="+layer+"&"+BBox.BBoxRandom().toString()+"&WIDTH=512&HEIGHT=353&CRS=EPSG:"+BBox.GetEPSG()+"&FORMAT=image/png";
		URL url;
		try {
			url = new URL(url_spec);
			return url;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	


}
