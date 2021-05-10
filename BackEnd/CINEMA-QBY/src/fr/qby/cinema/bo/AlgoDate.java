package fr.qby.cinema.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/* Pour construire cet algo je compte vérifier avec le .before du localdate */

public class AlgoDate {
	
	//Création de la méthode avec en paramètre une liste de session et un horaire
	//pour récupérer une liste de film selon une heure précise (Afficher les films entre 20h et 20h59)
	public static List<Movies> returnAllMoviesByTime(List<Sessions> sessionsMoviesList ,LocalDateTime broadcastTime){
		
		//Création de la liste qui récupèra les films éligible à la demande
		List<Movies> availableMoviesList = new ArrayList<Movies>();

		
		//Vérification de l'éligibilité pour chaque session contenu dans la liste
		for(Sessions sessionMovie:sessionsMoviesList){
			
			//Si l'horaire en cours de lecture correspond à l'horaire 
			//donné en paramètre de la fonction
			if(!sessionMovie.getDate().isBefore(broadcastTime)&&
			   !sessionMovie.getDate().isAfter(broadcastTime.plusMinutes(59))
			   )
				{
					//Ajout de l'ID correspondant au film à partir de la session
					availableMoviesList.add(sessionMovie.getId_movie());
				}
		}
		
		return availableMoviesList;
	}
}
