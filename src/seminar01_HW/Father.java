package seminar01_HW;

import javax.management.relation.Relation;

public class Father extends Human{

    public String relation;

    public Father(String firstName, String lastName, String dateOfBirth, String relation) {
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
