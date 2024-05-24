package at.fhooe.sail.mc.Aufgabe02;

import at.fhooe.sail.mc.Aufgabe01Exceptions.ValueException;

public class Trainer extends ActiveMember{

	public Trainer(String name, int activityLevel) throws ValueException {
		super(name, activityLevel);
	}

	@Override
	public double getIncome() {
		return 10 * 12;
	}

	@Override
	public double getCost() {
		return activityLevel * 40 * 12;
	}

}
