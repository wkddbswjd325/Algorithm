package AlgorithmHw;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_재귀 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {4,9,11,23,2,19,7,8,5,17};
		Arrays.sort(arr);

		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		
		if(binarySearch(arr, key)) System.out.println("있음");
		else System.out.println("없음");
		
		sc.close();
		
	}

	public static boolean binarySearch(int[] arr, int key) {
		// TODO Auto-generated method stub
		
		int start = 0;
		int end = arr.length-1;
		int middle;
		
		while(start <= end) {
			middle = (start+end)/2;
			
			if(arr[middle] == key) return true;
			
			else if(arr[middle] < key) start = middle+1;
			else end = middle-1;
			
		}
		
		return false;
		
	}

}
