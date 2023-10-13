import java.util.Arrays;

// implementation de l'interface File via une table circulaire

/**
 * @author
 *
 */

public class FileImplViaTable<E> implements File<E>{

	private Object[] table;  // ne modifiez pas cet identifiant, la classe test l'utilise					
	private int indiceTete;  // ne modifiez pas cet identifiant, la classe test l'utilise			
	private int taille;		// ne modifiez pas cet identifiant, la classe test l'utilise	
	// N'ajoutez pas d'autres attributs, la classe test risquerait de ne pas fonctionner


	public FileImplViaTable(){
		table = new Object[4];
		taille = 0;
		indiceTete = 0;
	}


	public boolean estVide(){
		return taille == 0;
	}


	public int taille(){
		return taille;
	}

	public E premier()throws FileVideException{
		if (estVide()){
			throw new FileVideException();
		}
		E temp = (E) table[indiceTete];
		return temp;
		//TODO

	}


	public E defile() throws FileVideException{
		if (estVide()){
			throw new FileVideException();
		}
		this.taille--;
		E temp = (E) table[indiceTete];
		this.indiceTete++;
		if (indiceTete == table.length){
			indiceTete = 0;
		}
		return temp;
		//TODO
	}


	public void enfile(E element){
		//TODO
		if (table.length == taille){
			E[] tableTailleDouble = (E[]) new Object[table.length * 2];
			for (int i = 0; i < table.length ; i++) {
				tableTailleDouble[i] = (E) table[indiceTete % taille];
				this.indiceTete++;
			}
			indiceTete = 0;
			table = tableTailleDouble;
		}
		table[(indiceTete + taille) % table.length] = element;
		taille++;
	}

} 
