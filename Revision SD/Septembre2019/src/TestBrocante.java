
public class TestBrocante {
	public static void main(String[] args) {
	
		char[] tableTypes = {'B','A','B','A','B','B','B','A'};
		Brocante brocante = new Brocante(tableTypes);
		
		System.out.println("Au depart:");
		System.out.println(brocante.toString());
		
		System.out.println();
		System.out.println("reservation type A: emplacement n°1 par b1");
		brocante.reserverEmplacementA("b1",1);
		System.out.println(brocante);
		
		System.out.println();
		System.out.println("reservation type A: emplacement n°3 par b1 : attention b1 a deja un emplacement de type A");
		brocante.reserverEmplacementA("b1",3);
		System.out.println(brocante);
		
		System.out.println();
		System.out.println("reservation type A: emplacement n°0 par b2 : attention 0 est un emplacement de type B");
		brocante.reserverEmplacementA("b2",0);
		System.out.println(brocante);
		
		System.out.println();
		System.out.println("reservation type B: par b2");
		brocante.attribuerAutomatiquementEmplacementB("b2");
		System.out.println(brocante);
		
		System.out.println();
		System.out.println("reservation type B: par b1");
		brocante.attribuerAutomatiquementEmplacementB("b1");
		System.out.println(brocante);
		
		System.out.println("Jeu de tests a completer!");
		
		
		
	}
}
