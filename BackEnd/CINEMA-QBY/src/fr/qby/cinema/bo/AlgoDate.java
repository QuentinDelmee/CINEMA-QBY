package fr.qby.cinema.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/* Pour construire cet algo je compte vérifier avec le .before du localdate */

public class AlgoDate {
	
	//CREER LIST SESSION 
	//CREATION D'UNE SESSION
	
	
	public static List<Movies> returnAllMoviesByTime(List<Sessions> moviesList ,LocalDateTime broadcastTime){
		List<Movies> availableMoviesList = new ArrayList<Movies>();

		
		for(Sessions sessionMovie:moviesList){
			if(!sessionMovie.getDate().isBefore(broadcastTime)&&
			   !sessionMovie.getDate().isAfter(broadcastTime.plusMinutes(59)))
			{
				availableMoviesList.add(sessionMovie.getId_movie());
			}
		}
		
		return availableMoviesList;
	}
}
