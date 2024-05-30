package at.fhooe.sail.Lambdas;

import java.util.Comparator;

import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import at.fhhgb.mc.opr.backblazedata.model.HardDisk;

public class DataProcessorStream {

	private List<HardDisk> hardDisk;

	public DataProcessorStream(Vector<HardDisk> hardDisks) {
		this.hardDisk = new Vector<>(hardDisks);
	}

	// Can use Vector.sort internally, sorts the internal Vector
	public void sort(Comparator<HardDisk> comparator) {
		hardDisk.sort(comparator);
	}

	// Returns size of the internal vector
	public long count() {
		return hardDisk.size();
	}

	// Returns a Vector of HardDisks filtered by predicate
	public Vector<HardDisk> filter(Predicate<HardDisk> predicate) {
		return hardDisk.stream().filter(predicate).collect(Collectors.toCollection(() -> new Vector<>()));
	}

	// Returns the HardDisk with a specified maximum value
	public HardDisk max(Comparator<HardDisk> comparator) {
		return hardDisk.stream().max(comparator).get();
	}

	// Returns the HardDisk with a specified minimum value
	public HardDisk min(Comparator<HardDisk> comparator) {
		return hardDisk.stream().min(comparator).get();
	}

	// Returns a mean value specified by the function
	public double mean(Function<HardDisk, Long> function) {
		return hardDisk.stream().mapToLong(hardDisk -> function.apply(hardDisk)).average().getAsDouble();
	}

	// Returns a median value specified by the function
	public long median(Comparator<HardDisk> sortingComparator, Function<HardDisk, Long> function) {
		List<HardDisk> sortedList = hardDisk.stream().sorted(sortingComparator).collect(Collectors.toList());
		int size = sortedList.size();
		if (size % 2 == 0) {
			return (function.apply(sortedList.get(size / 2)) + function.apply(sortedList.get(size / 2 + 1))) / 2;
		} else {
			return function.apply(sortedList.get(size / 2 + 1));
		}
	}

	// Counts distinct values based on the given HardDisk-to-String mapping function
	public long countDistinctStrings(Function<HardDisk, String> function) {
		return hardDisk.stream().map(function).distinct().count();
	}
}
