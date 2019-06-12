public  class Company {
    
    private String Name;
    private String Date;
    private int ID;
    private String tel;
    

    public Company(String Name, String Date, int ID, String tel) {
        this.Name = Name;
        this.Date = Date;
        this.ID = ID;
        this.tel = tel;
        
    }

    public Company() {
        Name = "N/A";
        Date = "N/A";
        ID = 000;
        tel = "N/A";
        
    }

    

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String DOJ) {
        this.Date = DOJ;
    }

    public String getName() {
        return Name;
    }

  
    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return  " Name : " + Name + " , Date : " + Date + " , ID : " + ID + " , tel : " + tel  ;
    }
}
