import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Read_file extends JFrame implements ItemListener,ActionListener {
    private JLabel l1 ;
    private JTextField t1 ;
    private JButton b1 ;
    private JCheckBox c1;
    
     public Read_file (){
         super ("Company");
         setLayout (new GridLayout(2,2,10,10));
         c1=new JCheckBox ("clear");
         l1=new JLabel("enter the password");
         t1=new JTextField(10);
         b1=new JButton("ok");
         add(l1);add(t1);add(b1);add(c1);
         b1.addActionListener(this);
         c1.addItemListener(this);
         
     }
     final private  int Pass = 2515333 ;
     public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                int pass = Integer.parseInt(t1.getText());
                if (pass == Pass){
                 FileReader data = new FileReader ("Data.txt");
                 BufferedReader data1 = new BufferedReader (data);
                
                 String line = data1.readLine();
                 while (line != null){
                  System.out.println(line);
                  line = data1.readLine();
                 }
                 JOptionPane.showMessageDialog(null, " Been Print All The Data ");
                }
                else {JOptionPane.showMessageDialog(null, " Wrong Password ");}   
                this.dispose();
            }
        }
        catch (IOException x){
            System.out.println("Faild Operation");
            
        }
        
     }
    
     public void itemStateChanged(ItemEvent event) {
        if (event.getSource() == c1) {
             t1.setText("");
        }   
     }
    
}
