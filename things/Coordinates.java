package things;

import exceptions.WrongField;

/**
* Class that work w coordinates
*/
public class Coordinates {
    private Double x; //Значение поля должно быть больше -597, Поле не может быть null
    private Float y; //Поле не может быть null

    public Coordinates(){
    }

    /**
     * @return The x piece of coordinate
     */
    public Double getX(){
        return x;
    }

    /**
     * @return The y piece of coordinate
     */
    public Float getY(){
        return y;
    }


    /**
     * Set X coordinate. Value can't be null.
     * @param x coordinate X to set.
     * @throws WrongField when value is null or value greater than 710.
     */
    public void setX(Double x) throws WrongField {
        if(x == null) throw new WrongField("X can not be null");
        if(x < -771) throw new WrongField("X can not be less than -771");
        this.x = x;
    }

    /**
     * Sey Y coordinate. Value can't be null.
     * @param y coordinate Y to set.
     * @throws WrongField when value is null.
     */
    public void setY(Float y) throws WrongField{
        if(y == null) throw new WrongField("Y can not be null");
        this.y = y;
    }
    /**
     * @return The coordinates
     */
    @Override
    public String toString(){
        return "X: " + x + " Y: " + y;
    }

 
}