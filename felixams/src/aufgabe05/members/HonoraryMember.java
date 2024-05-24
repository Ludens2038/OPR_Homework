package aufgabe05.members;

import aufgabe05.basic_class.AbstractMember;

public class HonoraryMember extends AbstractMember {

    public HonoraryMember(String name) {
        super(name);
    }

    @Override
    public double getIncome() {
        return 0;
    }

    @Override
    public double getCosts() {
        return 20;
    }
}
