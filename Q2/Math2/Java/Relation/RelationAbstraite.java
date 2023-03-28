import java.util.Iterator;

public abstract class RelationAbstraite implements RelationInterface {
	
	// Ex 3
	// renvoie true ssi this est inclus dans r
	public boolean inclusDans(RelationAbstraite r) {
		if (r == null || this == null)
			return false;
		if (!r.depart().equals(this.depart()) || !r.arrivee().equals(this.arrivee()))
			return false;
		if (!r.estVide() && this.estVide())
			return true;
		Iterator<Couple> iterator = this.iterator();
		for (Couple coupleTemp : this) {
			if (!r.contient(coupleTemp))
				return false;
		}
		return true;
	}

	// renvoie true ssi this est égale à o
	public boolean equals(Object o) {
		if (o== null) return false;
		if (o==this) return true;
		if (! (o instanceof RelationAbstraite)) return false;
		RelationAbstraite r = (RelationAbstraite) o;
		if (this.inclusDans(r) && r.inclusDans(this))
			return true;
		//TODO Vérifier que la relation courante est égale à r
		
		
		return false;
	}
	
	//renvoie un hashCode associé à la relation
	
	public int hashCode(){
		int hash = this.depart().hashCode();
		hash = hash * 31 + this.arrivee().hashCode();
		for (int i = 1; i <= MAX; i++) {
			Elt d = new Elt(i);
			if (this.depart().contient(d)){
				for (int j = 1; j <=MAX; j++ ){
					Elt a = new Elt(j);
					Couple c = new Couple(d,a);
					if (this.contient(c))
						hash = hash *31 + c.hashCode();
				}
			}
		}
		return hash;
	}
}
