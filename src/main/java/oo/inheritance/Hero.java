package oo.inheritance;

public class Hero extends Player {
	
	Hero(int x, int y) {
		super(x, y);
	}
	
	@Override
	boolean atack(Player other) {
		boolean atack1 = super.atack(other);
		boolean atack2 = super.atack(other);
		boolean atack3 = super.atack(other);
		return atack1 || atack2 || atack3;
	}
	
}
