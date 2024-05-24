package at.fhooe.sail.mc.Uebung05.Aufgabe02;

public class SupportingMember extends AbstractMember {

	// Constructor
	public SupportingMember(String name) {
		super(name);
	}

	@Override
	public double getIncome() {
		return 100;
	}

	@Override
	public double getCost() {
		return 15;
	}
}
