package at.fhooe.sail.mc.Aufgabe02;

//subclass of the abstract member for honorary members
public class HonoraryMember extends AbstractMember{

	public HonoraryMember(String name) {
		super(name);
	}

	@Override
	//overriding the method of the abstract member to get the income of the honorary member
	public double getIncome() {
		return 0;
	}

	@Override
	//overriding the method of the abstract member to get the cost of the honorary member
	public double getCost() {
		return 20;
	}

}
