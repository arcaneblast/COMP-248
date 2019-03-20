// -------------------------------------------------------
// Assignment 3. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) – Fall 2016
// Question 3 The class file only
// Date: 27 October 2016
// Purpose: Scale Class (weight in kg or pounds)
// Input: The unit type and value
// Output: waterIntake(), toString(), getKG or getPD, isLessThan(), ...
// -------------------------------------------------------

/**
 * The Scale class
 *
 * @version 1.1
 * @author it-elias@hotmail.com
 * @see driver class Program3
 *
 * Attributes: boolean isKg: whether the unit is kg or pounds double weight: the
 * value of the weight
 *
 * Static Attributes: KG_TO_PD, PD_TO_KG used to convert from kg to pounds and
 * vice versa.
 *
 */
public class Scale {

    private boolean isKg;
    private double weight;

    private static final double KG_TO_PD = 2.2;
    private static final double PD_TO_KG = 1 / 2.2;

    /**
     * Empty constructor that assumes weight is 0 kg
     */
    public Scale() {
        isKg = true;
        weight = 0;
    }

    /**
     * assumes the weight is in kg
     *
     * @param weight value in kg
     */
    public Scale(double weight) {
        isKg = true;
        this.weight = weight;
    }

    /**
     * Takes two params to specify the weight completely.
     *
     * @param isKg specify the unit true -> kg and false -> lbs
     * @param weight value
     */
    public Scale(boolean isKg, double weight) {
        this.isKg = isKg;
        this.weight = weight;
    }

    /**
     * This function is used to convert any double to two points after the
     * decimal point This is an extra ("not required in implementation") I did
     * not assume a smart user.
     *
     * @param x double value
     * @return double value that has only two decimal numbers after point
     */
    private static double cutToTwoDecimalPoints(double x) {
        int y = (int) (x * 100);
        return y / 100.0;
    }

    /**
     * accessor function that returns the weight in Kg
     *
     * @return the weight in KG
     */
    public double getKg() {
        if (this.isKg) {
            return cutToTwoDecimalPoints(weight);
        }

        return cutToTwoDecimalPoints(weight * PD_TO_KG);
    }

    /**
     * accessor function that returns the weight in lbs
     *
     * @return the weight in PD
     */
    public double getPd() {
        if (!this.isKg) {
            return cutToTwoDecimalPoints(weight);
        }

        return cutToTwoDecimalPoints(weight * Scale.KG_TO_PD);
    }

    /**
     * Setter: sets the weight value
     *
     * @param weight: the new value to be set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Setter: sets the weight value and units
     *
     * @param weight: the new value
     * @param isKg: the new unit
     */
    public void setWeightAndUnit(double weight, boolean isKg) {
        this.weight = weight;
        this.isKg = isKg;
    }

    /**
     * return the water intake in cups which is calculated as: int ounces = get
     * weight in pounds / 2; cups = ounces / 8;
     *
     * @return cups
     */
    public int waterIntake() {
        int ounces = (int) (getPd() / 2);
        return ounces / 8;
    }

    /**
     * extra 12 ounces of water for every 30 minutes of workout.
     *
     * @param workoutTimeInMinutes The duration of the workout through the day
     * @return cups of water
     */
    public int waterIntake(int workoutTimeInMinutes) {
        int ounces = (int) (getPd() / 2);
        ounces += 12 * ((workoutTimeInMinutes) / 30);
        return ounces / 8;
    }

    @Override
    public String toString() {
        return weight + " " + (isKg ? "kg" : "lbs");
    }

    /**
     * The equals method as defined by Java Documentations
     *
     * @param obj an object of any class (it should be of Scale)
     * @return true or false based on whether the two of them have the same
     * weight value
     *
     * example: 50 kg is equal to 110 lbs
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Scale other = (Scale) obj;
        return (Math.abs(this.getKg() - other.getKg()) < 0.000001);
    }

    /**
     * isLessThan(Scale other)
     *
     * @param other
     * @return true if this is less than the object given
     */
    public boolean isLessThan(Scale other) {
        return (this.getKg() < other.getKg());
    }

    /**
     * isGreaterThan(Scale other)
     *
     * @param other
     * @return true if this is greater than the object given
     */
    public boolean isGreaterThan(Scale other) {
        return (this.getKg() > other.getKg());
    }
}
