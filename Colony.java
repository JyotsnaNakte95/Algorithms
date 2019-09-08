import java.util.Arrays;

public class Colony
{
  //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static int[] cellCompete(int[] cells, int days)
  {
	  int[] temp = new int[cells.length]; 
	  temp = Arrays.copyOf(cells, cells.length);
	  System.out.println(Arrays.toString(temp));
    // INSERT YOUR CODE HERE
        for(int j=0;j<days;j++){
        for(int i=0;i<cells.length;i++){
            if(i==0 || i==cells.length-1){
            	//System.out.println(i);
            	if(i==0){
            		if(temp[i+1]==0){
            			cells[i]=0;
            		}
            		else{
            			cells[i]=1;
            		}
            	}
            	else if(i==cells.length-1){ 
            		if(temp[i-1]==0){
            			cells[i]=0;
            	}else{
                    cells[i]=1;
                }
            }
            }
            else{
                if(temp[i-1]==0&&temp[i+1]==0){
                    cells[i]=0;
                }
                else if(temp[i-1]==1&&temp[i+1]==1){
                    cells[i]=0;
                }
                else if(temp[i-1]==1&&temp[i+1]==0){
                    cells[i]=1;
                }
                else if(temp[i-1]==0&&temp[i+1]==1){
                    cells[i]=1;
                }
            }
        }
        } 
        
        return cells;
  }
  // METHOD SIGNATURE ENDS
  
  public static void main(String[] args){
	  int[] cells= new int[]{1,0,0,0,0,1,0,0};
	  int days=1;
	  int[] results= new int[cells.length];
	  results=cellCompete(cells,days);
	  System.out.println(Arrays.toString(results));
  }
}