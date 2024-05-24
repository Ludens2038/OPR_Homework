package at.fhooe.sail.mc.Uebung05.Aufgabe02;

public class TopAthlete extends ActiveMember{

	public TopAthlete(String name, int activityLevel) {
		super(name, activityLevel);
	}

	@Override
	public double getIncome() {
		return 10 * 12;
	}

	@Override
	public double getCost() {
		return activityLevel * 5;
	}
}
