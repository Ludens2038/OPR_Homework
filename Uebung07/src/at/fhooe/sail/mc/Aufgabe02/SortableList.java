package at.fhooe.sail.mc.Aufgabe02;

import java.util.Collections;

import at.fhooe.sail.mc.Aufgabe01.RandomAccessDoubleLinkedList;
import at.fhooe.sail.mc.Exceptions.InvalidAccessException;

public class SortableList<T extends Comparable<T>> extends RandomAccessDoubleLinkedList<T> implements Sortable<T> {

	@Override
	public void insertSorted(T value, boolean ascending) throws InvalidAccessException {
		if (this.size() == 0) {
			super.add(value);
		} else if (ascending) {
			for (int i = 0; i < this.size(); i++) {
				if (this.elementAt(i).compareTo(value) > 0) {
					this.insertAt(i, value);
					return;
				}
			}
		} else {
			for (int i = 0; i < this.size(); i++) {
				if (this.elementAt(i).compareTo(value) < 0) {
					this.insertAt(i, value);
					return;
				}
			}
		}
		super.add(value);
	}

	@Override
	public Sortable<T> sortAscending() {
		if (this.isEmpty()) {
			return null;
		} else if (this.size() == 1) {
			return this;
		} else {
			Collections.sort(this);
			return this;
		}
	}

	@Override
	public Sortable<T> sortDescending() {
		if (this.isEmpty()) {
			return null;
		} else if (this.size() == 1) {
			return this;
		} else {
			Collections.sort(this, Collections.reverseOrder());
			return this;
		}
	}

	////////////////////////////////////////////////
	////////////////////////////////////////////////
	//// 										////
	////		 Antworten auf die Fragen 		////
	//// 										////
	////////////////////////////////////////////////
	////////////////////////////////////////////////

	/*
	 * Antworten auf die Fragen:
	 * Antwort 1: Wird die Methode add von ArrayListverwendt,
	 * 			  so wird das Element nicht sortiert eingefügt.
	 * 			  Was theoretisch sowie praktisch möglich wäre.
	 * Antwort 2: Da RandomAccessDoubleLinkedList keine toString() implementiert,
	 * 			  wird die toString von ArrayList verwendet, da
	 *  		  RandomAccessDoubleLinkedList von ihr erbt.
	 */
}