package TestQos;

public class WmsRequest {
	private final String serveur;
	private final String depot;
	private final String layer;
	private final Bbox BBox;
	
	public WmsRequest(String serveur,String depot,String layer,Bbox BBox)
	{
		this.serveur=serveur;
		this.depot=depot;
		this.layer=layer;
		this.BBox=BBox;
	}

}
