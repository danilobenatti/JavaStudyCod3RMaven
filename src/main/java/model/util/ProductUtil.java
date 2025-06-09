package model.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import model.Product;

public class ProductUtil {
	
	public static double getPriceWithDiscount(Product p) {
		// 2 decimal places
		MathContext mc = new MathContext(2, RoundingMode.HALF_EVEN);
		
		BigDecimal price = new BigDecimal(p.getPrice());
		BigDecimal discount = new BigDecimal(p.getDiscount(), mc);
		
		return price.subtract(price.multiply(discount))
				.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
		// return Math.round((p.getPrice() * (1 - p.getDiscount())) * 100.0) / 100.0;
	}
	
	public static double getPriceWithDiscount(Product p, double addDiscount) {
		// 2 decimal places
		return Math.round((getPriceWithDiscount(p) * (1 - addDiscount)) * 100.0) / 100.0;
	}
	
	public void setValidity(Product p, long days) {
		p.setValidityDate(Date.from(p.getManufactureDate().toInstant()
				.plus(days, ChronoUnit.DAYS)));
	}
	
	public void setValidity(Product p, int months) {
		p.setValidityDate(Date.from(p.getManufactureDate().toInstant()
				.plus(months, ChronoUnit.MONTHS)));
		
	}
	
	public void setValidity(Product p, Year year) {
		p.setValidityDate(Date.from(p.getManufactureDate().toInstant()
				.plus(year.getValue(), ChronoUnit.YEARS)));
	}
}
