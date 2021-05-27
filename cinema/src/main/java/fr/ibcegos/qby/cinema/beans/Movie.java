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
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idmovie")
/**
 * 
 * @author QBY
 *
 */
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idmovie;
	
	private String title;
	private String originaltitle;
	private Integer pegi;
	private Integer releasedate;
	private LocalTime movieduration;
	private String moviegenre;
	private Double averagerating;
	
	@Column(columnDefinition="text")
	private String moviedescription;
	
	@OneToMany(targetEntity=Commentary.class, mappedBy="idmovie")
	private List<Commentary> lstCommentarys = new ArrayList<>();
	
	@OneToMany(targetEntity=Session.class, mappedBy="idmovie")
	private List<Session> lstSessions = new ArrayList<>();
	
	
	
	public Movie(Integer pegi, Double averagerating, LocalTime movieduration, String title, String originaltitle,
			Integer releasedate, String moviegenre, String moviedescription) {

		this.pegi = pegi;
		this.averagerating = averagerating;
		this.movieduration = movieduration;
		this.title = title;
		this.originaltitle = originaltitle;
		this.releasedate = releasedate;
		this.moviegenre = moviegenre;
		this.moviedescription = moviedescription;
	}

	@Override
	public String toString() {
		return "Movie [idmovie=" + idmovie + ", pegi=" + pegi + ", averagerating=" + averagerating
				+ ", movieduration=" + movieduration + ", title=" + title + ", originaltitle=" + originaltitle
				+ ", releasedate=" + releasedate + ", moviegenre=" + moviegenre + ", moviedescription="
				+ moviedescription + "]";
	}

	public Movie(String title, String originaltitle, Integer pegi, Integer releasedate,
			LocalTime movieduration, String moviegenre, Double averagerating, String moviedescription) {
		this.title = title;
		this.originaltitle = originaltitle;
		this.pegi = pegi;
		this.releasedate = releasedate;
		this.movieduration = movieduration;
		this.moviegenre = moviegenre;
		this.averagerating = averagerating;
		this.moviedescription = moviedescription;
	}
	
	
}
