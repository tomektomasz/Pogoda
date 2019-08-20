package aura;

import org.json.JSONObject;

public class ReadJson {
	JSONObject jsonOb;
	public ReadJson(String resp) {
		this.jsonOb = new JSONObject(resp);
	}
	
	public Doba transfer(int n) {

		String dataD_n= this.jsonOb.getJSONObject("data").getJSONArray("weather").getJSONObject(n).getString("date");
		String tempMax_n = this.jsonOb.getJSONObject("data").getJSONArray("weather").getJSONObject(n).getString("maxtempC");
		String tempMin_n = this.jsonOb.getJSONObject("data").getJSONArray("weather").getJSONObject(n).getString("mintempC");
		String wschSlonca_n = this.jsonOb.getJSONObject("data").getJSONArray("weather").getJSONObject(n).getJSONArray("astronomy").getJSONObject(0).getString("sunrise");
		String zachSlonca_n = this.jsonOb.getJSONObject("data").getJSONArray("weather").getJSONObject(n).getJSONArray("astronomy").getJSONObject(0).getString("sunset");
		String wiatr_n = this.jsonOb.getJSONObject("data").getJSONArray("weather").getJSONObject(n).getJSONArray("hourly").getJSONObject(3).getString("windspeedKmph");
		
		Doba doba_n=new Doba(dataD_n ,tempMax_n , tempMin_n,wschSlonca_n,zachSlonca_n,wiatr_n );
		return doba_n;
	}
	
	public String miejscowosc() {
		String miejsce = this.jsonOb.getJSONObject("data").getJSONArray("request").getJSONObject(0).getString("query");
		return miejsce;
		
	}

}
