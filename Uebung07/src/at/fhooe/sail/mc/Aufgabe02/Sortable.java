package at.fhooe.sail.mc.Aufgabe02;

import at.fhooe.sail.mc.Exceptions.InvalidAccessException;

public interface Sortable<T extends Comparable<T>> {
	
	 // Insert one element into the Sortable and do so either in ascending
	 // or descending fashion
	 public void insertSorted(T value, boolean ascending) throws InvalidAccessException;
	 
	 // Create a new Sortable which is guaranteed to be sorted ascending
	 public Sortable<T> sortAscending();
	 
	 // Create a new Sortable which is guaranteed to be sorted descending
	 public Sortable<T> sortDescending();
	}