package JavaCode;


public class shuffleFunction {

    
    public static void shuffle(Object[] array) {
        int numberOfElements = array.length;
    
        
     for(int i = 0; i < numberOfElements; i++){
            int s = i + (int)(Math.random() * (numberOfElements - i));
            
            Object temp = array[s];
            array[s] = array[i];
            array[i] = temp;
        
        }
    } 

   
    
    public static void shuffleActioncardsBegin()
{
      
        String[] strOfCharacters = {"Cellar", "Chapel", "Chancellor", "Village", "Woodcutter", 
        "Feast", "Militia","Moneylender", "Remodel", "Smithy", "Spy", "Thief", 
        "Throne Room", "Council Room", "Festival", "Laboratory", "Library",
        "Market", "Mine", "Witch", "Adventurer", "Gardens", "Workshop",
        "Bureaucrat"};
        
        shuffleFunction.shuffle(strOfCharacters);
        
        for(int i = 0; i < strOfCharacters.length; i++){
           
            System.out.print(strOfCharacters[i] + " ");
         
    }
     
} 
    
    
    public static void main(String[] args) {
    
        shuffleActioncardsBegin();
        
    }
    
}
    

