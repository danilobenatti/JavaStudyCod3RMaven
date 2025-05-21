package model;

import java.text.DateFormat;
import java.time.Instant;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	
	private static final Locale LOCALE = Locale.getDefault();
	
	private static final ZoneId SYSTEM_DEFAULT = ZoneId.systemDefault();
	
	private String name;
	
	private double price;
	
	private double discount = 0.1;
	
	private double shippingCost;
	
	private float weight;
	
	private float xSide;
	
	private float ySide;
	
	private float zSide;
	
	private float[] sides = new float[] { this.xSide, this.ySide, this.zSide };
	
	private Date manufactureDate;
	
	private Date validityDate;
	
	public Product() {
		this(1, 1, 1);
	}
	
	public Product(float x, float y, float z) {
		this.xSide = x;
		this.ySide = y;
		this.zSide = z;
		this.sides = new float[] { this.xSide, this.ySide, this.zSide };
	}
	
	public Product(String name, double price, double discount,
			double shippingCost, float weight, float[] sides,
			Date manufactureDate, Date validityDate) {
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.shippingCost = shippingCost;
		this.weight = weight;
		this.sides = sides;
		this.manufactureDate = manufactureDate;
		this.validityDate = validityDate;
	}
	
	public Product(String name, double price, float weight, double shippingCost,
			float[] sides, Date manufactureDate, Date validityDate) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.shippingCost = shippingCost;
		this.sides = sides;
		this.manufactureDate = manufactureDate;
		this.validityDate = validityDate;
	}
	
	public Product(String name, double price, double discount,
			double shippingCost, float weight) {
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.shippingCost = shippingCost;
		this.weight = weight;
	}
	
	public double getPriceWithDiscount() {
		return this.price * (1 - this.discount);
	}
	
	public double getPriceWithDiscount(double addDiscount) {
		return getPriceWithDiscount() * (1 - addDiscount);
	}
	
	/**
	 * @deprecated new code
	 * @param days
	 */
	@Deprecated(since = "1.0", forRemoval = true)
	public void setValidityDate(long days) {
		// assume that 1 day = 8,64e+7 milliseconds
		final double oneDayMilli = 8.64E7;
		this.validityDate = new Date(
				(long) (this.manufactureDate.getTime() + (days * oneDayMilli)));
	}
	
	public void setValidity(long days) {
		this.validityDate = Date.from(
				this.manufactureDate.toInstant().plus(days, ChronoUnit.DAYS));
	}
	
	/**
	 * @deprecated new code
	 * @param months
	 */
	@Deprecated(since = "1.0", forRemoval = true)
	public void setValidityDate(int months) {
		// assume that 1 month = 2,628e+9 milliseconds
		final double oneMonthMilli = 2.628E9;
		this.validityDate = new Date((long) (this.manufactureDate.getTime()
				+ (months * oneMonthMilli)));
	}
	
	public void setValidity(int months) {
		this.validityDate = Date.from(this.manufactureDate.toInstant()
				.atZone(SYSTEM_DEFAULT).plusMonths(months).toInstant());
		
	}
	
	public void setValidity(Year year) {
		this.validityDate = Date.from(this.manufactureDate.toInstant()
				.atZone(SYSTEM_DEFAULT).plusYears(year.getValue()).toInstant());
	}
	
	public Date getValidityDateByDays(long days) {
		return Date.from(
				this.manufactureDate.toInstant().plus(days, ChronoUnit.DAYS));
	}
	
	public Date getValidityDateByMonths(int months) {
		return Date.from(this.manufactureDate.toInstant().atZone(SYSTEM_DEFAULT)
				.plusMonths(months).toInstant());
	}
	
	public boolean validityDateIsOk() {
		if (this.validityDate != null)
			return Date.from(Instant.now().truncatedTo(ChronoUnit.DAYS))
					.before(this.validityDate);
		return false;
	}
	
	public void setVolume(float... side) {
		this.sides = new float[] { side[0], side[1], side[2] };
		this.xSide = this.sides[0];
		this.ySide = this.sides[1];
		this.zSide = this.sides[2];
	}
	
	public void setVolume(float x, float y, float z) {
		this.sides = new float[] { x, y, z };
		this.xSide = this.sides[0];
		this.ySide = this.sides[1];
		this.zSide = this.sides[2];
	}
	
	public float getVolume() {
		if (this.sides != null) {
			this.xSide = this.sides[0];
			this.ySide = this.sides[1];
			this.zSide = this.sides[2];
		}
		return this.xSide * this.ySide * this.zSide;
	}
	
	public float getVolume(float x, float y, float z) {
		if (this.sides != null) {
			this.xSide = this.sides[0];
			this.ySide = this.sides[1];
			this.zSide = this.sides[2];
		}
		return this.xSide * this.ySide * this.zSide;
	}
	
	public float getVolume(float... sides) {
		float volume = 1;
		for (float side : sides)
			volume *= side;
		return volume;
	}
	
	@Override
	public String toString() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, LOCALE);
		StringBuilder sb = new StringBuilder();
		sb.append("Product [name=");
		sb.append(this.name);
		sb.append(", price=");
		sb.append(this.price);
		sb.append(", discount=");
		sb.append(this.discount);
		sb.append(", shippingCost=");
		sb.append(this.shippingCost);
		sb.append(", weight=");
		sb.append(this.weight);
		sb.append(", sides=");
		sb.append(Arrays.toString(sides));
		sb.append(", manufactureDate=");
		sb.append(this.manufactureDate != null ? df.format(this.manufactureDate) : null);
		sb.append(", validityDate=");
		sb.append(this.validityDate != null ? df.format(this.validityDate) : null);
		sb.append(", validityDateIsOk=");
		sb.append(validityDateIsOk());
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name);
	}
	
}
