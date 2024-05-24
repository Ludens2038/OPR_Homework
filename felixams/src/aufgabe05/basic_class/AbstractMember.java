package aufgabe05.basic_class;

public abstract class AbstractMember implements Comparable<AbstractMember> {

    public String name;

    public AbstractMember(String name) {
        this.name = name;
    }

    public abstract double getIncome();

    public abstract double getCosts();

    public double getSurplus() {
        return getIncome() - getCosts();
    }

    @Override
    public int compareTo(AbstractMember otherMember) {
        return this.name.compareTo(otherMember.name);
    }
    
    @Override
    public String toString() {
        return toString(true);
    }

    public String toString(boolean ascending) {
        StringBuilder builder = new StringBuilder();
        builder.append("name: " + name + " - surplus: " + getSurplus() + " - income: " + getIncome() + " - costs: " + getCosts() + "\n");
        return builder.toString();
    }
}