package at.fhooe.sail.mc.Aufgabe02;

import at.fhooe.sail.mc.Aufgabe01Exceptions.ValueException;

//subclass of the abstract member for chair members
public class ChairMember extends AbstractMember{
	
	public int competenceLevel;

	//Implement exceptionhandling
	//calling the constructor of the abstract member setting the name and the competence level
	public ChairMember(String name, int competenceLevel) throws ValueException {
		super(name);
		if(competenceLevel < 0 || competenceLevel > 10) {
			throw new ValueException(competenceLevel);
		}
		this.competenceLevel = competenceLevel;
	}

	@Override
	//overriding the method of the abstract member to get the income of the chair member
	public double getIncome() {
		return competenceLevel * 100;
	}

	@Override
	//overriding the method of the abstract member to get the cost of the chair member
	public double getCost() {
		return getIncome() * 0.2;
	}

}
