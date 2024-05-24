package at.fhooe.sail.mc.Aufgabe02;

public abstract class AbstractMember implements Comparable<AbstractMember> {
	// of the member
	public String name;

	//constructor for the member
	public AbstractMember(String name) {
		this.name = name;
	}

	//abstract methods for getting the income and cost of the member that have to be implemented by the subclasses
	public abstract double getIncome();

	
	//abstract methods for getting the income and cost of the member that have to be implemented by the subclasses
	public abstract double getCost();

	//method for getting the surplus of the member
	public double getSurplus() {
		return getIncome() - getCost();
	}
	
	@Override
	//standard toString method calling the toString method with the parameter true
	public String toString() {
		return toString(true);
	}
	
	//method for getting the string representation of the member with the parameter for the ascending order
	public String toString(boolean ascending) {
		StringBuilder builder = new StringBuilder();
		builder.append("name: " + name + ", Income: " + getIncome() + ", Cost: " + getCost() + ", Surplus: " + getSurplus() + "\n");
		return builder.toString();
	}

	@Override
	//method for comparing two members by their name
	public int compareTo(AbstractMember o) {
		return this.name.compareTo(o.name);
	}

}
