package at.fhooe.sail.mc.Uebung05.Aufgabe02;

public class Trainer extends ActiveMember{

	public Trainer(String name, int activityLevel) {
		super(name, activityLevel);
	}

	@Override
	public double getIncome() {
		return 10 * 12;
	}

	@Override
	public double getCost() {
		return activityLevel * 40;
	}
}
