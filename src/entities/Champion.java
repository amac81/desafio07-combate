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
	
	public void takeDamage(Champion other) {
		
		int dano = other.getAttack() - this.armor;

		//pelo menos 1 de vida deve perder
		this.life = (dano <= 0) ? this.life -1 : ((this.life - dano > 0) ? this.life - dano : 0);
		
		//pelo menos 1 de vida deve perder
		/*if (dano <= 0) 
		{
			this.life --;
		}
		else {

			if(this.life - dano > 0) {
				this.life -= dano;			
			}
			else {
				this.life = 0;
			}	
		}*/
		
	}
	
	public String status() {
		String statusText = " de vida";		
		statusText += this.life >0 ? "" : " (morreu)";		
		return this.name + ": " + this.life + statusText;	
	}

}
