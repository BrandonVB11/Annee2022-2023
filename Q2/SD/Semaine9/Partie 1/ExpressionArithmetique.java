import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Brandon Van Bellinghen
 *
 */

public class ExpressionArithmetique extends ArbreDeCaracteres { 
	
	/**
	 * Cree une expression arithmetique a partir d'un arbre de caracteres
	 * @param a
	 */
	public ExpressionArithmetique (ArbreDeCaracteres a) {
		super(a);
	}

	public ExpressionArithmetique (char c) {
		super(c);
	}
	
	public ExpressionArithmetique (char c, ArbreDeCaracteres ag, ArbreDeCaracteres ad) {
		super(c, ag, ad);
	}
	
	
	/**
	 * calcule le nombre d'operations correspondant au type d'operateur passe en parametre que contient l'expression arithmetique
	 * Par ex : exp1 : + --> 1
	 *                 / --> 1
	 *                 ...
	 *          exp3 : + --> 4 
	 * @param operateur l'operateur verifie
	 * @return le nombre d'operations
	 * @throws IllegalArgumentException si le caractere passe en parametre n'est pas un operateur (+,-,*,/)
	 */
	public int nombreOperations(char operateur)  {
		// TODO	
		return nombreOperations(racine,operateur);
	}

	private int nombreOperations(NoeudCaractere noeud,char operateur)  {
		// TODO
		if(operateur != '+' && operateur != '-' && operateur != '*' && operateur != '/' )throw new IllegalArgumentException("Operateur invalide : " + operateur);
		if(noeud == null)
			return 0;
		if( noeud.caractere == operateur) {
			return 1 + nombreOperations(noeud.gauche,operateur) + nombreOperations(noeud.droit,operateur);
		}
		return nombreOperations(noeud.gauche,operateur) + nombreOperations(noeud.droit,operateur);
	}
	
	/**
	 * verifie si l'arbre ne contient que des additions
	 * Par ex : exp3 ne contient que des +
	 * @return true si l'expression arithmetique contient uniquement des additions, false sinon
	 */
	public boolean uniquementDesAdditions(){
		// TODO
		return uniquementDesAdditions(racine);
	}
	
	private boolean uniquementDesAdditions(NoeudCaractere noeud){
		if(noeud == null){
			return false;
		}
		if(noeud.caractere == '-' || noeud.caractere == '*' || noeud.caractere == '/' ){
			return false;
		}
		if(noeud.caractere == '+')return uniquementDesAdditions(noeud.droit) && uniquementDesAdditions(noeud.gauche);
		return true;
	}
	
	/**
	 * calcule le nombre d'entiers differents contenus dans l'expression arithmetique
	 * Par ex : exp2 contient 3 entiers differents : 1, 4 et 8
	 * @return le nombre d'entiers differents
	 */
	public int nombreEntiersDifferents(){
		// piste de solution:
		// utilisez un ensemble (HashSet<Character>) dans lequel seront places les entiers contenus dans l'arbre
		// Grace a la caracteristique d'unicite d'un ensemble, ceux-ci n'y figureront qu'une fois
		// La taille de l'ensemble obtenu correspondra au nombre recherche
		// TODO
		HashSet<Integer> nombre = new HashSet<>();
		return nombreEntiersDifferents(racine,nombre);
	}

	private int nombreEntiersDifferents(NoeudCaractere noeudµ,HashSet set){
		if(noeudµ == null){
			return 0;
		}
		if(noeudµ.caractere != '+' && noeudµ.caractere != '-' && noeudµ.caractere != '*' && noeudµ.caractere != '/' ){
			if (set.add(noeudµ.caractere)){
				return 1+nombreEntiersDifferents(noeudµ.gauche,set)+nombreEntiersDifferents(noeudµ.droit,set);
			}
		}
		return nombreEntiersDifferents(noeudµ.gauche,set)+nombreEntiersDifferents(noeudµ.droit,set);
	}

	/**
	 * calcule la valeur de l'expression stockee dans l'arbre
	 * Par ex : exp1 --> 13
	 * @return le resultat 
	 */
	public double resultat () {	
		// pour obtenir le chiffre : (int)element - '0'; 
		// car l'element est de type char
		// (int)'0' = 48  (int)'1' = 49  (int)'2' = 50 ...  (int)'9' = 57
		// Le cast (int) n'est pas obligatoire
		// TODO
		return resultat(racine);
	}

	private double resultat(NoeudCaractere noeud){
		if(noeud == null){
			return 0;
		}
		if(noeud.caractere <= '9' && noeud.caractere >= '0'){
			return  noeud.caractere - '0';
		}
		switch (noeud.caractere){
			case '+':
				return resultat(noeud.gauche) + resultat(noeud.droit);
			case '-':
				return resultat(noeud.gauche) - resultat(noeud.droit);
			case '*':
				return resultat(noeud.gauche) * resultat(noeud.droit);
			case '/':
				double droit = resultat(noeud.droit);
				if (droit == 0)throw new IllegalArgumentException("Pas de Division par 0");
				return resultat(noeud.gauche)/resultat(noeud.droit);
			default:
				return 0;
		}
	}
	
	

	/**
	 * renvoie l'expression stockee dans l'arbre en notation infixe
	 * Par exp : exp1 --> ((3-2)+(4*(9/3)))
	 * @return la notation infixe
	 */
	public String notationInfixe () {
		// TODO
		return notationInfixe(racine);
	}

	private String notationInfixe(NoeudCaractere noeud){
		if(noeud == null){
			return "";
		}
		if(noeud.caractere <= '9' && noeud.caractere >= '0'){
			return "" + noeud.caractere;
		}
		switch (noeud.caractere){
			case '+':
				return "("+ notationInfixe(noeud.gauche)+"+"+ notationInfixe(noeud.droit)+")";
			case '-':
				return "("+ notationInfixe(noeud.gauche)+"-"+ notationInfixe(noeud.droit)+")";
			case '*':
				return "("+ notationInfixe(noeud.gauche)+"*"+ notationInfixe(noeud.droit)+")";
			case '/':
				double droit = resultat(noeud.droit);
				if (droit == 0)throw new IllegalArgumentException("Pas de Division par 0");
				return "("+ notationInfixe(noeud.gauche)+"/"+ notationInfixe(noeud.droit)+")";
			default:
				return "";
		}
	}
}

