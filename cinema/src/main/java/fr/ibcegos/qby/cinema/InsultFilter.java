package fr.ibcegos.qby.cinema;

import java.util.ArrayList;

import org.apache.tomcat.jni.User;

import fr.ibcegos.qby.cinema.beans.Commentary;
import fr.ibcegos.qby.cinema.beans.Movie;

public class InsultFilter {
<<<<<<< HEAD

	
	
	String commentaire = "Merde j'ai pas aimé";
	String commentaire2 = "M E R D E j'ai pas aimé";
	String commentaire3 = "M3rd3 j'ai pas aimé";
	String commentaire4 = "Merd j'ai pas aimé";
	String commentaire5 = "Me rd e j'ai pas aimé";
	
	public String filter(String comment) {
		
		//Dictionnaire de gros mots
		String[] myList2 = {"merde","putain","connard"};
		
		for(String insult:myList2) {
			if(comment.contains(insult)) {
				
			}
		}
		
		return comment;
	} 
=======
	
>>>>>>> 5376c0cba3bc0cb3f1c41c3ba3355f0ec0d2bc86
}
