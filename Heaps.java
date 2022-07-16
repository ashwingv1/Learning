import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heaps {

    /*
Q4. Maximum array sum after B negations
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].

You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.



Problem Constraints
1 <= length of the array <= 5*105
1 <= B <= 5 * 106
-100 <= A[i] <= 100



Input Format
The first argument given is an integer array A.
The second argument given is an integer B.



Output Format
Return an integer denoting the maximum array sum after B modifications.



Example Input
Input 1:

 A = [24, -68, -29, -9, 84]
 B = 4
Input 2:

 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10


Example Output
Output 1:

 196
Output 2:

 362


Example Explanation
Explanation 1:

 Final array after B modifications = [24, 68, 29, -9, 84]
Explanation 2:

 Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]

*/
    public int solve1(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : A) minHeap.add(i);
        for (int i = 0; i < B; i++) {
            int n = minHeap.poll();
            n = -1 * n;
            minHeap.add(n);
        }
        int sum = 0;
        while (!minHeap.isEmpty()) {
            int a = minHeap.poll();
            sum += a;
        }
        return sum;

    }

    /*
Q3. Product of 3
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given an integer array A of size N.

You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.

Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.



Problem Constraints
1 <= N <= 105
0 <= A[i] <= 103



Input Format
First and only argument is an integer array A.



Output Format
Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [10, 2, 13, 4]


Example Output
Output 1:

 [-1, -1, 6, 24, 60]
Output 2:

 [-1, -1, 260, 520]


Example Explanation
Explanation 1:

 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 1 * 2 * 3 = 6
 For i = 4, ans = 2 * 3 * 4 = 24
 For i = 5, ans = 3 * 4 * 5 = 60

 So, the output is [-1, -1, 6, 24, 60].

Explanation 2:

 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 10 * 2 * 13 = 260
 For i = 4, ans = 10 * 13 * 4 = 520

 So, the output is [-1, -1, 260, 520].

    */
    public ArrayList<Integer> solve2(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int n = A.size();
        for (int i = 0; i < n; i++) {
            maxHeap.add(A.get(i));
            if (i < 2) B.add(-1);
            else {
                int i1 = maxHeap.poll();
                int i2 = maxHeap.poll();
                int i3 = maxHeap.peek();
                int res = i1 * i2 * i3;
                B.add(res);
                maxHeap.add(i2);
                maxHeap.add(i1);
            }
        }
        return B;
    }

    /*
   Q1. Magician and Chocolates
   Solved
   character backgroundcharacter
   Stuck somewhere?
   Ask for help from a TA and get it resolved.
   Get help from TA.
   Problem Description
   Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
   In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.

   Find the maximum number of chocolates that the kid can eat in A units of time.

   NOTE:

   floor() function returns the largest integer less than or equal to a given number.
   Return your answer modulo 109+7


   Problem Constraints
   1 <= N <= 100000
   0 <= B[i] <= INT_MAX
   0 <= A <= 105



   Input Format
   The first argument is an integer A.
   The second argument is an integer array B of size N.



   Output Format
   Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.



   Example Input
   Input 1:

    A = 3
    B = [6, 5]
   Input 2:

    A = 5
    b = [2, 4, 6, 8, 10]


   Example Output
   Output 1:

    14
   Output 2:

    33


   Example Explanation
   Explanation 1:

    At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates.
    At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates.
    At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate.
    so, total number of chocolates eaten are 6 + 5 + 3 = 14
   Explanation 2:

    Maximum number of chocolates that can be eaten is 33.
       */
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : B) maxHeap.offer(i);
        long res = 0;
        for (int i = 0; i < A; i++) {
            int a = maxHeap.poll();
            res += a;
            res = res % (long) (Math.pow(10, 9) + 7);
            maxHeap.offer(a / 2);
        }
        return (int) res;
    }

    /*
Q2. Connect ropes
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
You are given an array A of integers that represent the lengths of ropes.

You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.

Find and return the minimum cost to connect these ropes into one rope.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 1000



Input Format
The only argument given is the integer array A.



Output Format
Return an integer denoting the minimum cost to connect these ropes into one rope.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 33
Output 2:

 182


Example Explanation
Explanation 1:

 Given array A = [1, 2, 3, 4, 5].
 Connect the ropes in the following manner:
 1 + 2 = 3
 3 + 3 = 6
 4 + 5 = 9
 6 + 9 = 15

 So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
Explanation 2:

 Given array A = [5, 17, 100, 11].
 Connect the ropes in the following manner:
 5 + 11 = 16
 16 + 17 = 33
 33 + 100 = 133

 So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
    */
    public int solve3(ArrayList<Integer> A) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for(int i:A) minHeap.offer(i);
        int res=0;
        while(minHeap.size()>1){
            int i1=minHeap.poll();
            int i2=minHeap.poll();
            int sum=i1+i2;
            res+=sum;
            minHeap.offer(sum);
        }
        return res;
    }
}
