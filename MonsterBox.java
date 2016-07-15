import java.io.*;
public class MonsterBox{

   private Monster[] box;
   private int num_monster;
   
   
   //Constructor
   public MonsterBox(int numMon){
      num_monster = numMon;
      box = new Monster[num_monster];
      initMonster();
   }
   
   //Accessors
      public Monster[] getBox(){
      return box;
   }
   
   //This method initialize all the monsters in the box
   private void initMonster(){
      int count = 0;
      
         for(int i = 1; i <= 197; i++){
         try{
            BufferedReader in = new BufferedReader(new FileReader("Users/" + StartGame.getUser_id() +"/Monster Box/" + i + "" + ".txt"));
            box[count] = new Monster(in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), in.readLine(),Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),Integer.parseInt(in.readLine()));
            count++;
            in.close();
         
         }catch(IOException iox){
         
         }
         }
   }
   
   //This method sorts the monsters by name
   public void sortByName(){
   
     for(int i = 1; i < num_monster; i++){
       Monster temp = box[i];
       int empty = i;
       for(int j = i - 1; j >= 0 && (box[j].getName()).compareTo(temp.getName()) > 0; j--){
         box[j+1] = box[j];
         empty = j;
       }
       box[empty] = temp;
     }
   
   }
   
      //This method sorts the monsters by id
   public void sortById(){
   
     for(int i = 1; i < num_monster; i++){
       Monster temp = box[i];
       int empty = i;
       for(int j = i - 1; j >= 0 && (temp.getId() - box[j].getId()) < 0; j--){
         box[j+1] = box[j];
         empty = j;
       }
       box[empty] = temp;
     }
   
   }
   
      //This method sorts the monsters by type
   public void sortByType(){
   
     for(int i = 1; i < num_monster; i++){
       Monster temp = box[i];
       int empty = i;
       for(int j = i - 1; j >= 0 && (box[j].getType()).compareTo(temp.getType()) > 0; j--){
         box[j+1] = box[j];
         empty = j;
       }
       box[empty] = temp;
     }
   
   }
   
         //This method sorts the monsters by element
   public void sortByElement(){
   
     for(int i = 1; i < num_monster; i++){
       Monster temp = box[i];
       int empty = i;
       for(int j = i - 1; j >= 0 && (box[j].getElement()).compareTo(temp.getElement()) > 0; j--){
         box[j+1] = box[j];
         empty = j;
       }
       box[empty] = temp;
     }
   
   }
   
      //This method sorts the monsters by hp
   public void sortByHp(){
   
     for(int i = 1; i < num_monster; i++){
       Monster temp = box[i];
       int empty = i;
       for(int j = i - 1; j >= 0 && (temp.getHp() - box[j].getHp()) > 0; j--){
         box[j+1] = box[j];
         empty = j;
       }
       box[empty] = temp;
     }
   
   }
   
      //This method sorts the monsters by atk
   public void sortByAtk(){
   
     for(int i = 1; i < num_monster; i++){
       Monster temp = box[i];
       int empty = i;
       for(int j = i - 1; j >= 0 && (temp.getAtk() - box[j].getAtk()) > 0; j--){
         box[j+1] = box[j];
         empty = j;
       }
       box[empty] = temp;
     }
   
   }
   
   
      //This method sorts the monsters by rcv
   public void sortByRcv(){
   
     for(int i = 1; i < num_monster; i++){
       Monster temp = box[i];
       int empty = i;
       for(int j = i - 1; j >= 0 && (temp.getRcv() - box[j].getRcv()) > 0; j--){
         box[j+1] = box[j];
         empty = j;
       }
       box[empty] = temp;
     }
   
   }
   

   
   
   
     

}