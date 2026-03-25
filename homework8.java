public class homework8 {
    public static void main(String[] args) {
        /* 
        int [][] nums1= new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(nums1[i][j]+" ");

            }
            System.out.println();
        }
            */

        int [][] nums2= new int[][] {{1,2,3}, {4,5,6}, {7,8,9}, {10, 11, 12}};
        for(int i=0; i<4; i++){
            int rowSum = 0;
            for(int j=0; j<3; j++){
                System.out.print(nums2[i][j]+" ");
                rowSum+= nums2[i][j];

            }
            System.out.println("Row Sum " + rowSum);
        }
    }
}
