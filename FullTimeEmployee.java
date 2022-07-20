package payroll;

public class FullTimeEmployee extends Employee {
    private double YEARLY_SICK_DAYS = 20;
    private double MONTHS = 12;
    private double yearlySalary;
    private double sickDaysLeft;

    /**
     * Constructor that initializes the full time employee parameters
     * @param employeeNumber Employee's number
     * @param firstName Employee's first name
     * @param lastName Employee's last name
     * @param jobTitle Employee's job title
     * @param yearlySalary Employee's yearly salary
     * @param sickDaysLeft Employee's sick days left
     */
    public FullTimeEmployee(String employeeNumber, String firstName, String lastName, String jobTitle,
                            double yearlySalary, double sickDaysLeft) {
        super(employeeNumber, firstName, lastName, jobTitle);
        this.sickDaysLeft = sickDaysLeft;
        this.yearlySalary = yearlySalary;
    }

    /**
     * Returns the yearly salary of a full time employee
     * @return yearly salary
     */
    public double getYearlySalary() {
        return yearlySalary;
    }

    /**
     * Returns the pay of a full time employee
     * @return the pay of a full time employee
     */
    public double pay() {
        return yearlySalary / MONTHS;
    }

    /**
     * Returns the amount of sick days left of a full time employee
     * @return sick days left of a full time employee
     */
    public double getSickDays() {
        return sickDaysLeft;
    }

    /**
     * Uses a sick day of a full time employee
     * @param usedAmount sick day used
     */
    public void useSickDay(double usedAmount) {
        sickDaysLeft -= usedAmount;
    }

    /**
     * Resets the sick days of a full time employee to default
     */
    public void resetSickDays() {
        sickDaysLeft = YEARLY_SICK_DAYS;
    }

    /**
     * Prints the pay stub information of a full time employee
     */
    public void printPayStub() {
        System.out.println("-------------------- PAY STUB --------------------");
        System.out.printf("Yearly Salary: $ %.2f%n", yearlySalary);
        System.out.printf("Current Month pay: $ %.2f%n", pay());
        System.out.printf("Sick days left: %.1f%n", sickDaysLeft);
        System.out.println("--------------------------------------------------\n");
    }

    /**
     * Returns the information of a full time employee
     * @return full time employee informationn
     */
    @Override
    public String toString() {
        return super.toString() + ", full time" + ", " + yearlySalary + ", " + sickDaysLeft;
    }
}
