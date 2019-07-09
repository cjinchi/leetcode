import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static int[] pigs;
    static String calculate(int m, int k) {
        StringBuilder answer = new StringBuilder();
        pigs[1] = 2;
        pigs[2] = 3;
        pigs[3] = 5;
        int index = 3;
        while (pigs[index]<m){
            index++;
            pigs[index]=pigs[index-1]+pigs[index-2];
        }
        int result2 = index + 2018;

        pigs[0] = 2;
        pigs[1] = 3;
        if (m>2){
            pigs[2] = 4;
        }
        for (int i = 3;i<m;i++){
            pigs[i] = pigs[i-2]+pigs[i-3];
        }
        answer.append(pigs[m-1]+","+result2+",");


        PriorityQueue<Integer> queue= new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1<o2?1:o1==o2?0:-1;
            }
        });
        for (int i = 0;i<m;i++){
            queue.add(Integer.valueOf(new StringBuilder(String.valueOf(pigs[i])).reverse().toString()));
        }
        for (int i = 0;i<k-1;i++){
            queue.poll();
        }
        int prize = Integer.valueOf(new StringBuilder(String.valueOf(queue.peek())).reverse().toString());
        for (int i = 0;i<m;i++){
            if (pigs[i]==prize){
                answer.append(i+1);
                return answer.toString();
            }
        }

        return answer.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);
        pigs = new int[m];
        System.out.println(calculate(m, k));

    }
}