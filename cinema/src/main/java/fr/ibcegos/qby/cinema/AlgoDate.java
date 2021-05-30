package fr.ibcegos.qby.cinema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.ibcegos.qby.cinema.beans.Movie;
import fr.ibcegos.qby.cinema.beans.Session;

/* Pour construire cet algo je compte v�rifier avec le .before du localdate */

public class AlgoDate {
	
	//Creation de la methode avec en parametre une liste de session et un horaire
	//pour recuperer une liste de film selon une heure precise (Afficher les films entre 20h et 20h59)
	public static List<Movie> returnAllMoviesByTime(List<Session> sessionsMoviesList ,LocalDateTime broadcastTime){
		
		//Creation de la liste qui recupera les films eligible a la demande
		List<Movie> availableMoviesList = new ArrayList<Movie>();

		
		//V�rification de l'�ligibilit� pour chaque session contenu dans la liste
		for(Session sessionMovie:sessionsMoviesList){
			
			//Si l'horaire en cours de lecture correspond � l'horaire 
			//donn� en param�tre de la fonction
			if(!sessionMovie.getIdDate().isBefore(broadcastTime)&&
			   !sessionMovie.getIdDate().isAfter(broadcastTime.plusMinutes(59))
			   )
				{
					//Ajout de l'ID correspondant au film � partir de la session
					availableMoviesList.add(sessionMovie.getIdMovie());
				}
		}
		
		return availableMoviesList;
	}
}
