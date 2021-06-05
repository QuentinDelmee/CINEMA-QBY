package fr.ibcegos.qby.cinema;

public class InsultFilter {

	
	String commentaire = "Merde j'ai pas aimé";
	String commentaire2 = "M E R D E j'ai pas aimé";
	String commentaire3 = "M3rd3 j'ai pas aimé";
	String commentaire4 = "Merd j'ai pas aimé";
	String commentaire5 = "Me rd e j'ai pas aimé";
	
	public String filter(String comment) {
		
		//Dictionnaire de gros mots
		String[] myList2 = {"shit","fuck","vilain","chier"};
		
		for(String insult:myList2) {
			if(comment.contains(insult)) {
				comment.replace(insult, "*");
			}
		}
		
		return comment;
	}
	

	
	
}
