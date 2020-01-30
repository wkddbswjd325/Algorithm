package AlgorithmHw;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_반복 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {4,9,11,23,2,19,7,8,5,17};
		Arrays.sort(arr);

		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		
		if(binarySearch(arr, key , 0, arr.length-1)) System.out.println("있음");
		else System.out.println("없음");
		
		sc.close();
		
	}

	public static boolean binarySearch(int[] arr, int key, int start, int end) {
		// TODO Auto-generated method stub
		
		if(start > end) return false;
		
		int middle = (start+end)/2;
			
		if(arr[middle] == key) return true;
			
		else if(arr[middle] < key) 
			return binarySearch(arr, key, middle+1, end);
		else 
			return binarySearch(arr, key, start, middle-1);
		
		
	}
}
