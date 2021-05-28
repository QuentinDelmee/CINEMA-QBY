package fr.ibcegos.qby.cinema.beans;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/**
 * 
 * @author QBY
 *
 */
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String title;
	private String originalTitle;
	private Integer pegi;
	private Integer releaseDate;
	private LocalTime movieDuration;
	private String movieGenre;
	private Double averageRating;

	@Column(columnDefinition = "text")
	private String movieDescription;

	@OneToMany(targetEntity = Commentary.class, mappedBy = "id")
	private List<Commentary> lstCommentarys = new ArrayList<>();

	@OneToMany(targetEntity = Session.class, mappedBy = "id")
	private List<Session> lstSessions = new ArrayList<>();

	public Movie(String title, String originalTitle, Integer pegi, Integer releaseDate, LocalTime movieDuration,
			String movieGenre, Double averageRating, String movieDescription) {

		this.title = title;
		this.originalTitle = originalTitle;
		this.pegi = pegi;
		this.releaseDate = releaseDate;
		this.movieDuration = movieDuration;
		this.movieGenre = movieGenre;
		this.averageRating = averageRating;
		this.movieDescription = movieDescription;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", originalTitle=" + originalTitle + ", pegi=" + pegi
				+ ", releaseDate=" + releaseDate + ", movieDuration=" + movieDuration + ", movieGenre=" + movieGenre
				+ ", averageRating=" + averageRating + ", movieDescription=" + movieDescription + "]";
	}

}
