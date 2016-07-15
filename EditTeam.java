import java.io.*;
public class EditTeam{

   private Monster[] team;
   private int num_monster;
   
   //Constructor
   public EditTeam(int numMon){
      num_monster = numMon;
      team = new Monster[num_monster];
      initMonster();
   }
   
      //Accessors
      public Monster[] getTeam(){
      return team;
   }
   
   //This method initialize all the monsters in the team
   private void initMonster(){
      int count = 0;
      
         for(int i = 1; i <= 197; i++){
         try{
            BufferedReader in = new BufferedReader(new FileReader("Users/" + StartGame.getUser_id() +"/Team/" + i + "" + ".txt"));
            team[count] = new Monster(in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), in.readLine(),Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),Integer.parseInt(in.readLine()));
            count++;
            in.close();
         
         }catch(IOException iox){
         
         }
         }
   }

     //This method calculates the total Hp of the monsters in the team
     public int total_Hp(){
      int total = 0;
      
      for(int i = 0; i < num_monster; i++){
         total = total + team[i].getHp();
      }
      return total;
     
     }
     
     //This method calculates the total Attack of the monsters in the team
     public int total_Atk(){
      int total = 0;
      
      for(int i = 0; i < num_monster; i++){
         total = total + team[i].getAtk();
      }
      return total;
     
     }
     
     //This method calculates the total recovery of the monsters in the team
     public int total_Rcv(){
      int total = 0;
      
      for(int i = 0; i < num_monster; i++){
         total = total + team[i].getRcv();
      }
      return total;
     
     }
     
     
     
     /* //This method determines where the monster is in the monster box in a recursive way
   //Returns -1 if the monster is not found
   public int mon_search(Monster[] monCheck, int id, int low, int high){
        
      if(low > high){
         return -1;
      }
      int mid = (low + high) / 2;
        
      if(monCheck[mid].getId() == id){
         return mid;
      }
      else if(monCheck[mid].getId() < id){
         return mon_search(monCheck, id, mid + 1, high);
      }
      else{
         return mon_search(monCheck, id, low, mid - 1);
      }      
   }
   */


}