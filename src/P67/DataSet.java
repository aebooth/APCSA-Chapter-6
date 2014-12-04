package P67;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataSet {
    public static void main(String[] args) throws FileNotFoundException {
        double[] nums = readDoubleArray("src/dataset/text.txt");
        //print array
        for (double num:nums){
        System.out.println(num);
        }
        //print mean
        System.out.println("mean: "+mean(nums));
        //print stdev
        System.out.println("stdev: "+stnddev(nums));
    }
    
    public static double mean(double[] nums) {
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
           sum+=nums[i];
        }
        return sum / nums.length;
    }
    
    public static double stnddev(double[] nums) {
        double s = 0;
        double sum = 0;
        double sqsum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            sqsum+=nums[i] * nums[i];
        }
        
        return Math.sqrt((sqsum - sum * sum / nums.length) / (nums.length - 1));
    }
    
    public static double[] readDoubleArray(String file) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(file));
        //get number of tokens in the file
        int count = 0;
        while(scan.hasNext()) {
            count++;
            scan.next();
        }
        //flush toilet....
        scan.close();
        
        //Re-scan file and fill array with length equal to count from above 
        scan = new Scanner(new File(file));
        double[] nums = new double[count];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scan.nextDouble();
        }
        
        //return array for use in mean() and stnddev()
        return nums;
    }
}