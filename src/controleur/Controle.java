package controleur;

import java.util.ArrayList;

import modele.Carre;
import modele.Forme;
import modele.Rond;
import vue.FrmFormes;

public class Controle {
	//propri�t�s
	private FrmFormes frmFormes;
	private ArrayList lesFormes = new ArrayList<Forme>();
	
	public static void main(String[] args) {
		 new Controle();
	}
	
	/**
	 * Demande de la vue pour obtenir p�rim�tre et surface de la forme
	 * @param typeForme "carre" ou "rond"
	 * @param valeur rayon ou c�t�
	 */
	public void demandeFrmFormesValeurs(String typeForme, float valeur) {
		Forme uneForme;
		if (typeForme == "carr�") {
			uneForme = new Carre(valeur);
			frmFormes.afficheResultCarre(uneForme.perimetre(),uneForme.surface());
		}else{
			uneForme = new Rond(valeur);
			frmFormes.afficheResultRond(uneForme.perimetre(), uneForme.surface());
		}
		//ajout de la nouvelle forme dans la collection
		lesFormes.add(uneForme);
		//demande � la vue de remplir la liste de formes
		frmFormes.majLstFormes(lesFormes);
	}
	
	/**
	 * suppression d'une forme
	 * @param indice
	 */
	public void demandeFrmFormesDel(int indice) {
		//suppression dans la collection
		lesFormes.remove(indice);
		//demande de mise � jour de liste
		frmFormes.majLstFormes(lesFormes);
	}
	/**
	 * Constructeur
	 */
	
	public Controle() {
		frmFormes = new FrmFormes(this);
		frmFormes.setVisible(true);
	}
	
	

}
 