package entities;

public class Champion {
	private String name;
	private int life;
	private int attack;
	private int armor;
	
	//construtor padrao
	public Champion () {}
	
	//sobrecarga de construtor; construtor com parametros
	public Champion(String name, int life, int attack, int armor) {
		this.name = name;
		this.life = life;
		this.attack = attack;
		this.armor = armor;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getArmor() {
		return armor;
	}
	
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	/*
	 * A regra para um campeao A receber dano de outro campeão B é a seguinte:
		
		1) A quantidade de vida do campeão A deve ser decrescida da quantidade de ataque do campeão B, 
		descontada a quantidade de armadura do campeão A. 
		A quantidade de vida resultante não pode ser menor que zero.
		
		2) Independente da quantidade de armadura do campeão A, pelo menos 1 de vida o campeão A deve perder.
	*/
	public void takeDamage(Champion other) {
		this.life = this.life - other.attack + this.armor;
	}
	
	public String status() {
		String statusText = " de vida";
		
		statusText += this.life >0 ? "" : " (morreu)";
		
		return this.name + ": " + this.life + statusText;
	}

}
