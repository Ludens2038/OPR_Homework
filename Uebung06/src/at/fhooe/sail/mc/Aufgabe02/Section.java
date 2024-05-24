package at.fhooe.sail.mc.Aufgabe02;

import at.fhooe.sail.mc.Aufgabe01Exceptions.ValueException;

//subclass of the abstract member for sections
public class Section extends AbstractMember {
	private static int indent = 0;

	// binary search tree to store the members of the section in a sorted order
	private BinarySearchTree<AbstractMember> tree = new BinarySearchTree();

	// constructor of the section
	public Section(String name) {
		super(name);
	}

	// method to add a member to the section
	public boolean addMember(AbstractMember m) {
		// calling the insert method of the binary search tree to add the member
		try {
			return tree.insert(m);
		} catch (ValueException e) {
			System.out.print(e.toString());
			return false;
		}
	}

	// method to remove a member from the section
	public boolean removeMember(AbstractMember m) {
		// calling the remove method of the binary search tree to remove the member
		try {
			return tree.remove(m);
		} catch (ValueException e) {
			System.out.print(e.toString());
			return false;
		}
	}

	// method to check if a member is a member of the section
	public boolean isMember(AbstractMember m) {
		// calling the find method of the binary search tree to check if the member is a
		// member of the section
		try {
			return tree.find(m);
		} catch (ValueException e) {
			System.out.print(e.toString());
			return false;
		}
	}

	@Override
	// overriding the method of the abstract member to get the income of the section
	public double getIncome() {
		// calling the toArray method of the binary search tree to get the members of
		// the section
		Comparable<AbstractMember>[] member = tree.toArray(true);
		double income = 0.0;
		// iterating through the members of the section and adding their income
		for (int i = 0; i < member.length; i++) {
			// casting the member to an abstract member and calling the getIncome method
			income += ((AbstractMember) member[i]).getIncome();
		}
		return income;
	}

	@Override
	// overriding the method of the abstract member to get the cost of the section
	public double getCost() {
		// calling the toArray method of the binary search tree to get the members of
		// the section
		Comparable<AbstractMember>[] member = tree.toArray(true);
		double cost = 0.0;
		// iterating through the members of the section and adding their cost
		for (int i = 0; i < member.length; i++) {
			// casting the member to an abstract member and calling the getCost method
			cost += ((AbstractMember) member[i]).getCost();
		}
		return cost;
	}

	@Override
	// override the toString method of the abstract member to get the string
	// representation of the section
	// kind of readable
	public String toString(boolean sorted) {
		Comparable<AbstractMember>[] member = tree.toArray(sorted);
		StringBuilder builder = new StringBuilder();
		builder.append("Union: " + name + ", Income: " + getIncome() + ", Cost: " + getCost() + ", Surplus: "
				+ getSurplus() + "\n");

		// iterating through the members of the section and adding their string
		// representation
		for (int i = 0; i < member.length; i++) {
			// checking if the member is a section or an abstract member
			if (member[i] instanceof Section) {
				indent++;
				builder.append(getIndent() + ((Section) member[i]).toString(sorted));
				indent--;
			} else {
				indent++;
				builder.append(getIndent() + ((AbstractMember) member[i]).toString(true));
				indent--;
			}
		}

		return builder.toString();
	}

	// method to get the indent for the string representation
	private String getIndent() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < indent; i++) {
			builder.append("  ");
		}
		return builder.toString();
	}
}