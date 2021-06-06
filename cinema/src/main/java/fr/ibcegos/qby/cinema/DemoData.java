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
import fr.ibcegos.qby.cinema.beans.Quizz;
import fr.ibcegos.qby.cinema.beans.Reservation;
import fr.ibcegos.qby.cinema.beans.Seat;
import fr.ibcegos.qby.cinema.beans.SecurityLevel;
import fr.ibcegos.qby.cinema.beans.Session;
import fr.ibcegos.qby.cinema.beans.User;
import fr.ibcegos.qby.cinema.daos.CinemaRoomDAO;
import fr.ibcegos.qby.cinema.daos.CommentaryDAO;
import fr.ibcegos.qby.cinema.daos.MovieDAO;
import fr.ibcegos.qby.cinema.daos.OpinionDAO;
import fr.ibcegos.qby.cinema.daos.ProductDAO;
import fr.ibcegos.qby.cinema.daos.PurchaseDAO;
import fr.ibcegos.qby.cinema.daos.QuizzDAO;
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
	@Autowired
	private QuizzDAO qdao ;

	static String[] prenoms = { "Aaliyah", "Aaron", "Abby", "Abd", "Abdallah", "Abdel", "Abdelaziz", "Abdelkader",
			"Abdellah", "Abderrahmane", "Abdou", "Abdoul", "Abdoul-Aziz", "Abdoulaye", "Abdourahmane", "Abdramane",
			"Abdullah", "Abel", "Abigaël", "Abigaëlle", "Abigail", "Abigaïl", "Abishan", "Abou", "Aboubacar",
			"Aboubakar", "Abraham", "Aby", "Achille", "Achraf", "Ada", "Adam", "Adama", "Adame", "Adams", "Adan",
			"Adel", "Adélaïde", "Adèle", "Adélie", "Adeline", "Adem", "Aden", "Adib", "Adil", "Adja", "Adnane",
			"Adonis", "Adrian", "Adriana", "Adriano", "Adriel", "Adrien", "Aedan", "Agatha", "Agathe", "Aglaé", "Agnès",
			"Aharon", "Ahmad", "Ahmed", "Aicha", "Aïcha", "Aïda", "Aidan", "Aïdan", "Aiden", "Aïden", "Aïko", "Aimé",
			"Aimée", "Aïna", "Aïnhoa", "Aisha", "Aïsha", "Aïssa", "Aissata", "Aïssata", "Aissatou", "Aïssatou", "Aïssé",
			"Akram", "Aksel", "Akshaya", "Aksil", "Alaa", "Alaïa", "Alain", "Alan", "Alana", "Alassane", "Alba",
			"Alban", "Albane", "Albéric", "Albert", "Albertine", "Albin", "Aldo", "Alec", "Alejandro", "Aleksandar",
			"Aleksandra", "Alessandra", "Alessandro", "Alessia", "Alessio", "Alex", "Alexander", "Alexandra",
			"Alexandre", "Alexane", "Alexi", "Alexia", "Alexie", "Alexis", "Alexy", "Alfred", "Alhassane", "Ali",
			"Alia", "Alice", "Alicia", "Aliénor", "Alima", "Alina", "Aline", "Aliocha", "Aliou", "Alioune", "Alisha",
			"Alison", "Alissa", "Alistair", "Alix", "Alixe", "Aliya", "Aliyah", "Aliza", "Alizée", "Allan", "Allegra",
			"Allya", "Alma", "Aloïs", "Alon", "Alone", "Aloys", "Alpha", "Alphonse", "Althéa", "Alvin", "Aly", "Alya",
			"Alyah", "Alycia", "Alyssa", "Alyssia", "Alysson", "Amadou", "Amaël", "Amaia", "Amal", "Amalia", "Amanda",
			"Amandine", "Amani", "Amar", "Amara", "Amaury", "Amaya", "Ambre", "Ambrine", "Ambroise", "Amel", "Amelia",
			"Amélia", "Amélie", "Amicie", "Amin", "Amina", "Aminata", "Amine", "Amir", "Amira", "Amjad", "Amos", "Amy",
			"Ana", "Anabelle", "Anaé", "Anaë", "Anael", "Anaël", "Anaelle", "Anaëlle", "Anais", "Anaïs", "Anas",
			"Anass", "Anastasia", "Anatole", "Anaya", "André", "Andrea", "Andréa", "Andreas", "Andréas", "Andrei",
			"Andrés", "Andrew", "Andria", "Andy", "Anes", "Ange", "Angel", "Angela", "Angèle", "Angelica", "Angelina",
			"Angélina", "Angéline", "Angélique", "Angelo", "Angie", "Ania", "Anir", "Anis", "Anissa", "Anita", "Anjali",
			"Anna", "Anna-Rose", "Annabelle", "Annaëlle", "Anne", "Anne-Laure", "Anne-Lise", "Anne-Marie",
			"Anne-Sophie", "Anouchka", "Anouck", "Anouk", "Anselme", "Anta", "Anthony", "Antoine", "Antoinette",
			"Anton", "Antoni", "Antonia", "Antonin", "Antonio", "Antony", "Anya", "Apolline", "Appoline", "April",
			"Archibald", "Arda", "Ari", "Aria", "Ariana", "Ariane", "Arié", "Ariel", "Arielle", "Arij", "Aris",
			"Aristide", "Arlo", "Arman", "Armance", "Armand", "Armel", "Armelle", "Arnaud", "Arno", "Aron", "Arsène",
			"Arslan", "Arslane", "Artémis", "Arthur", "Arthus", "Arto", "Artur", "Artus", "Arwa", "Arwen", "Ary",
			"Arya", "Ashley", "Asia", "Asma", "Asmaa", "Assa", "Assad", "Asser", "Assetou", "Assia", "Assil", "Assiya",
			"Assiyah", "Assya", "Astou", "Astrée", "Astrid", "Athéna", "Athénaïs", "Aubin", "Aude", "Audrey", "Auguste",
			"Augustin", "Augustine", "Aure", "Aurel", "Aurèle", "Aurelia", "Aurélia", "Aurélie", "Aurélien", "Auriane",
			"Aurore", "Auxane", "Auxence", "Ava", "Avi", "Aviel", "Avigaïl", "Avital", "Avril", "Awa", "Axel", "Axelle",
			"Aya", "Ayaan", "Ayah", "Ayala", "Ayan", "Ayana", "Aydan", "Ayden", "Ayem", "Ayla", "Aylan", "Aylane",
			"Ayleen", "Aylin", "Ayline", "Ayman", "Aymane", "Aymar", "Aymen", "Aymeric", "Ayna", "Ayoub", "Ayrton",
			"Aysha", "Azad", "Azélie", "Aziz", "Baba", "Babacar", "Badis", "Bafodé", "Bahia", "Bakary", "Balkis",
			"Balthazar", "Baptiste", "Barbara", "Barnabé", "Barthélemy", "Barthélémy", "Basil", "Basile", "Basma",
			"Bastian", "Bastien", "Baudouin", "Baya", "Beatrice", "Béatrice", "Bella", "Ben", "Bénédicte", "Benjamin",
			"Benoit", "Benoît", "Bérénice", "Bernard", "Bertille", "Béryl", "Bettina", "Betty", "Beya", "Bianca",
			"Bilal", "Bilel", "Billal", "Billie", "Billy", "Binta", "Bintou", "Blaise", "Blanche", "Blandine",
			"Blessing", "Bogdan", "Bonnie", "Boris", "Bosco", "Boubacar", "Boubou", "Bouchra", "Bradley", "Brahim",
			"Brandon", "Brayan", "Briac", "Brian", "Brice", "Brieuc", "Brune", "Bruno", "Bryan", "Caleb", "Cali",
			"Calie", "Calista", "Calixte", "Calvin", "Calypso", "Camelia", "Camélia", "Cameron", "Camil", "Camila",
			"Camilia", "Camilla", "Camille", "Camillia", "Camilo", "Candice", "Capucine", "Cara", "Carine", "Carl",
			"Carla", "Carlos", "Carlotta", "Carmen", "Carolina", "Caroline", "Cassandra", "Cassandre", "Cassidy",
			"Cassie", "Cassiopée", "Castille", "Cataleya", "Catalina", "Catherine", "Cécile", "Cecilia", "Cécilia",
			"Cédric", "Celeste", "Céleste", "Célestin", "Célestine", "Celia", "Célia", "Célian", "Celina", "Célina",
			"Celine", "Céline", "Célya", "Cerise", "César", "Chad", "Chaden", "Chahine", "Chahinez", "Chaï", "Chaima",
			"Chaïma", "Chana", "Chanel", "Charlène", "Charles", "Charlie", "Charline", "Charlize", "Charlotte",
			"Charly", "Chayma", "Cheick", "Cheick-Oumar", "Cheikh", "Chelsea", "Chérine", "Cheyenne", "Chiara",
			"Chirine", "Chloé", "Chloë", "Chmouel", "Chris", "Christ", "Christelle", "Christian", "Christina",
			"Christine", "Christophe", "Christopher", "Ciara", "Cindy", "Claire", "Clara", "Clarence", "Clarisse",
			"Claudia", "Cléa", "Clélia", "Clélie", "Clémence", "Clément", "Clémentine", "Cléo", "Cléophée", "Cloé",
			"Clothilde", "Clotilde", "Clovis", "Colas", "Colette", "Colin", "Coline", "Colomban", "Colombe",
			"Colombine", "Côme", "Constance", "Constant", "Constantin", "Coralie", "Coraline", "Corentin", "Corto",
			"Cosima", "Coumba", "Cristiano", "Curtis", "Cynthia", "Cyprien", "Cyrian", "Cyriaque", "Cyrielle", "Cyril",
			"Cyrille", "Cyrine", "Cyrus", "Dado", "Dahlia", "Dali", "Dalia", "Dalil", "Dalla", "Dalva", "Dalya",
			"Damian", "Damien", "Dan", "Dana", "Danaé", "Dani", "Dania", "Daniel", "Daniela", "Daniella", "Danny",
			"Dante", "Dany", "Danyl", "Daoud", "Daouda", "Daphné", "Daphnée", "Daria", "Darine", "Dario", "Darius",
			"Darren", "David", "Dayan", "Dayana", "Dayane", "Deborah", "Déborah", "Delia", "Délia", "Delphine", "Délya",
			"Demba", "Denis", "Deniz", "Deva", "Diaba", "Diaby", "Diana", "Diane", "Diego", "Dieynaba", "Dimitri",
			"Dina", "Diogo", "Divine", "Djamila", "Djena", "Djeneba", "Djénéba", "Djenna", "Djibril", "Dominique",
			"Domitille", "Donatien", "Donia", "Dora", "Dorian", "Doriane", "Doron", "Dounia", "Dov", "Dramane", "Driss",
			"Dune", "Dylan", "Dyna", "Eddy", "Eden", "Éden", "Edgar", "Edgard", "Edmond", "Edouard", "Édouard",
			"Eduard", "Eduardo", "Edward", "Edwin", "Eglantine", "Eileen", "El", "Ela", "Eléa", "Éléa", "Eleanor",
			"Eléanor", "Eléanore", "Éléanore", "Elena", "Eléna", "Éléna", "Eléonore", "Éléonore", "Elhadj", "Eli",
			"Éli", "Elia", "Élia", "Eliahou", "Eliakim", "Elian", "Eliana", "Eliane", "Elias", "Élias", "Elie", "Élie",
			"Eliel", "Eliès", "Eliette", "Elif", "Elijah", "Elikya", "Elina", "Élina", "Eline", "Éline", "Elinor",
			"Elio", "Élio", "Elior", "Eliora", "Eliot", "Éliot", "Eliott", "Éliott", "Elisa", "Élisa", "Elisabeth",
			"Élisabeth", "Elise", "Élise", "Elisheva", "Elissa", "Eliza", "Elizabeth", "Ella", "Ellie", "Elliot",
			"Elliott", "Elly", "Eloan", "Eloane", "Elodie", "Élodie", "Eloi", "Éloi", "Eloïse", "Éloïse", "Elon",
			"Elona", "Elone", "Elora", "Elouan", "Elsa", "Elvire", "Ely", "Elya", "Elyan", "Elyana", "Elyas", "Elyes",
			"Elyès", "Elyna", "Elyne", "Élyne", "Elyo", "Elyssa", "Ema", "Emeline", "Émeline", "Emeric", "Emi", "Emie",
			"Émie", "Emil", "Emile", "Émile", "Emilia", "Emilie", "Émilie", "Emilien", "Emilio", "Emily", "Emir",
			"Emma", "Emmanuel", "Emmanuella", "Emmanuelle", "Emmie", "Emmy", "Emna", "Emy", "Enaël", "Enéa", "Eneko",
			"Enguerrand", "Ennio", "Enola", "Enora", "Énora", "Enzo", "Ephraïm", "Eren", "Eric", "Éric", "Erik",
			"Erika", "Erin", "Erine", "Ernest", "Ernestine", "Erwan", "Erwann", "Eryne", "Esaïe", "Esma", "Esmée",
			"Esra", "Esteban", "Estéban", "Estelle", "Esther", "Ethan", "Éthan", "Ethann", "Ethel", "Etienne",
			"Étienne", "Eugène", "Eugénie", "Eulalie", "Eunice", "Eurydice", "Eva", "Éva", "Eva-Rose", "Evan", "Evann",
			"Eve", "Ève", "Evelyne", "Evy", "Ewan", "Ewen", "Ewenn", "Eya", "Eyad", "Eyal", "Eydel", "Eyden", "Eymen",
			"Eytan", "Eythan", "Ézéchiel", "Ezio", "Ezra", "Fabien", "Fabio", "Fabrice", "Fadi", "Fady", "Faël", "Fahd",
			"Faith", "Fallou", "Fanny", "Fanta", "Fantin", "Fantine", "Farah", "Fares", "Farès", "Farouk", "Fatiha",
			"Fatim", "Fatima", "Fatima-Zahra", "Fatimata", "Fatma", "Fatou", "Fatouma", "Fatoumata", "Faustine",
			"Federico", "Félicie", "Félicien", "Félicité", "Felix", "Félix", "Ferdinand", "Feriel", "Fériel", "Ferima",
			"Feryel", "Filip", "Filipe", "Fiona", "Firas", "Firdaous", "Firdaws", "Flavia", "Flavie", "Flavien",
			"Flavio", "Fleur", "Flora", "Flore", "Florence", "Florent", "Florentin", "Florian", "Floriane", "Fodé",
			"Foucauld", "France", "Francesca", "Francesco", "Francis", "Franck", "François", "Françoise", "Franklin",
			"Frédéric", "Frida", "Gabin", "Gabriel", "Gabriela", "Gabriele", "Gabriella", "Gabrielle", "Gad", "Gael",
			"Gaël", "Gaëlle", "Gaétan", "Gaëtan", "Gaëtane", "Gaia", "Gaïa", "Gala", "Gaoussou", "Garance", "Gary",
			"Gaspar", "Gaspard", "Gaston", "Gatien", "Gauthier", "Gautier", "Gaye", "Gemma", "Geneviève", "Geoffrey",
			"Geoffroy", "George", "Georges", "Georgia", "Germain", "Giacomo", "Gianni", "Gilles", "Gina", "Giorgia",
			"Giovanni", "Gisèle", "Giulia", "Giulian", "Giuliana", "Giulio", "Gladys", "Gloria", "Gonzague", "Goundo",
			"Grace", "Grâce", "Grégoire", "Grégory", "Greta", "Guilhem", "Guillaume", "Guillemette", "Gustave",
			"Gustavo", "Guy", "Gwenaëlle", "Gwendal", "Gwendoline", "Habib", "Habiba", "Haby", "Hadassa", "Hadja",
			"Hadriel", "Hadrien", "Hafsa", "Haï", "Haïm", "Hajar", "Hakim", "Halima", "Halimatou", "Hamady", "Hamed",
			"Hamidou", "Hamza", "Hana", "Hanaa", "Hanae", "Hanaé", "Hania", "Hanna", "Hannah", "Hanya", "Haris",
			"Harold", "Haron", "Haroun", "Harouna", "Haroune", "Harry", "Hasna", "Hassan", "Hassane", "Hatem",
			"Hatouma", "Hava", "Hawa", "Haya", "Hayden", "Hector", "Hedi", "Hédi", "Heidi", "Helena", "Héléna",
			"Hélèna", "Hélène", "Hélie", "Hélio", "Hélios", "Hella", "Héloïse", "Henri", "Henriette", "Henry",
			"Hermance", "Hermine", "Hermione", "Hiba", "Hicham", "Hidaya", "Hillel", "Hind", "Hippolyte", "Hocine",
			"Honoré", "Honorine", "Hope", "Horace", "Hortense", "Houda", "Hubert", "Hugo", "Hugues", "Hussein", "Ian",
			"Ianis", "Iban", "Ibrahim", "Ibrahima", "Ibtissam", "Ida", "Idan", "Idir", "Idris", "Idriss", "Idrissa",
			"Igor", "Ihsan", "Ikram", "Ikrame", "Ilan", "Ilana", "Ilef", "Ilhan", "Ilian", "Iliana", "Iliane", "Ilias",
			"Ilies", "Ilina", "Ilona", "Ilya", "Ilyan", "Ilyana", "Ilyane", "Ilyas", "Ilyass", "Ilyes", "Ilyès",
			"Ilyess", "Imad", "Iman", "Imane", "Imani", "Imany", "Imen", "Imene", "Imène", "Imran", "Imrân", "Imrane",
			"Ina", "Inaya", "Inayah", "India", "Ines", "Inés", "Inès", "Inês", "Ingrid", "Inna", "Inza", "Ioana",
			"Iona", "Irène", "Irina", "Iris", "Isaac", "Isabella", "Isabelle", "Isadora", "Isaiah", "Isaïah", "Isaure",
			"Isayah", "Isée", "Iseult", "Ishak", "Ishaq", "Isia", "Isidore", "Isild", "Isis", "Islam", "Islem",
			"Ismael", "Ismaël", "Ismail", "Ismaïl", "Isra", "Israa", "Israel", "Israël", "Issa", "Issam", "Issiaka",
			"Ivan", "Ivana", "Ivy", "Iwan", "Iyad", "Iyed", "Izaac", "Izia", "Izïa", "Jack", "Jacob", "Jacqueline",
			"Jacques", "Jad", "Jade", "Jaden", "Jalil", "Jamal", "James", "Jamil", "Jan", "Jana", "Jane", "Janelle",
			"Janna", "Jannah", "Jannat", "Jarod", "Jasmine", "Jason", "Jassem", "Jassim", "Jawad", "Jawed", "Jayan",
			"Jayden", "Jayson", "Jean", "Jean-Baptiste", "Jean-Christophe", "Jean-David", "Jean-Luc", "Jean-Marc",
			"Jeanne", "Jeannette", "Jed", "Jehanne", "Jenna", "Jennah", "Jennifer", "Jenny", "Jérémie", "Jeremy",
			"Jérémy", "Jérôme", "Jessica", "Jessie", "Jessim", "Jessy", "Jibril", "Jihane", "Jill", "Jim", "Jimmy",
			"Jinane", "Joachim", "Joakim", "Joan", "Joana", "Joanna", "Joanne", "Joaquim", "Jodie", "Joe", "Joël",
			"Joëlle", "Joey", "Johan", "Johana", "Johann", "Johanna", "Johanne", "John", "Johnny", "Jonah", "Jonas",
			"Jonathan", "Jordan", "Jordane", "Jordy", "Joris", "Joseph", "Joséphine", "Josh", "Joshua", "Josselin",
			"Josué", "Joud", "Joudia", "Joy", "Joyce", "Juan", "Juba", "Jude", "Judith", "Jules", "Julia", "Julian",
			"Juliana", "Juliane", "Julianne", "Julie", "Julien", "Juliette", "Jun", "June", "Junior", "Junon", "Justin",
			"Justine", "Kacper", "Kader", "Kadiatou", "Kadidia", "Kadidiatou", "Kadidja", "Kady", "Kahil", "Kahina",
			"Kaïna", "Kaïs", "Kaïss", "Kali", "Kalilou", "Kamel", "Kamélia", "Kamil", "Kamila", "Karamba", "Karamoko",
			"Karen", "Karim", "Karima", "Karine", "Karl", "Karla", "Karol", "Karolina", "Kassandra", "Kassim",
			"Katarina", "Kate", "Katell", "Kathleen", "Katia", "Kawtar", "Kawthar", "Kayden", "Kayla", "Kayliah",
			"Kayna", "Kayron", "Kays", "Keïla", "Keira", "Kelly", "Kelvin", "Kelya", "Kelyan", "Kenan", "Kendra",
			"Kendrick", "Kenji", "Kenny", "Kenza", "Kenzi", "Kenzo", "Kenzy", "Keren", "Kessy", "Ketsia", "Kevin",
			"Kévin", "Keyla", "Keziah", "Khadidiatou", "Khadidja", "Khadija", "Khady", "Khaled", "Khalid", "Khalifa",
			"Khalil", "Kheira", "Kiara", "Kilian", "Killian", "Kilyan", "Kim", "Kimberley", "Kimberly", "Kimi", "Kimia",
			"Kiyan", "Klara", "Koumba", "Kristina", "Kurtis", "Kyan", "Kyara", "Kyle", "Kylian", "Kyliann", "Kyllian",
			"Ladji", "Laetitia", "Laëtitia", "Lahna", "Laïa", "Lalie", "Laly", "Lalya", "Lamia", "Lamine", "Lana",
			"Lancelot", "Lara", "Lassana", "Laszlo", "Latifa", "Laura", "Laure", "Laureen", "Lauren", "Laurence",
			"Laurène", "Laurent", "Lauriane", "Laurine", "Lauryn", "Laya", "Layana", "Layanah", "Layane", "Layel",
			"Layla", "Layna", "Lazar", "Lazare", "Lea", "Léa", "Leah", "Léah", "Leana", "Léana", "Léandre", "Leandro",
			"Léandro", "Léane", "Léanne", "Leelou", "Lehna", "Leia", "Leïa", "Leila", "Leïla", "Leïna", "Lélio", "Lena",
			"Léna", "Léni", "Lennie", "Lenny", "Leny", "Lény", "Leo", "Léo", "Léo-Paul", "Leon", "Léon", "Léona",
			"Leonard", "Léonard", "Leonardo", "Léone", "Léonie", "Leonor", "Léonor", "Léonore", "Léontine", "Leopold",
			"Léopold", "Léopoldine", "Leslie", "Leticia", "Levana", "Lévana", "Levi", "Lévi", "Lewis", "Leya", "Leyla",
			"Leyna", "Leyth", "Lia", "Liam", "Liana", "Liel", "Liham", "Lila", "Lilas", "Lili", "Lili-Rose", "Lilia",
			"Lilian", "Liliana", "Liliane", "Lilie", "Lilly", "Lilou", "Lilwenn", "Lily", "Lily-Rose", "Lilya", "Lina",
			"Linda", "Lindsay", "Line", "Lino", "Linoï", "Linoy", "Lionel", "Lior", "Liora", "Liron", "Lirone", "Lisa",
			"Lisandro", "Lise", "Lison", "Lital", "Liv", "Livia", "Livio", "Liya", "Liyah", "Liz", "Liza", "Loan",
			"Loane", "Logan", "Lohan", "Loïc", "Loïs", "Loïse", "Lola", "Lorena", "Lorenzo", "Lorette", "Lorie",
			"Loris", "Lorraine", "Lou", "Lou-Ann", "Lou-Anne", "Louan", "Louane", "Louann", "Louanne", "Louay",
			"Loubna", "Louca", "Louis", "Louis-Marie", "Louisa", "Louise", "Louison", "Louka", "Loula", "Louna",
			"Lounes", "Lounis", "Loup", "Louve", "Luan", "Lubin", "Luc", "Luca", "Lucas", "Lucca", "Luce", "Lucia",
			"Lucie", "Lucien", "Lucile", "Lucille", "Lucy", "Ludivine", "Ludmila", "Ludovic", "Luigi", "Luis", "Luisa",
			"Luka", "Lukas", "Luke", "Lula", "Luna", "Lune", "Luz", "Lya", "Lyah", "Lyam", "Lyana", "Lyanna", "Lydia",
			"Lyes", "Lyham", "Lyla", "Lylia", "Lylou", "Lyna", "Lynda", "Lyne", "Lynn", "Lyra", "Lysa", "Lysandre",
			"Lyse", "Maayane", "Maceo", "Macéo", "Macha", "Maddalena", "Madeleine", "Madeline", "Madina", "Mado",
			"Madoussou", "Mady", "Maé", "Mael", "Maël", "Maëlan", "Maëlie", "Maëline", "Maëlis", "Maelle", "Maëlle",
			"Maëly", "Maëlyne", "Maelys", "Maélys", "Maëlys", "Maeva", "Maéva", "Maëva", "Magdalena", "Maha",
			"Mahamadou", "Mahault", "Mahaut", "Mahdi", "Mahé", "Maher", "Mahmoud", "Maho", "Mai", "Maï", "Maia", "Maïa",
			"Maïly", "Maïlys", "Maimouna", "Maïmouna", "Maïna", "Maissa", "Maïssa", "Maïssane", "Maïwenn", "Maja",
			"Makan", "Maksim", "Malaïka", "Malak", "Malcolm", "Malek", "Malena", "Malia", "Malick", "Malik", "Malika",
			"Malo", "Malone", "Mama", "Mamadou", "Mamady", "Mame", "Mamou", "Mamoudou", "Manal", "Manar", "Manel",
			"Manelle", "Mani", "Manil", "Manon", "Mansour", "Manuel", "Manuela", "Mara", "Maram", "Marc",
			"Marc-Antoine", "Marceau", "Marcel", "Marcello", "Marco", "Marcus", "Margaux", "Margo", "Margot",
			"Marguerite", "Maria", "Mariam", "Mariama", "Mariame", "Mariana", "Marianne", "Marie", "Marie-Alix",
			"Marie-Ange", "Marie-Lou", "Mariem", "Marilou", "Marin", "Marina", "Marine", "Mario", "Marion", "Marius",
			"Mariya", "Marjane", "Marjorie", "Mark", "Marko", "Markus", "Marley", "Marlo", "Marlon", "Marlow", "Marnie",
			"Marouane", "Marta", "Martha", "Marthe", "Martin", "Marvin", "Marvyn", "Marwa", "Marwan", "Marwane",
			"Marwen", "Maryam", "Maryline", "Marylou", "Masha", "Massil", "Massinissa", "Massyl", "Matei", "Mateja",
			"Mateo", "Matéo", "Mateusz", "Matheo", "Mathéo", "Mathias", "Mathieu", "Mathilda", "Mathilde", "Mathis",
			"Mathurin", "Mathys", "Matias", "Matilda", "Matilde", "Matis", "Matisse", "Matt", "Matteo", "Mattéo",
			"Matthéo", "Matthew", "Matthias", "Matthieu", "Matthis", "Mattia", "Matys", "Maud", "Maude", "Maureen",
			"Maurice", "Max", "Maxence", "Maxens", "Maxim", "Maxime", "Maximilian", "Maximilien", "Maxine", "May",
			"Maya", "Mayane", "Mayar", "Mayas", "Mayeul", "Mayline", "Maylis", "Maÿlis", "Mayron", "Mayssa", "Mayssane",
			"Mazarine", "Mazen", "Mehdi", "Mehdy", "Meir", "Meïr", "Meïssa", "Meïssane", "Mélanie", "Melchior", "Mélia",
			"Mélie", "Melina", "Mélina", "Mélinda", "Méline", "Mélinée", "Mélisande", "Melissa", "Mélissa",
			"Mélissande", "Mellina", "Méllina", "Mélodie", "Melody", "Mélody", "Mélusine", "Melvil", "Melvin", "Melvyn",
			"Mélya", "Mélyna", "Menahem", "Mendel", "Meriam", "Meriem", "Merlin", "Merwan", "Meryam", "Meryem", "Meryl",
			"Meyron", "Meyssa", "Meziane", "Mia", "Michael", "Michaël", "Michel", "Michelle", "Mickael", "Mickaël",
			"Miguel", "Mika", "Mikaël", "Mikail", "Mikaïl", "Mike", "Mila", "Milan", "Milann", "Milena", "Miles",
			"Milhan", "Milhane", "Milica", "Milla", "Milo", "Mina", "Minh", "Mira", "Miral", "Miriam", "Miya", "Moché",
			"Modibo", "Mody", "Mohamed", "Mohamed-Ali", "Mohamed-Amine", "Mohamed-Lamine", "Mohammad", "Mohammed",
			"Moïra", "Moïse", "Molly", "Mona", "Monica", "Monique", "Morgan", "Morgane", "Morganne", "Mory", "Moshé",
			"Mouad", "Mouctar", "Mouhamad", "Mouhamadou", "Mouhamed", "Mouhammad", "Moulay", "Mouna", "Mounia",
			"Mounir", "Moussa", "Moustafa", "Moustapha", "Muhammad", "Muhammed", "Mustapha", "Mya", "Myla", "Mylan",
			"Mylann", "Myriam", "Myrtille", "Nabil", "Nabintou", "Nada", "Nadia", "Nadine", "Nadir", "Nael", "Naël",
			"Naelle", "Naëlle", "Nafissatou", "Nahel", "Nahia", "Nahil", "Nahla", "Nahyl", "Naïa", "Naïl", "Naila",
			"Naïla", "Naïm", "Naïma", "Naïs", "Nala", "Nalya", "Namizata", "Namory", "Nana", "Naomi", "Naomie", "Naor",
			"Narimane", "Nassim", "Natacha", "Natalia", "Natan", "Natasha", "Nathaël", "Nathalie", "Nathan",
			"Nathanael", "Nathanaël", "Nathane", "Nathaniel", "Nava", "Nawal", "Nawel", "Nawfel", "Naya", "Nayel",
			"Nayla", "Nazim", "Ndeye", "Neela", "Neil", "Neïla", "Nelia", "Nélia", "Nell", "Nellia", "Nelly", "Nelson",
			"Nelya", "Nélya", "Néné", "Néo", "Nermine", "Nesrine", "Neyl", "Neyla", "Niamé", "Nicolas", "Nicole",
			"Niels", "Nihel", "Nikita", "Nikola", "Nil", "Nils", "Nina", "Nine", "Nino", "Ninon", "Niouma", "Nisrine",
			"Nissim", "Nizar", "Noa", "Noah", "Noam", "Noâm", "Noan", "Noé", "Noée", "Noélia", "Noélie", "Noemi",
			"Noémi", "Noémie", "Noha", "Noham", "Nohan", "Nohé", "Nola", "Nolan", "Nolann", "Nolhan", "Noor", "Nora",
			"Norah", "Norhane", "Nouha", "Nour", "Noura", "Nourane", "Noya", "Océane", "Octave", "Octavie", "Odélia",
			"Olga", "Olive", "Oliver", "Olivia", "Olivier", "Oliwia", "Olympe", "Olympia", "Omar", "Ombeline", "Ondine",
			"Oona", "Ophélie", "Ora", "Oren", "Oriane", "Orion", "Orlane", "Ornella", "Orso", "Orson", "Ortal", "Oscar",
			"Oskar", "Othman", "Othmane", "Otto", "Oumar", "Oumou", "Ouriel", "Ousmane", "Oussama", "Ovadia", "Owen",
			"Pablo", "Paco", "Pacôme", "Paloma", "Paola", "Paolo", "Pape", "Paris", "Pascal", "Patricia", "Patrick",
			"Paul", "Paul-Antoine", "Paul-Arthur", "Paul-Emile", "Paula", "Paulin", "Pauline", "Pedro", "Penda",
			"Pénélope", "Perla", "Perle", "Perrine", "Peter", "Pétronille", "Pharell", "Philéas", "Philémon",
			"Philibert", "Philippa", "Philippe", "Philippine", "Philomène", "Pia", "Pierre", "Pierre-Alexandre",
			"Pierre-Antoine", "Pierre-Louis", "Pietro", "Pio", "Pol", "Preston", "Priam", "Prince", "Prisca",
			"Priscille", "Prosper", "Prudence", "Prune", "Prunelle", "Purity", "Qassim", "Quentin", "Quitterie",
			"Racha", "Rachel", "Racim", "Rafael", "Rafaël", "Rafaela", "Rahim", "Rahma", "Ralph", "Ramata",
			"Ramatoulaye", "Rami", "Ramy", "Rana", "Rania", "Ranim", "Ranya", "Raoul", "Raphael", "Raphaël",
			"Raphaëlle", "Rayan", "Rayane", "Rayen", "Rayhana", "Razan", "Razane", "Rebecca", "Rébecca", "Reda", "Réda",
			"Redouane", "Reine", "Rémi", "Rémy", "Renaud", "Réphaël", "Riad", "Ricardo", "Richard", "Rim", "Rime",
			"Rita", "Ritaj", "Ritej", "Rivka", "Riwan", "Riyad", "Robert", "Robin", "Robinson", "Roch", "Rodolphe",
			"Rodrigo", "Rodrigue", "Rohan", "Rokhaya", "Rokia", "Rokya", "Roland", "Romain", "Romaïssa", "Roman",
			"Romane", "Romeo", "Roméo", "Romie", "Romy", "Ron", "Ronan", "Rony", "Rosa", "Rosalie", "Rose", "Rosie",
			"Roxane", "Roxanne", "Roy", "Ruben", "Rubens", "Ruby", "Rudy", "Ruth", "Ryad", "Ryan", "Rym", "Saad",
			"Sabine", "Sabri", "Sabrina", "Sabrine", "Sacha", "Sadio", "Safa", "Safia", "Safiatou", "Safiya", "Safwan",
			"Safwane", "Safya", "Sahel", "Said", "Saïd", "Saif", "Saja", "Sakina", "Salem", "Salif", "Saliha", "Salim",
			"Salima", "Salimata", "Saliou", "Sally", "Salma", "Salman", "Salomé", "Salomée", "Salomon", "Saly", "Sam",
			"Samantha", "Samba", "Sami", "Samia", "Samir", "Samira", "Samson", "Samuel", "Samy", "Sana", "Sanaa",
			"Sandra", "Sandrine", "Sandro", "Sandy", "Santiago", "Sara", "Sarah", "Sarah-Lou", "Saran", "Sarra",
			"Sasha", "Saskia", "Satine", "Saul", "Saül", "Savannah", "Scarlett", "Scott", "Sean", "Sebastian",
			"Sebastien", "Sébastien", "Sekou", "Sékou", "Selena", "Séléna", "Sélène", "Selim", "Sélim", "Selma",
			"Selyan", "Sephora", "Séphora", "Séraphine", "Serena", "Séréna", "Serge", "Serigne", "Serine", "Sérine",
			"Séverin", "Seydina", "Seydou", "Seynabou", "Shady", "Shahd", "Shahine", "Shaï", "Shaïli", "Shaïly",
			"Shaïma", "Shaïna", "Shaïnez", "Shana", "Shanaya", "Shani", "Shanice", "Shanna", "Shannon", "Shanon",
			"Shany", "Sharon", "Shawn", "Shay", "Shayan", "Shayma", "Shayna", "Shelly", "Sherine", "Shérine", "Shira",
			"Shirel", "Shirine", "Shyrel", "Sia", "Siaka", "Sibylle", "Sidi", "Sidney", "Sidonie", "Sidra", "Sidy",
			"Sienna", "Siham", "Sihem", "Silas", "Siloé", "Siméon", "Simon", "Simone", "Sinan", "Sira", "Sirine",
			"Sixte", "Sixtine", "Skander", "Soan", "Soën", "Sofia", "Sofian", "Sofiane", "Sofya", "Sohan", "Sohane",
			"Sokhna", "Sokona", "Solal", "Solan", "Solange", "Solène", "Solenn", "Soline", "Solveig", "Sonia", "Sophia",
			"Sophie", "Soraya", "Soren", "Sören", "Souheyl", "Soujoud", "Soukaïna", "Soulayman", "Souleyman",
			"Souleymane", "Soumaya", "Stacy", "Stan", "Stanislas", "Stanley", "Steeve", "Stefan", "Stella", "Stéphane",
			"Stéphanie", "Steve", "Steven", "Suzanne", "Suzie", "Suzon", "Sven", "Swan", "Swann", "Sybille", "Sydney",
			"Sylia", "Sylvain", "Sylvia", "Sylvie", "Syrine", "Szymon", "Taha", "Tahar", "Tahel", "Tahira", "Taïna",
			"Taïs", "Takumi", "Tal", "Tali", "Talia", "Taly", "Talya", "Tamara", "Tancrède", "Tanguy", "Tania",
			"Tanina", "Tanya", "Tao", "Tara", "Tasnim", "Tasnime", "Tatiana", "Taym", "Tayron", "Téa", "Teddy",
			"Tehila", "Telma", "Tenzin", "Téo", "Teodor", "Terence", "Térence", "Teresa", "Tesnim", "Tesnime", "Tess",
			"Tessa", "Thaddée", "Thaïs", "Thalia", "Thalie", "Thanina", "Théa", "Thelma", "Thémis", "Theo", "Théo",
			"Théodora", "Theodore", "Théodore", "Théophane", "Théophile", "Théotime", "Thérèse", "Thiago", "Thibaud",
			"Thibault", "Thibaut", "Thierno", "Thierry", "Thomas", "Tia", "Tiago", "Tiana", "Tidiane", "Tidjane",
			"Tiffany", "Tiguida", "Tilio", "Tim", "Timéo", "Timoté", "Timothé", "Timothée", "Timothy", "Tina",
			"Tiphaine", "Titouan", "Tobias", "Tom", "Toma", "Tomas", "Tommy", "Tony", "Tosca", "Toscane", "Tracy",
			"Tristan", "Trystan", "Tsipora", "Tyana", "Tybalt", "Tylan", "Tyler", "Tyméo", "Typhaine", "Tyron", "Ugo",
			"Ulysse", "Uma", "Uriel", "Vadim", "Valentin", "Valentina", "Valentine", "Valentino", "Valère", "Valeria",
			"Valérian", "Valérie", "Vanessa", "Vasco", "Vassili", "Vassily", "Vera", "Vianney", "Victoire", "Victor",
			"Victoria", "Victorien", "Victorine", "Viggo", "Viktor", "Viktoria", "Vincent", "Vinciane", "Violaine",
			"Violette", "Virgil", "Virgile", "Virginie", "Vittoria", "Viviane", "Vivien", "Vivienne", "Vladimir",
			"Wael", "Waël", "Waïl", "Walid", "Wanda", "Wandrille", "Warren", "Wassil", "Wassim", "Wendy", "Wesley",
			"Wiem", "Wiktoria", "Wilfried", "Wilhem", "Will", "Willem", "William", "Willy", "Wilson", "Winner",
			"Wissam", "Wissem", "Xavier", "Yacine", "Yacoub", "Yacouba", "Yael", "Yaël", "Yaëlle", "Yahia", "Yahya",
			"Yaïr", "Yakine", "Yakoub", "Yamina", "Yan", "Yana", "Yani", "Yanice", "Yanis", "Yaniv", "Yann", "Yanni",
			"Yannick", "Yannis", "Yara", "Yaron", "Yasin", "Yasmina", "Yasmine", "Yasser", "Yassin", "Yassine", "Yaya",
			"Yazen", "Yazid", "Yesmine", "Yessine", "Ylan", "Yoan", "Yoann", "Yoav", "Yoel", "Yoël", "Yohan", "Yohann",
			"Yolan", "Yona", "Yoni", "Yoram", "Yosra", "Yossef", "Youcef", "Youmna", "Youna", "Younes", "Younès",
			"Youness", "Younous", "Younouss", "Youri", "Yousra", "Youssef", "Youssouf", "Ysé", "Ysée", "Yumi", "Yuna",
			"Yunus", "Yuri", "Yusuf", "Yvan", "Yves", "Zach", "Zacharia", "Zacharie", "Zachary", "Zack", "Zackary",
			"Zadig", "Zahara", "Zahra", "Zakaria", "Zakariya", "Zakary", "Zakarya", "Zara", "Zayd", "Zayn", "Zaynab",
			"Zayneb", "Zeinab", "Zelda", "Zélie", "Zéphyr", "Zeynab", "Zeyneb", "Zeynep", "Ziad", "Zied", "Zina",
			"Zineb", "Zinedine", "Zion", "Zita", "Ziyad", "Zoe", "Zoé", "Zoë", "Zoey", "Zohra", "Zuzanna", "Zyad" };
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

		sldao.save(new SecurityLevel("Client","NDS Client, accès aux utilisations basiques de réservation et achats."));
		sldao.save(new SecurityLevel("VIP","NDS Client Premium, accès aux utilisations premium de réservation et achats."));
		sldao.save(new SecurityLevel("Employee",
				"NDS Employé, accès aux utilisations basiques, de ventes et de modifications clients."));
		sldao.save(new SecurityLevel("RH",
				"NDS RH, accès aux utilisations basiques, ajout et suppression d\'employés de NDS 2,3,4."));
		sldao.save(new SecurityLevel("Moderator",
				"NDS Modérateur, accès aux utilisations basiques, de ventes et de modifications clients, employé et RH."));
		sldao.save(new SecurityLevel("Adminstrator","NDS Administrateur, accès total."));

		mdao.save(new Movie("Nadia, butterfly", "Nadia, butterfly", 0, 2021, LocalTime.of(1, 46, 00, 00), "Drame", 5.00, "https://m.media-amazon.com/images/M/MV5BNGFkMDlhZTMtOWU5Zi00YTFmLTkzNTktM2FkYTUzZmU3ZjljXkEyXkFqcGdeQXVyMjUwNDA4OTk@._V1_SX300.jpg"
				,"Le film fait partie de la Sélection Officielle de Cannes 2020. Nadia, 23 ans, nage pour le Canada aux Jeux olympiques. Cette compétition prestigieuse représente l\'aboutissement de sa vie de sacrifices. Pourtant, par peur de rester piégée dans le monde hermétique et éphémère du sport de haut niveau, Nadia a pris la décision..."));
		mdao.save(new Movie("Nouvel ordre", "New Order", 12, 2021, LocalTime.of(1, 28, 00, 00), "Drame", 5.00,"https://m.media-amazon.com/images/M/MV5BOTcwNmM5MWItYmU5Mi00NmFkLWEwNmMtNWUxY2U1NTIzOWIwXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_SX300.jpg",
				"Un mariage mondain est interrompu par l\'arrivée d\'invités importuns."));
		mdao.save(new Movie("Promising Young Woman", "Promising Young Woman", 12, 2021, LocalTime.of(1, 54, 00, 00),
				"Thriller", 5.00,"https://m.media-amazon.com/images/M/MV5BOTI0OGQzOWEtZWY1ZC00MTFjLThmODAtYWQ3MDk4ZGEyNGYyXkEyXkFqcGdeQXVyODc0OTEyNDU@._V1_SX300.jpg",
				"Tout le monde s\'entendait pour dire que Cassie était une jeune femme pleine d\'avenir jusqu\'à ce qu\'un évènement inattendu ne vienne tout bouleverser. Mais rien dans la vie de Cassie n\'est en fait conforme aux apparences , elle est aussi intelligente que rusée, séduisante que calculatrice et mêne une double vie dès la nuit..."));
		mdao.save(new Movie("Tom & Jerry", "Tom & Jerry", 0, 2021, LocalTime.of(1, 41, 00, 00), "Animation", 5.00,
				"https://m.media-amazon.com/images/M/MV5BNDg1Zjc4YzktMmRmZi00ZWJmLWJiYzgtYjg3MmE0OTM1NzY5XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg","Les nouvelles aventures de Tom & Jerry dans un long métrage melant CGI et prises de vues réelles. Tom, le chat et Jerry, la souris n\'ont plus de domicile. Ils emménagent dans un hôtel chic de New York où Kayla a trouvé un emploi. Mais pour qu\'elle puisse le garder, il faut impérativement qu\'elle chasse Jerry avant la réception..."));
		mdao.save(new Movie("Freaky", "Freaky", 0, 2021, LocalTime.of(1, 42, 00, 00), "Thriller", 5.00,"https://m.media-amazon.com/images/M/MV5BMTRkYmJlY2ItNmFlZi00OWVhLTg1ZTctOGE0MjM5ZGMwMmY4XkEyXkFqcGdeQXVyNjY1MTg4Mzc@._V1_SX300.jpg",
				"Millie Kessler, une adolescente de 17 ans, occupée à faire bonne figure dans son très élitiste lycée, Blissfield High, devient la nouvelle cible du Boucher, un tueur en série tristement notoire. Son année de Terminale va alors devenir le cadet de ses soucis. Lorsque, sous l\'effet du poignard antique du Boucher ils se réveillent dans le corps de..."));
		mdao.save(new Movie("9 jours à Raqqa", "9 jours à Raqqa", 12, 2021, LocalTime.of(1, 30, 00, 00), "Documentaire",
				5.00,
				"Le film fait partie de la Sélection Officielle Cannes 2020. Leïla Mustapha est à 30 ans la nouvelle maire Kurde de Raqqa en Syrie. Ingénieure en génie civil et chargée de la reconstruction de l\'ancienne capitale de Daech, elle doit réconcilier la population et arriver à faire vivre la démocratie. La journaliste grand reporter et écrivaine, Marine"));
		mdao.save(new Movie("Comment je suis devenu super-héros", "Comment je suis devenu super-héros", 12, 2021,
				LocalTime.of(1, 37, 00, 00), "Policier / Espionnage", 5.00,
				"Paris 2020. Dans une société où les surhommes sont banalisés et parfaitement intégrés, une mystérieuse substance procurant des super-pouvoirs à ceux qui n\'en ont pas se répand. Face aux incidents qui se multiplient, les lieutenants Moreau et Schaltzmann sont chargés de l\'enquête. Avec l\'aide de Monté Carlo et Callista, deux..."));
		mdao.save(new Movie("Fatima", "Fatima", 12, 2021, LocalTime.of(1, 53, 00, 00), "Drame", 5.00,"https://m.media-amazon.com/images/M/MV5BZTY4OWExZDYtN2ZkNy00ODA5LWE1MTktNGM3NzhmYTAwOTYyXkEyXkFqcGdeQXVyMTA2MDQ3MTQ3._V1_SX300.jpg",
				"Portugal. 1917, trois jeunes bergers de Fatima racontent avoir vu la Vierge Marie. Leurs révélations vont toucher de nombreux croyants mais également attirer la colère des représentants de l\'Eglise et du gouvernement. Ils vont tout faire pour essayer d\'étouffer l\'affaire et obliger les trois enfants à se rétracter. Mais la rumeur..."));
		mdao.save(new Movie("Mystère à Saint-Tropez", "Mystère à Saint-Tropez", 12, 2021, LocalTime.of(00, 00, 00, 00),
				"Comédie", 5.00,
				"Aout 1970, en pleine période yéyé. Comme chaque année, le milliardaire Claude Tranchant et sa femme Eliane ont invité le gratin du show-business dans leur somptueuse villa tropézienne. Rien ne semble pouvoir gâcher les festivités, si ce n\'est l\'inquiétant sabotage de la décapotable du couple. Persuadé d\'être victime"));
		mdao.save(new Movie("Nomadland", "Nomadland", 12, 2021, LocalTime.of(1, 48, 00, 00), "Drame", 5.00,"https://m.media-amazon.com/images/M/MV5BMDRiZWUxNmItNDU5Yy00ODNmLTk0M2ItZjQzZTA5OTJkZjkyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg",
				"Après avoir tout perdu pendant la Grande Récession, une sexagénaire se lance dans un voyage à travers l\'Ouest américain, vivant comme un nomade des temps modernes."));
		mdao.save(new Movie("Nos plus belles années", "Nos plus belles années", 12, 2021, LocalTime.of(2, 15, 00, 00),
				"Comédie dramatique", 5.00,"https://m.media-amazon.com/images/M/MV5BNzMyMDYwNmMtYTRkNi00NTdjLTllYWMtOTI4NmM1OGRlZjE1L2ltYWdlXkEyXkFqcGdeQXVyMjA0NzcwMjI@._V1_SX300.jpg",
				"C\'est l\'histoire de quatre amis, racontée sur quarante ans, en Italie, des années 1980 à aujourd\'hui. La chronique de leurs espoirs, de leurs désillusions, de leurs amours, et surtout, de leur amitié."));
		mdao.save(new Movie("Un homme en colère", "Un homme en colère", 12, 2021, LocalTime.of(00, 00, 00, 00),
				"Action", 5.00,"N/A",
				"Un convoyeur de fond fraichement engagé surprend ses collègues par l\'incroyable précision de ses tirs de riposte alors qu\'ils subissent les assauts de braqueurs expérimentés.Tous se demandent désormais qui il est, d\'où il vient et pourquoi est-il là."));
		mdao.save(new Movie("Délicieux", "Délicieux", 12, 2021, LocalTime.of(1, 53, 00, 00), "Comédie dramatique", 5.00,
				"N/A","XVIIIe siècle. Un cuisinier est limogé par son maître. Il trouve le courage au contact d\'une jeune femme étonnante de se libérer de sa condition de domestique et de proposer son savoir-faire directement au public en créant le premier restaurant."));
		mdao.save(new Movie("L\'un des notres", "L\'un des notres", 12, 2021, LocalTime.of(1, 55, 00, 00), "Thriller",
				5.00,
				"Après la perte de leur fils, le shérif à la retraite George Blackledge et son épouse, Margaret quittent leur ranch du Montana pour sauver leur jeune petit-fils des griffes d\'une dangereuse famille tenue d\'une main de fer par la matriarche Blanche Weboy. Quand ils découvrent que les Weboy n\'ont pas l\'intention de laisser partir l\'enfant..."));
		mdao.save(new Movie("Ca tourne à Saint-Pierre et Miquelon", "Ca tourne à Saint-Pierre et Miquelon", 12, 2021,
				LocalTime.of(1, 35, 00, 00), "Comédie dramatique", 5.00,"N/A",
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
		
		
		User ME1 = new User("MoshGoss","azertyuiop",new Person("Delmée","Quentin",LocalDate.of(1991, 3, 9), "H", "Nantes","Quentin.Delmee@QBY.fr"),allSL.get(0));
		User ME2 = new User("DocKantum","azertyuiop",new Person("Delmée","Quentin",LocalDate.of(1991, 3, 9), "H", "Nantes","Quentin.Delmee@QBY.fr"),allSL.get(5));
		
		udao.save(ME1);
		udao.save(ME2);
		
		
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

		List<CinemaRoom> allRooms = (List<CinemaRoom>) crdao.findAll();

		for (CinemaRoom cinemaRoom : allRooms) {
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
		List<Product> allProducts = (List<Product>) prdao.findAll();
		List<Seat> allSeats = (List<Seat>) seadao.findAll();
		int count = 0 ;
		for (CinemaRoom cinemaRoom : allRooms) {
			
			User tempU = allUsers.get(rand.nextInt(allUsers.size()));
			String tempP = proprete[rand.nextInt(proprete.length)];
			odao.save(new Opinion(cinemaRoom, tempU, rand.nextInt(5), tempP));
			odao.save(new Opinion(cinemaRoom,ME1, rand.nextInt(5),tempP));
			Movie tempM = allMovies.get(count);
			++count ;
			for( int i = 8 ; i < 22 ; i = i+3)
			{
				LocalDateTime ldt = LocalDateTime.of(LocalDate.now(),LocalTime.of(i,0)) ;
				sesdao.save(new Session(cinemaRoom, tempM, ldt, cinemaRoom.getNbSeats()));
				Seat tempSeat = allSeats.get(rand.nextInt(allSeats.size()));
				rdao.save(new Reservation(tempU, tempSeat,tempM, ldt));
				rdao.save(new Reservation(ME1, tempSeat,tempM, ldt));
			}
			
			
		}

		
		
		for (Movie movie : allMovies) {
			User tempU = allUsers.get(rand.nextInt(allUsers.size()));
			String tempC = comments[rand.nextInt(comments.length)];
			cdao.save(new Commentary(rand.nextInt(5), tempC, tempU, movie));
			cdao.save(new Commentary(rand.nextInt(5), tempC, ME1, movie));
		}
		
		for (Product prod : allProducts)
		{
			User tempU = allUsers.get(rand.nextInt(allUsers.size()));
			LocalDateTime ldt = LocalDateTime.of(randomDate(), LocalTime.of(0, 0));
			int tempQ = rand.nextInt(20);
			int tempTC = rand.nextInt(20);
			pudao.save(new Purchase(prod, tempU, ldt, tempQ, tempTC));
			pudao.save(new Purchase(prod, ME1, ldt, tempQ, tempTC));
		}
		
		
		  qdao.save( new Quizz( "Abeilles du rucher", "Comment appelle-t-on une personne qui élève des abeilles à miel ?", "Apiculteur", "Ostréiculteur", "Aviculteur", "Raniculteur", 1, "Pratiquée sur tous les continents, cette activité diffère selon les variétés d\'abeilles, le climat et le développement économique.", "https://fr.wikipedia.org/wiki/Apiculteur"));
		  qdao.save( new Quizz( "Abeilles du rucher", "De quel suc sécrété se nourrissent la plupart des abeilles de nos régions ?", "Nectar", "Cerne", "Bourgeon", "Loge", 1, "Cette substance possède, par son goût ou son odeur, un pouvoir d\'attraction sur les insectes ainsi que sur certains oiseaux.", "https://fr.wikipedia.org/wiki/Nectar_(botanique)"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Avec quel autre insecte plus agressif confond-on souvent l\'abeille ?", "Guêpe", "Frelon", "Taon", "Bourdon", 1, "La guêpe est un insecte ayant généralement un abdomen jaune rayé de noir et dont la femelle porte un dard venimeux.", "https://fr.wikipedia.org/wiki/Guêpe"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Que font les abeilles volant de fleur en fleur à la recherche de nourriture ?", "Elles butinent", "Elles ruminent", "Elles patinent", "Elles dessinent", 1, "L\'abeille récolte ainsi dans la nature nectar, propolis, miellat et pollen. En butinant, l\'abeille assure également la pollinisation.", "https://fr.wikipedia.org/wiki/Abeille"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quel phénomène important l\'abeille permet-elle d\'assurer en butinant ?", "Pollinisation", "Germination", "Sporulation", "Introgression", 1, "Les plantes contribuent quant à elle à l\'alimentation des pollinisateurs en leur fournissant le pollen en excès ou nectar.", "https://fr.wikipedia.org/wiki/Pollinisation"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Laquelle de ces propositions n\'est pas un produit dérivé de l\'abeille ?", "Beurre", "Miel", "Cire", "Gelée", 1, "Ces produits sont stockés dans des galeries pour les espèces solitaires, des assemblages complexes pour les espèces sociales.", "https://fr.wikipedia.org/wiki/Abeille"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quel est le seul individu femelle fertile au sein d\'une colonie d\'abeilles ?", "Reine", "Ouvrière", "Guêpe", "Frelon", 1, "La reine, à l\'abdomen plus allongé, est habituellement la mère de la plupart des abeilles de la ruche, sinon de la totalité.", "https://fr.wikipedia.org/wiki/Reine_des_abeilles"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quel mâle de l\'abeille est le produit de l\'éclosion d\'un oeuf non fécondé ?", "Faux bourdon", "Phasme", "Tique", "Coléoptère", 1, "Contrairement à l\'abeille ouvrière femelle, le faux bourdon ne possède pas de dard et ne récolte ni nectar ni pollen.", "https://fr.wikipedia.org/wiki/Faux_bourdon"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quelle petite abeille a fait la joie des enfants à la télévision dans les années 1980 ?", "Maya", "Heidi", "Tao Tao", "Zigby", 1, "Maya découvre le monde en compagnie de ses amis Willy l\'abeille, Flip la sauterelle, Max le ver de terre et Alexandre la souris.", "https://fr.wikipedia.org/wiki/Maya_l\'abeille_(série_télévisée)"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Environ combien d\'espèces d\'abeilles sont répertoriées à ce jour sur la planète ?", "20 000", "15 000", "10 000", "5 000", 1, "Les abeilles peuvent être classées selon leur mode de vie : abeilles domestiques, sauvages, solitaires ou bien sociales.", "https://fr.wikipedia.org/wiki/Abeille"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quel nom donne-t-on à un groupe d\'abeilles vivant en société ?", "Colonie", "Écotype", "Niche", "Guilde", 2, "En biologie, une colonie est un groupe d\'organismes de la même espèce vivant rassemblés selon un mode de vie particulier.", "https://fr.wikipedia.org/wiki/Colonie_(biologie)"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quelle espèce d\'abeille est probablement la plus connue en Europe ?", "Apis mellifera", "Apis cerana", "Apis florea", "Apis dorsata", 2, "Semi-domestique, le nom de genre Apis est le terme latin pour abeille, et mellifera signifie qui donne du miel.", "https://fr.wikipedia.org/wiki/Abeille"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quelle est la durée de vie moyenne d\'une abeille durant les mois d\'été ?", "Un mois", "Deux mois", "Trois mois", "Quatre mois", 2, "Se nourrissant du nectar des fleurs, une abeille peut vivre jusqu\'à dix mois en hiver et seulement un mois en été.", "https://fr.wikipedia.org/wiki/Abeille"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quelle expression désigne une espèce d\'abeille vivant en colonie ?", "Abeille sociale", "Abeille parasite", "Abeille solitaire", "Abeille à miel", 2, "D\'autres espèces sont des abeilles parasites ou abeilles coucous qui pratiquent le cleptoparasitisme.", "https://fr.wikipedia.org/wiki/Abeille"));
		  qdao.save( new Quizz( "Abeilles du rucher", "De quoi la larve d\'une future reine des abeilles est-elle exclusivement nourrie ?", "Gelée royale", "Insectes", "Sel", "Sédiments", 2, "La gelée royale est le produit de sécrétion des abeilles ouvrières, entre le cinquième et le quatorzième jour de leur existence.", "https://fr.wikipedia.org/wiki/Gelée_royale"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Comment appelle-t-on un rassemblement important d\'abeilles ?", "Essaim", "Grappe", "Manteau", "Sac", 2, "Le phénomène dit de nuée n\'a pas d\'origine météorologique directe mais est saisonnier et lié aux épisodes de sécheresse.", "https://fr.wikipedia.org/wiki/Essaim"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quelle abeille est la grande favorite de l\'apiculture en Europe ?", "Abeille noire", "Abeille rouge", "Abeille bleue", "Abeille blanche", 2, "Son aire de répartition originale s\'étendait de l\'ouest de la Russie à l\'Europe du Nord et probablement à la péninsule ibérique.", "https://fr.wikipedia.org/wiki/Apis_mellifera_mellifera"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Que se passe-t-il pour l\'abeille lorsque celle-ci utilise son dard cranté pour piquer ?", "Elle meurt", "Elle dort", "Elle gonfle", "Elle boit", 2, "La piqûre entraîne une partie des organes internes de l\'abeille, dont son sac à venin, ce qui est presque toujours fatal à l\'abeille.", "https://fr.wikipedia.org/wiki/Abeille"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Comment appelle-t-on l\'ensemble des ruches d\'un apiculteur ?", "Rucher", "Colonie", "Essaim", "Grappe", 2, "L\'emplacement des ruchers se fait notamment en fonction de l\'environnement et de l\'exposition (de préférence sud ou sud-est).", "https://fr.wikipedia.org/wiki/Rucher"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quel film d\'animation raconte la vie d\'une abeille fraîchement diplômée ?", "« Bee Movie »", "« Rosa »", "« Happy Feet »", "« Le Lorax »", 2, "Ce film d\'animation en images de synthèse sorti en 2007 a été écrit et produit par Jerry Seinfeld pour DreamWorks SKG.", "https://fr.wikipedia.org/wiki/Bee_Movie_:_Drôle_d\'abeille"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Dans quelle résine a-t-on retrouvé les plus anciens fossiles d\'abeilles ?", "Ambre", "Turquoise", "Jais", "Opale", 3, "Le plus vieux fossile à ce jour est Melittosphex burmensis, daté de 100 millions d\'années et découvert en 2006 en Birmanie.", "https://fr.wikipedia.org/wiki/Ambre"));
		  qdao.save( new Quizz( "Abeilles du rucher", "De combien de castes une colonie d\'abeilles est-elle composée ?", "Trois", "Quatre", "Cinq", "Six", 3, "La reine, l\'unique femelle fertile du groupe, une majorité d\'ouvrières et des mâles (ou faux-bourdons) qui fécondent les futures reines.", "https://fr.wikipedia.org/wiki/Abeille"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quelles abeilles utilisent des galeries creusées dans le bois ?", "Xylicoles", "Rubicoles", "Horticoles", "Vinicoles", 3, "Un xylophage est un organisme vivant dont le régime alimentaire est composé principalement d\'aubier, mais aussi de bois parfait.", "https://fr.wikipedia.org/wiki/Xylophage"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Jusqu\'à combien d\'oeufs la reine des abeilles peut-elle pondre environ en une année ?", "400 000", "300 000", "200 000", "100 000", 3, "Quand sa spermathèque commence à se vider, elle ne peut plus pondre d\'oeufs d\'ouvrières et sa diffusion de phéromones se modifie.", "https://fr.wikipedia.org/wiki/Reine_des_abeilles"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quel processus fait naître une nouvelle reine-mère pour la ruche ?", "Remérage", "Reinage", "Ruchage", "Restaurage", 3, "La colonie amorce alors le périlleux processus de nourrir plusieurs nymphes de gelée royale, la survie de la colonie en dépendant.", "https://fr.wikipedia.org/wiki/Reine_des_abeilles"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Dans quelle maternité de la ruche se développent les futures abeilles ?", "Couvain", "Bûcher", "Dortoir", "Levant", 3, "Il est généralement situé au centre de la ruche et est entouré de rayons de miel et de pollen (pain d\'abeille) pour l\'alimenter.", "https://fr.wikipedia.org/wiki/Couvain"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Comment les abeilles évitent-elles d\'engendrer un organisme étouffant ?", "Essaimage", "Remérage", "Pollinage", "Ruchage", 3, "Ce phénomène a lieu quand une partie des abeilles quitte la ruche avec une reine (l\'essaim) pour former une nouvelle colonie.", "https://fr.wikipedia.org/wiki/Essaimage"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quelle pratique consiste à soigner avec les produits de la ruche ?", "Apithérapie", "Oligothérapie", "Phytothérapie", "Ayurveda", 3, "L\'apithérapie propose d\'utiliser les propriétés supposées du miel, de la propolis, du venin d\'abeilles, de la gelée royale et du pollen.", "https://fr.wikipedia.org/wiki/Apithérapie"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Quel choc une piqûre d\'abeille peut-elle parfois entraîner sur l\'homme ?", "Anaphylactique", "Perforin", "Antigène", "Macrophage", 3, "Il s\'agit d\'une manifestation d\'hypersensibilité immédiate due à la libération de médiateurs vaso-actifs chez un sujet sensibilisé.", "https://fr.wikipedia.org/wiki/Choc_anaphylactique"));
		  qdao.save( new Quizz( "Abeilles du rucher", "Qu\'ont remplacé les abeilles impériales de Napoléon Bonaparte ?", "Fleur de lys", "Myosotis", "Bleuet", "Trèfle", 3, "Les fleurs de lis d\'or sur champ d\'azur devinrent les armes de France et l\'emblème spécifique des rois de France.", "https://fr.wikipedia.org/wiki/Fleur_de_lys"));
	}
}