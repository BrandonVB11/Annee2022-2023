/**
 *
 * @author Brandon Van Bellinghen
 *
 */
public class Grille9X9 {

	private int[][] table;

	public Grille9X9(int[][] tableARecopier)throws IllegalArgumentException{
		if(tableARecopier==null)
			throw new IllegalArgumentException();
		if(tableARecopier.length!=9)
			throw new IllegalArgumentException();
		for(int i = 0;i<9;i++){
			if(tableARecopier[i]==null||tableARecopier[i].length!=9)throw new IllegalArgumentException();
		}
		table = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(tableARecopier [i][j]<1||tableARecopier[i][j]>9)throw new IllegalArgumentException();
				table[i][j]=tableARecopier[i][j];
			}
		}
	}

	private boolean ligneCorrecte(int ligne){
		ligne--;
		Ensemble1A9 ens = new Ensemble1A9();
		for (int i = 0; i < 9; i++) {
			if (!ens.ajouter(table[ligne][i]))
				return false;
		}
		return true;
	}

	private boolean colonneCorrecte(int colonne){
		colonne--;
		Ensemble1A9 ens = new Ensemble1A9();
		for (int i = 0; i < 9; i++) {
			if (!ens.ajouter(table[i][colonne]))
				return false;
		}
		return true;
	}

	// verifie le bloc qui commence a la ligne et a la colonne passees en parametre
	private boolean blocCorrect(int ligne, int colonne){
		ligne--;
		colonne--;
		Ensemble1A9 ens = new Ensemble1A9();
		for (int i = ligne; i < ligne+3; i++){
			for (int j = colonne; j < colonne+3; j++) {
				if (!ens.ajouter(table[i][j]))
					return false;
			}
		}
		return true;
	}




	public boolean estUnSudoku() {
		for (int i = 1; i <= 9; i++) {
			if (!ligneCorrecte(i))
				return false;
			if (!colonneCorrecte(i))
				return false;
		}
		// verif blocs
		// 1/1 1/4 1/7
		// 4/1 4/4 4/7
		// 7/1 7/4 7/7
		for (int i = 1; i <= 9; i += 3) {
			for (int j = 1; j <= 9; j += 3) {
				if (!blocCorrect(i, j))
					return false;
			}
		}
		// tout est bon
		return true;
	}

	public boolean estUnSudokuDiagonal(){
		Ensemble1A9 ens = new Ensemble1A9();
		for (int i = 0; i < 9; i++) {
			if (!ens.ajouter(table[i][i]))
				return false;
		}
		return true;
	}



	public boolean estUnHyperSudoku(){
		return blocCorrect(2,2);
	}



}
