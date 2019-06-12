public class Maneger extends Company implements salary {
     private double hour;
     private double salary;
     private double netSalary = findSalary();
     
     public double getNetSalary() {
        return netSalary;
     }

     public Maneger(double hour, double salary, String Name, String Date, int ID, String tel) {
        super(Name, Date, ID, tel);
        this.hour = hour;
        this.salary = salary;
        netSalary = findSalary();
     }
    
     
    public double getHour() {
        return hour;
    }
    public void setHour(double hour) {
        this.hour = hour;
    }
    
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
     public double findSalary(){
      return hour*salary;      
     }
    
     @Override
     public String toString() {
        return super.toString()+" "+" Net Salary = "+netSalary+"$";
     }
}