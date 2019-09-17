import java.io.File;

public class Main {
    // By definition, the first two numbers in the Fibonacci sequence are either 1 and 1, or 0 and 1,
    // depending on the chosen starting point of the sequence,
    // and each subsequent number is the sum of the previous two.
    // Assignment 1
    // Write a recursive method to create a Fibonacci sequence of 20 numbers.
    //
    // Assignment 2
    // Create a Java method to display the sequence of numbers in the Collatz conjecture.
    //
    //The Collatz conjecture can be summarized as follows:
    //
    // Take any positive integer (Links to an external site.) n.
    // If n is even, divide it by 2 to get n / 2. If n is odd, multiply it by 3 and add 1 to obtain 3n + 1.
    // Repeat the process until you reach a result of 1.
    // The conjecture is that no matter what number you start with, you will always eventually reach 1.
    //
    static int n1=0,n2=1,n3=0;

    public static void main(String[] args) {
        walkin(new File("C:\\Users\\GBTC440004ur\\Desktop")); //Replace this with a suitable directory
        int count=20;                         // the number of fibonacci numbers desired
        System.out.println();
        System.out.print(n1 + " " + n2);      // printing 0 and 1   - initial values
        calcFibonacci(count - 2);       // n-2 because 2 numbers are already printed
        System.out.println("Process Collatz for an initial value of 30.");
        n1 = 0;
        collatz(30);
    }

    static void calcFibonacci(int count){
        if( count > 0 ){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" " + n3);
            calcFibonacci(count - 1);
        } else {
            System.out.println();
            System.out.println("Finished.");
        }
    }

    static void collatz(int init){
        //If n is even, divide it by 2 to get n / 2.
        // If n is odd, multiply it by 3 and add 1 to obtain 3n + 1.
        n3 = init;
        // n1 : loopCnt

        if (init % 2 == 0) {
            // Even Number
            n3 = n3/2;

        } else {
            // Odd Number
            n3 = 3*n3 + 1;
        }
        n1++;
        System.out.println("Count: " + n1);
        if (n3 > 1){
            collatz(n3);
        }
    }

    public static void fibonaciCalc(int limit, int sumNo, int num, int count){
        // limit = 20
        // num = 0      IC
        // sumNo = 1    IC
        // count = 0
        sumNo = sumNo + num;
        System.out.println("Next Fibonaci Element: " + sumNo);
        count++;
        if (count > limit)
        {
            return;
        }

        fibonaciCalc(20, sumNo, num, count);
    }

    /**
     * Recursive function to descend into the directory tree and find all the files
     * that end with ".mp3"
     * @param dir A file object defining the top directory
     **/
    public static void walkin(File dir) {
        System.out.println("Walking through directory: "+ dir.toString());
        String pattern = ".txt";
        File listFile[] = dir.listFiles();
        if (listFile != null){
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    walkin(listFile[i]);
                } else {
                    if (listFile[i].getName().endsWith(pattern)) {
                        System.out.println(listFile[i].getPath());
                    }
                }
            }
        }
    }
}
