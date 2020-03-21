package day0;

import java.util.HashMap;
import java.util.Scanner;

public class meanMedianMode {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n ; i++) {
            arr[i] = scanner.nextInt();
            sum = sum + arr[i];
        }

        // Insertion sort
        for (int i = 1; i < n ; i++) {
            int temp = arr[i];
            int hole = i;
            while(hole>0 && arr[hole-1] > temp){
                arr[hole] = arr[hole-1];
                hole--;
            }
            arr[hole] = temp;
        }

        //mean
        double mean = (double)sum/n;

        //median
        double median = 0;
        if(n%2 == 0){
            median = (double)(arr[(n/2)-1] + arr[(n/2)])/2;
        }else{
            median = arr[(n-1)/2];
        }

        //mod
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int max = 1;
        int mode = arr[0];
        int count = 0;
        for (int j = 0; j < n; j++) {
            if(hm.get(arr[j]) == null){
                hm.put(arr[j], 1);
            }else{
                count = hm.get(arr[j]);
                count++;
                hm.put(arr[j], count);
            }

            if(count > max){
                max = count;
                mode = arr[j];
            }
        }

        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
        System.out.println("Mode: " + mode);
    }
}
