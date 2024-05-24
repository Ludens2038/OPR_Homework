package aufgabe05.members;

import aufgabe05.basic_class.AbstractMember;

public class SupportingMember extends AbstractMember {

    public SupportingMember(String name) {
        super(name);
    }

    @Override
    public double getIncome() {
        return 100;
    }

    @Override
    public double getCosts() {
        return 15;
    }
}