package fr.ibcegos.qby.cinema;
import java.io.*;
import java.util.regex.*;

public class test {
	
public static String filter(String comment) {
		
	
		//Dictionnaire de gros mots
		String[] myList2 = {"shit","fuck","vilain","chier","merde"};
		
		for(String insult:myList2) {
			
			if(comment.toLowerCase().contains(insult)) {
				
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
		String commentaire = "merde j'ai pas aimé";
		System.out.println(filter(commentaire));

	}

}
