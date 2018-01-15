package system;

import java.util.Random;

/*
1. Napisać program, który 
tworzy dwuwymiarową tablicę liczb całkowitych o losowej wielkości (wylosowanej z
zakresu [10, 20]), gdzie liczba wierszy jest taka sama, jak liczba kolumn.
Następnie tablica zostaje uzupełniona liczbami losowymi z zakresu [-100, 100], z wyjątkiem elementów
znajdujących się na przekątnej tablicy, które w (losowo) ok. 50% przypadków otrzymują wartość 1, a w
pozostałych 50% przypadków wartość -1.
W wyniku działania programu należy wyświetlić na ekran:
•
dwie największe liczby zapisane w tabeli,
•
stosunek sumy liczb leżących w komórkach tablicy o parzystych indeksach wierszy i nieparzystych
indeksach kolumn,
•
liczbę komórek, których wartość jest mniejsza od iloczynu indeksu wiesza i kolumny tej komórki.
 */

public class MultiBoard {

	public static void main(String[] args) {
		Random rand = new Random();
		int x = rand.nextInt(20-10+1)+10;
		int maxI=0;
		int maxJ=0;
		int sumaI = 0;
		int sumaJ = 0;
		
		int[][] tab = new int[x][x];										//Uzupełnianie tablicy i wyprowadzanie 2 najwiekszych liczb z tablicy
		for(int i=0;i<tab.length;i++) {
			for(int j=0;j<tab[i].length;j++) {
				int b = rand.nextInt(100-(-100)+1)-100;
				if(i==j && b>0) 
					tab[i][j] = 1;
				else if(i==j && b<0)
					tab[i][j]= -1;
				else
				tab[i][j]=b;			
						if(b>maxI)
							maxI=b;
							if(maxI>=maxJ) {
								maxJ=maxI;
								maxI=0;}
			}	
		}
		for(int i =0;i<tab.length;i++) 										//sumowanie liczb z nie parzystych ideksów wierszy
			if(i%2==0)
			for(int j=0;j<tab[i].length;j++) 
					sumaI += tab[i][j];
		
		for(int i =0;i<tab.length;i++) 										//sumowanie liczb z nieparzystych indeksów kolumn
			for(int j=0;j<tab[i].length;j++)
				if(j%2==0)
					sumaJ += tab[i][j];
		
		int iloczyn;
		int lKomorek = 0;
		for(int i =0;i<tab.length;i++) {									//Zwraca liczbe których wartość jest mniejsza 
			for(int j=0;j<tab[i].length;j++) { 								//od iloczynu indeksu wiesza i kolumny tej komórki.
				iloczyn=i*j;
				if(iloczyn>tab[i][j])
					lKomorek++;
			}
		}
		
		
		System.out.println("Dwie najwieksze liczby w tabeli to: "+maxI+" i "+maxJ);
		System.out.println("Stosunek " +sumaI+" : "+sumaJ);
		System.out.println("liczba komorek: "+lKomorek);
		
	}

}
