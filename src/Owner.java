public class Owner extends Company{
    
    private double totalMoney;    
    private double purchases;
    private double sales;
    private double salaries;
    private double profits=net();
    public final double tax=0.17;

    public Owner(double totalMoney, double purchases, double sales, double salaries, String Name, String Date, int ID, String tel) {
        super(Name, Date, ID, tel);
        this.totalMoney = totalMoney;
        this.purchases = purchases;
        this.sales = sales;
        this.salaries = salaries;
        profits=net();
    }
    
    
    
    public double getProfits() {
        return profits;
    }
    


    
    public double getSalaries() {
        return salaries;
    }
    public void setSalaries(double salaries) {
        this.salaries = salaries;
    }

    
    
    public double getSales() {
        return sales;
    }
    public void setSales(double sales) {
        this.sales = sales;
    }


    
    public double getPurchases() {
        return purchases;
    }
    public void setPurchases(double purchases) {
        this.purchases = purchases;
    }


    
    public double getTotalMoney() {
        return totalMoney;
    }
    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
    public double net(){
        return (totalMoney+sales)-(purchases+salaries);
    }
    

    @Override
    public String toString() {
        return " Owner Mr.Moath Sareef { " +super.toString()+ " totalMoney = " + totalMoney + "$ , purchases = " + purchases + "$ , sales = " + sales + "$ , salaries = " + salaries + "$ , profits = " + profits + "$ , tax = " + tax + '}';
    }  
}

    

