package aura;

import java.util.List;
import java.util.ArrayList;
import java.net.URLEncoder;


public class Prognoza {
	public static void main(String[] args) throws Exception {

		String city = URLEncoder.encode(args[0], "UTF-8");
		int numberOfDays = Integer.parseInt(args[1]);
		
		WWOResponse ww = new WWOResponse();
		String inscription = ww.answer(city,numberOfDays);		
		
		// System.out.println(inscription);	//napis zwroconej odpowiedzi
		
		ReadJson rr = new ReadJson(inscription);
		List<Doba> dni = new ArrayList<Doba>();
		Doba dzien_i;
		for(int i=0; i < numberOfDays; i++) {
			dzien_i= rr.transfer( i);		
			dni.add(dzien_i)	;
		}
		
		System.out.print("\nDla miejscowości : ");
		System.out.println(rr.miejscowosc());
		for(int i=0; i < dni.size(); i++) {
			System.out.println("\nPrognoza na dzień : "+dni.get(i).dataD+"  : \n"+
					"Temperatura maksymalna: "+  dni.get(i).tempMax+" C\n"+
					"Temperatura minimalna: "+ dni.get(i).tempMin+" C\n"+
					"Wschód słońca : "+dni.get(i).wschSlonca+"\n"+
					"Zachód słońca : "+dni.get(i).zachSlonca+"\n"+
					"Wiatr o godz 3:00 PM: "+dni.get(i).wiatr+" km/h ");
		}

	}
}
