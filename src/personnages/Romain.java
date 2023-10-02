package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipement = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain (String nom, int force) {
		this.nom = nom;
		assert force > 0;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int forceInitial = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe !");
		} else {
			parler("J'abandonne...");
		}
		assert force < forceInitial;
	}
	
	public void sEquiper(Equipement equipementDuSoldat) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est deja bien protege !");
			break;
		case 1:
			if (equipement[0] == equipementDuSoldat) {
				System.out.println("Le soldat " + nom + " possede deja un " + equipementDuSoldat + ".");
			} else {
				equipement[1] = equipementDuSoldat;
				nbEquipement++;
				System.out.println("Le soldat " + nom + " s'equipe avec un " + equipementDuSoldat + ".");
			}
			break;
		case 0:
			equipement[0] = equipementDuSoldat;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'equipe avec un " + equipementDuSoldat + ".");
		}
	}
	
	public static void main(String[] args) {
		Romain test2 = new Romain("Test", 3);
		test2.parler("Je test parler et prendreParole");
		test2.recevoirCoup(6);
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		test2.sEquiper(Equipement.CASQUE);
		test2.sEquiper(Equipement.CASQUE);
		test2.sEquiper(Equipement.BOUCLIER);
		test2.sEquiper(Equipement.CASQUE);

	}

}
