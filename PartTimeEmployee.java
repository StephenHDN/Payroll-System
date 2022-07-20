package payroll;

public class PartTimeEmployee extends Employee{
    private double HOURS_PER_DAY = 7;
    private double numHoursAssigned;
    private double hourlyWage;
    private double sickDaysTaken;

    /**
     * constructor that initializes the parameters for part time employee
     * @param employeeNumber the employee's number
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param jobTitle the employee's job title
     * @param numHoursAssigned the employee's hours assigned
     * @param hourlyWage the employee's hourly wage
     * @param sickDaysTaken the employee's sick days taken
     */
    public PartTimeEmployee(String employeeNumber, String firstName, String lastName, String jobTitle,
                            double numHoursAssigned, double hourlyWage, double sickDaysTaken) {
        super(employeeNumber, firstName, lastName, jobTitle);
        this.numHoursAssigned = numHoursAssigned;
        this.hourlyWage = hourlyWage;
        this.sickDaysTaken = sickDaysTaken;
    }

    /**
     * Returns the hours assigned to a employee
     * @return hours assigned
     */
    public double getNumHoursAssigned() {
        return numHoursAssigned;
    }

    /**
     * returns the hourly wage of an employee
     * @return hourly wage
     */
    public double getHourlyWage() {
        return hourlyWage;
    }

    /**
     * Uses a sick day for a part-time employee
     * @param amount sick days used
     */
    public void useSickDay(double amount) {
        sickDaysTaken += amount;
    }

    /**
     * Returns the sick days taken
     * @return sick days taken
     */
    public double getSickDays() {
        return sickDaysTaken;
    }

    /**
     * Resets the sickday to 0 for a part time employee
     */
    public void resetSickDays() {
        sickDaysTaken = 0;
    }

    /**
     * Returns the pay of an employee that varries on the hours assigned, hourly wage, and sick days
     * @return the pay of a part time employee
     */
    public double pay() {
        return hourlyWage * (numHoursAssigned - sickDaysTaken * HOURS_PER_DAY);
    }

    /**
     * Prints the pay stub of a part time employee
     */
    public void printPayStub() {
        System.out.println("-------------------- PAY STUB --------------------");
        System.out.printf("Hourly Wage: $ %.2f%n", hourlyWage);
        System.out.printf("Number of Hours Assigned: $ %.1f%n", numHoursAssigned);
        System.out.printf("Sick days used: %.1f%n", sickDaysTaken);
        System.out.printf("Current Month of pay: $%.2f%n", pay());
        System.out.println("--------------------------------------------------\n");
    }

    /**
     * Returns the part-time employees information
     * @return part time employee information
     */
    @Override
    public String toString() {
        return super.toString() + ", part-time" + hourlyWage + ", " + sickDaysTaken;
    }
}
