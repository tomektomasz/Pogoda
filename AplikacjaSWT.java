package aura;

import java.net.URLEncoder;
import java.util.List;
import java.util.ArrayList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;

public class AplikacjaSWT {
	
	public static void main(String[] args) throws Exception {
		String city = URLEncoder.encode(args[0], "UTF-8");
		int numberOfDays = Integer.parseInt(args[1]);
		WWOResponse ww = new WWOResponse();
		String inscription = ww.answer(city,numberOfDays);
		ReadJson rr = new ReadJson(inscription);
		List<Doba> dni = new ArrayList<Doba>();
		Doba dzien_i;
		for(int i=0; i < numberOfDays; i++) {
			dzien_i= rr.transfer( i);		
			dni.add(dzien_i)	;
		}
		
		//----------okienko----------
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 400);
		shell.setText("Application Prognoza Pogody");
		
		Label tytulMiejsce = new Label(shell, SWT.CENTER);

		tytulMiejsce.setBounds(30, 24, 333, 27);
		tytulMiejsce.setText("MIEJSCOWOSC :  "+rr.miejscowosc());
		
		Label prognozaSWT = new Label(shell, SWT.NONE);	
		prognozaSWT.setBounds(203, 89, 208, 155);	
		
		org.eclipse.swt.widgets.List listSWT = new org.eclipse.swt.widgets.List(shell, SWT.BORDER);
		listSWT.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int n = listSWT.getSelectionIndex();
				String tekst="Temperatura maksymalna: "+  dni.get(n).tempMax+" C\n"+
						"Temperatura minimalna: "+ dni.get(n).tempMin+" C\n"+
						"Wschód słońca : "+dni.get(n).wschSlonca+"\n"+
						"Zachód słońca : "+dni.get(n).zachSlonca+"\n"+
						"Wiatr o godz 3:00 PM: "+dni.get(n).wiatr+" km/h";
				prognozaSWT.setText(tekst);
				
			}
		});	
		listSWT.setBounds(30, 89, 136, 155);
		for(int i=0; i < dni.size(); i++) {
			listSWT.add(dni.get(i).dataD);
		}
		

			
		
		//-------------------
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
