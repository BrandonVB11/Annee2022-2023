import java.util.Arrays;
/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class StatistiquesTemperatures {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static Temperatures temperatures;

	public static void main(String[] args) {

		chargerTemperatures();
		System.out.println(temperatures.toString());

		System.out.println("*****************************");
		System.out.println("Temperatures : statistiques :");
		System.out.println("*****************************");
		int choix;
		do{
			System.out.println();
			System.out.println("1 -> afficher toutes les temperatures");
			System.out.println("2 -> calculer la moyenne");
			System.out.println("3 ->  affiche la temperature min");
			System.out.println("4 -> afficher le nombre de jour de gel");
			System.out.println("5 -> affiche tous les jours de gel");
			System.out.println("6 -> regarde si tous est positive");
			System.out.println("7 -> contient Au Moins Un Jour De Gel");
			System.out.println("8 -> contient Au Moins Une Temperature Superieure a temperature");
			System.out.println("9 -> temperature Max");
			System.out.println("10 -> joursMax");
			System.out.println("11 -> joursMin");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){
			case 1: afficherTout();
			break;
			case 2: afficherMoyenne();
			break;
			case 3: temperatureMin();
			break;
			case 4:nombreJourGel();
			break;
			case 5:jourDeGel();
			break;
			case 6:toutesPositives();
			break;
			case 7:contientAuMoinsUnJourDeGel();
			break;
			case 8:contientAuMoinsUneTemperatureSuperieureA();
			break;
			case 9:temperatureMax();
			break;
			case 10:joursMax();
			break;
			case 11:joursMin();
			break;
			}
		}while(choix >=1 && choix<=11);
	}

	private static void afficherTout() {
		System.out.println(temperatures.toString());
	}

	private static void afficherMoyenne() {
		System.out.println(temperatures.moyenne());
	}

	private  static void temperatureMin(){
		System.out.println(temperatures.temperatureMin());
	}

	private static void nombreJourGel(){
		System.out.println(temperatures.nombreJoursDeGel());
	}

	private static void jourDeGel(){
		System.out.println(temperatures.joursDeGel().toString());
	}

	private static void toutesPositives(){
		System.out.println(temperatures.toutesPositives());
	}

	private static void contientAuMoinsUnJourDeGel(){
		System.out.println(temperatures.contientAuMoinsUnJourDeGel());
	}

	private static void contientAuMoinsUneTemperatureSuperieureA(){
		double temperature = 2;
		System.out.println(temperatures.contientAuMoinsUneTemperatureSuperieureA(temperature));
	}

	private static void temperatureMax(){
		System.out.println(temperatures.temperatureMax());
	}

	private static void joursMax(){
		System.out.println(temperatures.joursMax().toString());
	}

	private static void joursMin(){
		System.out.println(temperatures.joursMin().toString());
	}

	public static void chargerTemperatures(){
		double[]tableTemperatures = {-1,1,0,1,-1,-3,-3,-2,0,-1,0,1,1,3,5,4,2,0,1,1,5,3,2,0,-1,0,1,1,3,4,5};
		temperatures = new Temperatures("janvier",tableTemperatures);
	}

	public static void afficherTable(int[]table){
		System.out.println(Arrays.toString(table));
	}

}
