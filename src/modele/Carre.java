package modele;

public class Carre implements Forme{
	
	//propriétés
	private float cote;
	
	public Carre(float cote) {
		this.cote = cote;
	}

	@Override
	public float perimetre() {
		return this.cote*4;
	}

	@Override
	public float surface() {
		return this.cote*this.cote;
	}
	
	public float getCote() {
		return this.cote;
	}

}
