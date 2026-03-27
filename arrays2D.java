public class arrays2D{
    public static void main(String[] args) {
        //here is a 1d array with 4 items indexed 0 to 3
        int[] nums1= {1,2,3,4};
        //this prints the 3rd item which is 3
        System.out.println(nums1[2]);
        //this creates an empty 1d array with 4 variables
        int[] nums2 = new int[4];
        //a 2D array with 3 rows and 4 columns
        int[][] nums3 = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //this prints out row 2 column 3 which is 7
        System.out.println(nums3[1][2]);
        //this creates an empty 2d array with 3 rows and 4 columns
        int[][] nums4 = new int[3][4];
        //this is a nested for loop with the outer loop
        //as the rows and the inner loop as the columns
        for (int i=0; i<3; i++){
            for (int j=0; j<4; j++){
                System.out.print(nums3[i][j]+" "); //prints each row
            }
            System.out.println(); //goes to the next row
        }
        int row1= nums3[0][0] + nums3[0][1] + nums3[0][2] + nums3[0][3];
        System.out.println("The sum of the first row is " + row1);
    }
}