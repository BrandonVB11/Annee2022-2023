import java.util.Iterator;
import java.util.Scanner;


public class TestABRDEntiers {
	
	private final static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}

	public static void main(String[] args) {
		
		
		System.out.println("*****************************************");
		System.out.println("Programme Test pour la classe ABRDEntiers");
		System.out.println("*****************************************");
	
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> Tester la methode contientPlusieurs()");
			System.out.println("2 -> Tester la methode supprimeMax()");
			System.out.println("3 -> Tester la methode iterator()");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testContientPlusieurs();
				break;
			case 2:
				testSupprimeMax();
				break;

			case 3:
				testIterator();
				break;

			default:
				break;
			}

		} while (choix >= 1 && choix <= 3);

	}
	
	private static void testContientPlusieurs() {
		ABRDEntiers aTeste = new ABRDEntiers(1);
		System.out.println("l'arbre teste est l'arbre de l'enonce.");
		
		System.out.print("contient plusieurs 12");
		assertEquals("\ncontient plusieurs 12 ko", true, aTeste.contientPlusieurs(12));
		System.out.println(" ok");
		
		System.out.print("contient plusieurs 12");
		assertEquals("\ncontient plusieurs 12 ko", true, aTeste.contientPlusieurs(12));
		System.out.println(" ok");
		
		System.out.print("contient plusieurs 7");
		assertEquals("\ncontient plusieurs 7 ko", true, aTeste.contientPlusieurs(7));
		System.out.println(" ok");
		
		System.out.print("contient plusieurs 1");
		assertEquals("\ncontient plusieurs 1 ko", true, aTeste.contientPlusieurs(1));
		System.out.println(" ok");
		
		System.out.print("contient plusieurs 15");
		assertEquals("\ncontient plusieurs 15 ko", true, aTeste.contientPlusieurs(15));
		System.out.println(" ok");
		
		System.out.print("contient plusieurs 13");
		assertEquals("\ncontient plusieurs 13 ko", false, aTeste.contientPlusieurs(13));
		System.out.println(" ok");
		
		System.out.print("contient plusieurs 14");
		assertEquals("\ncontient plusieurs 14 ko", false, aTeste.contientPlusieurs(14));
		System.out.println(" ok");
		
		System.out.print("contient plusieurs 17");
		assertEquals("\ncontient plusieurs 17 ko", false, aTeste.contientPlusieurs(17));
		System.out.println(" ok");

		System.out.print("contient plusieurs 8");
		assertEquals("\ncontient plusieurs 8 ko", false, aTeste.contientPlusieurs(8));
		System.out.println(" ok");
		
		System.out.print("contient plusieurs 3");
		assertEquals("\ncontient plusieurs 3 ko", false, aTeste.contientPlusieurs(3));
		System.out.println(" ok");
		
		System.out.println("--> Tous les tests de la methode contientPlusieurs() avec l'arbre de l'enonce ont reussi.");

		System.out.println();
	}



	private static void testSupprimeMax() {
		System.out.println("Le scenario suivi part de l'arbre de l'enonce"); 
		System.out.println("A la fin des suppressions, l'arbre devrait etre vide");
		ABRDEntiers a = new ABRDEntiers(1);
		System.out.println("l'arbre au depart :");
		System.out.println(a.toString());

		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[  [  [  [ 1(2x) ] 3(1x) [ ]  ] 7(3x) [ 8(1x) ]  ] 12(2x) [  [ 13(1x) ] 15(1x) [ ]  ]  ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}

		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[  [  [  [ 1(2x) ] 3(1x) [ ]  ] 7(3x) [ 8(1x) ]  ] 12(2x) [ 13(1x) ]  ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}

		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[  [  [  [ 1(2x) ] 3(1x) [ ]  ] 7(3x) [ 8(1x) ]  ] 12(2x) [ ]  ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}

		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[  [  [  [ 1(2x) ] 3(1x) [ ]  ] 7(3x) [ 8(1x) ]  ] 12(1x) [ ]  ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}

		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[  [  [ 1(2x) ] 3(1x) [ ]  ] 7(3x) [ 8(1x) ]  ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}

		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[  [  [ 1(2x) ] 3(1x) [ ]  ] 7(3x) [ ]  ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}

		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[  [  [ 1(2x) ] 3(1x) [ ]  ] 7(2x) [ ]  ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}

		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[  [  [ 1(2x) ] 3(1x) [ ]  ] 7(1x) [ ]  ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}

		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[  [ 1(2x) ] 3(1x) [ ]  ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}

		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[ 1(2x) ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[ 1(1x) ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println(a.toString());
			assertEquals("contenu ko", "[  ]", a.toString());
		}catch(ABRVideException e){
			System.out.println("Il ne fallait pas d'ABRVideException!");
			System.exit(0);
		}catch(Exception e){
			System.out.println("Exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			a.supprimeMax();
			System.out.println("l'arbre apres supprimeMax() : ");
			System.out.println("Il fallait une ABRVideException!");
			System.exit(0);
		}catch(ABRVideException e){
			
		}catch(Exception e){
			System.out.println("Exception non prevue : "+e);
			e.printStackTrace();
			System.exit(0);
		}
			
		System.out.println();
		System.out.println("--> Tous les tests de la methode supprimeMax() pour detruire l'arbre de l'enonce ont reussi.");

		System.out.println();
	}


	private static void testIterator() {
		ABRDEntiers aTeste = new ABRDEntiers(1);
		System.out.println("l'arbre teste est l'arbre de l'enonce.");
		int[] entiers = {15, 15, 13, 12, 12, 8, 7, 7, 7, 3, 1, 1};
		int i=0;
		for (Integer entier : aTeste) {
			if(i>11){
				System.out.println("nombre next ko. Attendu=12 reçu=13");
				System.exit(0);
			}
			System.out.print("next :"+entiers[i]);
			assertEquals("\nnext ko", entiers[i], entier);
			System.out.println(" ok");
			i++;
		}
		assertEquals("nombre next ko", 12, i);
		System.out.println();
		System.out.println();
		assertEquals("Attention, l'iterateur ne peut pas modifier l'arbre", "[  [  [  [ 1(2x) ] 3(1x) [ ]  ] 7(3x) [ 8(1x) ]  ] 12(2x) [  [ 13(1x) ] 15(2x) [ ]  ]  ]", aTeste.toString());
		System.out.println("--> L'arbre teste a bien ete parcouru par votre iterateur.");
	}
	






}
