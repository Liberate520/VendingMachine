package seminar01_HW;

public class Son extends Human{
    public String relation;

    public Son(String firstName, String lastName, String dateOfBirth, String relation) {
        super(firstName, lastName, dateOfBirth);
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return  firstName + " "
                + lastName
                + ", date of birth: " + dateOfBirth
                + " is a " + relation;
    }
}
