package payroll;

public abstract class Employee {
    protected String employeeNumber;
    protected String firstName;
    protected String lastName;
    protected String jobTitle;

    /**
     * Constructor that initializes the parameters
     * @param employeeNumber employee's number
     * @param firstName employee's first name
     * @param lastName employee's last name
     * @param jobTitle employee's job title
     */
    public Employee(String employeeNumber, String firstName, String lastName, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
    }

    /**
     * returns the employee number
     * @return employee number
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * returns employee's first name
     * @return employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * returns employee's last name
     * @return employee's last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * returns employee's job title
     * @return employee's job title
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * returns employees information
     * @return
     */
    @Override
    public String toString() {
        return "Employee: " + employeeNumber + ", " +  lastName + ", " + firstName + ", " + jobTitle;
    }

    /**
     * Employee's pay
     * @return the pay of an employee
     */
    abstract  double pay();

    /**
     * Uses the employee sick day given the amount
     * @param usedAmount sick day used
     */
    abstract void useSickDay(double usedAmount);

    /**
     * Returns the amount of sick days of an emplyee
     * @return sick days
     */
    abstract double getSickDays();

    /**
     * reset employee sick day to default
     */
    abstract void resetSickDays();

    /**
     * prints the pay stub for an employee
     */
    abstract void printPayStub();

}
