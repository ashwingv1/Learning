import java.util.ArrayList;

public class GreedyAlgorithm {
    public static void main(String [] args){

        int i=seats("....x..xx...x..");
        System.out.println("Hello:"+i);
    }

    /*
    Q1. Distribute Candy
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
N children are standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum number of candies you must give?



Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109



Input Format
The first and only argument is an integer array A representing the rating of children.



Output Format
Return an integer representing the minimum candies to be given.



Example Input
Input 1:

 A = [1, 2]
Input 2:

 A = [1, 5, 2, 1]


Example Output
Output 1:

 3
Output 2:

 7


Example Explanation
Explanation 1:

 The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
 So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
Explanation 2:

 Candies given = [1, 3, 2, 1]

    */
    public int candy(ArrayList<Integer> A) {
        int n=A.size();
        int L[] = new int[n];
        int R[] = new int[n];
        L[0]=1;
        for(int i=1;i<n;i++){
            if(A.get(i)>A.get(i-1)) L[i]=L[i-1]+1;
            else L[i] =1;
        }
        R[n-1]=1;
        for(int i=n-2;i>=0;i--){
            if(A.get(i)>A.get(i+1)) R[i]=R[i+1]+1;
            else R[i] =1;
        }
        int res=0;
        for(int i=0;i<n;i++){
            res+=Math.max(L[i],R[i]);
        }
        return res;
    }

    /*
 Problem Description
There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other.
There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.

An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')

Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.

In one jump a person can move to the adjacent seat (if available).

NOTE: 1. Return your answer modulo 107 + 3.



Problem Constraints
1 <= N <= 1000000
A[i] = 'x' or '.'



Input Format
The first and only argument is a string A of size N.



Output Format
Return an integer denoting the minimum number of jumps required.



Example Input
Input 1:

A = "....x..xx...x.."
Input 2:

A = "....xxx"


Example Output
Output 1:

5
Output 2:

0


Example Explanation
Explanation 1:

Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14)
              . . . . x . . x x . . . x . .
Now to make them sit together one of approaches is -
              . . . . . . x x x x . . . . .
Steps To achieve this:
1) Move the person sitting at 4th index to 6th index: Number of jumps by him =   (6 - 4) = 2
2) Bring the person sitting at 12th index to 9th index: Number of jumps by him = (12 - 9) = 3
So, total number of jumps made: 2 + 3 = 5 which is the minimum possible.

If we other ways to make them sit together but the number of jumps will exceed 5 and that will not be minimum.

Explanation 2:

They are already together. So, the cost is zero.
 */
    public static int seats(String A) {
        int n=A.length();
        n=n+2;
        long [] X=new long[n];
        long [] L=new long[n];
        long [] R= new long[n];
        for(int i=0;i<n;i++){
            if(i==0 ||i==(n-1)) continue;
            X[i] = A.charAt(i-1)=='.'?0:1;
        }
        long oneCount=0;
        for(int i=1;i<(n-1);i++){
            if(X[i]==1){
                oneCount++;
                L[i]=L[i-1];
            }else{
                L[i]=L[i-1]+oneCount;
            }
        }
        oneCount=0;
        for(int i=(n-2);i>0;i--){
            if(X[i]==1){
                oneCount++;
                R[i]=R[i+1];
            } else{
                R[i]=R[i+1]+oneCount;
            }
        }
        long min=Long.MAX_VALUE;
        for(int i=1;i<(n-1);i++){
            min=Math.min(min, (L[i]+R[i]));

        }

        min=min%((long)Math.pow(10,7)+3);
        return (int) min;
    }




    }
