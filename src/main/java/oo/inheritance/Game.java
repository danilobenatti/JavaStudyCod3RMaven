package oo.inheritance;

public class Game {
	
	public static void main(String[] args) {
		
		var villain = new Villain();
		villain.x = 10;
		villain.y = 10;
		
		var hero = new Hero(10, 11);
		
		System.out.println(msg(villain));
		System.out.println(msg(hero));
		
		villain.atack(hero);
		hero.atack(villain);
		
		villain.atack(hero);
		hero.atack(villain);
		
		villain.walk(Direction.NORTH);
		villain.atack(hero);
		hero.atack(villain);
		
		System.out.println(msg(villain));
		System.out.println(msg(hero));
	}
	
	private static String msg(Player player) {
		return switch (player) {
			case Hero h -> String.format("Hero Life: %d", h.life);
			case Villain v -> String.format("Villain Life: %d", v.life);
			default -> throw new IllegalArgumentException(
					"Unexpected value: " + player);
		};
	}
	
}
