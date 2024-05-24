package aufgabe05.members.function;

import aufgabe05.members.ActiveMember;

public class Trainer extends ActiveMember {

    public Trainer(String name, int activityLevel) {
        super(name, activityLevel);
    }

    @Override
    public double getIncome() {
        return 10 * 12;
    }

    @Override
    public double getCosts() {
        return activityLevel * 40 * 12;
    }
}
