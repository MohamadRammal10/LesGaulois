package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {


	public static void main(String[] args) {
		/*
		 * Gaulois asterix = new Gaulois("Astérix", 8); Romain minus = new
		 * Romain("Minus", 6); asterix.parler("Bonjour à tous");
		 * minus.parler("UN GAU... UN GAUGAU..."); asterix.frapper(minus);
		 * asterix.frapper(minus); asterix.frapper(minus);
		 */
		
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion(6);
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
	}

}
