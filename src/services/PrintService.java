package services;

import java.util.ArrayList;
import java.util.List;

public class PrintService {

	protected Integer n;
	protected Integer addNumber;

	public PrintService(int n) {
		this.n = n;
	}

	List<Integer> numbers = new ArrayList<>();

	public List<Integer> getNumbers() {
		return numbers;
	}

	public PrintService(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public void addValue(int n, int addNumber) {
		numbers.add(addNumber);
	}

	public Integer first() {
		if (numbers.isEmpty()) {
			throw new IllegalStateException("List is empty");
		} 
		return numbers.get(0);
		
	}

	public void print() {
		numbers.toArray().toString();
	}
}
