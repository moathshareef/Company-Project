import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUI extends JFrame implements ItemListener,ActionListener {
    
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    private JRadioButton r1,r2,r3;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8;
    private ButtonGroup g1;
    private JCheckBox c1;
    private Company [] arr;
    private int c = 0;
    
    public GUI (){
         super ("Company");
         setLayout (new GridLayout(17,2,10,10));
         arr = new Company[100];
         c1=new JCheckBox ("clear");
         l1=new JLabel(" name");
         l2=new JLabel(" ID");
         l3=new JLabel(" Date");
         l4=new JLabel(" Tel");
         l5=new JLabel(" Net Salary");
         l6=new JLabel(" total Money");
         l7=new JLabel(" purchases");
         l8=new JLabel(" sales");
         l9=new JLabel(" salaries");
         l10=new JLabel(" profits");
         t1=new JTextField(10);
         t2=new JTextField(10);
         t3=new JTextField(10);
         t4=new JTextField(10);
         t5=new JTextField(10);
         t6=new JTextField(10);
         t7=new JTextField(10);
         t8=new JTextField(10);
         t9=new JTextField(10);
         t10=new JTextField(10);
         r1=new JRadioButton ("Owner");
         r2=new JRadioButton ("Maneger");
         r3=new JRadioButton ("Employee");
         b1=new JButton("Add");
         b2=new JButton("Delete");
         b3=new JButton("Search");
         b4=new JButton("Print All");
         b5=new JButton("Delet All");
         b6=new JButton("save");
         b7=new JButton("calculate");
         b8=new JButton("Owner");
         g1=new ButtonGroup ();
         g1.add(r1);g1.add(r2);g1.add(r3);
         add(r1);add(r2);add(r3);add(c1);add(l1);add(t1);
         add(l2);add(t2);add(l3);add(t3);add(l4);add(t4);
         add(l5);add(t5);add(l6);add(t6);add(l7);add(t7);
         add(l8);add(t8);add(l9);add(t9);add(l10);add(t10);
         add(b1);add(b2);add(b3);add(b4);
         add(b5);add(b6);add(b7);add(b8);
         b1.addActionListener(this);
         b2.addActionListener(this);
         b3.addActionListener(this);
         b4.addActionListener(this);
         b5.addActionListener(this);
         b6.addActionListener(this);
         b7.addActionListener(this);
         b8.addActionListener(this);
         r1.addItemListener(this);
         r2.addItemListener(this);
         r3.addItemListener(this);
         c1.addItemListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                String name = t1.getText();
                int id = Integer.parseInt(t2.getText());
                String Date = t3.getText();
                String tel = t4.getText();
                double txt5 = Double.parseDouble(t5.getText());
                double txt6 = Double.parseDouble(t6.getText());
                double txt7 = Double.parseDouble(t7.getText());
                double txt8 = Double.parseDouble(t8.getText());
                double txt9 = Double.parseDouble(t9.getText());
                

                if (r1.isSelected()) {
                    arr[c] = new Owner(txt6,txt7,txt8,txt9,name,Date,id,tel);
                    c++;
                }
                else if (r2.isSelected()) {
                    arr[c] = new Maneger(txt5,txt6,name,Date,id,tel);
                    c++;
                }
                else if (r3.isSelected()) {
                    arr[c] = new Employee(txt5,txt6,name,Date,id,tel);
                    c++;
                }
                JOptionPane.showMessageDialog(null, "Added Successfully");
            } 
            // ********-- Button 2 --******** 
            else if (e.getSource() == b2) {
                int deletenum = Integer.parseInt(JOptionPane.showInputDialog("Enter The Cell Number To Delete"));
                if (deletenum == c - 1) {
                    arr[deletenum] = null;
                    JOptionPane.showMessageDialog(null, "Successfully Deleted");
                    c--;
                } 
                else if (deletenum < c - 1) {
                    arr[deletenum] = arr[c - 1];
                    arr[c-1]=null;
                    JOptionPane.showMessageDialog(null, "Successfully Deleted");
                    c--;
                } 
                else {
                    JOptionPane.showMessageDialog(null, "No Object in This Cell Number");
                }
            } 
            // ********-- Button 3 --********             
            else if (e.getSource() == b3) {
                int Sea = Integer.parseInt(JOptionPane.showInputDialog("Enter ID for Search"));
                int cell = -1;
                for (int i = 0; i < c; i++) {
                    if (arr[i].getID() == Sea) {
                        cell = i;
                        break;
                    }
                }
                if (cell != -1) {
                    JOptionPane.showMessageDialog(null, " Operation Succeeded" + "\n" + "This Object in Cell " + cell);
                    t1.setText(arr[cell].getName());
                    t2.setText(arr[cell].getDate());
                    t3.setText(arr[cell].getID() + "");
                    t4.setText(arr[cell].getTel());
                    if (arr[cell] instanceof Maneger) {
                        t5.setText(((Maneger) arr[cell]).getSalary() + "");
                        t6.setText(((Maneger) arr[cell]).getHour() + "");
                        t7.setText(((Maneger) arr[cell]).getNetSalary() + "");
                    } 
                    else if (arr[cell] instanceof Employee) {
                        t5.setText(((Employee) arr[cell]).getSalary() + "");
                        t6.setText(((Employee) arr[cell]).getDays() + "");
                        t7.setText(((Employee) arr[cell]).getNetSalary() + "");
                    }
                    else if (arr[cell] instanceof Owner) {
                        t5.setText("0");
                        t6.setText(((Owner) arr[cell]).getTotalMoney() + "");
                        t7.setText(((Owner) arr[cell]).getPurchases() + "");
                        t8.setText(((Owner) arr[cell]).getSales() + "");
                        t9.setText(((Owner) arr[cell]).getSalaries() + "");
                        t10.setText(((Owner) arr[cell]).getProfits() + "");
                    }
                } 
                else {
                    JOptionPane.showMessageDialog(null, " Operation Succeeded" + "\n" + "Not Found");
                }
            } 
            // ********-- Button 4 --********             
            else if (e.getSource() == b4) {
                if (c > 0) {
                    for (int i = 0; i < c; i++) {
                        System.out.println(arr[i].toString());
                    }
                    System.out.println("-------------------------------------------------------------------------");
                } else {
                    JOptionPane.showMessageDialog(null, "Can't Print, No Object Exist!!!");
                }
            } 
            // ********-- Button 5 --********             
            else if (e.getSource() == b5) {
                for (int i = 0; i < c; i++) {
                    arr[i] = null;
                    c--;
                }
               // clearAllTxt();
                JOptionPane.showMessageDialog(null, " Operation Succeeded" + "\n" + "All Objects are Deleted");
            } 
            // ********-- Button 6 --********             
            else if (e.getSource() == b6) {
                FileWriter fr = new FileWriter("Data.txt");
                PrintWriter p = new PrintWriter(fr);
                for (int i = 0; i < c; i++) {
                    p.println(arr[i].toString());

                }
                p.close();
                JOptionPane.showMessageDialog(null, " Saved Successfully ");
            }
            // ********-- Button 7 --********
            else if (e.getSource() == b7) {
                 double txt5 = Double.parseDouble(t5.getText());
                 double txt6 = Double.parseDouble(t6.getText());
                if (r2.isSelected()||r3.isSelected()) {
                    double net=txt5*txt6;
                    t7.setText(""+net);
                }
                if (r1.isSelected()){
                 double Txt6 = Double.parseDouble(t6.getText());
                 double Txt7 = Double.parseDouble(t7.getText());
                 double Txt8 = Double.parseDouble(t8.getText());
                 double Txt9 = Double.parseDouble(t9.getText());
                 double net = (Txt6+Txt8)-(Txt7+Txt9);
                 t10.setText(""+net);
                }
            }
            // ********-- Button 8 --********
            else if (e.getSource() == b8) {
               Read_file c1=new Read_file();
               c1.setSize(600,600);
               c1.setVisible(true);
               c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        } 
        
        catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(null, "You Should Enter a Number");
        } 
        
        catch (NegativeArraySizeException a) {
            JOptionPane.showMessageDialog(null, "You Should Enter a Positive Number");
        } 
        
        catch (ArrayIndexOutOfBoundsException a) {
            JOptionPane.showMessageDialog(null, "You Exceed Array Size");
        } 
        
        catch (Exception a) {
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }

    public void itemStateChanged(ItemEvent event) {
        if (event.getSource() == r1) {
                    l5.setText("");
                    t5.setText("0");
                    l6.setText("total Money");
                    l7.setText("purchases");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                    t10.setText("0");
                    t5.setEnabled(false);
                    t8.setEnabled(true);
                    t7.setEnabled(true);
                    t9.setEnabled(true);
                    t10.setEnabled(false);
                    t5.setBackground(Color.red);
                    t10.setBackground(Color.black);
                    t7.setBackground(Color.white);
                    t8.setBackground(Color.white);
                    t9.setBackground(Color.white);
        }
        else if (event.getSource() == r2) {
                    l5.setText("hour");
                    t5.setText("");
                    l6.setText("salary");
                    l7.setText("netSalary");
                    t7.setText("0");
                    t8.setText("0");
                    t9.setText("0");
                    t10.setText("0");
                    t5.setEnabled(true);
                    t7.setEnabled(false);
                    t8.setEnabled(false);
                    t9.setEnabled(false);
                    t10.setEnabled(false);
                    t5.setBackground(Color.white);
                    t6.setBackground(Color.white);
                    t7.setBackground(Color.black);
                    t8.setBackground(Color.red);
                    t9.setBackground(Color.red);
                    t10.setBackground(Color.red);
        } 
        else if (event.getSource() == r3) {
                    l5.setText("salary");
                    t5.setText("");
                    l6.setText("day");
                    l7.setText("netSalary");
                    t7.setText("0");
                    t8.setText("0");
                    t9.setText("0");
                    t10.setText("0");
                    t5.setEnabled(true);
                    t7.setEnabled(false);
                    t8.setEnabled(false);
                    t9.setEnabled(false);
                    t10.setEnabled(false);
                    t5.setBackground(Color.white);
                    t6.setBackground(Color.white);
                    t7.setBackground(Color.black);
                    t8.setBackground(Color.red);
                    t9.setBackground(Color.red);
                    t10.setBackground(Color.red);
        }
        
        if (r1.isSelected()&&event.getSource() == c1) {
             t1.setText("");
             t2.setText("");
             t3.setText("");
             t4.setText("");
             t6.setText("");
             t7.setText("");
             t8.setText("");
             t9.setText("");
        }
        if (r2.isSelected()&&event.getSource() == c1) {
             t1.setText("");
             t2.setText("");
             t3.setText("");
             t4.setText("");
             t5.setText("");
             t6.setText("");
        }
        if (r3.isSelected()&&event.getSource() == c1) {
             t1.setText("");
             t2.setText("");
             t3.setText("");
             t4.setText("");
             t5.setText("");
             t6.setText("");
        }
    }
}