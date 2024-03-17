package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@SuperBuilder(builderMethodName = "customer")
public class Customer extends Person {
	
	@Include
	private String email;
	
	@Default
	private boolean isGoodPayer = true;
	
	private LocalDate lastPurchaseDate;
	
}
