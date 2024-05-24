package aufgabe05.members.function;

import aufgabe05.members.ActiveMember;

public class AmateurAthlete extends ActiveMember {

    public AmateurAthlete(String name, int activityLevel) {
        super(name, activityLevel);
    }

    @Override
    public double getIncome() {
        return 25 * 12;
    }

    @Override
    public double getCosts() {
        return activityLevel * 2.5 * 12;
    }
}
