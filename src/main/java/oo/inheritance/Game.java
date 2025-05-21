package oo.inheritance;

import java.io.PrintWriter;

public class Game {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Villain villain = new Villain();
		villain.x = 10;
		villain.y = 10;
		
		Player hero = new Hero(10, 11);
		
		console.println(info(villain));
		console.println(info(hero));
		
		villain.atack(hero);
		hero.atack(villain);
		
		villain.atack(hero);
		hero.atack(villain);
		
		villain.walk(Direction.NORTH);
		villain.atack(hero);
		hero.atack(villain);
		hero.walk(Direction.EAST);
		
		console.println(info(villain));
		console.println(info(hero));
		
		console.close();
	}
	
	private static String info(Player player) {
		String msg = "%s Life(Position): %d(%d, %d)";
		return switch (player) {
			case Hero h -> String.format(msg, "Hero", h.life, h.x, h.y);
			case Villain v -> String.format(msg, "Villain", v.life, v.x, v.y);
			default -> throw new IllegalArgumentException(
					"Unexpected value: " + player);
		};
	}
	
}
