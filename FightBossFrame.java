import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class FightBossFrame extends JFrame{

   //Variable declaration
   private JPanel main_panel;
   private JLabel[] team;
   private final int MAX_TEAM = 5;
   private JLabel team_stats;
   private JLabel boss_pic;
   private JLabel boss_stats;
   private JButton fight;
   private GridBagConstraints gbc_label;
   private GridBagConstraints gbc_button;
   private ImageIcon slot;
   private int num_mon = 0;
   private EditTeam team_box;
   private Monster[] monster;
   private int team_hp;
   private int team_atk;
   private int team_rcv;
   private int boss_hp;
   private int boss_atk;
   
   
   
   //Constructor
   public FightBossFrame(){
   
      //Setting layout
      setLayout(new FlowLayout());
      
      //Creating panel for the slots
      main_panel = new JPanel(new GridBagLayout());
      
      //Creating Grid Bag Constraints to space the slots
      gbc_label = new GridBagConstraints();
      gbc_label.insets = new Insets(10,10,10,10);   
      
      //Setting x and y coordinates to move the buttons around
      gbc_label.gridx = 0;
      gbc_label.gridy = 0;
      
      //Setting and outputting the empty slots for the team
      slot = new ImageIcon(getClass().getResource("Slot.jpg"));
      team = new JLabel[MAX_TEAM];
      
      for(int i = 0; i < MAX_TEAM; i++){
         gbc_label.gridx = i;
         team[i] = new JLabel(slot);
         main_panel.add(team[i], gbc_label);
      }
      
      
            //Counting the number of monsters in the team
                  for(int i = 1; i <= 197; i++){
                     try{
                        BufferedReader in = new BufferedReader(new FileReader("Users/" + StartGame.getUser_id() + "/Team/" + i + ".txt"));
                        num_mon++;
                        in.close();
                     }
                     catch(IOException iox){
                     }
                  }
                  
                  //Declaring the array of monsters from the monster box  
                  team_box = new EditTeam(num_mon);
                  monster = team_box.getTeam();
                           
                           System.out.println(num_mon);
                  //Outputting the image onto the screen
                  for(int i = 0; i < num_mon; i++){
                     gbc_label.gridx = i;
                     main_panel.remove(team[i]);
                     slot = new ImageIcon(getClass().getResource("Monster Box/Monster Pics/" + monster[i].getId() + ".jpg"));
                     team[i] = new JLabel(slot);
                     main_panel.add(team[i], gbc_label);
                  }
                  
              //Calculating the stats of the team
              team_hp = team_box.total_Hp();
              team_atk = team_box.total_Atk();
              team_rcv = team_box.total_Rcv();
              
              //Displaying the stats of the team
              gbc_label.gridx = 2;
              gbc_label.gridy = 1;
              team_stats = new JLabel("Team Hp: " + team_hp);
              main_panel.add(team_stats, gbc_label);
              
              //Creating and displaying the fight button
              gbc_label.gridy = 2;
              fight = new JButton("Attack Boss");
              main_panel.add(fight,gbc_label);
              
              //Displaying the boss
              gbc_label.gridy = 3;
              slot = new ImageIcon(getClass().getResource("Monster Box/Boss/boss.jpg"));
              boss_pic = new JLabel(slot);
              main_panel.add(boss_pic, gbc_label);
              
              //Saving the boss stats
              try{
                  BufferedReader in = new BufferedReader(new FileReader("Monster Box/Boss/boss.txt"));
                  boss_hp = Integer.parseInt(in.readLine());
                  boss_atk = Integer.parseInt(in.readLine());
                  in.close();
              }catch(IOException iox){
              }
              
              //Displaying the boss stats
              gbc_label.gridy = 4;
              boss_stats = new JLabel("Boss Hp: " + boss_hp);
              main_panel.add(boss_stats, gbc_label);
              
              //the action that occurs when the Challenge boss button is pressed
              fight.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
        
                  if(num_mon != MAX_TEAM){
                     JOptionPane.showMessageDialog(null,"You dont have a full team to fight, please add monsters to your team");
                  }else{
                     
                     boss_hp = boss_hp - team_atk;
                     
                     if(boss_hp <= 0){
                        JOptionPane.showMessageDialog(null,"CONGRATS!!!! YOU WON THE GAME");
                     }
                     
                     team_hp = team_hp - boss_atk;
                     
                     if(team_hp <= 0){
                        JOptionPane.showMessageDialog(null,"sorry, you lost");
                     }
                     
                     team_hp = team_hp + team_rcv;
                     
                  }
        
               }
               }); 
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      


      setContentPane(main_panel);
      
         
   }
   
   public static void main (String [] args){
   
      FightBossFrame gui = new FightBossFrame();     
          //Setting size of the window
      gui.setSize(650,500);
      gui.setVisible(true);
          
          //Setting Title of the window
      gui.setTitle("Challenge boss");
   
   
   }
   

}