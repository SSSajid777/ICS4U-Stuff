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

    }
}