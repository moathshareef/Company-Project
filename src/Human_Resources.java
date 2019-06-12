import java.io.*;
public class Human_Resources {
    public static void main(String[] args) {
        
        System.out.println ("Welcome In Company Jordan investment ");
        
        Company [] C = new Company [10];
            C[0]=new Owner(100000,56000,73548,4880,"Moath.Shareef","17/5/2016",001,"0799900001");
            C[1]=new Company();
            C[2]=new Maneger(120,10,"Mohammed","6/8/2016",010,"0799900010");
            C[3]=new Maneger(80,10,"Mazen","13/10/2016",020,"0799900020");
            C[4]=new Employee(20,24,"Khaleel","19/11/2016",050,"0799900050");
            C[5]=new Employee(20,24,"Ahmed","19/11/2016",051,"0799900051");
            C[6]=new Employee(20,24,"Saif","19/11/2016",052,"0799900052");
            C[7]=new Employee(20,24,"Musa","19/11/2016",053,"0799900053");
            C[8]=new Employee(20,24,"Esaa","19/11/2016",054,"0799900054");
            C[9]=new Employee(20,24,"Hammam","19/11/2016",055,"0799900055");
            
            try{
             FileWriter fr = new FileWriter ("com.txt");
             PrintWriter pr = new PrintWriter (fr);
             
             for (int i=0;i<10;i++){
                 pr.println(C[i].toString());
             }
             pr.close();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            try{
                FileReader fr=new FileReader ("com.txt");
                BufferedReader br=new BufferedReader (fr);
                 String line = br.readLine();
                 while (line != null){
                     System.out.println(line);
                     line=br.readLine();
                 }
                
                
                
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
              
    }   
}
