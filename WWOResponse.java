package aura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WWOResponse {
	private static final String KEY_VALUE = "04c3adde5c0d4855ace121335190708"; //"04e98fac0b734480b44143104191902"; //"f0105f618b794b359f8135714181612";	
	private static final String KEY = "key";
	
	private static final String URL_PREFIX = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key="+KEY_VALUE;
	
	
	private static final String LOCATION = "q";
	private static final String NUMBER_OF_DAYS = "num_of_days";
	private static final String FORMAT = "format";	
	
	public  String answer(String localPlace , int numberD) throws IOException {
		URL url = new URL(URL_PREFIX + "&" + LOCATION + "=" + localPlace + "&" + NUMBER_OF_DAYS + "=" + numberD + "&" + FORMAT + "=json");			
		HttpURLConnection polaczenie = (HttpURLConnection) url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(polaczenie.getInputStream()));
		String napis="";
		
		napis=br.readLine();
		br.close();
		return napis;
	}
	

	
}
