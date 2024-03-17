package beginners_level;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class RelationalOperators {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(RelationalOperators.class.getName(),
				"./src/util/log4j.properties");
		
		int a = 97;
		int b = 'a';
		log.info(a == b);
		
		log.info(3 > 4);
		log.info(30 != 7);
		log.info(3 >= (1 + 2));
		log.info(3 < 7);
		log.info(30 <= 7);
		
		double grade = Double.parseDouble(showInputDialog("Inform grade:"));
		boolean goodBehavior = showConfirmDialog(null, "Have good behavior?",
				"Behavior", JOptionPane.YES_NO_OPTION) == 0;
		boolean reachedAverage = grade >= 7.0;
		boolean willHaveDiscount = goodBehavior && reachedAverage;
		
		String result = willHaveDiscount ? "Yes" : "No";
		
		showMessageDialog(null,
				new StringBuilder().append("Will have a discount? ")
						.append(result),
				"Discount",
				willHaveDiscount ? INFORMATION_MESSAGE : WARNING_MESSAGE);
		
		log.info(() -> "Will have a discount? " + result);
	}
	
}
