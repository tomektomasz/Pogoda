# Pogoda
Prognoza pogody zaczerpnięta z http://api.worldweatheronline.com

Do programu potrzebne są biblioteki json.jar i swt.jar lub nowsze
Dla właściwego łączenia się z serwisem worldweatheronline.com potrzebny jest też aktualny klucz który jest ważny tylko 3 miesiące i obecnie może być przeterminowany

Program uruchamia się poleceniem: java AplikacjaSWT < miejsce> <ilosc_dni>        
-gdzie < miejsce> to miasto dla którego będzie prognoza, a <ilość_dni> - dla ilu dni będzie pobrana prognoza (najlepiej ok.10)
Program wyświetla okienko gdzie są napisane u góry miasto i kraj, oraz z boku wymienione daty dla których są prognozy. Po kliknięciu w datę obok wyświetla się prognoza: temp.maks., temp.min., wschód sł., zachód sł., wiatr o 3pm. 
  
Program można też uruchomić w wersji konsolowej poleceniem: java Prognoza < miejsce> <ilosc_dni>
