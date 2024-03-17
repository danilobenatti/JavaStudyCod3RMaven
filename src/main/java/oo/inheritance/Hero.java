package oo.inheritance;

public class Hero extends Player {
	
	Hero(int x, int y) {
		super(x, y);
	}
	
	@Override
	boolean atack(Player otherPlayer) {
		boolean atack1 = super.atack(otherPlayer);
		boolean atack2 = super.atack(otherPlayer);
		boolean atack3 = super.atack(otherPlayer);
		return atack1 || atack2 || atack3;
	}
	
}
