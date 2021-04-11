package fr.qby.cinema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class PlacesCreation {
	
	// Tableau des places des salles par ordre d'index
	static int[] nbPlaces = {256,256,128,256,128,128,256,128,64,64} ;
	// Tableau des tailles des rangs des salles par ordre d'index
	static int[] rangSize = {32 ,32 ,16 ,32 ,16 ,16 ,32 ,16 ,16,16} ;
	// Ordre de nommage des rangs
	static String rangName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
	
	public static void main(String[] args) {
		
		// On essaie de cr�er ou ouvrir le fichier, le buffer sert � �viter de multiples acc�s au fichier.
		try(FileWriter fw = new FileWriter("placesData.sql", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			// On �crit dans le fichier � la suite de ce qui existe.
				out.println("INSERT INTO places(id_places,id_salles,numero,rang)") ;
				out.println("VALUES") ;
				
				// Pour chaque salle on lui cr�e ses places
				Random rand = new Random() ;
			    for(int i = 0 ; i < 10 ; ++i )
			    {	
			    	int nbRangTotal = nbPlaces[i]/rangSize[i] ;
			    	int nbPlaceparRang = rangSize[i] ;
			    	// Pour chaque rang on cr�� les places
			    	for(int j = 0 ; j < nbRangTotal ; ++j )
			    	{
			    		// Cr�ation des places
			    		for(int k = 1 ; k < nbPlaceparRang+1 ; k++)
			    		{
			    			String toWrite = createPlaces(i,j,k) ;
			    			// On ajoute la place � la suite du document.
			    			out.println(toWrite) ;
			    			System.out.println(toWrite);
				    	}
			    	}
			    }
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}
	
	/**
	 * 
	 * @param salle index de la salle
	 * @param rang index du rang
	 * @param place Num�ro de la place
	 * @return retourne la place � ins�rer dans le document
	 */
	private static String createPlaces(int salle, int rang,int place) {
		String toReturn = "("+(salle+1)+","+place+",'"+rangName.charAt(rang)+"')," ;
		return toReturn ;
	}
}
