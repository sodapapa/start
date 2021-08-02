import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolutionsTest2 {


    @Test
    public void stringCompress(){

       // int result = compress("aaaaaaaaaaaaaaabbbbbbbbbbc");


        // buildArray(new int[]{0, 2, 1, 5, 3, 4});
        // [0,1,2,4,5,3]

       //  getConcatenation(new int[]{1,2,1});
       //  runningSum(new int[]{1,1,1,1,1});
        // [1,2,1,1,2,1]


        numJewelsInStones("aA",  "aaaaAAbbbb");
    }

    public String defangIPaddr(String address) {
        String answer = "";

        address.replaceAll(".", "[.]");
        return  answer;
    }


    public int numJewelsInStones(String jewels, String stones) {
        System.out.println(stones.replaceAll("[" + jewels + "]", ""));

        // return stones.replaceAll("[^" + jewels + "]", "").length();
        int output = 0;
        String[] arrJewels = jewels.split("");
        String[] arrStones = stones.split("");

        for (int j = 0; j < arrJewels.length; j++) {
                System.out.println("j : " + j);
            for (int i = 0; i < arrStones.length; i++) {
                System.out.println("i : " + i);
                if(arrStones[i].equals(arrJewels[j])){
                    System.out.println(arrStones[i]);
                    output++;
                }

            }
        }

        System.out.println(output);
        return output;
    }


    public int[] runningSum(int[] nums) {
        int[] answer = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = 0; j <= i; j++) {
                // System.out.println(nums[j]);
                sum += nums[j];
            }
            answer[i] = sum;
        }
        return answer;
    }


    private int[] getConcatenation(int[] nums) {
        int length = nums.length * 2;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = nums[i % nums.length];

        }

        return answer;
    }


    private int[] buildArray(int[] nums) {

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[nums[i]];
            System.out.println(answer[i]);
        }


        return answer;
    }



    private int compress(String s) {
        int answer = s.length();

        System.out.println(s.length());



        for (int i = 1; i < s.length()  ; i++) {
            System.out.println(s.substring(0,i));
            String stand  = "";
            String result = "";
            int standCnt = 1;
            if(s.substring(0, i).length() <= s.length() /2){
                for (int j = 0; j < s.length()  ; j+=i) {
                    int tmp = j + i;


                    String preVal= "";

                    if(j != 0){
                        System.out.println("tmp : "  + tmp);
                        preVal = s.substring(j-i,j);

                       if(tmp >= s.length()){

                           String now = s.substring(j);

                           if(!preVal.equals(now)){
                               result += standCnt > 1 ? standCnt : "";
                               result += preVal;
                               standCnt = 1;
                           }else{
                               standCnt++;

                           }
                           result += standCnt > 1 ? standCnt : "";
                               result += now;

                       }else{
                           String now = s.substring(j,tmp);

                           if(preVal.equals(now)){
                               standCnt++;
                           }else{
                               result += standCnt > 1 ? standCnt : "";
                               result += preVal;
                               standCnt = 1;
                           }
                       }

                    }


                }
            }else{

                if(s.substring(0, i) == s.substring(i)){
                    result += standCnt > 1 ? ++standCnt : "";
                    result += s.substring(0,i);
                }else{
                    result= s;
                }

            }
            System.out.println(" result :: " + result);
            System.out.println(" result :: " + result.length());

            if(answer > result.length())
                answer = result.length();

        }

        return answer;

    }


    @Test
    public void password(){

        // 대문자는 65 ~ 90
        // 소문자는 97 ~ 122
        //
        String s = "a B z"; // 원하는 값은 cD
        int n = 4;

         int n2= n %24;

        System.out.println(n2);
        String answer = "";
        for (int i = 0; i < s.length() ; i++) {

            if(s.charAt(i) == ' '){
                answer += " ";
                continue;
            }

            int oriValue = (int) s.charAt(i);
            int value = (int) s.charAt(i) + n2;

            // 대문자
            if(oriValue > 64 && oriValue<91 ){

                value =  value > 90  ?   64 +(value - 90) : value;

            // 소문자
            }else{
                value =  value > 122  ?   96 +(value - 122) : value;
            }


            System.out.println();
            answer +=(char) value;
        }
        System.out.println(answer);

    }

    @Test
    public void findPrime(){
        int n = 13; // 4
        int answer = 0;

        for (int i = 2; i <= n ; i++) {

            for(int j=2; j <= n; j++){

                if( i%2 == 0 && j != i){

                     System.out.println(j +"  is not prime");
                } else if( i%2 == 0 && j == i){

                     System.out.println(j +"  is prime");
                }
                else{
                    System.out.println(j);
                }

            }

        }

        // return answer;

    }



    @Test
    public void secretMap(){
//        n	5
//        arr1	[9, 20, 28, 18, 11]
//        arr2	[30, 1, 21, 17, 28]
//        출력	["#####","# # #", "### #", "# ##", "#####"]

        int n = 6;
        int[] arr1 ={46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        String[] answer = new String[n];
        //String tmep = ;
        for (int i = 0; i < n; i++) {

           String tmp1 = String.format("%0"+n+"d",Long.parseLong(Integer.toBinaryString(arr1[i])));
           String tmp2 = String.format("%0"+n+"d",Long.parseLong(Integer.toBinaryString(arr2[i])));
            System.out.println(tmp1);
            System.out.println(tmp2);

            String newRow = "";
            for (int j = 0; j <n ; j++) {
                // char chatTemp1 = ;
                if(tmp1.charAt(j) == '0' && tmp2.charAt(j) == '0'){
                    newRow += " ";
                }else{

                    newRow += "#";
                }
            }
            answer[i]= newRow;
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }


    }
    @Test
    public void sumOfTwo(){
//        [2,1,3,4,1]	[2,3,4,5,6,7]
//        [5,0,2,7]	[2,5,7,9,12]
        int[] numbers = {5,0,2,7};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                System.out.println(numbers[i]);
                System.out.println(numbers[j]);
                set.add(numbers[i] +numbers[j]);
            }
            System.out.println();
        }
        set.stream().sorted().mapToInt(Integer::intValue).toArray();

        System.out.println(set.toString());
//        List<Integer> targetList = new ArrayList<>(set);
//        targetList.sort(null);
//        int[] array = new int[targetList.size()];
//        for(int i = 0; i < targetList.size(); i++) array[i] = targetList.get(i);

    }


    @Test
    public void divisorSum(){
        int left=13;
        int right = 17;
        int answer = 0;
        int cnt = 0;
        for (int i = left; i <= right ; i++) {
            cnt = 0;
            for (int j = 1; j <= right; j++) {

                if(i%j == 0 ){

                    System.out.println(j);
                    cnt++;
                }
            }

            if(cnt % 2 == 0){
               answer += i;
            }else{

               answer -= i ;
            }
        }
        System.out.println(answer);
    }


    @Test
    public void budget(){
//        [1,3,2,5,4]	9	3
//        [2,2,3,3]	10	4

        int[]  d = {2,2,3,3};
        int budget = 10;
        List<?> list = (List<?>) Arrays.asList(d);
        int partialSumMax= 0;
        int answer= 0;


        List<Integer> numList = new ArrayList<Integer>(d.length);
        for (int i : d)
        {
            numList.add(i);
        }


        numList.sort(null);
        System.out.println(numList);

        for (int num :numList){
            if(num <= budget){

                budget = budget - num;
                answer++;
            }
        }
        System.out.println(answer);
/*
        for (int i = 0; i < d.length ; i++) {
            int partialSum = 0;
            for (int j = i; j < d.length; j++) {
                partialSum += d[j];

                if (partialSum <= budget) {
                    partialSumMax = partialSumMax < partialSum ? partialSum: partialSumMax ;
                    list.add(partialSum);
                    System.out.println(" i , j  "+ i + "  " +j);
                }
            }

        }
        System.out.println(partialSumMax);


        list = list.stream().filter(i -> i <= budget).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list.size());

        for (int i :list){
            if(budget <= i){
                answer++;
            }
        }*/

    }


}
