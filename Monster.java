public class Monster{

   private String name;
   private int id;
   private String type;
   private String element;
   private int hp;
   private int atk;
   private int rcv;
   
   //Constructor
   public Monster(String new_name, int new_id, String new_type, String new_element, int new_hp, int new_atk, int new_rcv){
      name = new_name;
      id = new_id;
      type = new_type;
      element = new_element;
      hp = new_hp;
      atk = new_atk;
      rcv = new_rcv;
   
   }
   
   
   //accessors
   public String getName(){
      return name;
   }

   public int getId(){
      return id;
   }
   
   public String getType(){
      return type;
   }
   
   public String getElement(){
      return element;
   }
   
   public int getHp(){
      return hp;
   }
   
   public int getAtk(){
      return atk;
   }
   
   public int getRcv(){
      return rcv;
   }
   
   //mutators
   public void setName(String new_name){
      name = new_name;
   }

   public void setId(int new_id){
      id = new_id;
   }
   
   public void setType(String new_type){
      type = new_type;
   }
   
   public void setElement(String new_element){
      element = new_element;
   }
   
   public void setHp(int new_hp){
      hp = new_hp;
   }
   
   public void setAtk(int new_atk){
      atk = new_atk;
   }
   
   public void setRcv(int new_rcv){
      rcv = new_rcv;
   }   
   
}