 public class Matrice {
    private final int nbLignes;              // nombre de lignes
    private final int nbColonnes;            // nombre de colonnes
    private final double[][] data;           // matrice (nbLignes,nbColonnes)

    // ce constructeur cree la matrice nulle de genre (a,b)
    public Matrice(int a, int b) throws IllegalArgumentException { 
    	//TODO : Les lignes ci-dessous sont là uniquement pour qu'il n'y ait pas d'erreur. Elles doivent être modifiées
        if (a <= 0 || b <= 0) throw new IllegalArgumentException();
        data = new double[a][b];
        nbLignes = a;
        nbColonnes = b;

    }

    //  Ce constructeur permet de construire la matrice correspondant 
    //  au tableau en parametre. 
    public Matrice(double[][] tab)  throws IllegalArgumentException {
    	//TODO : La ligne suivante est là uniquement pour qu'il n'y ait pas d'erreur. Elle doit être modifiée ou supprimée
        if (tab == null || tab.length == 0 || tab[0] == null || tab[0].length == 0)
            throw new IllegalArgumentException();
        for (int i = 1; i < tab.length; i++) {
            //verifie que aucune ligne n'est null et que chaque ligne a le meme nombre de colonnes
            if (tab[i] == null || tab[i].length != tab[0].length) throw new IllegalArgumentException();
        }
        data = new double[tab.length][tab[0].length];
        for (int i = 0; i < tab.length; i++) {
            System.arraycopy(tab[i], 0, data[i], 0, tab[0].length);
        }
        nbLignes = tab.length;
        nbColonnes = tab[0].length;
    }

    // constructeur par recopie
    public Matrice(Matrice a)  throws IllegalArgumentException {
        //TODO : La ligne suivante est là uniquement pour qu'il n'y ait pas d'erreur. Elle doit être modifiée ou supprimée
    	if (a == null) throw new IllegalArgumentException();
        nbColonnes = a.nbColonnes;
        nbLignes = a.nbLignes;
        data = new double[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            System.arraycopy(a.data[i], 0, data[i], 0, nbColonnes);
        }
	}

    // cree la matrice identite d'ordre a
    public static Matrice identite(int a)  throws IllegalArgumentException {
    	//TODO
        if(a <= 0) throw new IllegalArgumentException();
        Matrice m = new Matrice(a,a);
        for(int i = 0; i < a; i++){
            m.data[i][i] = 1;
        }
        return m;
    }
    
    //Cette methode renvoie l'element de la ligne numLigne et de la 
    //colonne numColonne de la matrice. Si cet element n'existe pas, la 
    //methode lance une IllegalArgumentException 
	public double getElement(int numLigne, int numColonne)
			throws IllegalArgumentException {
		//TODO
        if (numLigne <= 0 || numColonne <= 0 || numColonne > data[0].length || numLigne > data.length)
            throw new IllegalArgumentException();
        return data[numLigne - 1][numColonne - 1];
	 }
    
    // ajoute b a la matrice courante si c'est possible
    public Matrice somme(Matrice b)  throws IllegalArgumentException {
    	//TODO
        if (b == null || b.data.length != data.length || b.data[0].length != data[0].length)
            throw new IllegalArgumentException();
        Matrice a = new Matrice(data);
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                a.data[i][j] += b.data[i][j];
            }
        }
        return a;
    }

    // calcule le produit scalaire.this de la matrice courante avec scalaire
    public Matrice produitParScalaire(double scalaire){
    	//TODO
        Matrice a = new Matrice(nbLignes, nbColonnes);
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                a.data[i][j] = this.data[i][j] * scalaire;
            }
        }
        return a;
    }

    // calcule le produit this*b de la matrice courante avec b si possible
    public Matrice produitAGauche(Matrice b)  throws IllegalArgumentException {
    	//TODO
        if (b == null || data[0].length != b.data.length) throw new IllegalArgumentException();
        Matrice a = new Matrice(this.nbLignes, b.nbColonnes);
        double elementTmp = 0;
        for (int i = 0; i < a.nbLignes; i++) {
            for (int j = 0; j < a.nbColonnes; j++) {
                for (int k = 0; k < b.nbLignes; k++) {
                    elementTmp += this.data[i][k] * b.data[k][j];
                }
                a.data[i][j] = elementTmp;
                elementTmp = 0;
            }
        }
        return a;
    }
    
	// calcule le produit b*this de b avec la matrice courante si possible
    public Matrice produitADroite(Matrice b)  throws IllegalArgumentException {
    	//TODO
        if (b == null || this.nbLignes != b.nbColonnes) throw new IllegalArgumentException();
        return b.produitAGauche(this);
    }
	 
   // renvoie true si la matrice courante est carrée
	 public boolean carree(){
		//TODO
		 return nbColonnes == nbLignes;
    }
    
    // Calcule this^n. Lance une Mathexception si this n'est pas carrée
    public Matrice puissance(int n) throws  IllegalArgumentException {
    	//TODO
        if (!this.carree()) throw new MathException();
        if (n < 0) throw new IllegalArgumentException();
        if (n == 1) return new Matrice(this);
        if (n == 0) return identite(nbLignes);
        Matrice matrice = new Matrice(this);
        for (int i = 0; i < n - 1; i++) {
            matrice = matrice.produitADroite(this);
        }
        return matrice;
    }
    
	//Calcule this^T : la tranposée de this
	public Matrice transposee() {
		//TODO
        Matrice tp = new Matrice(nbColonnes, nbLignes);
        for (int i = 0; i < tp.nbLignes; i++) {
            for (int j = 0; j < tp.nbColonnes; j++) {
                tp.data[i][j] = data[j][i];
            }
        }
        return tp;
	}
	 
    // affiche la matrice en format standard
    public String toString(){
    	//TODO
        String text = "";
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                text += data[i][j] + "      ";
            }
            text += "\n";
        }
        return text;
    }

    public Matrice pageRank() {
        // A FAIRE QUAND MARKOV AURA ÉTÉ VU
        return null ;
    }
  }   
