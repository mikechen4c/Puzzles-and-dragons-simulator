import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class StartGame extends JFrame{
  
  //Variable declaration
  private JLabel intro;
  private JButton start;
  private JButton load;
  private JButton instructions;
  private static String user_id;
  private boolean check;
  private JPanel mainPanel;
  private JPanel panel_b;
  private JPanel panel_l;
  private GridBagConstraints gbc;
  private static int num_roll;
  private boolean exist;
  
  
  //Constructor
  public StartGame(){
   //Setting flow layout
    setLayout(new FlowLayout());
    
    //Creating main panel
    mainPanel = new JPanel();
    
    //Creating panels to put buttons, texts, labels into right places
    panel_b = new JPanel(new GridBagLayout());
    panel_l = new JPanel();
    
    //Creating Grid Bag Constraints to include spacing beside elements on the screen
    gbc = new GridBagConstraints();
    gbc.insets = new Insets(15,15,15,15);
    
    //Setting x and y coordinates to move the buttons around
    gbc.gridx = 0;
    gbc.gridy = 0;
    
    //Setting and adding text(label) on the screen
    intro = new JLabel("Welcome to our Puzzles and Dragons Rare Egg Machine simulator");
    panel_l.add(intro, gbc);
    
    //Setting and adding start,load and instructions buttons
    start = new JButton("Start New Game");
    panel_b.add(start, gbc);
    
    gbc.gridy = 1;
    
    load = new JButton("Load game from ID");
    panel_b.add(load, gbc);
    
    gbc.gridy = 2;
    
    instructions = new JButton("Instructions");
    panel_b.add(instructions, gbc);
    
    //Adding the panels to the main panel
    mainPanel.add(panel_l);
    mainPanel.add(panel_b);
    
    setContentPane(mainPanel);
    
    //the action that occurs when the start new game button is pressed
    start.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        
        menu(mainPanel,gbc);
        
        user_id = (int)(Math.random() * 10000000) + "";
        
        //Telling the users what their id is
        JOptionPane.showMessageDialog(null, "Your ID is: " + user_id);
        //Creates new folder with the user's ID
        File userID = new File("Users/"+user_id);
        userID.mkdir();
        
        try{
         BufferedWriter out = new BufferedWriter(new FileWriter("Users/" + user_id + ".txt"));
         out.close();
        }catch(IOException iox){
        } 
        
        //Creates a folder which contains all of the user's monsters in their monster box
        File box = new File ("Users/" + user_id + "/Monster Box");
        box.mkdir();
        
        //Creates a folder which contains all the monsters in their team
        File team = new File ("Users/" + user_id + "/Team");
        team.mkdir();
      }
      
    });
    
    //the action that occurs when the Load button is pressed
    load.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
          exist = false;
          user_id = JOptionPane.showInputDialog("Enter your id");
           
         //Checking if the user exists
         try{
         BufferedReader in = new BufferedReader (new FileReader("Users/" + user_id + ".txt"));
            exist = true;
            in.close();
         }catch(IOException iox){
         }
         
         if(exist == true){
            menu(mainPanel, gbc);
         }else{
            JOptionPane.showMessageDialog(null, "Error, user does not exist");
         }
         
      }  
    });
    
    //the action that occurs when the instructions button is pressed
    instructions.addActionListener(
                                   new ActionListener(){
      public void actionPerformed(ActionEvent e){
        
        JOptionPane.showMessageDialog(null, "The objective of this puzzles and dragons similator is to \n" + 
                                      "build a team of monsters strong enough to defeat the boss. \n" + 
                                      "You can do this by 'rolling' for a strong monster and managing \n" + 
                                      "your monster box in order to build a strong team and beat the boss. \n"+
                                      "click Roll button to roll for a random monster\n" +
                                      "click monster box to check out the monsters that you have, \n" +
                                      "you can also sort you monsters in your monster box.\n" +
                                      "Click the edit team button to select the monsters that you want on your team.\n" +
                                      "Click the save button to save all your monsters untill next time.\n" + 
                                      "To exit, click x on the top right hand corner" );
        
      }
      
    });  
    
    
  }  
  
      //Accessor
  public static String getUser_id(){
    return user_id;
  }
    public static int getNum_roll(){
    return num_roll;
  }
  
  public static void main (String [] args){
    
    StartGame gui = new StartGame();
    
    //Allows the program to close when you exit
    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Setting size of the window
    gui.setSize(500,500);
    gui.setVisible(true);
    gui.setResizable(false);
    
    //Setting Title of the window
    gui.setTitle("Game Menu");
    
    
  }
  
  
  
  
  
  //This method displays the menu screen
  public void menu (JPanel main,GridBagConstraints gb){
    
    //Clearing the screen
    main.removeAll();
    
    //Creating new JPanel for buttons inside the window
    JPanel button = new JPanel(new GridBagLayout());
    
    //Creating Roll, Monster box, edit team, fight and save buttons
    JButton roll;  
    JButton monster_box;
    JButton team;
    JButton fight;
    JButton save;
    
    //Creating ID label 
    JLabel id_label;
    
    //Creating panel to place id
    JPanel id_panel = new JPanel(new GridBagLayout());
    
    id_label = new JLabel("Your id is: " + user_id);
    id_panel.add(id_label);
    
    
    gb.insets = new Insets(15,15,15,15);
    
    //Setting x and y coordinates to move the buttons around
    gb.gridx = 0;
    gb.gridy = 0;     
    
    //Setting Roll, Monster box, edit team, fight and save buttons
    roll = new JButton("Roll");
    button.add(roll,gb);
    
    gb.gridy = 1;
    monster_box = new JButton("Monster Box");
    button.add(monster_box,gb);
    
    gb.gridy = 2;
    team = new JButton("Edit Team");
    button.add(team,gb);
    
    gb.gridy = 3;
    fight = new JButton("Challenge Boss");
    button.add(fight,gb);
    
    
    //Setting the button panels to the center
    main.add(button, BorderLayout.NORTH);
    main.add(id_panel);
    
    
    //the action that occurs when the roll button is pressed
    roll.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
                 
        roll();
        num_roll++;
        
      }
    });
    
    //the action that occurs when the monsterBox button is pressed
    monster_box.addActionListener(new ActionListener(){
      
      public void actionPerformed(ActionEvent e){
        
        monsterBox();
        
        
      }
      
    });
    
    //the action that occurs when the team button is pressed
    team.addActionListener(new ActionListener(){
      
      public void actionPerformed(ActionEvent e){
        
        editTeam();
        
      }
      
    });
    
    //the action that occurs when the Challenge boss button is pressed
    fight.addActionListener(new ActionListener(){
      
      public void actionPerformed(ActionEvent e){
        
        fightBoss();
        
      }
      
    });                                       
    
    
    
    //Displays the contents
    setContentPane(main);
  }    
  
  
  //This method calls the rolling class 
  public void roll(){
        Roll r = new Roll();
  }
  
  //This method calls the frame for the monsterBox
  public void monsterBox(){
  //Calling the MonsterBoxFrame class
  MonsterBoxFrame box_Frame = new MonsterBoxFrame();
  
    //Setting size of the window
    box_Frame.setSize(620,750);
    box_Frame.setVisible(true);
    box_Frame.setResizable(false);
    
    //Setting Title of the window
    box_Frame.setTitle("Monster Box");
  }
  
  //This method calls the frame for the edit team
  public void editTeam(){
      //Calling the EditTeamFrame class
      EditTeamFrame team_Frame = new EditTeamFrame();
      
      //Setting the size of the window and making it visible
      team_Frame.setSize(650,350);
      team_Frame.setVisible(true);
      team_Frame.setResizable(false);
      
      //Setting the title of the window
      team_Frame.setTitle("Edit Team");
  }
  
  //This method calls the fram for the fight boss frame
  public void fightBoss(){
      //Calling the FightBossFrame class
      FightBossFrame boss_frame = new FightBossFrame();
      
      //Setting the size of the window and making it visible
      boss_frame.setSize(650,500);
      boss_frame.setVisible(true);
      boss_frame.setResizable(false);
      
      //Setting the title of the window
      boss_frame.setTitle("Challenge Boss");
  
  
  }
  
}

