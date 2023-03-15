/**
 *
 * @author Brandon Van Bellinghen
 *
 */
public class ConnexionInfo {
   
 	Ensemble<LoginInfo> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
 	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGININFO
 	
 	public ConnexionInfo(){
		// TODO
		ensembleDesConnectes = new EnsembleTableBooleens<LoginInfo>(666);
	}
 	
 	public	int nombreDeConnectes(){
 		return ensembleDesConnectes.taille();
 		// TODO

	}

 	// ajoute le loginInfo s'il n'est pas encore connecte
	public boolean connecter(LoginInfo loginInfo){
		 if (ensembleDesConnectes.contient(loginInfo)){
			 return false;
		 }
		 ensembleDesConnectes.ajouter(loginInfo);
		return true;
		// TODO

	}

	// retire le loginInfo s'il est connecte
	public boolean deconnecter(LoginInfo loginInfo){
		if (!ensembleDesConnectes.contient(loginInfo)){
			return false;
		}
		ensembleDesConnectes.enlever(loginInfo);
		return true;
		// TODO
	}

	public boolean estConnecte(LoginInfo loginInfo){
		 if (ensembleDesConnectes.contient(loginInfo)){
			 return true;
		 }
		return false;
		// TODO

	}
	

}