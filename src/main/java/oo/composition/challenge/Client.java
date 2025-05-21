package oo.composition.challenge;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {
	
	private String name;
	
	private List<Purchase> purchases = new ArrayList<>();
	
	Client(String name) {
		this.name = name;
	}
	
	void addPurchase(Purchase purchases) {
		getPurchases().add(purchases);
	}
	
	void addPurchases(List<Purchase> purchases) {
		getPurchases().addAll(purchases);
	}
	
	double getTotal() {
		return getPurchases().stream().mapToDouble(p -> p.getTotal()).sum();
	}
	
	Map<LocalDate, Double> getTotalByDate() {
		return getPurchases().stream()
				.collect(Collectors.groupingBy(Purchase::getPurchaseDate,
						Collectors.summingDouble(Purchase::getTotal)));
	}
	
	Map<Pair<Year, Month>, Double> getTotalByYearAndMonth() {
		return getPurchases().stream()
				.collect(Collectors.groupingBy(
						p -> new ImmutablePair<>(p.getPurchaseYear(), p.getPurchaseMonth()),
						Collectors.summingDouble(Purchase::getTotal)));
	}
	
	Map<YearMonth, Double> getTotalByYearMonth(Year year, Month month) {
		return getPurchases().stream().filter(
				p -> p.getPurchaseYear().equals(year) && p.getPurchaseMonth().equals(month))
				.collect(Collectors.groupingBy(p -> year.atMonth(month),
						Collectors.summingDouble(Purchase::getTotal)));
	}
	
	double getTotalByYearAndMonth(Year year, Month month) {
		return getPurchases().stream().filter(
				p -> p.getPurchaseYear().equals(year) && p.getPurchaseMonth().equals(month))
				.collect(Collectors.summingDouble(Purchase::getTotal));
	}
	
}
