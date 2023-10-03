package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement [] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		if (effetPotion > 1) {
			parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
		}
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//				+ romain.getNom());
//		romain.recevoirCoup(force * effetPotion / 3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement [] trophees2 = romain.recevoirCoup((force / 3) *effetPotion);
		for (int i = 0; trophees2 != null && i < trophees2.length; i++) {
			if (trophees2 != null) {
				nbTrophees++;
			}
			this.trophees[nbTrophees] = trophees2[i];
		}
	}

	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]"; 
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
		Romain test = new Romain("test", 2);
		asterix.parler("Je teste ma methode parler et prendreParole");
		asterix.frapper(test);
		asterix.boirePotion(6);
		
	}
}