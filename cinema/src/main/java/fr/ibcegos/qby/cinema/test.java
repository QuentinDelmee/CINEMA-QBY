package fr.ibcegos.qby.cinema;

public class test {
	
public static String filter(String comment) {
	comment = comment.toLowerCase();
	
		//Dictionnaire de gros mots
		String[] myList2 = {"shit","fuck","vilain","chier","merde"};
		
		for(String insult:myList2) {
			
			if(comment.contains(insult)) {
				
				String replace = "";
				for(int i = 0; i< insult.length(); i++) {
					replace += "*";
				}
				comment = comment.replace(insult, replace);
			}
		}
		
		return comment;
	}
	public static void main(String[] args) {
		String commentaire = "mErde espece de vilain";
		System.out.println(filter(commentaire));

	}

}
