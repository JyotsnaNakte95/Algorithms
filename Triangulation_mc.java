import java.util.Scanner;
public class Triangulation_mc {
	public static double calculateEdgeLength(float x1, float y1, float x2, float y2)
    {
        return Math.sqrt(Math.pow((x2- x1),2) + Math.pow((y2 - y1),2));
    }

    public static double triangulationSum(float [] arrayX, float[] arrayY, int i, int j, int k)
    {
        double lenght1 = calculateEdgeLength(arrayX[i], arrayY[i], arrayX[j], arrayY[j]);
        double lenght2 = calculateEdgeLength(arrayX[j], arrayY[j], arrayX[k], arrayY[k]);
        double lenght3 = calculateEdgeLength(arrayX[k], arrayY[k], arrayX[i], arrayY[i]);
        double totalLength =lenght1 + lenght2 + lenght3;

        return totalLength;
    }

    public static double minTriangulation(int noOfVertices,float [] arrayX, float [] arrayY){
       //Edge case
        if (noOfVertices < 3)
            return 0;

        double[][] matrix = new double[noOfVertices][noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            for (int j = i ; j < noOfVertices; j++) {
                if (j < i+2){
                    matrix[i][j] = 0;
                }
                else {
                    matrix[i][j] = 1000000.0;
                    for (int k = i+1; k < j; k++) {
                        double val = matrix[i][k] + matrix[k][j] + triangulationSum(arrayX,arrayY,i,j,k);
                        if (matrix[i][j] > val)
                            matrix[i][j] = val;
                    }
                }
            }
        }
        return  matrix[0][noOfVertices-1];
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int noOfVertices = sc.nextInt();

        float[] arrayX = new float[noOfVertices];
        float[] arrayY = new float[noOfVertices];

        for(int i=0; i< noOfVertices; i++) {
            arrayX[i] = sc.nextFloat();
            arrayY[i] = sc.nextFloat();
        }
        sc.close();
        //DecimalFormat numberFormat = new DecimalFormat("#.0000");
        System.out.println(minTriangulation(noOfVertices,arrayX, arrayY));
    }

}
