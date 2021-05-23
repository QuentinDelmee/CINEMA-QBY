package fr.ibcegos.qby.cinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/* Pour construire cet algo je compte v�rifier avec le .before du localdate */

public class AlgoDate {
	
	//Cr�ation de la m�thode avec en param�tre une liste de session et un horaire
	//pour r�cup�rer une liste de film selon une heure pr�cise (Afficher les films entre 20h et 20h59)
	public static List<Movie> returnAllMoviesByTime(List<Session> sessionsMoviesList ,LocalDateTime broadcastTime){
		
		//Cr�ation de la liste qui r�cup�ra les films �ligible � la demande
		List<Movie> availableMoviesList = new ArrayList<Movie>();

		
		//V�rification de l'�ligibilit� pour chaque session contenu dans la liste
		for(Session sessionMovie:sessionsMoviesList){
			
			//Si l'horaire en cours de lecture correspond � l'horaire 
			//donn� en param�tre de la fonction
			if(!sessionMovie.getDate().isBefore(broadcastTime)&&
			   !sessionMovie.getDate().isAfter(broadcastTime.plusMinutes(59))
			   )
				{
					//Ajout de l'ID correspondant au film � partir de la session
					availableMoviesList.add(sessionMovie.getId_movie());
				}
		}
		
		return availableMoviesList;
	}
}
