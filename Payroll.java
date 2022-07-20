package payroll;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Payroll {
    private ArrayList<Employee> staffList;

    /**
     * Constructor that constructs an arraylist for StaffList
     */
    public Payroll() {
        staffList = new ArrayList<>();
    }

    /**
     * Loads the staffList from the file that is given
     * @param file The name of file to load information from
     * @return If true, loads staff list
     */
    public boolean loadStaffList (String file) {
        Employee e;
        String employeeNumber;
        String firstName;
        String lastName;
        String jobTitle;
        String typeOfEmployee;
        double salary;
        double hoursAssigned;
        double hourlyWage;
        double sickDays;
        boolean a = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String text = reader.readLine();
            while (text != null) {
                Scanner textRead = new Scanner(text).useDelimiter(",");
                employeeNumber = textRead.next();
                firstName = textRead.next();
                lastName = textRead.next();
                jobTitle = textRead.next();
                typeOfEmployee = textRead.next();

                if (typeOfEmployee.equals("full-time")) {
                    salary = Double.parseDouble(textRead.next());
                    sickDays = Double.parseDouble(textRead.next());
                    e = new FullTimeEmployee(employeeNumber, firstName, lastName, jobTitle, salary ,sickDays);

                }
                else {
                    hoursAssigned = Double.parseDouble(textRead.next());
                    hourlyWage = Double.parseDouble(textRead.next());
                    sickDays = Double.parseDouble(textRead.next());
                    e = new PartTimeEmployee(employeeNumber, firstName, lastName ,jobTitle, hoursAssigned, hourlyWage, sickDays);
                }
                staffList.add(e);
                text = reader.readLine();
            }
            a = true;
        } catch (IOException ioException) {
            System.out.println("There is a Problem with reading file");
        }
        return a;
    }

    /**
     * Saves the staff list to the given file
     * @param file The file to save the information
     * @return if true, saves data to the given file
     */
    public boolean saveStaffList(String file){
        boolean a = false;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file,false));
            for (Employee e: staffList) {
                writer.write(e.getEmployeeNumber() + ","  + e.getFirstName() + "," + e.getLastName() +"," + e.getJobTitle() + ",");

                if (e instanceof PartTimeEmployee) {
                    writer.write("part-time, " + ((PartTimeEmployee) e).getNumHoursAssigned() + "," + ((PartTimeEmployee) e).getHourlyWage() + ",");
                } else {
                    writer.write("full-time," +((FullTimeEmployee)e).getYearlySalary() + ",");
                }
                writer.write((int) e.getSickDays());
            }
            a = true;
            writer.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());

        }
        return a;
    }

    /**
     * Prints list of employees
     */
    public void listAllEmployees()
    {
        System.out.println("All Employees:");
        for (Employee e: staffList)
        {
            System.out.println(e);
        }
        System.out.println();
    }

    /**
     * returns the employee given their employee Number
     * @param employeeNumber
     * @return
     */
    public Employee getEmployee(String employeeNumber)
    {
        for (Employee e: staffList)
        {
            if(e.getEmployeeNumber().equals(employeeNumber))
            {
                return e;
            }
        }
        return null;
    }

    /**
     * Prints the given Employee Pay stub by the employee number
     * @param employeeNumber
     */
    public void printEmployeePayStub(String employeeNumber)
    {
        Employee e = getEmployee(employeeNumber);

        if(e != null)
        {
            e.printPayStub();
        }
        else
        {
            System.out.println("Employee " + employeeNumber + " not found ");
        }
        System.out.println();
    }

    /**
     * Prints all employee pay stubs
     */
    public void printAllPayStubs()
    {
        System.out.println("All Employee Pay Stubs: ");
        for (Employee e: staffList)
        {
            e.printPayStub();
        }
    }

    /**
     * Used the amount of sickday given, by employee number
     * @param employeeNumber Employee number
     * @param amount the amount of sick days used
     */
    public void enterSickDay(String employeeNumber, double amount)
    {
        Employee e = getEmployee(employeeNumber);

        if(e != null)
        {
            e.useSickDay(amount);
            System.out.println("New sick days taken: " + e.getSickDays() );
        }
        else
        {
            System.out.println("Employee " + employeeNumber + " not found!");
        }
    }

    /**
     * reset full time employee sick days to 20
     */
    public void yearlySickDayReset()
    {
        for (Employee e: staffList)
        {
            if(e instanceof FullTimeEmployee)
            {e.resetSickDays();}
        }
    }

    /**
     * reset part time employee sick days to 0
     */
    public void monthlySickDayReset() {
        for (Employee e : staffList) {
            if (e instanceof PartTimeEmployee) {
                e.resetSickDays();
            }
        }
    }
}
