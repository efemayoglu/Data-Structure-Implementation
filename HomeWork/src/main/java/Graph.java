public class Graph {

    public static void print(int[][] matris){

   /*
        1 2 3 4
      1 1 1 1 1
      2 1 0 0 0
      3 0 1 0 1
      4 0 1 1 0
      1'den 1'e 2'ye 3'e 4'e
      2'den 1'e
      3'ten 2'ye 4'e
      4'ten 2'ye 3'e
    */

        for (int i =0; i< matris.length; i++){
            for(int j = 0;j<matris.length/*Dimension kısmı*/;j++){
                System.out.print(matris[i][j]+ " ");
            }
            System.out.print("\n");
        }
    }
    public static void main(String args[]){
        int[][] matris = new int[4][4];

        matris[0][0] = 1;matris[0][1] = 1; matris[0][2] = 1; matris[0][3] = 1;
        matris[1][0] = 1;matris[1][1] = 0; matris[1][2] = 0; matris[1][3] = 0;
        matris[2][0] = 0;matris[2][1] = 1; matris[2][2] = 0; matris[2][3] = 1;
        matris[3][0] = 0;matris[3][1] = 1; matris[3][2] = 1; matris[3][3] = 0;

        print(matris);




    }
}
