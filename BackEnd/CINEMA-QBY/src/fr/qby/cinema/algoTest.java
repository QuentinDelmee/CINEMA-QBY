package fr.qby.cinema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.qby.cinema.bo.AlgoDate;
import fr.qby.cinema.bo.Movies;
import fr.qby.cinema.bo.Sessions;

public class algoTest {

	public static void main(String[] args) {
		List<Sessions> listTestMovies = new ArrayList<Sessions>();
		listTestMovies.add(new Sessions((new Movies(1)), LocalDateTime.of(2021, 5, 3, 22, 0)));
		listTestMovies.add(new Sessions((new Movies(2)), LocalDateTime.of(2021, 5, 3, 15, 0)));
		listTestMovies.add(new Sessions((new Movies(3)), LocalDateTime.of(2021, 5, 3, 17, 0)));
		listTestMovies.add(new Sessions((new Movies(4)), LocalDateTime.of(2021, 5, 3, 22, 30)));
		
		
		
		List<Movies> availableMoviesList = new ArrayList<Movies>();
		//APPEL DE LA FONCTION
		availableMoviesList = AlgoDate.returnAllMoviesByTime(listTestMovies, LocalDateTime.of(2021, 5, 3, 22, 0));
		
		for(Movies film:availableMoviesList)
		{
			System.out.println(film);
		}

	}

}
