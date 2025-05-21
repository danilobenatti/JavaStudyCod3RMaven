package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.util.PersonUtil;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@SuperBuilder(builderMethodName = "customer")
public class Customer extends Person {
	
	@EqualsAndHashCode.Include
	private String email;
	
	@Builder.Default
	private boolean isGoodPayer = true;
	
	private LocalDate lastPurchaseDate;
	
	public int getAge() {
		return PersonUtil.getAge(this);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [");
		builder.append(super.getName());
		builder.append(", ");
		builder.append(super.getGender());
		builder.append(", ");
		builder.append(PersonUtil.getAgeWithSymbol(this));
		builder.append(", ");
		builder.append(email);
		builder.append(", ");
		builder.append(isGoodPayer);
		builder.append(", ");
		builder.append(lastPurchaseDate);
		builder.append("]");
		return builder.toString();
	}
	
}
