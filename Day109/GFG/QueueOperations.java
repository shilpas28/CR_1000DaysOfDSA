//GFG
//Queue Operations
//Time complexity: O(N*M)
//Space complexity: O(N)

package GFG;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueOperations {

    public static void main(String[] args) {
        // Taking input using scanner class
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		while(testcase-- > 0){
		    // Declaring Queue
		    Queue<Integer> q = new LinkedList<>();
		    int n = sc.nextInt();
		    
		    // Invoking object of Geeks class
		    QueueOperations obj = new QueueOperations();
		    
		    for(int i = 0;i<n;i++){
		        int k = sc.nextInt();
		        obj.insert(q, k);
		    }
		   
		    int x = sc.nextInt();
		    for(int i = 0;i<x;i++){
		        int k = sc.nextInt();
		        int f = obj.findFrequency(q, k);
		        if(f != 0){
		            System.out.println(f);
		        }
		        else{
		            System.out.println("-1");
		        }
		    }
		}
    }

    static HashMap<Integer, Integer> mm;
    static boolean a = false;
    // Function to insert element into the queue
    void insert(Queue<Integer> q, int k) {
        // Your code here
        if (a == false) {
            mm = new HashMap<>();
            a = true;
        }
        q.add(k);
        mm.putIfAbsent(k, 0);
        mm.put(k, mm.get(k) + 1);
    }

    // Function to find frequency of an element
    // rteturn the frequency of k
    int findFrequency(Queue<Integer> q, int k) {
        // Your code here
        a = false;
        if (mm.get(k) == null)
            return 0;
        return mm.get(k);
    }
}
