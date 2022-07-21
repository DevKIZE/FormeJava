package modele;

public class Rond implements Forme{
	
	//propriétés
	private float rayon;
	
	/**
	 * constructeur
	 * @param rayon
	 */
	public Rond(float rayon) {
		this.rayon = rayon;
	}

	@Override
	public float perimetre() {
		return (float)(2*Math.PI*this.rayon);
	}

	@Override
	public float surface() {
		return (float)(Math.PI*this.rayon*this.rayon);
	}
	
	/**
	 * getter sur rayon
	 * @return rayon
	 */
	public float getRayon() {
		return this.rayon;
	}
	

}
