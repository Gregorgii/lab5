package things;

import exceptions.WrongField;

import java.time.LocalDate;
/**
* The class Person th work w persons
*/

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDate birthday; //Поле не может быть null
    private long weight; //Значение поля должно быть больше 0
    private String passportID; //Строка не может быть пустой, Поле не может быть null

    /**
     * @param name
     * @param birthday
     * @param weight
     * @param passportID
     */
    public Person(String name, LocalDate birthday, Long weight, String passportID){
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.passportID = passportID;
    }
    /**
     * @return The persons name
     */

    public String getName(){
        return name;
    }
    /**
     * @return The persons bday
     */

    public LocalDate getBirthday(){
        return birthday;
    }
    /**
     * @return The perss weight
     */

    public Long getWeight(){
        return weight;
    }

    /**
     * @return The perses passportID
     */

    public String getPassportID(){
        return passportID;
    }


    /**
     * Set Person name.
     * @param name name to set.
     * @throws WrongField when value is null or empty string.
     */
    public void setName(String name) throws WrongField {
        if(name == null) throw new WrongField("Name can nor be null");
        if(name.length() == 0) throw new WrongField("String can not be empty");
        this.name = name;
    }

    /**
     * Set Person passport ID.
     * @param passportID value to set.
     * @throws WrongField when value is null or length greater than 28 or less than 8.
     */
    public void setPassportID(String passportID) throws WrongField{
        if(passportID == null) throw new WrongField("PassportID can nor be null");
        if( passportID.length() > 21) throw new WrongField("PassportID length shouldn't be greater than 21");
        this.passportID = passportID;
    }

    public void setWeight(Long weight) throws WrongField{
        if(weight == 0) throw new WrongField("Weight cant be zero");
        this.weight = weight;
    }

    public void setBirthday(LocalDate birthday) throws WrongField {
        if(birthday == null) throw new WrongField("Birthday cant be null");
        this.birthday = birthday;
    }


    
}
