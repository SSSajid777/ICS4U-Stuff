    public class avg2_homework9 {
        public static void average1(int n1, int n2, int n3, int n4){
            int average1 = (n1+n2+n3+n4)/4;
            System.out.println("The average of the 4 numbers is " + average1);
            if (average1 >= 70) {
                System.out.println(" High average");
            } else if (average1>50 || average1<69){
                System.out.println("Medium average");
            }
            else{
                System.out.println("Low average");
            }
        }
    }
