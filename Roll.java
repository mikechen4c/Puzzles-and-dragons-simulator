import java.io.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Roll{
  //Variable declaration
    private int random = (int)(Math.random() * 197) + 1;
    private String picName = "Monster Box/Monster Pics/" + random + "" + ".jpg";
    private String fileName = "Monster Box/Monster Stats/" + random + "" + ".txt";
    private ImageIcon random_monster;
    private JLabel monster_pic;
    private String mon_name;
    private int mon_id;
    private String type;
    private String element;
    private int hp;
    private int atk;
    private int rcv;
    private Monster mon_info;
    private MonsterBox mon_box;
    private int free_slot;
    private int num_mon = 0;
    


  
//This method shows the monster that the user rolled and stores it
  public Roll(){
  
   //Calculating the number of monsters that the user has in his box
      for(int i = 1; i <= 197; i++){
         try{
            BufferedReader in = new BufferedReader(new FileReader("Users/" + StartGame.getUser_id() +"/Monster Box/" + i + "" + ".txt")); 
            num_mon++;
         }
         catch(IOException iox){
         }
      }
      
      //Rolling for a new monster only if the box has 25 or less monsters in it
      if(num_mon != 25){
    
    //Taking the stats and the photos of the monster and outputting the photos on one window and the stats on another
    try{
      //Loading the image
      BufferedImage image = ImageIO.read(new File(picName));
      JLabel picLabel = new JLabel(new ImageIcon(picName));
      
      
      //Loading and outputting the stats
      BufferedReader in = new BufferedReader(new FileReader(fileName)); 
      
      //Saving the stats of the monster
      mon_name = in.readLine();
      mon_id = Integer.parseInt(in.readLine());
      type = in.readLine();
      element = in.readLine();
      hp = Integer.parseInt(in.readLine());
      atk = Integer.parseInt(in.readLine());
      rcv = Integer.parseInt(in.readLine());
      in.close();
      //Calling the monster class to store the info of the monster
      mon_info = new Monster(mon_name, mon_id, type, element, hp, atk, rcv);
      
      //Displaying the image and the stats of the monster that you rolled
      JOptionPane.showMessageDialog(null, picLabel, "Monster", JOptionPane.PLAIN_MESSAGE, null);
      JOptionPane.showMessageDialog(null,"The name of the monster is: " + mon_name + "\nMonster ID: " + mon_id + "\nMonster Type: "
                                      + type + "\nMonster Element: " + element + "\n Monster HP:" + hp + "\nMonster Attack: " + atk +
                                    "\nMonster Recovery: " + rcv);
      
    }
    catch(IOException iox){
      JOptionPane.showMessageDialog(null,"Error, File not found");      
    }
    
   saveMonster();
   }
   //Else outputting a message saying the box is full
   else{   
      JOptionPane.showMessageDialog(null,"The monster box is full, you cannot roll for any more monsters");
   }
    
  }
  
      //Accessors
    public int getMon_id(){
      return mon_id;
    }
    public String getRandom(){
      return random + "";
    }
  
    //Method that saves the monster rolled to the user's monster box
  private void saveMonster(){
    String id; 
    
    //Gets the user's id
    id = StartGame.getUser_id();
    System.out.println(id);
    try{
      BufferedWriter out = new BufferedWriter (new FileWriter ("Users/" + id + "/" + "Monster Box/" + mon_id + ".txt"));
      //Converts the variables to string
      String monsterID = mon_id + "";
      String health = hp + "";
      String attack = atk + "";
      String recovery = rcv + "";
      
      //Writes all the rolled monster's info onto a text file     
      out.write(mon_name);
      out.newLine();
      out.write(monsterID);
      out.newLine();
      out.write(type);
      out.newLine();
      out.write(element);
      out.newLine();
      out.write(health);
      out.newLine();
      out.write(attack);
      out.newLine();
      out.write(recovery);
      
      out.close();
    } catch (IOException iox){
      System.out.println("wtf");
    }
  }
}