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

public class Client {
	
	String name;
	
	List<Purchase> purchases = new ArrayList<>();
	
	Client(String name) {
		this.name = name;
	}
	
	void addPurchase(Purchase purchases) {
		this.purchases.add(purchases);
	}
	
	void addPurchases(List<Purchase> purchases) {
		this.purchases.addAll(purchases);
	}
	
	double getTotal() {
		return this.purchases.stream().mapToDouble(p -> p.getTotal()).sum();
	}
	
	Map<LocalDate, Double> getTotalByDate() {
		return this.purchases.stream()
				.collect(Collectors.groupingBy(Purchase::getDate,
						Collectors.summingDouble(Purchase::getTotal)));
	}
	
	Map<Pair<Year, Month>, Double> getTotalByYearAndMonth() {
		return this.purchases.stream()
				.collect(Collectors.groupingBy(
						p -> new ImmutablePair<>(p.getYear(), p.getMonth()),
						Collectors.summingDouble(Purchase::getTotal)));
	}
	
	Map<YearMonth, Double> getTotalByYearMonth(Year year, Month month) {
		return this.purchases.stream().filter(
				p -> p.getYear().equals(year) && p.getMonth().equals(month))
				.collect(Collectors.groupingBy(p -> year.atMonth(month),
						Collectors.summingDouble(Purchase::getTotal)));
	}
	
	double getTotalByYearAndMonth(Year year, Month month) {
		return this.purchases.stream().filter(
				p -> p.getYear().equals(year) && p.getMonth().equals(month))
				.collect(Collectors.summingDouble(Purchase::getTotal));
	}
}
