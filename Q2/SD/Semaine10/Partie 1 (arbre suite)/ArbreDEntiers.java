import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author Brandon Van Bellinghen
 *
 */
public class ArbreDEntiers implements Iterable<Integer> {
	protected NoeudEntier racine;
	protected int taille;

	public ArbreDEntiers() {
		this.racine = null;
		this.taille = 0;
	}

	public ArbreDEntiers(int entier) {
		this.racine = new NoeudEntier(entier);
		this.taille = 1;
	}

	public ArbreDEntiers(ArbreDEntiers gauche, int entier, ArbreDEntiers droit) {
		this.racine = new NoeudEntier(gauche.racine, entier, droit.racine);
		this.taille = 1 + gauche.taille + droit.taille;
	}

	public boolean estVide() {
		return this.racine == null;
	}

	public int taille() {
		return taille;
	}

	public Iterator<Integer> preIterateur() {
		return new PreIterateur(this);
	}

	public Iterator<Integer> postIterateur() {
		return new PostIterateur(this);

	}

	// iterateur in ordre
	public Iterator<Integer> iterator() {
		return new InIterateur(this);

	}

	public Iterator<Integer> iterateurParNiveau() {
		return new ByIterateur(this);
	}


	protected class NoeudEntier {
		protected int entier;
		protected NoeudEntier gauche;
		protected NoeudEntier droit;

		private NoeudEntier(int entier) {
			this.entier = entier;
			this.gauche = null;
			this.droit = null;
		}

		private NoeudEntier(NoeudEntier g, int entier, NoeudEntier d) {
			this.entier = entier;
			this.gauche = g;
			this.droit = d;
		}
	}

	private class PreIterateur implements Iterator<Integer> {

		private ArrayDeque<Integer> fileDEntiers;

		public PreIterateur(ArbreDEntiers a) {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile(a.racine);
		}

		private void remplirFile(NoeudEntier n) {
			if (n == null)
				return;
			fileDEntiers.add(n.entier);
			remplirFile(n.gauche);
			remplirFile(n.droit);
		}

		public boolean hasNext() {
			if (fileDEntiers.isEmpty()) {
				return false;
			}
			return true;
		}

		public Integer next() {
			if (fileDEntiers.isEmpty()) {
				throw new NoSuchElementException();
			} else {
				return fileDEntiers.removeFirst();
			}
		}
	}

	private class PostIterateur implements Iterator<Integer> {

		private ArrayDeque<Integer> fileDEntiers;

		public PostIterateur(ArbreDEntiers a) {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile(a.racine);
		}

		private void remplirFile(NoeudEntier n) {
			if (n == null)
				return;
			remplirFile(n.gauche);
			remplirFile(n.droit);
			fileDEntiers.addLast(n.entier);

		}

		public boolean hasNext() {
			if (fileDEntiers.isEmpty()) {
				return false;
			}
			return true;
		}

		public Integer next() {
			if (fileDEntiers.isEmpty()) {
				throw new NoSuchElementException();
			} else {
				return fileDEntiers.removeFirst();
			}
		}
	}

	private class ByIterateur implements Iterator<Integer> {

		private ArrayDeque<NoeudEntier> fileDeNoeuds;

		public ByIterateur(ArbreDEntiers a) {
			fileDeNoeuds = new ArrayDeque<NoeudEntier>();
			remplirFile(a.racine);
		}

		private void remplirFile(NoeudEntier n) {
			if (n == null)
				return;
			fileDeNoeuds.addLast(n);
		}

		public boolean hasNext() {
			return !fileDeNoeuds.isEmpty();
		}

		public Integer next() {
			if (!hasNext())
				throw new NoSuchElementException();
			NoeudEntier noeud = fileDeNoeuds.removeFirst();
			if (noeud.gauche != null)
				remplirFile(noeud.gauche);
			if (noeud.droit != null)
				remplirFile(noeud.droit);
			return noeud.entier;
		}
	}
	private class InIterateur implements Iterator<Integer> {

		private ArrayDeque<Integer> fileDEntiers;

		public InIterateur(ArbreDEntiers a) {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile(a.racine);
		}

		private void remplirFile(NoeudEntier n) {
			if (n == null)
				return;

			remplirFile(n.gauche);
			fileDEntiers.addLast(n.entier);
			remplirFile(n.droit);
		}

		public boolean hasNext() {
			return !fileDEntiers.isEmpty();
		}

		public Integer next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return fileDEntiers.removeFirst();
		}

	}
}