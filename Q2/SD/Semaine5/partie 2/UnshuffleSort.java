import java.util.ArrayDeque;
import java.util.LinkedList;
/**
 *
 * @author Van Bellinghen Brandon
 *
 */

/**
 * Algorithme de tri : UnshuffleSort 

 * Cet algorithme de tri necessite l’utilisation d’une liste de deques.
 * Cet algorithme de tri comporte deux etapes. La premiere consiste a repartir
 * les entiers a trier dans un nombre variable de deques. Lorsque tous
 * les entiers auront ete repartis, la deuxieme etape se chargera de remplir la
 * table a renvoyer.
 *
 * Les 2 etapes sont basees sur le principe suivant : La liste des deques devra
 * toujours etre triee en utilisant le premier entier de chaque deque comme clef de tri.
 * Les deques aussi sont tries.
 *
 *
 */
public class UnshuffleSort {

	private LinkedList<ArrayDeque<Integer>>  listeDeDeques;

	public UnshuffleSort() {
		this.listeDeDeques = new LinkedList<ArrayDeque<Integer>>();
	}

	/**
	 * tri de la table d'entiers reçue en parametre
	 *
	 * @param tableATrier la table a trier
	 * @return table contenant les entiers tries
	 */
	public int[] trier(int[] tableATrier) {
		remplirDeques(tableATrier);
		return viderDeques(tableATrier.length);
	}

	/**
	 * 1ere etape du tri : repartition des entiers dans des deques
	 * @param tableATrier la table a trier
	 */
	private void remplirDeques(int[]tableATrier) {
		for(int i=0;i<tableATrier.length;i++) {
			placerEntier(tableATrier[i]);
		}
	}

	public void placerEntier(int entier) {
		// Trouver le deque dans lequel le nouvel entier doit être placé
		ArrayDeque<Integer> deque = null;
		for(ArrayDeque<Integer> d : listeDeDeques) {
			if(d.peekFirst() > entier) {
				deque = d;
				break;
			}
		}
		if(deque == null) {
			deque = new ArrayDeque<Integer>();
			listeDeDeques.addLast(deque);
		}
		deque.addFirst(entier);
		reorganiserListe();
	}


	/**
	 * 2eme etape du tri : on vide les deques
	 *
	 * @param taille nombre d'entiers de la table a trier
	 * @return table contenant les entiers tries
	 */
	private int[] viderDeques(int taille) {
		int[] tableauTrie = new int[taille];
		int index = 0;
		while(!listeDeDeques.isEmpty()) {
			ArrayDeque<Integer> deque = listeDeDeques.getFirst();
			tableauTrie[index] = deque.removeFirst();
			if(deque.isEmpty()) {
				listeDeDeques.removeFirst();
			}
			deplacerPremierDeque();
			index++;
		}
		return tableauTrie;
	}

	private int supprimerPlusPetitEntier(){
		// Recherche du premier entier de la liste triée des deques
		int entierMin = Integer.MAX_VALUE;
		int indiceDequeMin = -1;
		for (int i = 0; i < listeDeDeques.size(); i++) {
			ArrayDeque<Integer> deque = listeDeDeques.get(i);
			if (!deque.isEmpty() && deque.getFirst() < entierMin) {
				entierMin = deque.getFirst();
				indiceDequeMin = i;
			}
		}
		// Suppression et renvoi de l'entier minimum
		return listeDeDeques.get(indiceDequeMin).removeFirst();
	}

	private void reorganiserListe(){
		// Tri des deques par ordre croissant de leur premier élément
		listeDeDeques.sort((d1, d2) -> Integer.compare(d1.getFirst(), d2.getFirst()));
		// Suppression des deques vides
		listeDeDeques.removeIf(ArrayDeque::isEmpty);
	}

	private void deplacerPremierDeque() {
		// Déplacement de la première deque à la fin de la liste
		if (!listeDeDeques.isEmpty()) {
			listeDeDeques.getFirst().removeFirst();
			reorganiserListe();
		}
		ArrayDeque<Integer> deque = listeDeDeques.removeFirst();
		listeDeDeques.add(deque);
	}


}
