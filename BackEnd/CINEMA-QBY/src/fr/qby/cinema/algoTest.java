package fr.qby.cinema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.qby.cinema.bo.AlgoDate;
import fr.qby.cinema.bo.Movies;
import fr.qby.cinema.bo.Sessions;

public class algoTest {

	public static void main(String[] args) {
		
		//Creation d'une liste de sessions contenant des films et une heure de passage
		List<Sessions> listTestMovies = new ArrayList<Sessions>();
		listTestMovies.add(new Sessions((new Movies(1)), LocalDateTime.of(2021, 5, 3, 22, 0)));
		listTestMovies.add(new Sessions((new Movies(2)), LocalDateTime.of(2021, 5, 3, 15, 0)));
		listTestMovies.add(new Sessions((new Movies(3)), LocalDateTime.of(2021, 5, 3, 17, 0)));
		listTestMovies.add(new Sessions((new Movies(4)), LocalDateTime.of(2021, 5, 3, 22, 30)));
		
		
		//Creation d'une nouvelle liste pour recevoir les films éligible à l'heure de passage spécifié dans la fonction
		List<Movies> availableMoviesList = new ArrayList<Movies>();
		
		//APPEL DE LA FONCTION
		availableMoviesList = AlgoDate.returnAllMoviesByTime(listTestMovies, LocalDateTime.of(2021, 5, 3, 22, 0));
		
		//Affichage des films récupérés et obtenu grace à la fonction
		for(Movies film:availableMoviesList)
		{
			System.out.println(film);
		}

	}

}
