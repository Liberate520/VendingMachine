package seminar02_HW;

import java.util.ArrayList;
import java.util.List;

/**
 * Родительский класс для данного пакета
 * Сущность скопирована с пакета первого семинара seminar01_HW
 * Добавлены правки с учетом замечаний
 */
public class Human {
    public String firstName;
    public String lastName;
    public String dateOfBirth;


    public Human(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * Добавил лист для хранения данных
     */
    public List<FamilyCommunication> familyCommunicationList = new ArrayList<>();




    @Override
    public String toString() {
        return
                ", firstName='" + firstName + '\t' +
                ", lastName='" + lastName + '\t' +
                ", dateOfBirth='" + dateOfBirth +
                '\'';
    }
}
