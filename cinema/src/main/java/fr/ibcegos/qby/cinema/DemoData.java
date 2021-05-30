package fr.ibcegos.qby.cinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.ibcegos.qby.cinema.beans.CinemaRoom;
import fr.ibcegos.qby.cinema.beans.Commentary;
import fr.ibcegos.qby.cinema.beans.Movie;
import fr.ibcegos.qby.cinema.beans.Opinion;
import fr.ibcegos.qby.cinema.beans.Person;
import fr.ibcegos.qby.cinema.beans.Product;
import fr.ibcegos.qby.cinema.beans.Purchase;
import fr.ibcegos.qby.cinema.beans.Reservation;
import fr.ibcegos.qby.cinema.beans.Seat;
import fr.ibcegos.qby.cinema.beans.SecurityLevel;
import fr.ibcegos.qby.cinema.beans.Session;
import fr.ibcegos.qby.cinema.beans.User;
import fr.ibcegos.qby.cinema.daos.CinemaRoomDAO;
import fr.ibcegos.qby.cinema.daos.CommentaryDAO;
import fr.ibcegos.qby.cinema.daos.MovieDAO;
import fr.ibcegos.qby.cinema.daos.OpinionDAO;
import fr.ibcegos.qby.cinema.daos.PersonDAO;
import fr.ibcegos.qby.cinema.daos.ProductDAO;
import fr.ibcegos.qby.cinema.daos.PurchaseDAO;
import fr.ibcegos.qby.cinema.daos.ReservationDAO;
import fr.ibcegos.qby.cinema.daos.SeatDAO;
import fr.ibcegos.qby.cinema.daos.SecurityLevelDAO;
import fr.ibcegos.qby.cinema.daos.SessionDAO;
import fr.ibcegos.qby.cinema.daos.UserDAO;

@Component
public class DemoData {
	@Autowired
	private CinemaRoomDAO crdao;
	@Autowired
	private CommentaryDAO cdao;
	@Autowired
	private MovieDAO mdao;
	@Autowired
	private OpinionDAO odao;
	@Autowired
	private PersonDAO pedao;
	@Autowired
	private ProductDAO prdao;
	@Autowired
	private PurchaseDAO pudao;
	@Autowired
	private ReservationDAO rdao;
	@Autowired
	private SeatDAO seadao;
	@Autowired
	private SecurityLevelDAO sldao;
	@Autowired
	private SessionDAO sesdao;
	@Autowired
	private UserDAO udao;

	static String[] prenoms = { "Aaliyah", "Aaron", "Abby", "Abd", "Abdallah", "Abdel", "Abdelaziz", "Abdelkader",
			"Abdellah", "Abderrahmane", "Abdou", "Abdoul", "Abdoul-Aziz", "Abdoulaye", "Abdourahmane", "Abdramane",
			"Abdullah", "Abel", "Abiga�l", "Abiga�lle", "Abigail", "Abiga�l", "Abishan", "Abou", "Aboubacar",
			"Aboubakar", "Abraham", "Aby", "Achille", "Achraf", "Ada", "Adam", "Adama", "Adame", "Adams", "Adan",
			"Adel", "Ad�la�de", "Ad�le", "Ad�lie", "Adeline", "Adem", "Aden", "Adib", "Adil", "Adja", "Adnane",
			"Adonis", "Adrian", "Adriana", "Adriano", "Adriel", "Adrien", "Aedan", "Agatha", "Agathe", "Agla�", "Agn�s",
			"Aharon", "Ahmad", "Ahmed", "Aicha", "A�cha", "A�da", "Aidan", "A�dan", "Aiden", "A�den", "A�ko", "Aim�",
			"Aim�e", "A�na", "A�nhoa", "Aisha", "A�sha", "A�ssa", "Aissata", "A�ssata", "Aissatou", "A�ssatou", "A�ss�",
			"Akram", "Aksel", "Akshaya", "Aksil", "Alaa", "Ala�a", "Alain", "Alan", "Alana", "Alassane", "Alba",
			"Alban", "Albane", "Alb�ric", "Albert", "Albertine", "Albin", "Aldo", "Alec", "Alejandro", "Aleksandar",
			"Aleksandra", "Alessandra", "Alessandro", "Alessia", "Alessio", "Alex", "Alexander", "Alexandra",
			"Alexandre", "Alexane", "Alexi", "Alexia", "Alexie", "Alexis", "Alexy", "Alfred", "Alhassane", "Ali",
			"Alia", "Alice", "Alicia", "Ali�nor", "Alima", "Alina", "Aline", "Aliocha", "Aliou", "Alioune", "Alisha",
			"Alison", "Alissa", "Alistair", "Alix", "Alixe", "Aliya", "Aliyah", "Aliza", "Aliz�e", "Allan", "Allegra",
			"Allya", "Alma", "Alo�s", "Alon", "Alone", "Aloys", "Alpha", "Alphonse", "Alth�a", "Alvin", "Aly", "Alya",
			"Alyah", "Alycia", "Alyssa", "Alyssia", "Alysson", "Amadou", "Ama�l", "Amaia", "Amal", "Amalia", "Amanda",
			"Amandine", "Amani", "Amar", "Amara", "Amaury", "Amaya", "Ambre", "Ambrine", "Ambroise", "Amel", "Amelia",
			"Am�lia", "Am�lie", "Amicie", "Amin", "Amina", "Aminata", "Amine", "Amir", "Amira", "Amjad", "Amos", "Amy",
			"Ana", "Anabelle", "Ana�", "Ana�", "Anael", "Ana�l", "Anaelle", "Ana�lle", "Anais", "Ana�s", "Anas",
			"Anass", "Anastasia", "Anatole", "Anaya", "Andr�", "Andrea", "Andr�a", "Andreas", "Andr�as", "Andrei",
			"Andr�s", "Andrew", "Andria", "Andy", "Anes", "Ange", "Angel", "Angela", "Ang�le", "Angelica", "Angelina",
			"Ang�lina", "Ang�line", "Ang�lique", "Angelo", "Angie", "Ania", "Anir", "Anis", "Anissa", "Anita", "Anjali",
			"Anna", "Anna-Rose", "Annabelle", "Anna�lle", "Anne", "Anne-Laure", "Anne-Lise", "Anne-Marie",
			"Anne-Sophie", "Anouchka", "Anouck", "Anouk", "Anselme", "Anta", "Anthony", "Antoine", "Antoinette",
			"Anton", "Antoni", "Antonia", "Antonin", "Antonio", "Antony", "Anya", "Apolline", "Appoline", "April",
			"Archibald", "Arda", "Ari", "Aria", "Ariana", "Ariane", "Ari�", "Ariel", "Arielle", "Arij", "Aris",
			"Aristide", "Arlo", "Arman", "Armance", "Armand", "Armel", "Armelle", "Arnaud", "Arno", "Aron", "Ars�ne",
			"Arslan", "Arslane", "Art�mis", "Arthur", "Arthus", "Arto", "Artur", "Artus", "Arwa", "Arwen", "Ary",
			"Arya", "Ashley", "Asia", "Asma", "Asmaa", "Assa", "Assad", "Asser", "Assetou", "Assia", "Assil", "Assiya",
			"Assiyah", "Assya", "Astou", "Astr�e", "Astrid", "Ath�na", "Ath�na�s", "Aubin", "Aude", "Audrey", "Auguste",
			"Augustin", "Augustine", "Aure", "Aurel", "Aur�le", "Aurelia", "Aur�lia", "Aur�lie", "Aur�lien", "Auriane",
			"Aurore", "Auxane", "Auxence", "Ava", "Avi", "Aviel", "Aviga�l", "Avital", "Avril", "Awa", "Axel", "Axelle",
			"Aya", "Ayaan", "Ayah", "Ayala", "Ayan", "Ayana", "Aydan", "Ayden", "Ayem", "Ayla", "Aylan", "Aylane",
			"Ayleen", "Aylin", "Ayline", "Ayman", "Aymane", "Aymar", "Aymen", "Aymeric", "Ayna", "Ayoub", "Ayrton",
			"Aysha", "Azad", "Az�lie", "Aziz", "Baba", "Babacar", "Badis", "Bafod�", "Bahia", "Bakary", "Balkis",
			"Balthazar", "Baptiste", "Barbara", "Barnab�", "Barth�lemy", "Barth�l�my", "Basil", "Basile", "Basma",
			"Bastian", "Bastien", "Baudouin", "Baya", "Beatrice", "B�atrice", "Bella", "Ben", "B�n�dicte", "Benjamin",
			"Benoit", "Beno�t", "B�r�nice", "Bernard", "Bertille", "B�ryl", "Bettina", "Betty", "Beya", "Bianca",
			"Bilal", "Bilel", "Billal", "Billie", "Billy", "Binta", "Bintou", "Blaise", "Blanche", "Blandine",
			"Blessing", "Bogdan", "Bonnie", "Boris", "Bosco", "Boubacar", "Boubou", "Bouchra", "Bradley", "Brahim",
			"Brandon", "Brayan", "Briac", "Brian", "Brice", "Brieuc", "Brune", "Bruno", "Bryan", "Caleb", "Cali",
			"Calie", "Calista", "Calixte", "Calvin", "Calypso", "Camelia", "Cam�lia", "Cameron", "Camil", "Camila",
			"Camilia", "Camilla", "Camille", "Camillia", "Camilo", "Candice", "Capucine", "Cara", "Carine", "Carl",
			"Carla", "Carlos", "Carlotta", "Carmen", "Carolina", "Caroline", "Cassandra", "Cassandre", "Cassidy",
			"Cassie", "Cassiop�e", "Castille", "Cataleya", "Catalina", "Catherine", "C�cile", "Cecilia", "C�cilia",
			"C�dric", "Celeste", "C�leste", "C�lestin", "C�lestine", "Celia", "C�lia", "C�lian", "Celina", "C�lina",
			"Celine", "C�line", "C�lya", "Cerise", "C�sar", "Chad", "Chaden", "Chahine", "Chahinez", "Cha�", "Chaima",
			"Cha�ma", "Chana", "Chanel", "Charl�ne", "Charles", "Charlie", "Charline", "Charlize", "Charlotte",
			"Charly", "Chayma", "Cheick", "Cheick-Oumar", "Cheikh", "Chelsea", "Ch�rine", "Cheyenne", "Chiara",
			"Chirine", "Chlo�", "Chlo�", "Chmouel", "Chris", "Christ", "Christelle", "Christian", "Christina",
			"Christine", "Christophe", "Christopher", "Ciara", "Cindy", "Claire", "Clara", "Clarence", "Clarisse",
			"Claudia", "Cl�a", "Cl�lia", "Cl�lie", "Cl�mence", "Cl�ment", "Cl�mentine", "Cl�o", "Cl�oph�e", "Clo�",
			"Clothilde", "Clotilde", "Clovis", "Colas", "Colette", "Colin", "Coline", "Colomban", "Colombe",
			"Colombine", "C�me", "Constance", "Constant", "Constantin", "Coralie", "Coraline", "Corentin", "Corto",
			"Cosima", "Coumba", "Cristiano", "Curtis", "Cynthia", "Cyprien", "Cyrian", "Cyriaque", "Cyrielle", "Cyril",
			"Cyrille", "Cyrine", "Cyrus", "Dado", "Dahlia", "Dali", "Dalia", "Dalil", "Dalla", "Dalva", "Dalya",
			"Damian", "Damien", "Dan", "Dana", "Dana�", "Dani", "Dania", "Daniel", "Daniela", "Daniella", "Danny",
			"Dante", "Dany", "Danyl", "Daoud", "Daouda", "Daphn�", "Daphn�e", "Daria", "Darine", "Dario", "Darius",
			"Darren", "David", "Dayan", "Dayana", "Dayane", "Deborah", "D�borah", "Delia", "D�lia", "Delphine", "D�lya",
			"Demba", "Denis", "Deniz", "Deva", "Diaba", "Diaby", "Diana", "Diane", "Diego", "Dieynaba", "Dimitri",
			"Dina", "Diogo", "Divine", "Djamila", "Djena", "Djeneba", "Dj�n�ba", "Djenna", "Djibril", "Dominique",
			"Domitille", "Donatien", "Donia", "Dora", "Dorian", "Doriane", "Doron", "Dounia", "Dov", "Dramane", "Driss",
			"Dune", "Dylan", "Dyna", "Eddy", "Eden", "�den", "Edgar", "Edgard", "Edmond", "Edouard", "�douard",
			"Eduard", "Eduardo", "Edward", "Edwin", "Eglantine", "Eileen", "El", "Ela", "El�a", "�l�a", "Eleanor",
			"El�anor", "El�anore", "�l�anore", "Elena", "El�na", "�l�na", "El�onore", "�l�onore", "Elhadj", "Eli",
			"�li", "Elia", "�lia", "Eliahou", "Eliakim", "Elian", "Eliana", "Eliane", "Elias", "�lias", "Elie", "�lie",
			"Eliel", "Eli�s", "Eliette", "Elif", "Elijah", "Elikya", "Elina", "�lina", "Eline", "�line", "Elinor",
			"Elio", "�lio", "Elior", "Eliora", "Eliot", "�liot", "Eliott", "�liott", "Elisa", "�lisa", "Elisabeth",
			"�lisabeth", "Elise", "�lise", "Elisheva", "Elissa", "Eliza", "Elizabeth", "Ella", "Ellie", "Elliot",
			"Elliott", "Elly", "Eloan", "Eloane", "Elodie", "�lodie", "Eloi", "�loi", "Elo�se", "�lo�se", "Elon",
			"Elona", "Elone", "Elora", "Elouan", "Elsa", "Elvire", "Ely", "Elya", "Elyan", "Elyana", "Elyas", "Elyes",
			"Ely�s", "Elyna", "Elyne", "�lyne", "Elyo", "Elyssa", "Ema", "Emeline", "�meline", "Emeric", "Emi", "Emie",
			"�mie", "Emil", "Emile", "�mile", "Emilia", "Emilie", "�milie", "Emilien", "Emilio", "Emily", "Emir",
			"Emma", "Emmanuel", "Emmanuella", "Emmanuelle", "Emmie", "Emmy", "Emna", "Emy", "Ena�l", "En�a", "Eneko",
			"Enguerrand", "Ennio", "Enola", "Enora", "�nora", "Enzo", "Ephra�m", "Eren", "Eric", "�ric", "Erik",
			"Erika", "Erin", "Erine", "Ernest", "Ernestine", "Erwan", "Erwann", "Eryne", "Esa�e", "Esma", "Esm�e",
			"Esra", "Esteban", "Est�ban", "Estelle", "Esther", "Ethan", "�than", "Ethann", "Ethel", "Etienne",
			"�tienne", "Eug�ne", "Eug�nie", "Eulalie", "Eunice", "Eurydice", "Eva", "�va", "Eva-Rose", "Evan", "Evann",
			"Eve", "�ve", "Evelyne", "Evy", "Ewan", "Ewen", "Ewenn", "Eya", "Eyad", "Eyal", "Eydel", "Eyden", "Eymen",
			"Eytan", "Eythan", "�z�chiel", "Ezio", "Ezra", "Fabien", "Fabio", "Fabrice", "Fadi", "Fady", "Fa�l", "Fahd",
			"Faith", "Fallou", "Fanny", "Fanta", "Fantin", "Fantine", "Farah", "Fares", "Far�s", "Farouk", "Fatiha",
			"Fatim", "Fatima", "Fatima-Zahra", "Fatimata", "Fatma", "Fatou", "Fatouma", "Fatoumata", "Faustine",
			"Federico", "F�licie", "F�licien", "F�licit�", "Felix", "F�lix", "Ferdinand", "Feriel", "F�riel", "Ferima",
			"Feryel", "Filip", "Filipe", "Fiona", "Firas", "Firdaous", "Firdaws", "Flavia", "Flavie", "Flavien",
			"Flavio", "Fleur", "Flora", "Flore", "Florence", "Florent", "Florentin", "Florian", "Floriane", "Fod�",
			"Foucauld", "France", "Francesca", "Francesco", "Francis", "Franck", "Fran�ois", "Fran�oise", "Franklin",
			"Fr�d�ric", "Frida", "Gabin", "Gabriel", "Gabriela", "Gabriele", "Gabriella", "Gabrielle", "Gad", "Gael",
			"Ga�l", "Ga�lle", "Ga�tan", "Ga�tan", "Ga�tane", "Gaia", "Ga�a", "Gala", "Gaoussou", "Garance", "Gary",
			"Gaspar", "Gaspard", "Gaston", "Gatien", "Gauthier", "Gautier", "Gaye", "Gemma", "Genevi�ve", "Geoffrey",
			"Geoffroy", "George", "Georges", "Georgia", "Germain", "Giacomo", "Gianni", "Gilles", "Gina", "Giorgia",
			"Giovanni", "Gis�le", "Giulia", "Giulian", "Giuliana", "Giulio", "Gladys", "Gloria", "Gonzague", "Goundo",
			"Grace", "Gr�ce", "Gr�goire", "Gr�gory", "Greta", "Guilhem", "Guillaume", "Guillemette", "Gustave",
			"Gustavo", "Guy", "Gwena�lle", "Gwendal", "Gwendoline", "Habib", "Habiba", "Haby", "Hadassa", "Hadja",
			"Hadriel", "Hadrien", "Hafsa", "Ha�", "Ha�m", "Hajar", "Hakim", "Halima", "Halimatou", "Hamady", "Hamed",
			"Hamidou", "Hamza", "Hana", "Hanaa", "Hanae", "Hana�", "Hania", "Hanna", "Hannah", "Hanya", "Haris",
			"Harold", "Haron", "Haroun", "Harouna", "Haroune", "Harry", "Hasna", "Hassan", "Hassane", "Hatem",
			"Hatouma", "Hava", "Hawa", "Haya", "Hayden", "Hector", "Hedi", "H�di", "Heidi", "Helena", "H�l�na",
			"H�l�na", "H�l�ne", "H�lie", "H�lio", "H�lios", "Hella", "H�lo�se", "Henri", "Henriette", "Henry",
			"Hermance", "Hermine", "Hermione", "Hiba", "Hicham", "Hidaya", "Hillel", "Hind", "Hippolyte", "Hocine",
			"Honor�", "Honorine", "Hope", "Horace", "Hortense", "Houda", "Hubert", "Hugo", "Hugues", "Hussein", "Ian",
			"Ianis", "Iban", "Ibrahim", "Ibrahima", "Ibtissam", "Ida", "Idan", "Idir", "Idris", "Idriss", "Idrissa",
			"Igor", "Ihsan", "Ikram", "Ikrame", "Ilan", "Ilana", "Ilef", "Ilhan", "Ilian", "Iliana", "Iliane", "Ilias",
			"Ilies", "Ilina", "Ilona", "Ilya", "Ilyan", "Ilyana", "Ilyane", "Ilyas", "Ilyass", "Ilyes", "Ily�s",
			"Ilyess", "Imad", "Iman", "Imane", "Imani", "Imany", "Imen", "Imene", "Im�ne", "Imran", "Imr�n", "Imrane",
			"Ina", "Inaya", "Inayah", "India", "Ines", "In�s", "In�s", "In�s", "Ingrid", "Inna", "Inza", "Ioana",
			"Iona", "Ir�ne", "Irina", "Iris", "Isaac", "Isabella", "Isabelle", "Isadora", "Isaiah", "Isa�ah", "Isaure",
			"Isayah", "Is�e", "Iseult", "Ishak", "Ishaq", "Isia", "Isidore", "Isild", "Isis", "Islam", "Islem",
			"Ismael", "Isma�l", "Ismail", "Isma�l", "Isra", "Israa", "Israel", "Isra�l", "Issa", "Issam", "Issiaka",
			"Ivan", "Ivana", "Ivy", "Iwan", "Iyad", "Iyed", "Izaac", "Izia", "Iz�a", "Jack", "Jacob", "Jacqueline",
			"Jacques", "Jad", "Jade", "Jaden", "Jalil", "Jamal", "James", "Jamil", "Jan", "Jana", "Jane", "Janelle",
			"Janna", "Jannah", "Jannat", "Jarod", "Jasmine", "Jason", "Jassem", "Jassim", "Jawad", "Jawed", "Jayan",
			"Jayden", "Jayson", "Jean", "Jean-Baptiste", "Jean-Christophe", "Jean-David", "Jean-Luc", "Jean-Marc",
			"Jeanne", "Jeannette", "Jed", "Jehanne", "Jenna", "Jennah", "Jennifer", "Jenny", "J�r�mie", "Jeremy",
			"J�r�my", "J�r�me", "Jessica", "Jessie", "Jessim", "Jessy", "Jibril", "Jihane", "Jill", "Jim", "Jimmy",
			"Jinane", "Joachim", "Joakim", "Joan", "Joana", "Joanna", "Joanne", "Joaquim", "Jodie", "Joe", "Jo�l",
			"Jo�lle", "Joey", "Johan", "Johana", "Johann", "Johanna", "Johanne", "John", "Johnny", "Jonah", "Jonas",
			"Jonathan", "Jordan", "Jordane", "Jordy", "Joris", "Joseph", "Jos�phine", "Josh", "Joshua", "Josselin",
			"Josu�", "Joud", "Joudia", "Joy", "Joyce", "Juan", "Juba", "Jude", "Judith", "Jules", "Julia", "Julian",
			"Juliana", "Juliane", "Julianne", "Julie", "Julien", "Juliette", "Jun", "June", "Junior", "Junon", "Justin",
			"Justine", "Kacper", "Kader", "Kadiatou", "Kadidia", "Kadidiatou", "Kadidja", "Kady", "Kahil", "Kahina",
			"Ka�na", "Ka�s", "Ka�ss", "Kali", "Kalilou", "Kamel", "Kam�lia", "Kamil", "Kamila", "Karamba", "Karamoko",
			"Karen", "Karim", "Karima", "Karine", "Karl", "Karla", "Karol", "Karolina", "Kassandra", "Kassim",
			"Katarina", "Kate", "Katell", "Kathleen", "Katia", "Kawtar", "Kawthar", "Kayden", "Kayla", "Kayliah",
			"Kayna", "Kayron", "Kays", "Ke�la", "Keira", "Kelly", "Kelvin", "Kelya", "Kelyan", "Kenan", "Kendra",
			"Kendrick", "Kenji", "Kenny", "Kenza", "Kenzi", "Kenzo", "Kenzy", "Keren", "Kessy", "Ketsia", "Kevin",
			"K�vin", "Keyla", "Keziah", "Khadidiatou", "Khadidja", "Khadija", "Khady", "Khaled", "Khalid", "Khalifa",
			"Khalil", "Kheira", "Kiara", "Kilian", "Killian", "Kilyan", "Kim", "Kimberley", "Kimberly", "Kimi", "Kimia",
			"Kiyan", "Klara", "Koumba", "Kristina", "Kurtis", "Kyan", "Kyara", "Kyle", "Kylian", "Kyliann", "Kyllian",
			"Ladji", "Laetitia", "La�titia", "Lahna", "La�a", "Lalie", "Laly", "Lalya", "Lamia", "Lamine", "Lana",
			"Lancelot", "Lara", "Lassana", "Laszlo", "Latifa", "Laura", "Laure", "Laureen", "Lauren", "Laurence",
			"Laur�ne", "Laurent", "Lauriane", "Laurine", "Lauryn", "Laya", "Layana", "Layanah", "Layane", "Layel",
			"Layla", "Layna", "Lazar", "Lazare", "Lea", "L�a", "Leah", "L�ah", "Leana", "L�ana", "L�andre", "Leandro",
			"L�andro", "L�ane", "L�anne", "Leelou", "Lehna", "Leia", "Le�a", "Leila", "Le�la", "Le�na", "L�lio", "Lena",
			"L�na", "L�ni", "Lennie", "Lenny", "Leny", "L�ny", "Leo", "L�o", "L�o-Paul", "Leon", "L�on", "L�ona",
			"Leonard", "L�onard", "Leonardo", "L�one", "L�onie", "Leonor", "L�onor", "L�onore", "L�ontine", "Leopold",
			"L�opold", "L�opoldine", "Leslie", "Leticia", "Levana", "L�vana", "Levi", "L�vi", "Lewis", "Leya", "Leyla",
			"Leyna", "Leyth", "Lia", "Liam", "Liana", "Liel", "Liham", "Lila", "Lilas", "Lili", "Lili-Rose", "Lilia",
			"Lilian", "Liliana", "Liliane", "Lilie", "Lilly", "Lilou", "Lilwenn", "Lily", "Lily-Rose", "Lilya", "Lina",
			"Linda", "Lindsay", "Line", "Lino", "Lino�", "Linoy", "Lionel", "Lior", "Liora", "Liron", "Lirone", "Lisa",
			"Lisandro", "Lise", "Lison", "Lital", "Liv", "Livia", "Livio", "Liya", "Liyah", "Liz", "Liza", "Loan",
			"Loane", "Logan", "Lohan", "Lo�c", "Lo�s", "Lo�se", "Lola", "Lorena", "Lorenzo", "Lorette", "Lorie",
			"Loris", "Lorraine", "Lou", "Lou-Ann", "Lou-Anne", "Louan", "Louane", "Louann", "Louanne", "Louay",
			"Loubna", "Louca", "Louis", "Louis-Marie", "Louisa", "Louise", "Louison", "Louka", "Loula", "Louna",
			"Lounes", "Lounis", "Loup", "Louve", "Luan", "Lubin", "Luc", "Luca", "Lucas", "Lucca", "Luce", "Lucia",
			"Lucie", "Lucien", "Lucile", "Lucille", "Lucy", "Ludivine", "Ludmila", "Ludovic", "Luigi", "Luis", "Luisa",
			"Luka", "Lukas", "Luke", "Lula", "Luna", "Lune", "Luz", "Lya", "Lyah", "Lyam", "Lyana", "Lyanna", "Lydia",
			"Lyes", "Lyham", "Lyla", "Lylia", "Lylou", "Lyna", "Lynda", "Lyne", "Lynn", "Lyra", "Lysa", "Lysandre",
			"Lyse", "Maayane", "Maceo", "Mac�o", "Macha", "Maddalena", "Madeleine", "Madeline", "Madina", "Mado",
			"Madoussou", "Mady", "Ma�", "Mael", "Ma�l", "Ma�lan", "Ma�lie", "Ma�line", "Ma�lis", "Maelle", "Ma�lle",
			"Ma�ly", "Ma�lyne", "Maelys", "Ma�lys", "Ma�lys", "Maeva", "Ma�va", "Ma�va", "Magdalena", "Maha",
			"Mahamadou", "Mahault", "Mahaut", "Mahdi", "Mah�", "Maher", "Mahmoud", "Maho", "Mai", "Ma�", "Maia", "Ma�a",
			"Ma�ly", "Ma�lys", "Maimouna", "Ma�mouna", "Ma�na", "Maissa", "Ma�ssa", "Ma�ssane", "Ma�wenn", "Maja",
			"Makan", "Maksim", "Mala�ka", "Malak", "Malcolm", "Malek", "Malena", "Malia", "Malick", "Malik", "Malika",
			"Malo", "Malone", "Mama", "Mamadou", "Mamady", "Mame", "Mamou", "Mamoudou", "Manal", "Manar", "Manel",
			"Manelle", "Mani", "Manil", "Manon", "Mansour", "Manuel", "Manuela", "Mara", "Maram", "Marc",
			"Marc-Antoine", "Marceau", "Marcel", "Marcello", "Marco", "Marcus", "Margaux", "Margo", "Margot",
			"Marguerite", "Maria", "Mariam", "Mariama", "Mariame", "Mariana", "Marianne", "Marie", "Marie-Alix",
			"Marie-Ange", "Marie-Lou", "Mariem", "Marilou", "Marin", "Marina", "Marine", "Mario", "Marion", "Marius",
			"Mariya", "Marjane", "Marjorie", "Mark", "Marko", "Markus", "Marley", "Marlo", "Marlon", "Marlow", "Marnie",
			"Marouane", "Marta", "Martha", "Marthe", "Martin", "Marvin", "Marvyn", "Marwa", "Marwan", "Marwane",
			"Marwen", "Maryam", "Maryline", "Marylou", "Masha", "Massil", "Massinissa", "Massyl", "Matei", "Mateja",
			"Mateo", "Mat�o", "Mateusz", "Matheo", "Math�o", "Mathias", "Mathieu", "Mathilda", "Mathilde", "Mathis",
			"Mathurin", "Mathys", "Matias", "Matilda", "Matilde", "Matis", "Matisse", "Matt", "Matteo", "Matt�o",
			"Matth�o", "Matthew", "Matthias", "Matthieu", "Matthis", "Mattia", "Matys", "Maud", "Maude", "Maureen",
			"Maurice", "Max", "Maxence", "Maxens", "Maxim", "Maxime", "Maximilian", "Maximilien", "Maxine", "May",
			"Maya", "Mayane", "Mayar", "Mayas", "Mayeul", "Mayline", "Maylis", "Ma�lis", "Mayron", "Mayssa", "Mayssane",
			"Mazarine", "Mazen", "Mehdi", "Mehdy", "Meir", "Me�r", "Me�ssa", "Me�ssane", "M�lanie", "Melchior", "M�lia",
			"M�lie", "Melina", "M�lina", "M�linda", "M�line", "M�lin�e", "M�lisande", "Melissa", "M�lissa",
			"M�lissande", "Mellina", "M�llina", "M�lodie", "Melody", "M�lody", "M�lusine", "Melvil", "Melvin", "Melvyn",
			"M�lya", "M�lyna", "Menahem", "Mendel", "Meriam", "Meriem", "Merlin", "Merwan", "Meryam", "Meryem", "Meryl",
			"Meyron", "Meyssa", "Meziane", "Mia", "Michael", "Micha�l", "Michel", "Michelle", "Mickael", "Micka�l",
			"Miguel", "Mika", "Mika�l", "Mikail", "Mika�l", "Mike", "Mila", "Milan", "Milann", "Milena", "Miles",
			"Milhan", "Milhane", "Milica", "Milla", "Milo", "Mina", "Minh", "Mira", "Miral", "Miriam", "Miya", "Moch�",
			"Modibo", "Mody", "Mohamed", "Mohamed-Ali", "Mohamed-Amine", "Mohamed-Lamine", "Mohammad", "Mohammed",
			"Mo�ra", "Mo�se", "Molly", "Mona", "Monica", "Monique", "Morgan", "Morgane", "Morganne", "Mory", "Mosh�",
			"Mouad", "Mouctar", "Mouhamad", "Mouhamadou", "Mouhamed", "Mouhammad", "Moulay", "Mouna", "Mounia",
			"Mounir", "Moussa", "Moustafa", "Moustapha", "Muhammad", "Muhammed", "Mustapha", "Mya", "Myla", "Mylan",
			"Mylann", "Myriam", "Myrtille", "Nabil", "Nabintou", "Nada", "Nadia", "Nadine", "Nadir", "Nael", "Na�l",
			"Naelle", "Na�lle", "Nafissatou", "Nahel", "Nahia", "Nahil", "Nahla", "Nahyl", "Na�a", "Na�l", "Naila",
			"Na�la", "Na�m", "Na�ma", "Na�s", "Nala", "Nalya", "Namizata", "Namory", "Nana", "Naomi", "Naomie", "Naor",
			"Narimane", "Nassim", "Natacha", "Natalia", "Natan", "Natasha", "Natha�l", "Nathalie", "Nathan",
			"Nathanael", "Nathana�l", "Nathane", "Nathaniel", "Nava", "Nawal", "Nawel", "Nawfel", "Naya", "Nayel",
			"Nayla", "Nazim", "Ndeye", "Neela", "Neil", "Ne�la", "Nelia", "N�lia", "Nell", "Nellia", "Nelly", "Nelson",
			"Nelya", "N�lya", "N�n�", "N�o", "Nermine", "Nesrine", "Neyl", "Neyla", "Niam�", "Nicolas", "Nicole",
			"Niels", "Nihel", "Nikita", "Nikola", "Nil", "Nils", "Nina", "Nine", "Nino", "Ninon", "Niouma", "Nisrine",
			"Nissim", "Nizar", "Noa", "Noah", "Noam", "No�m", "Noan", "No�", "No�e", "No�lia", "No�lie", "Noemi",
			"No�mi", "No�mie", "Noha", "Noham", "Nohan", "Noh�", "Nola", "Nolan", "Nolann", "Nolhan", "Noor", "Nora",
			"Norah", "Norhane", "Nouha", "Nour", "Noura", "Nourane", "Noya", "Oc�ane", "Octave", "Octavie", "Od�lia",
			"Olga", "Olive", "Oliver", "Olivia", "Olivier", "Oliwia", "Olympe", "Olympia", "Omar", "Ombeline", "Ondine",
			"Oona", "Oph�lie", "Ora", "Oren", "Oriane", "Orion", "Orlane", "Ornella", "Orso", "Orson", "Ortal", "Oscar",
			"Oskar", "Othman", "Othmane", "Otto", "Oumar", "Oumou", "Ouriel", "Ousmane", "Oussama", "Ovadia", "Owen",
			"Pablo", "Paco", "Pac�me", "Paloma", "Paola", "Paolo", "Pape", "Paris", "Pascal", "Patricia", "Patrick",
			"Paul", "Paul-Antoine", "Paul-Arthur", "Paul-Emile", "Paula", "Paulin", "Pauline", "Pedro", "Penda",
			"P�n�lope", "Perla", "Perle", "Perrine", "Peter", "P�tronille", "Pharell", "Phil�as", "Phil�mon",
			"Philibert", "Philippa", "Philippe", "Philippine", "Philom�ne", "Pia", "Pierre", "Pierre-Alexandre",
			"Pierre-Antoine", "Pierre-Louis", "Pietro", "Pio", "Pol", "Preston", "Priam", "Prince", "Prisca",
			"Priscille", "Prosper", "Prudence", "Prune", "Prunelle", "Purity", "Qassim", "Quentin", "Quitterie",
			"Racha", "Rachel", "Racim", "Rafael", "Rafa�l", "Rafaela", "Rahim", "Rahma", "Ralph", "Ramata",
			"Ramatoulaye", "Rami", "Ramy", "Rana", "Rania", "Ranim", "Ranya", "Raoul", "Raphael", "Rapha�l",
			"Rapha�lle", "Rayan", "Rayane", "Rayen", "Rayhana", "Razan", "Razane", "Rebecca", "R�becca", "Reda", "R�da",
			"Redouane", "Reine", "R�mi", "R�my", "Renaud", "R�pha�l", "Riad", "Ricardo", "Richard", "Rim", "Rime",
			"Rita", "Ritaj", "Ritej", "Rivka", "Riwan", "Riyad", "Robert", "Robin", "Robinson", "Roch", "Rodolphe",
			"Rodrigo", "Rodrigue", "Rohan", "Rokhaya", "Rokia", "Rokya", "Roland", "Romain", "Roma�ssa", "Roman",
			"Romane", "Romeo", "Rom�o", "Romie", "Romy", "Ron", "Ronan", "Rony", "Rosa", "Rosalie", "Rose", "Rosie",
			"Roxane", "Roxanne", "Roy", "Ruben", "Rubens", "Ruby", "Rudy", "Ruth", "Ryad", "Ryan", "Rym", "Saad",
			"Sabine", "Sabri", "Sabrina", "Sabrine", "Sacha", "Sadio", "Safa", "Safia", "Safiatou", "Safiya", "Safwan",
			"Safwane", "Safya", "Sahel", "Said", "Sa�d", "Saif", "Saja", "Sakina", "Salem", "Salif", "Saliha", "Salim",
			"Salima", "Salimata", "Saliou", "Sally", "Salma", "Salman", "Salom�", "Salom�e", "Salomon", "Saly", "Sam",
			"Samantha", "Samba", "Sami", "Samia", "Samir", "Samira", "Samson", "Samuel", "Samy", "Sana", "Sanaa",
			"Sandra", "Sandrine", "Sandro", "Sandy", "Santiago", "Sara", "Sarah", "Sarah-Lou", "Saran", "Sarra",
			"Sasha", "Saskia", "Satine", "Saul", "Sa�l", "Savannah", "Scarlett", "Scott", "Sean", "Sebastian",
			"Sebastien", "S�bastien", "Sekou", "S�kou", "Selena", "S�l�na", "S�l�ne", "Selim", "S�lim", "Selma",
			"Selyan", "Sephora", "S�phora", "S�raphine", "Serena", "S�r�na", "Serge", "Serigne", "Serine", "S�rine",
			"S�verin", "Seydina", "Seydou", "Seynabou", "Shady", "Shahd", "Shahine", "Sha�", "Sha�li", "Sha�ly",
			"Sha�ma", "Sha�na", "Sha�nez", "Shana", "Shanaya", "Shani", "Shanice", "Shanna", "Shannon", "Shanon",
			"Shany", "Sharon", "Shawn", "Shay", "Shayan", "Shayma", "Shayna", "Shelly", "Sherine", "Sh�rine", "Shira",
			"Shirel", "Shirine", "Shyrel", "Sia", "Siaka", "Sibylle", "Sidi", "Sidney", "Sidonie", "Sidra", "Sidy",
			"Sienna", "Siham", "Sihem", "Silas", "Silo�", "Sim�on", "Simon", "Simone", "Sinan", "Sira", "Sirine",
			"Sixte", "Sixtine", "Skander", "Soan", "So�n", "Sofia", "Sofian", "Sofiane", "Sofya", "Sohan", "Sohane",
			"Sokhna", "Sokona", "Solal", "Solan", "Solange", "Sol�ne", "Solenn", "Soline", "Solveig", "Sonia", "Sophia",
			"Sophie", "Soraya", "Soren", "S�ren", "Souheyl", "Soujoud", "Souka�na", "Soulayman", "Souleyman",
			"Souleymane", "Soumaya", "Stacy", "Stan", "Stanislas", "Stanley", "Steeve", "Stefan", "Stella", "St�phane",
			"St�phanie", "Steve", "Steven", "Suzanne", "Suzie", "Suzon", "Sven", "Swan", "Swann", "Sybille", "Sydney",
			"Sylia", "Sylvain", "Sylvia", "Sylvie", "Syrine", "Szymon", "Taha", "Tahar", "Tahel", "Tahira", "Ta�na",
			"Ta�s", "Takumi", "Tal", "Tali", "Talia", "Taly", "Talya", "Tamara", "Tancr�de", "Tanguy", "Tania",
			"Tanina", "Tanya", "Tao", "Tara", "Tasnim", "Tasnime", "Tatiana", "Taym", "Tayron", "T�a", "Teddy",
			"Tehila", "Telma", "Tenzin", "T�o", "Teodor", "Terence", "T�rence", "Teresa", "Tesnim", "Tesnime", "Tess",
			"Tessa", "Thadd�e", "Tha�s", "Thalia", "Thalie", "Thanina", "Th�a", "Thelma", "Th�mis", "Theo", "Th�o",
			"Th�odora", "Theodore", "Th�odore", "Th�ophane", "Th�ophile", "Th�otime", "Th�r�se", "Thiago", "Thibaud",
			"Thibault", "Thibaut", "Thierno", "Thierry", "Thomas", "Tia", "Tiago", "Tiana", "Tidiane", "Tidjane",
			"Tiffany", "Tiguida", "Tilio", "Tim", "Tim�o", "Timot�", "Timoth�", "Timoth�e", "Timothy", "Tina",
			"Tiphaine", "Titouan", "Tobias", "Tom", "Toma", "Tomas", "Tommy", "Tony", "Tosca", "Toscane", "Tracy",
			"Tristan", "Trystan", "Tsipora", "Tyana", "Tybalt", "Tylan", "Tyler", "Tym�o", "Typhaine", "Tyron", "Ugo",
			"Ulysse", "Uma", "Uriel", "Vadim", "Valentin", "Valentina", "Valentine", "Valentino", "Val�re", "Valeria",
			"Val�rian", "Val�rie", "Vanessa", "Vasco", "Vassili", "Vassily", "Vera", "Vianney", "Victoire", "Victor",
			"Victoria", "Victorien", "Victorine", "Viggo", "Viktor", "Viktoria", "Vincent", "Vinciane", "Violaine",
			"Violette", "Virgil", "Virgile", "Virginie", "Vittoria", "Viviane", "Vivien", "Vivienne", "Vladimir",
			"Wael", "Wa�l", "Wa�l", "Walid", "Wanda", "Wandrille", "Warren", "Wassil", "Wassim", "Wendy", "Wesley",
			"Wiem", "Wiktoria", "Wilfried", "Wilhem", "Will", "Willem", "William", "Willy", "Wilson", "Winner",
			"Wissam", "Wissem", "Xavier", "Yacine", "Yacoub", "Yacouba", "Yael", "Ya�l", "Ya�lle", "Yahia", "Yahya",
			"Ya�r", "Yakine", "Yakoub", "Yamina", "Yan", "Yana", "Yani", "Yanice", "Yanis", "Yaniv", "Yann", "Yanni",
			"Yannick", "Yannis", "Yara", "Yaron", "Yasin", "Yasmina", "Yasmine", "Yasser", "Yassin", "Yassine", "Yaya",
			"Yazen", "Yazid", "Yesmine", "Yessine", "Ylan", "Yoan", "Yoann", "Yoav", "Yoel", "Yo�l", "Yohan", "Yohann",
			"Yolan", "Yona", "Yoni", "Yoram", "Yosra", "Yossef", "Youcef", "Youmna", "Youna", "Younes", "Youn�s",
			"Youness", "Younous", "Younouss", "Youri", "Yousra", "Youssef", "Youssouf", "Ys�", "Ys�e", "Yumi", "Yuna",
			"Yunus", "Yuri", "Yusuf", "Yvan", "Yves", "Zach", "Zacharia", "Zacharie", "Zachary", "Zack", "Zackary",
			"Zadig", "Zahara", "Zahra", "Zakaria", "Zakariya", "Zakary", "Zakarya", "Zara", "Zayd", "Zayn", "Zaynab",
			"Zayneb", "Zeinab", "Zelda", "Z�lie", "Z�phyr", "Zeynab", "Zeyneb", "Zeynep", "Ziad", "Zied", "Zina",
			"Zineb", "Zinedine", "Zion", "Zita", "Ziyad", "Zoe", "Zo�", "Zo�", "Zoey", "Zohra", "Zuzanna", "Zyad" };

	// Liste de noms en 44
	static String[] noms = { "MOYON", "HERVOUET", "HERVY", "DOUILLARD", "EVAIN", "DUGAST", "BERTHO", "DOUSSET",
			"MORICEAU", "BATARD", "GUILBAUD", "TERRIEN", "LERAY", "VIAUD", "SORIN", "BICHON", "PERRAUD", "MAISONNEUVE",
			"CLAVIER", "POUVREAU", "BOUCARD", "MAHE", "PRAUD", "BIDET", "DOUET", "BOUYER", "DUPAS", "CLOUET", "HUCHET",
			"NOBLET", "TUAL", "VINET", "BRIAND", "CAILLON", "JEANNEAU", "GOBIN", "EON", "BACHELIER", "LEMARIE",
			"LEFEUVRE", "FAVREAU", "LEMASSON", "GUILLET", "PICAUD", "CHOTARD", "BRAUD", "PRIN", "ROUE", "GIRAUDET",
			"ALLAIRE", "BLAIS", "MACE", "GRELIER", "PEDRON", "LANOE", "FONTENEAU", "GUITTON", "MORICE", "ALLAIS",
			"BLANDIN", "BURGAUD", "MINIER", "CHIRON", "LECHAT", "CHEREAU", "BRISSON", "HERY", "FOUCHER", "LANDAIS",
			"GUILLARD", "GUIMARD", "TESSIER", "PELE", "PACAUD", "MORISSEAU", "PINEAU", "CHAUVEL", "LERAT", "HAMON",
			"MENAGER", "FOUCHARD", "BOSSARD", "BUSSON", "PORCHER", "MERLET", "GARREAU", "POULARD", "GUIBERT",
			"LEVESQUE", "RIVAL", "BODET", "AUGEREAU", "GILET", "JUHEL", "LABARRE", "DELANOE", "VRIGNAUD", "RONDEAU",
			"LANGLAIS", "MOISAN", "THIBAUD", "BOURON", "FORGET", "GENDRON", "BAUDOUIN", "MANDIN", "BOURCIER", "DROUET",
			"BERTHAUD", "DESBOIS", "BOURGET", "GIRAUDEAU", "GUILLE", "CHAILLOU", "BOURSIER", "BABIN", "NOURY", "BOSSE",
			"GICQUEL", "FERRE", "PROVOST", "DREAN", "LANDREAU", "GRIMAUD", "CHESNEAU", "BERTAUD", "LEGEAY", "BROCHARD",
			"CRESPIN", "DELALANDE", "GABORIT", "BERNIER", "JOUIN", "CHAPRON", "DUGUE", "LEDUC", "BOURDEAU", "CHARRIER",
			"RIO", "HAREL", "FOURRIER", "GUILLOU", "VERGER", "GAUDET", "GAUTIER", "FOUGERE", "FAUCHEUX", "AUFFRAY",
			"LEBRETON", "PINEL", "GASNIER", "GRASSET", "BIRON", "CAILLAUD", "DAVID", "DANET", "PELLERIN", "JOSSE",
			"GALLAIS", "GRELLIER", "MARCHAIS", "LAUNAY", "MENARD", "BOUTIN", "LECOQ", "PINSON", "GOURDON", "BARREAU",
			"AUBIN", "CHEVILLARD", "BILLY", "MORTIER", "COQUARD", "LEBEAU", "HERBRETEAU", "DENIEL", "BESNIER",
			"GUILLOTEAU", "CHAUVET", "BUREAU", "RENAUD", "LEBERT", "SAULNIER", "BRARD", "MALARD", "HAVARD", "BOUE",
			"ALLAIN", "HEMERY", "BLAIN", "BOURREAU", "GUILLOTIN", "NEAU", "PINARD", "HERVE", "PITON", "LELOUP",
			"OUVRARD", "MONNIER", "GAUDIN" };

	// Liste des villes du 44
	static String[] villes = { "Abbaretz (44001)", "Aigrefeuille-sur-Maine (44002)", "Ancenis-Saint-Géréon (44003)",
			"Chaumes-en-Retz (44005)", "Assérac (44006)", "Avessac (44007)", "Basse-Goulaine (44009)",
			"Batz-sur-Mer (44010)", "La Bernerie-en-Retz (44012)", "Besné (44013)", "Le Bignon (44014)",
			"Blain (44015)", "La Boissière-du-Doré (44016)", "Bouaye (44018)", "Bouée (44019)", "Bouguenais (44020)",
			"Villeneuve-en-Retz (44021)", "Boussay (44022)", "Bouvron (44023)", "Brains (44024)", "Campbon (44025)",
			"Carquefou (44026)", "Casson (44027)", "Le Cellier (44028)", "Divatte-sur-Loire (44029)",
			"La Chapelle-des-Marais (44030)", "La Chapelle-Glain (44031)", "La Chapelle-Heulin (44032)",
			"La Chapelle-Launay (44033)", "La Chapelle-sur-Erdre (44035)", "Châteaubriant (44036)",
			"Château-Thébaud (44037)", "Chauvé (44038)", "Cheix-en-Retz (44039)", "La Chevrolière (44041)",
			"Clisson (44043)", "Conquereuil (44044)", "Cordemais (44045)", "Corsept (44046)", "Couëron (44047)",
			"Couffé (44048)", "Le Croisic (44049)", "Crossac (44050)", "Derval (44051)", "Donges (44052)",
			"Drefféac (44053)", "Erbray (44054)", "La Baule-Escoublac (44055)", "Fay-de-Bretagne (44056)",
			"Fégréac (44057)", "Fercé (44058)", "Frossay (44061)", "Le Gâvre (44062)", "Gétigné (44063)",
			"Gorges (44064)", "Grand-Auverné (44065)", "Grandchamps-des-Fontaines (44066)", "Guémené-Penfao (44067)",
			"Guenrouet (44068)", "Guérande (44069)", "La Haie-Fouassière (44070)", "Haute-Goulaine (44071)",
			"Herbignac (44072)", "Héric (44073)", "Indre (44074)", "Issé (44075)", "Jans (44076)",
			"Joué-sur-Erdre (44077)", "Juigné-des-Moutiers (44078)", "Le Landreau (44079)", "Lavau-sur-Loire (44080)",
			"Legé (44081)", "Ligné (44082)", "La Limouzinière (44083)", "Le Loroux-Bottereau (44084)",
			"Louisfert (44085)", "Lusanger (44086)", "Machecoul-Saint-Même (44087)", "Maisdon-sur-Sèvre (44088)",
			"Malville (44089)", "La Marne (44090)", "Marsac-sur-Don (44091)", "Massérac (44092)",
			"Mauves-sur-Loire (44094)", "La Meilleraye-de-Bretagne (44095)", "Mésanger (44096)", "Mesquer (44097)",
			"Missillac (44098)", "Moisdon-la-Rivière (44099)", "Monnières (44100)", "La Montagne (44101)",
			"Montbert (44102)", "Montoir-de-Bretagne (44103)", "Montrelais (44104)", "Mouais (44105)",
			"Les Moutiers-en-Retz (44106)", "Mouzeil (44107)", "Mouzillon (44108)", "Nantes (44109)",
			"Nort-sur-Erdre (44110)", "Notre-Dame-des-Landes (44111)", "Noyal-sur-Brutz (44112)", "Nozay (44113)",
			"Orvault (44114)", "Oudon (44115)", "Paimbœuf (44116)", "Le Pallet (44117)", "Pannecé (44118)",
			"Paulx (44119)", "Le Pellerin (44120)", "Petit-Auverné (44121)", "Petit-Mars (44122)", "Pierric (44123)",
			"Le Pin (44124)", "Piriac-sur-Mer (44125)", "La Plaine-sur-Mer (44126)", "La Planche (44127)",
			"Plessé (44128)", "Pontchâteau (44129)", "Pont-Saint-Martin (44130)", "Pornic (44131)", "Pornichet (44132)",
			"Port-Saint-Père (44133)", "Pouillé-les-Côteaux (44134)", "Le Pouliguen (44135)", "Préfailles (44136)",
			"Prinquiau (44137)", "Puceul (44138)", "Quilly (44139)", "La Regrippière (44140)", "La Remaudière (44141)",
			"Remouillé (44142)", "Rezé (44143)", "Riaillé (44144)", "Rouans (44145)", "Rougé (44146)",
			"Ruffigné (44148)", "Saffré (44149)", "Saint-Aignan-Grandlieu (44150)", "Saint-André-des-Eaux (44151)",
			"Sainte-Anne-sur-Brivet (44152)", "Saint-Aubin-des-Châteaux (44153)", "Saint-Brevin-les-Pins (44154)",
			"Saint-Colomban (44155)", "Corcoué-sur-Logne (44156)", "Saint-Étienne-de-Mer-Morte (44157)",
			"Saint-Étienne-de-Montluc (44158)", "Saint-Fiacre-sur-Maine (44159)", "Saint-Gildas-des-Bois (44161)",
			"Saint-Herblain (44162)", "Vair-sur-Loire (44163)", "Saint-Hilaire-de-Chaléons (44164)",
			"Saint-Hilaire-de-Clisson (44165)", "Saint-Jean-de-Boiseau (44166)", "Saint-Joachim (44168)",
			"Saint-Julien-de-Concelles (44169)", "Saint-Julien-de-Vouvantes (44170)", "Saint-Léger-les-Vignes (44171)",
			"Sainte-Luce-sur-Loire (44172)", "Saint-Lumine-de-Clisson (44173)", "Saint-Lumine-de-Coutais (44174)",
			"Saint-Lyphard (44175)", "Saint-Malo-de-Guersac (44176)", "Saint-Mars-de-Coutais (44178)",
			"Saint-Mars-du-Désert (44179)", "Vallons-de-l'Erdre (44180)", "Saint-Michel-Chef-Chef (44182)",
			"Saint-Molf (44183)", "Saint-Nazaire (44184)", "Saint-Nicolas-de-Redon (44185)", "Sainte-Pazanne (44186)",
			"Saint-Père-en-Retz (44187)", "Saint-Philbert-de-Grand-Lieu (44188)", "Sainte-Reine-de-Bretagne (44189)",
			"Saint-Sébastien-sur-Loire (44190)", "Saint-Viaud (44192)", "Saint-Vincent-des-Landes (44193)",
			"Sautron (44194)", "Savenay (44195)", "Sévérac (44196)", "Sion-les-Mines (44197)", "Les Sorinières (44198)",
			"Soudan (44199)", "Soulvache (44200)", "Sucé-sur-Erdre (44201)", "Teillé (44202)",
			"Le Temple-de-Bretagne (44203)", "Thouaré-sur-Loire (44204)", "Les Touches (44205)", "Touvois (44206)",
			"Trans-sur-Erdre (44207)", "Treffieux (44208)", "Treillières (44209)", "Trignac (44210)",
			"La Turballe (44211)", "Vallet (44212)", "Loireauxence (44213)", "Vay (44214)", "Vertou (44215)",
			"Vieillevigne (44216)", "Vigneux-de-Bretagne (44217)", "Villepot (44218)", "Vue (44220)",
			"La Chevallerais (44221)", "La Roche-Blanche (44222)", "Geneston (44223)", "La Grigonnais (44224)" };

	// Liste des différents genres
	static String[] sexes = { "H", "F", "B", "A", "T" };

	// List des commentaires aléatoires
	static String[] comments = { "C'est trop bien!", "C'était pas mal!", "C'était moyen :(", "C'était bofbof :(",
			"Je me suis fait chier", "C'était de la merde!" };

	// Liste des propretés
	static String[] proprete = { "Très Propre", "Propre", "Passable", "Moyen", "Sale", "Très Sale", "Inadmissible" };

	// Liste de pseudos futuristes
	static String[] pseudoFutur = { "Aarav", "Aarom", "Abbrahan", "Abrahan", "Ace", "Acsel", "Adahm", "Adahn", "Adit",
			"Adone", "Adran", "Adrihan", "Adrihel", "Adrihen", "Adriyel", "Adriyen", "Adryan", "Adryel", "Aebram",
			"Aedan", "Aedar", "Aedard", "Aeden", "Aedyn", "Aeraf", "Aerav", "Aeron", "Agost", "Agust", "Ahbel", "Ahlan",
			"Ahlex", "Ahlwin", "Ahron", "Aibel", "Aibram", "Aice", "Aiden", "Aisaak", "Aksel", "Alber", "Aldoh",
			"Aldohr", "Aldon", "Aldone", "Alecx", "Alefret", "Alexand", "Alexin", "Alezand", "Alezander", "Alhan",
			"Alifred", "Alin", "Alix", "Alixandr", "Alixer", "Allan", "Alren", "Andere", "Anderz", "Andie", "Andret",
			"Andrex", "Andry", "Anedre", "Anthonis", "Anthonix", "Antoin", "Antoniye", "Antorn", "Apollox", "Arhun",
			"Arihan", "Arion", "Aris", "Ariyan", "Arjun", "Arlox", "Arman", "Armanis", "Armanix", "Arnaf", "Arnav",
			"Arthir", "Artuhr", "Aryan", "Asa", "Asan", "Asher", "Ashir", "Ashr", "Ashtin", "Ashtom", "Astin",
			"Atticas", "Augun", "Augus", "Austim", "Austyn", "Averyx", "Axtin", "Ayaan", "Aybram", "Aydan", "Ayden",
			"Aydin", "Barreth", "Beckhan", "Bekn", "Benja", "Benjam", "Bentlae", "Bentleye", "Bentlix", "Bentom",
			"Billis", "Billix", "Blaike", "Blayne", "Blayse", "Bobbis", "Bobbyx", "Bohin", "Bouwen", "Brack", "Bracken",
			"Braddy", "Bradger", "Bradlix", "Braeden", "Braedy", "Braedyn", "Braidn", "Brandon", "Brantom", "Brax",
			"Braydan", "Braydn", "Brayeden", "Braylin", "Brayln", "Breckett", "Brenden", "Brensom", "Brigan", "Brindan",
			"Brindon", "Briyan", "Briyce", "Brodin", "Brodrik", "Brodyn", "Broggs", "Brunnos", "Bruwes", "Bruwno",
			"Bryce", "Caerson", "Cahlun", "Callam", "Callin", "Calrin", "Calwin", "Camden", "Camdon", "Camran",
			"Camren", "Camrin", "Camryn", "Canning", "Canrad", "Carbin", "Carliyel", "Carsin", "Cartr", "Cayeden",
			"Cayedn", "Cayen", "Cayne", "Caze", "Cedrix", "Cedroc", "Charle", "Charliye", "Chindler", "Chindlr",
			"Christover", "Chrix", "Clarx", "Claye", "Claytin", "Clintom", "Codex", "Codix", "Cohlin", "Cohren",
			"Colbix", "Colemin", "Colrin", "Coltan", "Coltin", "Conr", "Corly", "Coup", "Crag", "Craix", "Crayg",
			"Crew", "Cristover", "Crux", "Cullin", "Curtix", "Cyris", "Cyrox", "Daerryl", "Daltom", "Damari", "Damaris",
			"Damiran", "Damiron", "Damiyen", "Danirel", "Danom", "Darilan", "Darinell", "Dariox", "Dariux", "Darren",
			"Darwon", "Daryen", "Daviad", "Davian", "Daviron", "Davith", "Davix", "Davon", "Dawson", "Dax", "Dayne",
			"Derix", "Derock", "Deron", "Derril", "Desmon", "Devan", "Dexton", "Dismon", "Doriyan", "Dorrinell",
			"Doryen", "Draex", "Drav", "Drax", "Drayk", "Drick", "Duglas", "Edam", "Edan", "Edard", "Edvin", "Elber",
			"Elden", "Elex", "Eligah", "Elijea", "Elliat", "Elrin", "Elriot", "Elyot", "Emberson", "Emerton", "Emerys",
			"Emeryx", "Emex", "Emmed", "Emorson", "Ender", "Enders", "Enderson", "Erix", "Erock", "Ethin", "Flyx",
			"Francole", "Frankin", "Frankyl", "Fransix", "Fynn", "Fynnegun", "Fyster", "Gabryel", "Gaerry", "Garreth",
			"Gav", "Gavryn", "Gayel", "Gayge", "Gayle", "Geral", "Geremy", "Gideron", "Graeham", "Graeme", "Graesen",
			"Graeyam", "Graezzon", "Grald", "Grayham", "Gzad", "Haral", "Harlin", "Harp", "Harris", "Harryx", "Harvel",
			"Hectrr", "Hendrix", "Hoard", "Horris", "Horrison", "Hueson", "Ifan", "Ilex", "Jaden", "Jadirel", "Jaecob",
			"Jaeden", "Jaedon", "Jaek", "Jaeke", "Jael", "Jaggex", "Jagx", "Jame", "Jardan", "Jareth", "Jariden",
			"Jaro", "Jasih", "Jastin", "Jax", "Jaxer", "Jaxon", "Jaxson", "Jaxtom", "Jaycobe", "Jayecob", "Jayedn",
			"Jayme", "Jaze", "Jazon", "Jefry", "Jefrye", "Jenzen", "Jezper", "Jezzy", "Johnath", "Jordein", "Jordyen",
			"Juliran", "Julyen", "Justan", "Kade", "Kaeler", "Kai", "Kamern", "Kamron", "Kartr", "Karzen", "Kase",
			"Kaydn", "Kayel", "Kaze", "Khal", "Kiran", "Knox", "Koale", "Koba", "Kodyn", "Kohner", "Kohren", "Kolb",
			"Kold", "Kolt", "Koltn", "Korb", "Korey", "Krastin", "Krish", "Kurson", "Kyel", "Kyeler", "Kyllan",
			"Kyllen", "Kyman", "Kyre", "Kyris", "Laenard", "Laene", "Landan", "Landn", "Larrence", "Larris", "Lasson",
			"Layne", "Laytn", "Leeroye", "Lennox", "Lero", "Leviye", "Liyam", "Luekas", "Lushian", "Maddax", "Madn",
			"Maeck", "Maerlon", "Maikle", "Malahki", "Malakye", "Malax", "Malcalm", "Martn", "Marwin", "Matzen",
			"Mauris", "Maverock", "Maxtn", "Maxtom", "Maxwill", "Mayzon", "Mazen", "Mikl", "Moargan", "Morgn", "Myles",
			"Naethan", "Nathanael", "Nathn", "Nayel", "Niklas", "Nix", "Nyco", "Olver", "Orin", "Orlan", "Oron", "Own",
			"Ozcar", "Pabl", "Patrack", "Patrock", "Pax", "Paxt", "Paxtn", "Payeton", "Phenix", "Philp", "Rafel",
			"Ragan", "Randis", "Raydn", "Rober", "Roberd", "Roderock", "Rodneye", "Rodrick", "Rodrock", "Rogr", "Rohn",
			"Roys", "Rube", "Rusl", "Ryder", "Ryker", "Rylan", "Rymond", "Sawyir", "Sawyr", "Shaene", "Shaw", "Shayn",
			"Skylr", "Solmon", "Soren", "Stevn", "Sulvan", "Sylas", "Taelor", "Taln", "Tann", "Tanr", "Tatm", "Teag",
			"Ternce", "Thadd", "Thoms", "Timoth", "Tobis", "Tobs", "Ton", "Tray", "Traze", "Trephor", "Treye",
			"Tristen", "Tristiran", "Tristn", "Trum", "Tryst", "Tyse", "Tyze", "Victr", "Vycter", "Vyctor", "Waelon",
			"Waerren", "Walkr", "Wallon", "Waltr", "Wayde", "Wayn", "Wilm", "Wils", "Winson", "Wye", "Xan", "Xandr",
			"Xav", "Xavis", "Xavix", "Ximon", "Xzav", "Xzavis", "Yael", "Yahr", "Yan", "Yce", "Yos", "Ysaac", "Zaeden",
			"Zaen", "Zaid", "Zan", "Zand", "Zandr", "Zav", "Zavir", "Zavis", "Zavr", "Zavyr", "Zax", "Zaxary", "Zayre",
			"Zimeon", "Zimon", "Zyre", "Abbigael", "Abbil", "Abbyl", "Abgale", "Abrielle", "Abril", "Adley", "Adlyn",
			"Adlynn", "Adrana", "Adriaenne", "Adriannae", "Aebby", "Aedele", "Aekira", "Aelani", "Aeliyah", "Aellana",
			"Aellice", "Aellyce", "Aemmalee", "Aera", "Aerora", "Aesha", "Aevangel", "Aevangelina", "Aeyana", "Aileene",
			"Akyra", "Alaegha", "Alaena", "Alaina", "Alaysia", "Aleigha", "Alestra", "Alestrandra", "Alextra", "Allany",
			"Alyce", "Amaera", "Amaeri", "Amelise", "Amelix", "Anahi", "Anastase", "Anaya", "Anbel", "Andraea", "Aneya",
			"Angique", "Anka", "Anlise", "Annalisa", "Aracelle", "Arana", "Arbelle", "Arelle", "Arly", "Arlyse",
			"Aryana", "Aryanna", "Aubriena", "Aubrina", "Avae", "Avaeana", "Avalynn", "Avry", "Ayana", "Aymee", "Ayna",
			"Azarea", "Azyriah", "Baeleigh", "Baelleigh", "Baely", "Baethany", "Balee", "Banca", "Barba", "Belenne",
			"Beraelyn", "Betrice", "Brae", "Braealyn", "Braelley", "Braeylee", "Braley", "Breaenna", "Brennya",
			"Breyanna", "Brialea", "Brialeagh", "Brialey", "Bridgeth", "Brisea", "Britella", "Briya", "Briyanna",
			"Briyelle", "Bryaleigh", "Byenca", "Caedence", "Caelia", "Caemron", "Caera", "Caeryssa", "Cambrisa",
			"Camla", "Camryn", "Carline", "Carlisa", "Casdy", "Cassana", "Cassanra", "Catalea", "Cathrise", "Catlea",
			"Cayelyn", "Cayetlin", "Ceilia", "Celethe", "Chaeya", "Charleagh", "Charlise", "Charliza", "Charlo", "Chlo",
			"Claissa", "Claudira", "Corlina", "Dafnea", "Danice", "Daniyela", "Daniyelle", "Danuella", "Danyka",
			"Daphnea", "Dayana", "Deabora", "Denice", "Desree", "Deyanna", "Diyana", "Dlaney", "Dlilah", "Dmi", "Dnise",
			"Elaena", "Eleine", "Eleno", "Elenoh", "Ellayina", "Emelisa", "Emelyse", "Emery", "Emesyn", "Emilea",
			"Emilisa", "Emiliye", "Emilyse", "Emson", "Erinne", "Erisha", "Eriska", "Erixa", "Evaelyn", "Evanline",
			"Evleyen", "Evlyn", "Eyleene", "Fyna", "Fyonae", "Galea", "Galya", "Giana", "Giuiana", "Giyana", "Gloriya",
			"Graece", "Gyanna", "Haelee", "Haeleigh", "Haellen", "Haennah", "Haerlo", "Haylay", "Haylea", "Helna",
			"Henna", "Herlee", "Idelle", "Ilana", "Isbel", "Isbelle", "Islae", "Islea", "Iveanne", "Iyleen", "Izbella",
			"Jacquine", "Jaelah", "Jaelyne", "Jaemma", "Jaenelle", "Jaesmin", "Jaessa", "Jaezmina", "Jaiya", "Jaleah",
			"Janae", "Janiah", "Jasemine", "Jasmina", "Jayda", "Jayla", "Jaynelle", "Jazmi", "Jazzly", "Jemna",
			"Jennife", "Jennix", "Jexa", "Jexica", "Jilleane", "Jordyna", "Jordynia", "Joselane", "Juith", "Juliasa",
			"Julisa", "Julith", "Jynna", "Kaedn", "Kaela", "Kaeleen", "Kaelia", "Kaelyn", "Kaence", "Kaerine", "Kaeya",
			"Kalyah", "Kamryn", "Karina", "Karise", "Karsyne", "Kasdy", "Kasra", "Katlina", "Kaya", "Kayelin",
			"Kayetlyn", "Kayi", "Keana", "Keaya", "Kelya", "Kelyn", "Kily", "Kimbr", "Kimly", "Kimra", "Kira", "Kirsen",
			"Kirst", "Kora", "Krissa", "Kyndle", "Laeila", "Laera", "Lainesy", "Laryse", "Layala", "Laylah", "Leshi",
			"Leski", "Liala", "Lilea", "Lillya", "Lilya", "Lolea", "Loriya", "Lorlea", "Lucira", "Lylah", "Madlyn",
			"Maecey", "Maecy", "Maelana", "Maelynn", "Maenzee", "Maesin", "Maev", "Maeve", "Maianna", "Makenna",
			"Makenze", "Mareana", "Marina", "Marixah", "Marsa", "Marza", "Mayve", "Meado", "Medo", "Medow", "Megn",
			"Meldy", "Melnie", "Melo", "Meriya", "Mikaela", "Mikayla", "Milaia", "Milaya", "Mirah", "Misah", "Miya",
			"Moriyah", "Myha", "Nadira", "Nahla", "Nathly", "Natlea", "Natlee", "Natlia", "Nayea", "Nayla", "Nayli",
			"Nyala", "Rachle", "Raelle", "Raeyan", "Raielyn", "Rane", "Rayegan", "Rayely", "Rayelyn", "Rayina",
			"Raynia", "Rayven", "Rebexa", "Rebexi", "Reegan", "Reesha", "Reighley", "Reina", "Reiyna", "Renaya",
			"Renette", "Rianara", "Riya", "Roemary", "Rosae", "Rosaliya", "Roselyna", "Roseya", "Rosha", "Ryleegh",
			"Ryliane", "Ryliea", "Saavi", "Sabrya", "Saedi", "Saera", "Saeva", "Saevi", "Sanya", "Sanyah", "Saraia",
			"Saria", "Sarina", "Scarleth", "Scarlex", "Sealena", "Seliah", "Seliena", "Sereya", "Sirah", "Soaph",
			"Sofia", "Soniya", "Taeliyah", "Taelor", "Taera", "Taiana", "Talira", "Tamira", "Taraia", "Taryne", "Tatum",
			"Temrance", "Thalira", "Tira", "Tiyana", "Ulivia", "Vaessa", "Valria", "Valrie", "Valriya", "Viliana",
			"Wyla", "Wylo", "Wylow", "Ylena", "Ylivea", "Yrenea", "Yve", "Zaera", "Zaiyah", "Zarilah", "Zarina",
			"Zarinah", "Ziahra" };

	// Liste de rôles afin de changer le pourcentage de chance de chaque rôle
	static int[] rolesNDS = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 4, 5 };
	/*
	 * 1 = client 2 = employé 3 = RH 4 = Modo 5 = Admin
	 * 
	 */

	// Liste alphanumérique pour créer les mdp
	static String mdpLetter = "azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN123456789";

	/**
	 * 
	 * @return retourne un mot de passe créé aléatoirement sur les alphanumériques.
	 */
	static String createMDP() {
		String temp = "";

		// On prend aléatoirement un charactère parmis les alphanumériques (16 fois pour
		// avoir une bonne longueur de mdp).
		for (int i = 0; i < 16; ++i) {
			temp += mdpLetter.charAt(new Random().nextInt(mdpLetter.length()));
		}

		return temp;
	}

	/**
	 * 
	 * @return retourne une date de naissance aléatoire
	 */
	static LocalDate randomDate() {
		LocalDate startDate = LocalDate.of(1970, 1, 1);
		LocalDate endDate = LocalDate.of(2003, 1, 1);
		long start = startDate.toEpochDay();
		long end = endDate.toEpochDay();
		long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
		return LocalDate.ofEpochDay(randomEpochDay);
	}

	@EventListener
	public void appReadyBasic(ApplicationReadyEvent event) {

		sldao.save(new SecurityLevel("NDS Client, accès aux utilisations basiques de réservation et achats."));
		sldao.save(new SecurityLevel(
				"NDS Employé, accès aux utilisations basiques, de ventes et de modifications clients."));
		sldao.save(new SecurityLevel(
				"NDS RH, accès aux utilisations basiques, ajout et suppression d\'employés de NDS 2,3,4."));
		sldao.save(new SecurityLevel(
				"NDS Modérateur, accès aux utilisations basiques, de ventes et de modifications clients, employé et RH."));
		sldao.save(new SecurityLevel("NDS Administrateur, accès total."));

		mdao.save(new Movie("Nadia, butterfly", "Nadia, butterfly", 0, 2021, LocalTime.of(1, 46, 00, 00), "Drame", 5.00,
				"Le film fait partie de la Sélection Officielle de Cannes 2020. Nadia, 23 ans, nage pour le Canada aux Jeux olympiques. Cette compétition prestigieuse représente l\'aboutissement de sa vie de sacrifices. Pourtant, par peur de rester piégée dans le monde hermétique et éphémère du sport de haut niveau, Nadia a pris la décision..."));
		mdao.save(new Movie("Nouvel ordre", "New Order", 12, 2021, LocalTime.of(1, 28, 00, 00), "Drame", 5.00,
				"Un mariage mondain est interrompu par l\'arrivée d\'invités importuns."));
		mdao.save(new Movie("Promising Young Woman", "Promising Young Woman", 12, 2021, LocalTime.of(1, 54, 00, 00),
				"Thriller", 5.00,
				"Tout le monde s\'entendait pour dire que Cassie était une jeune femme pleine d\'avenir jusqu\'à ce qu\'un évènement inattendu ne vienne tout bouleverser. Mais rien dans la vie de Cassie n\'est en fait conforme aux apparences , elle est aussi intelligente que rusée, séduisante que calculatrice et mêne une double vie dès la nuit..."));
		mdao.save(new Movie("Tom & Jerry", "Tom & Jerry", 0, 2021, LocalTime.of(1, 41, 00, 00), "Animation", 5.00,
				"Les nouvelles aventures de Tom & Jerry dans un long métrage melant CGI et prises de vues réelles. Tom, le chat et Jerry, la souris n\'ont plus de domicile. Ils emménagent dans un hôtel chic de New York où Kayla a trouvé un emploi. Mais pour qu\'elle puisse le garder, il faut impérativement qu\'elle chasse Jerry avant la réception..."));
		mdao.save(new Movie("Freaky", "Freaky", 0, 2021, LocalTime.of(1, 42, 00, 00), "Thriller", 5.00,
				"Millie Kessler, une adolescente de 17 ans, occupée à faire bonne figure dans son très élitiste lycée, Blissfield High, devient la nouvelle cible du Boucher, un tueur en série tristement notoire. Son année de Terminale va alors devenir le cadet de ses soucis. Lorsque, sous l\'effet du poignard antique du Boucher ils se réveillent dans le corps de..."));
		mdao.save(new Movie("9 jours à Raqqa", "9 jours à Raqqa", 12, 2021, LocalTime.of(1, 30, 00, 00), "Documentaire",
				5.00,
				"Le film fait partie de la Sélection Officielle Cannes 2020. Leïla Mustapha est à 30 ans la nouvelle maire Kurde de Raqqa en Syrie. Ingénieure en génie civil et chargée de la reconstruction de l\'ancienne capitale de Daech, elle doit réconcilier la population et arriver à faire vivre la démocratie. La journaliste grand reporter et écrivaine, Marine"));
		mdao.save(new Movie("Comment je suis devenu super-héros", "Comment je suis devenu super-héros", 12, 2021,
				LocalTime.of(1, 37, 00, 00), "Policier / Espionnage", 5.00,
				"Paris 2020. Dans une société où les surhommes sont banalisés et parfaitement intégrés, une mystérieuse substance procurant des super-pouvoirs à ceux qui n\'en ont pas se répand. Face aux incidents qui se multiplient, les lieutenants Moreau et Schaltzmann sont chargés de l\'enquête. Avec l\'aide de Monté Carlo et Callista, deux..."));
		mdao.save(new Movie("Fatima", "Fatima", 12, 2021, LocalTime.of(1, 53, 00, 00), "Drame", 5.00,
				"Portugal. 1917, trois jeunes bergers de Fatima racontent avoir vu la Vierge Marie. Leurs révélations vont toucher de nombreux croyants mais également attirer la colère des représentants de l\'Eglise et du gouvernement. Ils vont tout faire pour essayer d\'étouffer l\'affaire et obliger les trois enfants à se rétracter. Mais la rumeur..."));
		mdao.save(new Movie("Mystère à Saint-Tropez", "Mystère à Saint-Tropez", 12, 2021, LocalTime.of(00, 00, 00, 00),
				"Comédie", 5.00,
				"Aout 1970, en pleine période yéyé. Comme chaque année, le milliardaire Claude Tranchant et sa femme Eliane ont invité le gratin du show-business dans leur somptueuse villa tropézienne. Rien ne semble pouvoir gâcher les festivités, si ce n\'est l\'inquiétant sabotage de la décapotable du couple. Persuadé d\'être victime"));
		mdao.save(new Movie("Nomadland", "Nomadland", 12, 2021, LocalTime.of(1, 48, 00, 00), "Drame", 5.00,
				"Après avoir tout perdu pendant la Grande Récession, une sexagénaire se lance dans un voyage à travers l\'Ouest américain, vivant comme un nomade des temps modernes."));
		mdao.save(new Movie("Nos plus belles années", "Nos plus belles années", 12, 2021, LocalTime.of(2, 15, 00, 00),
				"Comédie dramatique", 5.00,
				"C\'est l\'histoire de quatre amis, racontée sur quarante ans, en Italie, des années 1980 à aujourd\'hui. La chronique de leurs espoirs, de leurs désillusions, de leurs amours, et surtout, de leur amitié."));
		mdao.save(new Movie("Un homme en colère", "Un homme en colère", 12, 2021, LocalTime.of(00, 00, 00, 00),
				"Action", 5.00,
				"Un convoyeur de fond fraichement engagé surprend ses collègues par l\'incroyable précision de ses tirs de riposte alors qu\'ils subissent les assauts de braqueurs expérimentés.Tous se demandent désormais qui il est, d\'où il vient et pourquoi est-il là."));
		mdao.save(new Movie("Délicieux", "Délicieux", 12, 2021, LocalTime.of(1, 53, 00, 00), "Comédie dramatique", 5.00,
				"XVIIIe siècle. Un cuisinier est limogé par son maître. Il trouve le courage au contact d\'une jeune femme étonnante de se libérer de sa condition de domestique et de proposer son savoir-faire directement au public en créant le premier restaurant."));
		mdao.save(new Movie("L\'un des notres", "L\'un des notres", 12, 2021, LocalTime.of(1, 55, 00, 00), "Thriller",
				5.00,
				"Après la perte de leur fils, le shérif à la retraite George Blackledge et son épouse, Margaret quittent leur ranch du Montana pour sauver leur jeune petit-fils des griffes d\'une dangereuse famille tenue d\'une main de fer par la matriarche Blanche Weboy. Quand ils découvrent que les Weboy n\'ont pas l\'intention de laisser partir l\'enfant..."));
		mdao.save(new Movie("Ca tourne à Saint-Pierre et Miquelon", "Ca tourne à Saint-Pierre et Miquelon", 12, 2021,
				LocalTime.of(1, 35, 00, 00), "Comédie dramatique", 5.00,
				"Céline, une actrice, engagée par le célèbre réalisateur Milan Zodowski, arrive à Saint-Pierre et Miquelon. Sur place, il n\'y a qu\'un ingénieur du son et une régisseuse pour toute équipe et Milan refuse obstinément de sortir du cabanon où il s\'est enfermé. Le grand \'menteur en sc�ne\", adepte du cinéma vérité, fera-t-il tourner Céline ou l\'a-t-il..."));

		prdao.save(new Product("Ticket Cinéma Unité", 8.00, "Ticketterie",
				"Votre ticket de cinéma, tarif avant réduction éventuelle. Valable 3 mois."));
		prdao.save(new Product("Ticket Cinéma 10 pièces", 60.00, "Ticketterie",
				"Vos ticket de cinéma à -25%. Valable 3 mois."));
		prdao.save(new Product("Ticket Cinéma Mensuel", 30.00, "Ticketterie",
				"Votre pass mensuel de cinéma, tarif avant réduction éventuelle."));
		prdao.save(new Product("PopCorn Nature 25cl", 4.00, "Nourriture", "Votre PopCorn tout chaud tout frais !"));
		prdao.save(new Product("PopCorn Nature 50cl", 6.00, "Nourriture", "Votre PopCorn tout chaud tout frais !"));
		prdao.save(new Product("PopCorn Nature 100cl", 8.00, "Nourriture", "Votre PopCorn tout chaud tout frais !"));
		prdao.save(new Product("PopCorn Caramel 25cl", 4.00, "Nourriture",
				"Votre PopCorn tout chaud tout frais au Caramel !"));
		prdao.save(new Product("PopCorn Caramel 50cl", 6.00, "Nourriture",
				"Votre PopCorn tout chaud tout frais au Caramel !"));
		prdao.save(new Product("PopCorn Caramel 100cl", 8.00, "Nourriture",
				"Votre PopCorn tout chaud tout frais au Caramel !"));
		prdao.save(new Product("PopCorn Salé 25cl", 4.00, "Nourriture", "Votre PopCorn tout chaud tout frais Salé !"));
		prdao.save(new Product("PopCorn Salé 50cl", 6.00, "Nourriture", "Votre PopCorn tout chaud tout frais Salé !"));
		prdao.save(new Product("PopCorn Salé 100cl", 8.00, "Nourriture", "Votre PopCorn tout chaud tout frais Salé !"));
		prdao.save(new Product("PopCorn Caramel au Beurre Salé 25cl", 5.00, "Nourriture",
				"Votre PopCorn tout chaud tout frais ! Nouveau ! Caramel au Beurre Salé !!!"));
		prdao.save(new Product("PopCorn Caramel au Beurre Salé 50cl", 7.50, "Nourriture",
				"Votre PopCorn tout chaud tout frais !  Nouveau ! Caramel au Beurre Salé !!!"));
		prdao.save(new Product("PopCorn Caramel au Beurre Salé 100cl", 10.00, "Nourriture",
				"Votre PopCorn tout chaud tout frais ! Nouveau ! Caramel au Beurre Salé !!!"));
		prdao.save(new Product("Coca Cola 25cl", 1.00, "Boisson", "Votre incontournable boisson Coca Cola!"));
		prdao.save(new Product("Coca Cola 33cl", 1.50, "Boisson", "Votre incontournable boisson Coca Cola!"));
		prdao.save(new Product("Coca Cola 50cl", 2.00, "Boisson", "Votre incontournable boisson Coca Cola!"));
		prdao.save(new Product("Orangina 25cl", 1.00, "Boisson", "Votre incontournable boisson Orangina!"));
		prdao.save(new Product("Orangina 33cl", 1.50, "Boisson", "Votre incontournable boisson Orangina!"));
		prdao.save(new Product("Orangina 50cl", 2.00, "Boisson", "Votre incontournable boisson Orangina!"));
		prdao.save(new Product("Schweppes 25cl", 1.00, "Boisson", "Votre incontournable boisson Schweppes!"));
		prdao.save(new Product("Schweppes 33cl", 1.50, "Boisson", "Votre incontournable boisson Schweppes!"));
		prdao.save(new Product("Schweppes 50cl", 2.00, "Boisson", "Votre incontournable boisson Schweppes!"));

		crdao.save(new CinemaRoom("Atlantis", 0, "4K", 128));
		crdao.save(new CinemaRoom("Babylone", 0, "4K", 128));
		crdao.save(new CinemaRoom("Carthage", 0, "4K", 64));
		crdao.save(new CinemaRoom("Daedalus", 1, "4K", 128));
		crdao.save(new CinemaRoom("Eristhem", 1, "4K", 64));
		crdao.save(new CinemaRoom("Franborg", 1, "4K", 64));
		crdao.save(new CinemaRoom("Gargantos", 2, "4K", 128));
		crdao.save(new CinemaRoom("Hermetic", 2, "4K", 64));
		crdao.save(new CinemaRoom("Istanbul", 2, "2K", 32));
		crdao.save(new CinemaRoom("Jakarta", 2, "2K", 32));

		List<SecurityLevel> allSL = (List<SecurityLevel>) sldao.findAll();
		Random rand = new Random();

		for (int i = 0; i < 32; ++i) {
			String tempN = noms[rand.nextInt(noms.length)];
			String tempP = prenoms[rand.nextInt(prenoms.length)];
			LocalDate bd = randomDate();
			String tempS = sexes[rand.nextInt(sexes.length)];
			String tempV = villes[rand.nextInt(villes.length)];
			String email = tempN + "." + tempP + "@email44.fr";

			Person tempPerson = new Person(tempN, tempP, bd, tempS, tempV, email);
			

			String tempPseudo = pseudoFutur[rand.nextInt(pseudoFutur.length)];
			int SL = rolesNDS[rand.nextInt(rolesNDS.length)];

			User tempUser = new User(tempPseudo, createMDP(), tempPerson, allSL.get(SL - 1));
			udao.save(tempUser);
//			pedao.save(tempPerson);
//			tempPerson.setIdUser(tempUser);
//			pedao.save(tempPerson);
		}

		List<CinemaRoom> cineRoom = (List<CinemaRoom>) crdao.findAll();

		for (CinemaRoom cinemaRoom : cineRoom) {
			int tempSize = cinemaRoom.getNbSeats() / 32;
			int tempRank = 32;

			for (int i = 0; i < tempSize; ++i) {
				for (int j = 0; j < tempRank; ++j) {
					Seat tempSeat = new Seat(j, Character.toString(65 + i).toString(), true, cinemaRoom);
					seadao.save(tempSeat);
				}
			}
		}

		List<User> allUsers = (List<User>) udao.findAll();
		List<Movie> allMovies = (List<Movie>) mdao.findAll();
		List<CinemaRoom> allRooms = (List<CinemaRoom>) crdao.findAll();
		List<Product> allProducts = (List<Product>) prdao.findAll();
		List<Seat> allSeats = (List<Seat>) seadao.findAll();

		for (int i = 0; i < 10; ++i) {
			String tempC = comments[rand.nextInt(comments.length)];
			User tempU = allUsers.get(rand.nextInt(allUsers.size()));
			Movie tempM = allMovies.get(rand.nextInt(allMovies.size()));
			CinemaRoom tempCR = allRooms.get(rand.nextInt(allRooms.size()));
			String tempP = proprete[rand.nextInt(proprete.length)];
			Product tempProduct = allProducts.get(rand.nextInt(allProducts.size()));
			LocalDateTime ldt = LocalDateTime.of(randomDate(), LocalTime.of(0, 0));
			Seat tempSeat = allSeats.get(rand.nextInt(allSeats.size()));
			int tempQ = rand.nextInt(20);
			int tempTC = rand.nextInt(20);

			cdao.save(new Commentary(rand.nextInt(5), tempC, tempU, tempM));
			odao.save(new Opinion(tempCR, tempU, rand.nextInt(5), tempP));
			pudao.save(new Purchase(tempProduct, tempU, ldt, tempQ, tempTC));

			rdao.save(new Reservation(tempU, tempSeat, ldt));
			sesdao.save(new Session(tempCR, tempM, ldt, tempCR.getNbSeats()));
		}

	}
}
