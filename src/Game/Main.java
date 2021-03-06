package Game;

import IG.Plateau;
import Perceptron.IA;
import Strategie.StrategieType;


/**
 * Cette classe permet le d�marrage du jeu
 * @author Simon et R�mi
 */

public class Main {

	public static void main(String[] args) {
		
		Plateau plateau = new Plateau("src/Layout/Plateau.lay");
		IA perceptron = new IA();

		perceptron.vizualise(100,StrategieType.PERCEPTRON,StrategieType.RANDOM,plateau);
		//perceptron.getAverageReward(1000,10,StrategieType.PERCEPTRON,StrategieType.RANDOM,plateau);
	}
}