package org.openjfx.AnimalPopIt;

public class Player {	/**
	 * Clase jugador
	 */
	private String namePlayer;
	private int nivelAlcanzado =0;	
	private  int lives =3;

	Player(String namePlayer){
		namePlayer = namePlayer.substring(0,1).toUpperCase() + namePlayer.substring(1);
		this.namePlayer = namePlayer;		
	}
	/**
	 * obtiene el nombre del jugador
	 * @return nombre del jugador
	 */
	protected String getNamePlayer() {
		return namePlayer;
	}
	/**
	 * obtiene  las vidas del jugador
	 * @return vidas del jugador
	 */
	protected int getLives() {
		return lives;
	}
	/**
	 * asigna las vidas del jugador
	 * @return asigna del jugador
	 */
	protected void setLivesLess() {
		lives--;
	}
	/**
	 * obtiene el nivel alcanzado por el jugador
	 * @return nivel alcanzado del jugador
	 */
	protected int getNivelAlcanzado() {
		return nivelAlcanzado;
	}
	/**
	 * asigna el nivel alcanzado por el jugador
	 * @return asigna nivel alcanzado por el jugador
	 */
	protected void setNivelAlcanzado(int nivelAlcanzado) {
		this.nivelAlcanzado = nivelAlcanzado;
	}
}