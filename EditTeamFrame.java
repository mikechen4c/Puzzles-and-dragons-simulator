import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class EditTeamFrame extends JFrame{
   
   //Variable declaration
   private ImageIcon slot;
   private JLabel[] slot_label;
   private JPanel slot_panel;
   private JPanel button_panel;
   private GridBagConstraints gbc;
   private JButton add_monster;
   private int monster_id;
   private final int  MAX_MON = 5;
   private int count = 0;
   private String monster_id_string;
   private JPanel main_panel;
   private Monster[] mon;
   private EditTeam team_box;
   
   
   //Constructor
   public EditTeamFrame(){
      //Setting flow layout
      setLayout(new FlowLayout());
      
      //Creating main panel
      main_panel = new JPanel();
      
      //Creating panel for the slots
      slot_panel = new JPanel(new GridBagLayout());
      
      //Creating Grid Bag Constraints to space the slots
      gbc = new GridBagConstraints();
      gbc.insets = new Insets(10,10,10,10);   
      
      //Setting x and y coordinates to move the buttons around
      gbc.gridx = 0;
      gbc.gridy = 0;
      
      //Setting and outputting the labels
      slot = new ImageIcon(getClass().getResource("Slot.jpg"));
      slot_label = new JLabel[MAX_MON];
      
      for(int i = 0; i < MAX_MON; i++){
         gbc.gridx = i;
         slot_label[i] = new JLabel(slot);
         slot_panel.add(slot_label[i], gbc);
      }
      
      
      
      //Creating panel for buttons
      button_panel = new JPanel ();
   
      //Creating add_monster button
      add_monster = new JButton("Add monster by monster ID");
      button_panel.add(add_monster,gbc);
      
      //Counting the number of monsters in the team
                  for(int i = 1; i <= 197; i++){
                     try{
                        BufferedReader in = new BufferedReader(new FileReader("Users/" + StartGame.getUser_id() + "/Team/" + i + ".txt"));
                        count++;
                        in.close();
                     }
                     catch(IOException iox){
                     }
                  }
                  
                  //Declaring the array of monsters from the monster box  
                  team_box = new EditTeam(count);
                  mon = team_box.getTeam();
                           
                           System.out.println(count);
                  //Outputting the image onto the screen
                  for(int i = 0; i < count; i++){
                     gbc.gridx = i;
                     slot_panel.remove(slot_label[i]);
                     slot = new ImageIcon(getClass().getResource("Monster Box/Monster Pics/" + mon[i].getId() + ".jpg"));
                     slot_label[i] = new JLabel(slot);
                     slot_panel.add(slot_label[i], gbc);
                  }

          
      //Asking the user to enter the monster ID to add to the team
      add_monster.addActionListener(
            new ActionListener(){
               public void actionPerformed(ActionEvent e){
               
               //Taking the users input
                  monster_id_string = JOptionPane.showInputDialog("Enter the monsters id: ");               
               
               //Determining if the user entered an invalid input, cancelled, or the correct input
                  if(monster_id_string == null){
                  //Nothing happens because the user clicked cancel
                  }
                  else{
                     //Checking if the team is full
                     if(count != MAX_MON){
                        try{
                        //Converting the string id into an integer id
                           monster_id = Integer.parseInt(monster_id_string);
                           System.out.println(monster_id);
                        
                        //Checking if the monster added is in the users' monster box
                           if(validMon(monster_id) != false){
                              
                              //Reading the monster's info then writing it in the user's team as a text file
                              try{
                                 BufferedReader in = new BufferedReader (new FileReader("Monster Box/Monster Stats/" + monster_id + ".txt"));
                              
                                 try{
                                    BufferedWriter out = new BufferedWriter (new FileWriter ("Users/" + StartGame.getUser_id() + "/Team/" + monster_id + ".txt"));
                                 
                                 //Writes all the selected monster's info onto a text file     
                                    out.write(in.readLine());
                                    out.newLine();
                                    out.write(in.readLine());
                                    out.newLine();
                                    out.write(in.readLine());
                                    out.newLine();
                                    out.write(in.readLine());
                                    out.newLine();
                                    out.write(in.readLine());
                                    out.newLine();
                                    out.write(in.readLine());
                                    out.newLine();
                                    out.write(in.readLine());
                                 
                                    out.close();
                                    in.close();
                                 }
                                 catch(IOException iox){
                                    System.out.println("Error");
                                 }
                              
                              }
                              catch(IOException iox){
                                 System.out.println("Error");
                              }
                              
                              
                              //Counting the number of monsters in the team
                              count = 0;
                              for(int i = 1; i <= 197; i++){
                                 try{
                                    BufferedReader in = new BufferedReader(new FileReader("Users/" + StartGame.getUser_id() + "/Team/" + i + ".txt"));
                                    count++;
                                    in.close();
                                 }
                                 catch(IOException iox){
                                 }
                              }
                              
                           //Declaring the array of monsters from the monster box  
                              team_box = new EditTeam(count);
                              mon = team_box.getTeam();
                           
                           System.out.println(count);
                           
                           //Outputting the image onto the screen
                              for(int i = 0; i < count; i++){
                                 gbc.gridx = i;
                                 slot_panel.remove(slot_label[i]);
                                 slot = new ImageIcon(getClass().getResource("Monster Box/Monster Pics/" + mon[i].getId() + ".jpg"));
                                 slot_label[i] = new JLabel(slot);
                                 slot_panel.add(slot_label[i], gbc);
                              }
                           
                              main_panel.add(slot_panel);
                              main_panel.add(button_panel);
                              setContentPane(main_panel);
                           }
                           else{
                           //Tells the user that the id that they entered is out of range
                              if(monster_id < 1 || monster_id > 197){
                                 JOptionPane.showMessageDialog(null, "The monster id that you entered is out of range");
                              }
                              else{
                              //Tells the user that the id of the monster entered is not in their monster box
                                 JOptionPane.showMessageDialog(null,"The id of the Monster that you entered is not in your monster box");
                              }
                           }
                        }
                        catch(NumberFormatException nfe){
                        //Tells the user that they entered an invalid input
                           JOptionPane.showMessageDialog(null,"Error, please enter the monster's id correct(in integers)");
                        }
                     }
                     else{
                        JOptionPane.showMessageDialog(null,"you've reached the maximum number of monsters in your team, you cannot add anymore monsters");
                     }
                  }
               }
            });
      
      //Adding the panels to the main panel
      main_panel.add(slot_panel);
      main_panel.add(button_panel);
      setContentPane(main_panel);
   }
     
   
   
   public static void main (String [] args){
      
      EditTeamFrame gui = new EditTeamFrame();
      
      //Setting size of the window
      gui.setSize(630,300);
      gui.setVisible(true);
      
      //Setting Title of the window
      gui.setTitle("Monster Box");
      
   }
   
   //This method determines where the monster is in the monster box in a recursive way
   //Returns -1 if the monster is not found
   public boolean validMon(int id){
      boolean check = false;
      try{
         BufferedReader in = new BufferedReader(new FileReader("Users/" + StartGame.getUser_id() + "/Monster Box/" + id + ".txt"));
         check = true;
         in.close();
      }
      catch(IOException iox){
      }
      return check;
   }
   
   
}