import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
      
public class MonsterBoxFrame extends JFrame{
        
        //Variable declaration
   private ImageIcon[] slot;
   private JLabel[] slot_label;
   private JPanel slot_panel;
   private JPanel button_p;
   private JPanel main_panel;
   private JButton sort_id;
   private JButton sort_hp;
   private JButton sort_atk;
   private JButton sort_rcv;
   private JButton sort_name;
   private JButton sort_element;
   private JButton sort_type;
   private GridBagConstraints gbc_button;
   private GridBagConstraints gbc_label;
   private final int MAX_ROW = 5;
   private final int MAX_COL = 5;
   private final int MAX_MON = MAX_ROW * MAX_COL;
   private int num_mon = 0;
   private String user_id;
   private String random_mon;
   private int num_times_rolled;
   private int count = 0;
   private Monster[] monster;
   private MonsterBox mon_box;
        
        //Constructor
   public MonsterBoxFrame(){
          //Setting flow layout
      setLayout(new FlowLayout());
          
      user_id = StartGame.getUser_id();
      
      //Creating main panel
      main_panel = new JPanel();
          
          //Creating panel for slots
      slot_panel = new JPanel(new GridBagLayout());
          
          //Declaring the array of labels and photos
      slot_label = new JLabel[MAX_MON];
      slot = new ImageIcon[MAX_MON];
          
          //Creating grid bag constraints to include spacing beside slots on the screen
      gbc_label = new GridBagConstraints();
      gbc_label.insets = new Insets(10,10,10,10);
          
          //Setting and outputting the slots for the monster box
          
      for(int i = 0; i < MAX_ROW; i++){
         for(int k = 0; k < MAX_COL; k++){
            slot[num_mon] = new ImageIcon(getClass().getResource("Slot.jpg"));
            gbc_label.gridx = k;
            gbc_label.gridy = i;
              
            slot_label[num_mon] = new JLabel(slot[num_mon]);
            slot_panel.add(slot_label[num_mon], gbc_label);
            num_mon ++;
         }
      }
          
          //Calculating the number of monsters in the monster box
      for(int i = 1; i <= 197; i++){
         try{
            BufferedReader in = new BufferedReader(new FileReader("Users/" + user_id +"/Monster Box/" + i + "" + ".txt")); 
            count++;
         }
         catch(IOException iox){
         }
      }
          
      System.out.println(count);
          
          //Storing the information of the monsters in the monster box
      mon_box = new MonsterBox(count);
      monster = mon_box.getBox();
          
      gbc_label.gridx = 0;
      gbc_label.gridy = 0;
          
          //Outputting the images of the monsters added to the monster box
      for(int i = 0; i < count; i++){
            
         slot_panel.remove(slot_label[i]);
         gbc_label.gridx = i - i/5 * 5;
            //x = num - num*5 * 5
         gbc_label.gridy = i / 5;
            //y = num / 5
         slot[i] = new ImageIcon(getClass().getResource("Monster Box/Monster Pics/" + monster[i].getId() + "" + ".jpg"));
         slot_label[i] = new JLabel(slot[i]);
         slot_panel.add(slot_label[i], gbc_label);
            
      }
        
          //Creating panel for buttons
      button_p = new JPanel (new GridBagLayout());
          
          //Creating Grid Bag Constraints to include spacing beside button on the screen
      gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(10,10,10,10);
          
          //Setting x and y coordinates to move the buttons around
      gbc_button.gridx = 0;
      gbc_button.gridy = 0;
          
          //Creating sorting buttons
      sort_id = new JButton("Sort by ID");
      button_p.add(sort_id, gbc_button);
          
      gbc_button.gridx = 1;
          
      sort_hp = new JButton("Sort by HP");
      button_p.add(sort_hp,gbc_button);
          
      gbc_button.gridx = 2;
          
      sort_atk = new JButton("Sort by atk");
      button_p.add(sort_atk,gbc_button);
          
      gbc_button.gridx = 3;
          
      sort_rcv = new JButton("Sort by rcv");
      button_p.add(sort_rcv,gbc_button);
          
      gbc_button.gridy = 2;
      gbc_button.gridx = 0;
          
      sort_name = new JButton("Sort by name");
      button_p.add(sort_name,gbc_button);
          
      gbc_button.gridx = 1;
          
      sort_element = new JButton("Sort by element");
      button_p.add(sort_element,gbc_button);
          
      gbc_button.gridx = 2;
          
      sort_type = new JButton("Sort by type");
      button_p.add(sort_type,gbc_button);

      //the action that occurs when the sort_id button is pressed
      sort_id.addActionListener(
            new ActionListener(){
            
               public void actionPerformed(ActionEvent e){
                  //Sorting the monster box by element
                  mon_box.sortById();
                  monster = mon_box.getBox();
                  
                  //Outputting the sorted images of the monsters into the monster box
                  for(int i = 0; i < count; i++){
                     //Removing the slot and replacing it with a photo of the monster
                     slot_panel.remove(slot_label[i]);
                     gbc_label.gridx = i - i/5 * 5;
                     gbc_label.gridy = i / 5;
                     slot[i] = new ImageIcon(getClass().getResource("Monster Box/Monster Pics/" + monster[i].getId() + "" + ".jpg"));
                     slot_label[i] = new JLabel(slot[i]);
                     slot_panel.add(slot_label[i], gbc_label);
                  
                  }                  
                  setContentPane(main_panel);
               }
            });
            
                  //the action that occurs when the sort_hp button is pressed
      sort_hp.addActionListener(
            new ActionListener(){
            
               public void actionPerformed(ActionEvent e){
                  //Sorting the monster box by element
                  mon_box.sortByHp();
                  monster = mon_box.getBox();
                  
                  //Outputting the sorted images of the monsters into the monster box
                  for(int i = 0; i < count; i++){
                     //Removing the slot and replacing it with a photo of the monster
                     slot_panel.remove(slot_label[i]);
                     gbc_label.gridx = i - i/5 * 5;
                     gbc_label.gridy = i / 5;
                     slot[i] = new ImageIcon(getClass().getResource("Monster Box/Monster Pics/" + monster[i].getId() + "" + ".jpg"));
                     slot_label[i] = new JLabel(slot[i]);
                     slot_panel.add(slot_label[i], gbc_label);
                  
                  }                  
                  setContentPane(main_panel);
               }
            });
            
      //the action that occurs when the sort_atk button is pressed
      sort_atk.addActionListener(
            new ActionListener(){
            
               public void actionPerformed(ActionEvent e){
                  //Sorting the monster box by element
                  mon_box.sortByAtk();
                  monster = mon_box.getBox();
                  
                  //Outputting the sorted images of the monsters into the monster box
                  for(int i = 0; i < count; i++){
                     //Removing the slot and replacing it with a photo of the monster
                     slot_panel.remove(slot_label[i]);
                     gbc_label.gridx = i - i/5 * 5;
                     gbc_label.gridy = i / 5;
                     slot[i] = new ImageIcon(getClass().getResource("Monster Box/Monster Pics/" + monster[i].getId() + "" + ".jpg"));
                     slot_label[i] = new JLabel(slot[i]);
                     slot_panel.add(slot_label[i], gbc_label);
                  
                  }                  
                  setContentPane(main_panel);
               }
            });
            
      //the action that occurs when the sort_rcv button is pressed
      sort_rcv.addActionListener(
            new ActionListener(){
            
               public void actionPerformed(ActionEvent e){
                  //Sorting the monster box by element
                  mon_box.sortByRcv();
                  monster = mon_box.getBox();
                  
                  //Outputting the sorted images of the monsters into the monster box
                  for(int i = 0; i < count; i++){
                     //Removing the slot and replacing it with a photo of the monster
                     slot_panel.remove(slot_label[i]);
                     gbc_label.gridx = i - i/5 * 5;
                     gbc_label.gridy = i / 5;
                     slot[i] = new ImageIcon(getClass().getResource("Monster Box/Monster Pics/" + monster[i].getId() + "" + ".jpg"));
                     slot_label[i] = new JLabel(slot[i]);
                     slot_panel.add(slot_label[i], gbc_label);
                  
                  }                  
                  setContentPane(main_panel);
               }
            });
          
          //the action that occurs when the sort_name button is pressed
      sort_name.addActionListener(
            new ActionListener(){
            
               public void actionPerformed(ActionEvent e){
                  //Sorting the monster box by element
                  mon_box.sortByName();
                  monster = mon_box.getBox();
                  
                  //Outputting the sorted images of the monsters into the monster box
                  for(int i = 0; i < count; i++){
                     //Removing the slot and replacing it with a photo of the monster
                     slot_panel.remove(slot_label[i]);
                     gbc_label.gridx = i - i/5 * 5;
                     gbc_label.gridy = i / 5;
                     slot[i] = new ImageIcon(getClass().getResource("Monster Box/Monster Pics/" + monster[i].getId() + "" + ".jpg"));
                     slot_label[i] = new JLabel(slot[i]);
                     slot_panel.add(slot_label[i], gbc_label);
                  
                  }                  
                  setContentPane(main_panel);
               }
            });
            
      //the action that occurs when the sort_element button is pressed
      sort_element.addActionListener(
            new ActionListener(){
            
               public void actionPerformed(ActionEvent e){
                  //Sorting the monster box by element
                  mon_box.sortByElement();
                  monster = mon_box.getBox();
                  
                  //Outputting the sorted images of the monsters into the monster box
                  for(int i = 0; i < count; i++){
                     //Removing the slot and replacing it with a photo of the monster
                     slot_panel.remove(slot_label[i]);
                     gbc_label.gridx = i - i/5 * 5;
                     gbc_label.gridy = i / 5;
                     slot[i] = new ImageIcon(getClass().getResource("Monster Box/Monster Pics/" + monster[i].getId() + "" + ".jpg"));
                     slot_label[i] = new JLabel(slot[i]);
                     slot_panel.add(slot_label[i], gbc_label);
                  
                  }                  
                  setContentPane(main_panel);
               }
            });


      //the action that occurs when the sort_type button is pressed
      sort_type.addActionListener(
            new ActionListener(){
            
               public void actionPerformed(ActionEvent e){
                  //Sorting the monster box by element
                  mon_box.sortByType();
                  monster = mon_box.getBox();
                  
                  //Outputting the sorted images of the monsters into the monster box
                  for(int i = 0; i < count; i++){
                     //Removing the slot and replacing it with a photo of the monster
                     slot_panel.remove(slot_label[i]);
                     gbc_label.gridx = i - i/5 * 5;
                     gbc_label.gridy = i / 5;
                     slot[i] = new ImageIcon(getClass().getResource("Monster Box/Monster Pics/" + monster[i].getId() + "" + ".jpg"));
                     slot_label[i] = new JLabel(slot[i]);
                     slot_panel.add(slot_label[i], gbc_label);
                  
                  }                  
                  setContentPane(main_panel);
               }
            });

            
            
      //Adding the panels 
      main_panel.add(slot_panel);
      main_panel.add(button_p);
      setContentPane(main_panel);
          
          
   }
            
   
   public static void main (String [] args){
          
      MonsterBoxFrame gui = new MonsterBoxFrame();
          
          //Setting size of the window
      gui.setSize(600,800);
      gui.setVisible(true);
          
          //Setting Title of the window
      gui.setTitle("Monster Box");
          
   }
        
        
        
        
}