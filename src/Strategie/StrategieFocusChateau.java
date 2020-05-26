package Strategie;

import IG.Plateau;
import Perceptron.SparseVector;
import Troupes.*;
import java.util.ArrayList;

/**
 * Dans cette strat�gie les unites se dirigent toujours vers le chateau ennemi et attaquent des qu'un ennemi est a portee.
 * Les unites ne prennent pas en compte les positions des unites ennemies,
 *  elles se concentrent uniquement sur le chateau ennemi.
 * @author R�mi
 */

public class StrategieFocusChateau extends Strategie{
	
	public StrategieFocusChateau(Plateau plateau) {
		super(plateau);
	}
	
	/**
	 * M�thode qui retourne une action pour la troupe donn�e
	 * @param troupe
	 * @return TroupesAction
	 */
	
	public TroupesAction coup(Troupes troupe) {
		int x = troupe.getPosition().getX();
		int y = troupe.getPosition().getY();
		ArrayList<TroupesAction> coups = this.coupsPossibles(troupe);
		
		if(this.estPresent(TroupesAction.ATTACK1,coups)) {
			return TroupesAction.ATTACK1;
		}
		
		
		Coordonnees chateauEn = rechercheChateauEn(troupe);

		if(y == chateauEn.getY()) {
			if(x < chateauEn.getX() && estPresent(TroupesAction.RIGHT,coups)) return TroupesAction.RIGHT;
			if(x > chateauEn.getX() && estPresent(TroupesAction.LEFT,coups)) return TroupesAction.LEFT;
		}
		else if(y > chateauEn.getY()) {
			if(estPresent(TroupesAction.TOP,coups)) return TroupesAction.TOP;
			if(x < chateauEn.getX() && estPresent(TroupesAction.RIGHT,coups)) return TroupesAction.RIGHT;
			if(x > chateauEn.getX() && estPresent(TroupesAction.LEFT,coups)) return TroupesAction.LEFT;
		}
		else {
			if(estPresent(TroupesAction.BOTTOM,coups)) return TroupesAction.BOTTOM;
			if(x < chateauEn.getX() && estPresent(TroupesAction.RIGHT,coups)) return TroupesAction.RIGHT;
			if(x > chateauEn.getX() && estPresent(TroupesAction.LEFT,coups)) return TroupesAction.LEFT;
		}
		return TroupesAction.STOP;
		
		
	}
	
	/**
	 * M�thode qui retourne la position du ch�teau ennemi
	 * @param troupe
	 * @return Coordonnees
	 */
	
	public Coordonnees rechercheChateauEn(Troupes troupe) {
		ArrayList<Troupes> ennemi;
		if(this.estBleu(troupe))
			ennemi = this.getPlateau().getUnite_rouge();
		else
			ennemi = this.getPlateau().getUnite_bleue();
		
		for(Troupes unite : ennemi) {
			if(unite.getType() == "Chateau") {
				return unite.getPosition();
			}
		}
		System.out.println("Chateau non trouve");

		return null;
	}	
	
	public boolean estPerceptron() {return false;}
	
	public SparseVector encodageEtat(Plateau plateau, Troupes troupe) {return null;}	
	
}