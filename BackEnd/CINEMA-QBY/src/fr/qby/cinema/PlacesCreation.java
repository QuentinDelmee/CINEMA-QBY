package fr.qby.cinema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class PlacesCreation {
	
	static int[] nbPlaces = {256,256,128,256,128,128,256,128,64,64} ;
	static int[] rangSize = {32 ,32 ,16 ,32 ,16 ,16 ,32 ,16 ,16,16} ;
	static String rangName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
	
	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("placesData.sql", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
				out.println("INSERT INTO places(id_places,id_salles,numero,rang)") ;
				out.println("VALUES") ;
				
				Random rand = new Random() ;
			    for(int i = 0 ; i < 10 ; ++i )
			    {	
			    	int nbRangTotal = nbPlaces[i]/rangSize[i] ;
			    	int nbPlaceparRang = rangSize[i] ;
			    	for(int j = 0 ; j < nbRangTotal ; ++j )
			    	{
			    		for(int k = 1 ; k < nbPlaceparRang+1 ; k++)
			    		{
			    			String toWrite = createPlaces(i,j,k) ;
			    			out.println(toWrite) ;
			    			System.out.println(toWrite);
				    	}
			    	}
			    }
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}

	private static String createPlaces(int salle, int rang,int place) {
		String toReturn = "("+(salle+1)+","+place+",'"+rangName.charAt(rang)+"')," ;
		return toReturn ;
	}
}
