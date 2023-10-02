package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois [] villageois;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numeroVillageois) {
		return villageois[numeroVillageois];
	}
	
	public static void afficherVillageois(Village village) {
		System.out.println("Dans village du chef " + village.chef.getNom() + " vivent les l�gendaires gaulois :");
		for (int i = 0; i < village.nbVillageois; i++) {
			System.out.println("- " + village.trouverHabitant(i).getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles", 30);
		// Gaulois gaulois = village.trouverHabitant(1);
		// Il n'y a toujours pas d'habitant dans le village
		Chef chef = new Chef("Abraracourcix", 6, village);
		village.setChef(chef);
		Gaulois gaulois0 = new Gaulois("Ast�rix", 8);
		village.ajouterHabitant(gaulois0);
		// Gaulois gaulois = village.trouverHabitant(1);
		// System.out.println(gaulois);
		// Gaulois n'est pas un string our qu'il puisse l'afficher il faut print le nom du chef
		Gaulois gaulois1 = new Gaulois("Ob�lix", 25);
		village.ajouterHabitant(gaulois1);
		afficherVillageois(village);
	}
}
