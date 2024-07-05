import java.io.*;
import java.util.*;

class Main {
    private static int[] arr;
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);	
		
		int left = 1;
		int right = arr[n - 1] - arr[0] + 1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if (check(mid) < m) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(left - 1);
	}
	
	private static int check (int distance) {
		int count = 1;
		int prev = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			int current = arr[i];
			if (current - prev >= distance) {
				count++;
				prev = current;
			}
		}
        
		return count;
	}
}