/** Classe Relation héritant de RelationDeBase
	 Fournit des outils de manipulation des relations entre sous-ensembles de l'Univers
 */

import java.util.*;

public class Relation extends RelationDeBase {

	/** Valeur numérique de MAXELT */
	private static final int MAX = Elt.MAXELT.val();

	/** Construit la Relation vide sur l'ensemble vide */
	public Relation() {
		super();
	}

	/** Construit la Relation vide de d vers a */
	public Relation(EnsembleAbstrait d, EnsembleAbstrait a) {
		super(d, a);
	}

	/** Clone */
	public Relation clone() {
		return (Relation) super.clone();
	}
	
	//Ex1
	//renvoie le domaine de la relation courante
	public EnsembleAbstrait domaine() {
		Ensemble e = new Ensemble();
		for (Couple c:this) {
			e.ajouter(c.getX());
		}
		return e;
	}
	
	//renvoie l'image de la relation courante
	public EnsembleAbstrait image() {
		Ensemble e = new Ensemble();
		for (Couple c:this) {
			e.ajouter(c.getY());
		}
		return e;
	}
	
	// EX 2
	// renvoie la complémentaire de la relation courante
	public Relation complementaire() {
		Relation RelComplementaire = new Relation(this.depart(), this.arrivee());
		for (Elt eltDepart : this.depart()) {
			for (Elt eltArrivee : this.arrivee()) {
				Couple couple = new Couple(eltDepart, eltArrivee);
				if (!this.contient(couple))
					RelComplementaire.ajouter(couple);
			}
		}
		return RelComplementaire;
	}

	// renvoie la réciproque de la relation courante
	public Relation reciproque() {
		Relation relationReciproque = new Relation(this.arrivee(), this.depart());

		for (Couple coupletempo : this) {
			relationReciproque.ajouter(coupletempo.reciproque());
		}
		return relationReciproque;
	}

	// si possible, remplace la relation courante par son union avec r
	//sinon, lance une IllegalArgumentException
	public void ajouter(RelationInterface r) {
		if (r == null || this.depart().equals(r.arrivee()) || this.arrivee().equals(r.depart()))
			throw new IllegalArgumentException();
		for (Couple c : r) {
			this.ajouter(c);
		}
	}

	// si possible, remplace this par sa différence avec r
	//sinon, lance une IllegalArgumentException
	public void enlever(RelationInterface r) {
		if (r == null || !r.depart().equals(this.depart()) || !r.arrivee().equals(this.arrivee()))
			throw new IllegalArgumentException();
		for (Elt elt : r.depart()) {
			for (Elt elt2 : r.arrivee()) {
				Couple couple = new Couple(elt, elt2);
				if (this.contient(couple) && r.contient(couple))
					this.enlever(couple);
			}
		}
	}

	// si possible, remplace this par son intersection avec r
	//sinon, lance une IllegalArgumentException
	public void intersecter(RelationInterface r) {
		if (r == null || !r.depart().equals(this.depart()) || !r.arrivee().equals(this.arrivee()))
			throw new IllegalArgumentException();
		for (Elt elt : r.depart()) {
			for (Elt elt2 : r.arrivee()) {
				Couple couple = new Couple(elt, elt2);
				if (this.contient(couple) && !r.contient(couple))
					this.enlever(couple);
			}
		}
	}

	// si possible, renvoie la composée : this après r
	//sinon, lance une IllegalArgumentException
	public Relation apres(RelationInterface r) {
		if (r == null || !r.arrivee().equals(this.depart()))
			throw new IllegalArgumentException();
		Relation thisApresR = new Relation(r.depart(), this.arrivee());
		for (Couple coupleR : r) {
			for (Couple coupleThis : this) {
				if (coupleR.getY().equals(coupleThis.getX())) {
					thisApresR.ajouter(new Couple(coupleR.getX(), coupleThis.getY()));
				}
			}
		}
		return thisApresR;
	}


	
	/*Les exercices 4 et 5 ne concernent que les relations sur un ensemble.
	 * Les méthodes demandées génèreront donc une MathException lorsque l'ensemble de départ
	 * ne coïncide pas avec l'ensemble d'arrivée.
	 */
	
	/* Ex 4 */
		
	// Clôture la Relation courante pour la réflexivité
	public void cloReflex() {
		if (!this.depart().equals(this.arrivee()))
			throw new MathException();
		for (Elt elt : this.depart())
			this.ajouter(new Couple(elt, elt));
	}

	// Clôture la Relation courante pour la symétrie
	public void cloSym() {
		if (!this.depart().equals(this.arrivee()))
			throw new MathException();
		for (Elt elt : this.depart()) {
			for (Elt elt2 : this.arrivee()) {
				Couple couple = new Couple(elt, elt2);
				if (this.contient(couple))
					this.ajouter(couple.reciproque());
			}
		}
	}

	// Clôture la Relation courante pour la transitivité (Warshall)
	public void cloTrans() {
		if (!this.depart().equals(this.arrivee()))
			throw new MathException();
		for (Elt elt1 : this.depart()) {
			for (Elt elt2 : this.depart()) {
				if (this.contient(elt1, elt2)) {
					for (Elt elt3 : this.depart()) {
						if (this.contient(elt3, elt1)) {
							this.ajouter(elt3, elt2);
						}
					}
				}
			}
		}
	}
	
	
	//Ex 5
	/*Les questions qui suivent ne concernent que les relations sur un ensemble.
	 * Les méthodes demandées génèreront donc une MathException lorsque l'ensemble de départ
	 * ne coïncide pas avec l'ensemble d'arrivée.
	 */
	// renvoie true ssi this est réflexive
	public boolean reflexive(){
		if (!this.depart().equals(this.arrivee()))
			throw new MathException();
		for (Elt elt : this.depart()) {
			if (!this.contient(new Couple(elt, elt)))
				return false;
		}
		return true;
	}

	// renvoie true ssi this est antiréflexive
	public boolean antireflexive(){
		if (!this.depart().equals(this.arrivee()))
			throw new MathException();
		for (Elt elt : this.depart()) {
			if (this.contient(new Couple(elt, elt)))
				return false;
		}
		return true;
	}

	// renvoie true ssi this est symétrique
	public boolean symetrique(){
		if (!this.depart().equals(this.arrivee()))
			throw new MathException();
		for (Couple couple : this) {
			if (!this.contient(couple.reciproque()))
				return false;
		}
		return true;
	}

	// renvoie true ssi this est antisymétrique
	public boolean antisymetrique(){
		if (!this.depart().equals(this.arrivee()))
			throw new MathException();
		for (Couple couple : this) {
			if (!couple.getX().equals(couple.getY()) && this.contient(couple.reciproque()))
				return false;
		}
		return true;
	}

	// renvoie true ssi  this est transitive
	public boolean transitive(){
		if (!this.depart().equals(this.arrivee()))
			throw new MathException();
		Relation relTemp = this.clone();
		Relation relTemp2 = this.clone();
		for (Couple couple : relTemp) {
			for (Couple couple2 : relTemp2) {
				if (couple.getY().equals(couple2.getX()) && !this.contient(new Couple(couple.getX(), couple2.getY())))
					return false;
			}
		}
		return true;
	}
	
	// Ex 6
	//Construit une copie de la relation en paramètre
	//lance une IllegalArgumentException en cas de paramètre invalide
	public Relation(RelationInterface r) {
		this();
		if (r == null)
			throw new IllegalArgumentException();
		for (Elt elementDepart : r.depart()) {
			this.ajouterDepart(elementDepart);
		}
		for (Elt elementArrivee : r.arrivee()) {
			this.ajouterArrivee(elementArrivee);
		}
		for (Couple couple : r) {
			this.ajouter(couple);
		}

	}

	//renvoie l'identité sur e
	//lance une IllegalArgumentException en cas de paramètre invalide
	public static Relation identite(EnsembleAbstrait e) {
		if (e == null)
			throw new IllegalArgumentException();
		Relation aRenvoyer = new Relation(e, e);
		for (Elt elt : e) {
			Couple couple = new Couple(elt, elt);
			aRenvoyer.ajouter(couple);
		}
		return aRenvoyer;
	}

	//renvoie le produit cartésien de a et b
	//lance une IllegalArgumentException en cas de paramètre invalide
	public static Relation produitCartesien(EnsembleAbstrait a, EnsembleAbstrait b) {
		if (a == null || b == null) {
			throw new IllegalArgumentException();
		}
		Relation aRenvoyer = new Relation(a, b);
		for (Elt elt : a) {
			for (Elt elt2 : b) {
				Couple couple = new Couple(elt, elt2);
				aRenvoyer.ajouter(couple);
			}
		}
		return aRenvoyer;
	}

} // class Relation
