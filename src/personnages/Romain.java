package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain (String nom, int force) {
		this.nom = nom;
		assert force > 0;
		this.force = force;
	}
	
	public int getForce() {
		return force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "Â« " + texte + "Â»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			}
			// post condition la force a diminuée
			assert force < oldForce;
			return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			 texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			 for (int i = 0; i < nbEquipement; i++) {
				 if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					 resistanceEquipement += 8;
				 } else {
					 System.out.println("Equipement casque");
					 resistanceEquipement += 5;
				 }
			 }
			 texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		nbEquipement = 0;
		return equipementEjecte;
	}

		

	
	public void sEquiper(Equipement equipementDuSoldat) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est deja bien protege !");
			break;
		case 1:
			if (equipements[0] == equipementDuSoldat) {
				System.out.println("Le soldat " + nom + " possede deja un " + equipementDuSoldat + ".");
			} else {
				equipements[1] = equipementDuSoldat;
				nbEquipement++;
				System.out.println("Le soldat " + nom + " s'equipe avec un " + equipementDuSoldat + ".");
			}
			break;
		default:
			equipements[0] = equipementDuSoldat;
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
