public class Employee extends Company implements salary {
      private double Salary;
      private double days;
      private double netSalary = findSalary();

    public double getNetSalary() {
        return netSalary;
    }

    public Employee(double Salary, double days, String Name, String Date, int ID, String tel) {
        super(Name, Date, ID, tel);
        this.Salary = Salary;
        this.days = days;
        netSalary = findSalary();
    }
    
    
    public double getDays() {
        return days;
    }
    public void setDays(double days) {
        this.days = days;
    }
    
    public double getSalary() {
        return Salary;
    }
    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    

    public double findSalary(){
        return days*Salary;
        
    }

    @Override
    public String toString() {
        return super.toString()+" "+" Net Salary = "+netSalary+"$";
    } 
}
