package exercise1;

public class Player {
	private Weapon weapon;
	
	
	public Player(){
	}
	
	public Player(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
//	무기를 사용할때 호출하는 메소드를 지정
	public void usePlayerWeapon() {
		weapon.useWeapon();
	}
	
	
	
	
	
}
