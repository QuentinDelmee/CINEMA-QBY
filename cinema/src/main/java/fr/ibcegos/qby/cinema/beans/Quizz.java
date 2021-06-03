package fr.ibcegos.qby.cinema.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Quizz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String theme;
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private Integer trueAnswer;
	@Column(columnDefinition = "text")
	private String explanation;
	private String wikiUrl ;
	
	
	public Quizz(String theme, String question, String answer1, String answer2, String answer3, String answer4,
			Integer trueAnswer, String explanation, String wikiUrl) {
		this.theme = theme;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.trueAnswer = trueAnswer;
		this.explanation = explanation;
		this.wikiUrl = wikiUrl ;
	}


	@Override
	public String toString() {
		return "Quizz [id=" + id + ", theme=" + theme + ", question=" + question + ", answer1=" + answer1 + ", answer2="
				+ answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", trueAnswer=" + trueAnswer
				+ ", explanation=" + explanation + "]";
	}
	
	
	
	
}
