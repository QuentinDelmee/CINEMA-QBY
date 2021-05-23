package fr.ibcegos.qby.cinema.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;
	private CinemaRoom id_cinema ;
	private Movie id_movie ;
	private LocalDateTime id_date ;
	private Integer seats_left;
	
	
}
