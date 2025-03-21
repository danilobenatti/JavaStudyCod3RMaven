package control_structure;

import java.io.PrintWriter;

public class StructureFor {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		for (int i = 0; i < 10; i++) {
			if (i >= 5)
				break; // Avoid this option
			for (int j = 0; j < 10; j++) {
				if (j % 2 == 1)
					continue; // Avoid this option
				console.printf("[i=%d j=%d]", i, j);
			}
			console.println();
		}
		
		console.println();
		
		for (int i = 0; i < 5; i++) {
			if (i > 2)
				break; // Avoid this option
			external: for (int j = 0; j < 5; j++) {
				if (j >= 5)
					continue external; // Avoid this option
				console.printf("[i=%d j=%d]", i, j);
			}
			console.println();
		}
	}
	
}
