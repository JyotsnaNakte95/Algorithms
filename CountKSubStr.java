import java.util.Arrays; 
  
public class CountKSubStr 
{ 
    // Function to count number of substrings 
    // with exactly k unique characters 
    int countkDist(String inputString, int num) 
    { 
        // Initialize result 
int input26Characters[] = new int[26];
        
        int numberOfSubstrings=0;
        
        for(int i=0;i<inputString.length();i++){
            int count=0;
           
           for(int l=0;l<input26Characters.length;l++){
            input26Characters[l]=0;
            }
            
           for(int m=i;m<inputString.length();m++){
               if(input26Characters[inputString.charAt(m)-'a']==0)
                   count++;
               
               
              input26Characters[inputString.charAt(m)-'a']++;
              
              if(count==num)
                  numberOfSubstrings++;
              
           } 
        
        
        
        }
        
        
        return numberOfSubstrings;
    } 
  
    // Driver Program 
    public static void main(String[] args) 
    { 
        CountKSubStr ob = new CountKSubStr(); 
        String ch = "abafg"; 
        int k = 2; 
        System.out.println("Total substrings with exactly " + 
                           k +    " distinct characters : "
                           + ob.countkDist(ch, k)); 
    } 
} 