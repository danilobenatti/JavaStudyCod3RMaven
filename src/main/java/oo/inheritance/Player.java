package oo.inheritance;

public class Player {
	
	int life = 100;
	int x;
	int y;
	
	Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	boolean walk(Direction direction) {
		switch (direction) {
			case NORTH -> y--;
			case EAST -> x++;
			case SOUTH -> y++;
			case WEST -> x--;
		}
		return true;
	}
	
	boolean atack(Player otherPlayer) {
		
		int deltaX = Math.abs(x - otherPlayer.x);
		int deltaY = Math.abs(y - otherPlayer.y);
		
		if ((deltaX == 0 && deltaY == 1) || (deltaX == 1 && deltaY == 0)) {
			otherPlayer.life -= 10;
			return true;
		} else {
			return false;
		}
	}
}
