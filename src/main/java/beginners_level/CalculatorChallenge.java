package beginners_level;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.join;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.fraction.Fraction;

import lombok.Getter;

public class CalculatorChallenge {
	
	public static void main(String[] args) {
		
		Operation[] operations = { Operation.ADD, Operation.SUB, Operation.MULT, Operation.DIV };
		
		Operation op = (Operation) showInputDialog(null, "Select an operation",
				"Operation", QUESTION_MESSAGE, null, operations, Operation.ADD);
		
		var n1 = new BigDecimal(showInputDialog(null, "Info 1º number",
				"1º Number", QUESTION_MESSAGE).replace(',', '.'));
		
		var n2 = new BigDecimal(showInputDialog(null, "Info 2º number",
				"2º Number", QUESTION_MESSAGE).replace(',', '.'));
		
		BigDecimal rs = switch (op.getCode()) {
			case 0 -> n1.add(n2);
			case 1 -> n1.subtract(n2);
			case 2 -> n1.multiply(n2);
			case 3 -> n1.divide(n2, 10, RoundingMode.HALF_EVEN);
			default -> BigDecimal.ZERO;
		};
		Object[] operation = { n1, op.getSymbol(), n2, "=", rs };
		
		StringBuilder sb = new StringBuilder();
		sb.append("Code: ").append(op.getCode()).append(LF);
		sb.append("Description: ").append(op.getDescription()).append(LF);
		sb.append("Symbol: ").append(op.getSymbol()).append(LF);
		sb.append("Operation: ").append(join(operation, SPACE)).append(LF);
		sb.append("Result: ").append(String.format(Locale.of("pt", "BR"), "%.3f", rs));
		
		if (op == Operation.DIV) {
			Fraction fraction = new Fraction(rs.doubleValue());
			
			int numerator = fraction.getNumerator();
			int denominator = fraction.getDenominator();
			
			BigDecimal num = BigDecimal.valueOf(numerator);
			BigDecimal den = BigDecimal.valueOf(denominator);
			
			BigDecimal[] divideAndRemainder = num.divideAndRemainder(den, MathContext.DECIMAL128);
			long quotient = divideAndRemainder[0].longValueExact();
			long remainder = divideAndRemainder[1].longValueExact();
			
			sb.append(SPACE).append("(");
			if (quotient != 0)
				sb.append(StringUtils.join(quotient, "\s"));
			sb.append(StringUtils.join(remainder, " / ", denominator));
			sb.append(")");
		}
		
		System.out.println(sb);
		showMessageDialog(null, sb);
		
	}
	
}

@Getter
enum Operation {
	ADD(0, "Addition", '\u002B'), SUB(1, "Subtraction", '\u002D'),
	MULT(2, "Multiplication", '\u00D7'), DIV(3, "Division", '\u00F7');
	
	private int code;
	private String description;
	private char symbol;
	
	private Operation(int code, String description, char symbol) {
		this.code = code;
		this.description = description;
		this.symbol = symbol;
	}
	
	public static Operation toEnum(int code) {
		for (Operation operation : Operation.values()) {
			if (code == operation.getCode()) {
				return operation;
			}
		}
		throw new IllegalArgumentException("Invalid code operation: " + code);
	}
	
	@Override
	public String toString() {
		/**
		 * this.name().toLowerCase();
		 */
		return String.format("%s (%c)", getDescription(), getSymbol());
	}
}
