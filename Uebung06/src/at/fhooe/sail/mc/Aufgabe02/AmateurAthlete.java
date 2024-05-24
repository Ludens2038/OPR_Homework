package at.fhooe.sail.mc.Aufgabe02;

import at.fhooe.sail.mc.Aufgabe01Exceptions.ValueException;

//subclass of the active member for amateur athletes
public class AmateurAthlete extends ActiveMember{

	//calling the constructor of the active member
	public AmateurAthlete(String name, int activityLevel) throws ValueException {
		super(name, activityLevel);
	}

	@Override
	//overriding the method of the active member to get the income of the amateur athlete
	public double getIncome() {
		return 25 * 12;
	}

	@Override
	//overriding the method of the active member to get the cost of the amateur athlete
	public double getCost() {
		return activityLevel * 2.5 * 12;
	}
}
