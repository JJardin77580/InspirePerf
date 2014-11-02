package TestQos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;



public class HttpGet {
	private final String user_agent = "Mozilla/5.0"; // par defaut test avec mozilla
	private final URL url;

	public HttpGet(URL url2){
		this.url=url2;
	}

	public long sendHttp() throws IOException{
		long t = System.currentTimeMillis();
		URL url_sent= url;
		HttpURLConnection con = (HttpURLConnection) url_sent.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", user_agent);
		long result=0;
		int reponse=con.getResponseCode();
		if(reponse!=200){
			System.out.println("echec");
			result=3000;
			return result;
		}
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + reponse);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		 result=System.currentTimeMillis()-t;
		//System.out.println(result);

		/*
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		 */
		//print result
		return(result);
	}
	/*
	public static void main(String[] args) throws IOException {
		HttpGet h = new HttpGet("http://ows.region-bretagne.fr/geoserver/rb/wms?service=WMS&version=1.1.0&request=GetMap&layers=rb:port_rb&styles=&bbox=102438.84375,6709004.5,348383.75,6878675.5&width=512&height=353&srs=EPSG:2154&format=application/openlayers");
		h.sendHttp();
	}
	 */
}
