package aufgabe05.members;

import aufgabe05.basic_class.AbstractMember;

public class ChairMember extends AbstractMember {

    public int competencyValue;

    public ChairMember(String name, int competencyValue) {
        super(name);
        this.competencyValue = competencyValue;
    }

    @Override
    public double getIncome() {
        return competencyValue * 100;
    }

    @Override
    public double getCosts() {
        return getIncome() * 0.2;
    }
}
