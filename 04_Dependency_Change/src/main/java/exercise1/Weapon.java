package exercise1;

public interface Weapon {
	void useWeapon();
}

class Knife implements Weapon{
	public void useWeapon() {
		System.out.println("Use Knife");
	}
}

class Gun implements Weapon{
	public void useWeapon() {
		System.out.println("Use Gun");
	}
}


class Spike implements Weapon{
	public void useWeapon() {
		System.out.println("Use Spike");
	}
}