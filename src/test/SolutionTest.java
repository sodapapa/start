import com.sun.org.apache.regexp.internal.RETest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


class SolutionTest {


    @Test
    public void makdPrime(){
        int num[] = {1,2,3,4,5};
        int answer= 0;
        int maxNum = 0;
        for (int i = 0; i < num.length; i++) {

            maxNum   += num[i];
        }

        System.out.println(maxNum);
        List<Integer> primeList = makePrimeList(maxNum);
        List<Integer> makeSumOfThree = makeSumOfThree(num);

        System.out.println("primeList " + primeList);
        System.out.println("makeSumOfThree " + makeSumOfThree);
        System.out.println(primeList.retainAll(makeSumOfThree));
        System.out.println(primeList.toString());
        System.out.println(primeList.size());

        for (int i = 0; i < primeList.size(); i++) {
            int prime = primeList.get(i);

            for (int j = 0; j <makeSumOfThree.size() ; j++) {
                int sum = makeSumOfThree.get(j);
                        if(prime == sum)
                            answer++;
            }
        }


    }
    public List<Integer> makeSumOfThree(int[] nums){
        List<Integer> sumList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k]; //값을 담아

                    sumList.add(num);

                }
            }

        }
       //  List<Integer> sumList = new ArrayList<>(sumSet);
        return sumList;
    }

    public List<Integer> makePrimeList(int num){
        int arr[] = new int[num + 1];   // 지워졌으면 true

        List<Integer> primeList = new ArrayList<>();

        for (int i = 2; i <= num; i++)
            arr[i] = i;


        for (int i = 2; i <= num; i++) {  // 나누는 값 : i

            for (int j = 2; j <= num; j++) {

                if (arr[j] != i && arr[j] % i == 0) {  // 자신과 같지않고 0으로 떨어지면 소수아님

                    arr[j] = 0; // 소수가 아닌 경우 0을 넣어둔다

                }

            }

        }

        for (int i = 2; i<= num; i++) {

            if(arr[i] != 0){

                primeList.add(arr[i]);
            }
        }
        return primeList;
    }


    @Test
    public void Ternary (){

        int n = 0;
        String third = Integer.toString(n, 3);
        StringBuffer sb = new StringBuffer(third);
        String reversed = sb.reverse().toString();
        Integer.parseInt(reversed,3);

        String s = "";

        while(n != 0){

            //3진법 변환
            if( (n % 3) < 10 ) {

                s = (n % 3) + s;

                n /= 3;
            }

        }
        // StringBuffer sb = new StringBuffer(s);
        int answer = Integer.parseInt(sb.reverse().toString(),3);
        // return answer;

        n = 50000000;
        int []b = new int[32];
         s = "";

        int i = 0;
        while(n != 0){

            //3진법 변환
            if( (n % 3) < 10 ) {

                s = (n % 3) + s;

                n /= 3;
            }

        }








//        for(int j = i; j >= 0; --j)
//        {
//            System.out.print(b[j]);
//            s += b[j];
//        }
        System.out.println(s);
        sb = new StringBuffer(s);

        System.out.println(sb.reverse().toString());
        String tmp = sb.toString();
        i = tmp.length()-1;
        int result = 0;
        for(int j = i; j >= 0; --j){
            System.out.println("j : "+j);
            System.out.println(Math.pow(j,3) );
             System.out.println(Math.pow(3,j) * Integer.parseInt(String.valueOf(tmp.charAt(j))));
//            System.out.println(tmp.charAt(j));
            result += Math.pow(3,j) * Integer.parseInt(String.valueOf(tmp.charAt(j)));
            System.out.println( Integer.parseInt(String.valueOf(tmp.charAt(j))));
        }
        System.out.println(result);

        System.out.println(Integer.parseInt(s,3));
    }




    @Test
    public void numberAndWord(){
        String s = "one4seveneight";
        String[] numbers = {"zero"  , "one"
               , "two"
               , "three"
               , "four"
               , "five"
               , "six"
               , "seven"
               , "eight"
               , "nine"};
        int index = 0;
        for (String word: numbers ) {
            if(s.contains(word)){
                s = s.replaceAll(word,Integer.toString(index));
            }
            index++;
        }
        System.out.println(Integer.parseInt(s));

    }

    @Test
    public void dotProduct(){
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        System.out.println(answer);
    }

    @Test
    public void arrayAdd() {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {

            int num = absolutes[i];
            if(!signs[i]){
                num =  Math.negateExact(num);
            }
            System.out.println(num);
            answer += num;
        }
        System.out.println(answer);
        // return answer;
    }


    @Test
    public void lottos() {
        int[] lottos =   {0, 0, 0, 0, 0, 0};
        int[] win_nums = {31, 10, 45, 1, 6, 19};



        // 1. 0이 아닌 값과 정답과 일치하는 개수 파악
        // 2. 0이 전부다 맞은 경우  : 1+2 = 최대 맞은 갯수
        // 3. 0이 전부다 틀린 경우 : 1 => 최소 맞은 갯수

        /*
        1	6개 번호가 모두 일치 7-6
        2	5개 번호가 일치
        3	4개 번호가 일치
        4	3개 번호가 일치
        5	2개 번호가 일치
        6	그 외
        */
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        if(Arrays.equals(lottos,win_nums)){
            int[] answer = {1,1};
        }
        int correctCnt = 0;
        int wildCardCnt = 0;

        for (int i :lottos) {
            int index = Arrays.binarySearch(win_nums,i);

            System.out.println("i : "+ i );
            System.out.println("index : "+index );

            if(i == 0)
                wildCardCnt++;

            if(index>=0){
                correctCnt++;
            }


        }


        System.out.println(correctCnt+  "  " +wildCardCnt);

        int maxRank = 7 - (correctCnt + wildCardCnt );
        int minRank = 7 - correctCnt;

        System.out.println("maxRank  "+ maxRank);
        System.out.println("minRank  "+ minRank);

            int temp = countToGrade(correctCnt);
            int temp2 = countToGrade(correctCnt + wildCardCnt);
        System.out.println(correctCnt );
        System.out.println(temp);

        System.out.println(correctCnt + wildCardCnt);
        System.out.println(temp2 );

        int[] answer = {temp,temp2};
        // return answer;
    }

    private int countToGrade(int correctCnt) {

        int result = 6;
        switch (correctCnt){
            case 7:
            case 6:
                result = 1;
            break;
            case 5:
                result = 2;
            break;
            case 4:
                result = 3;
            break;
            case 3:
                result = 4;
            break;
            case 2:
                result = 5;
                break;

        }



        return result;
    }


    @Test
    void kakaoCrane() {
        // parameters
        int[][] board = {
                {0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
                    //
        // int[] basket = new int[]{};
        List<Integer> basket = new ArrayList<>();

        // result
         int answer = 0;

        for (int i = 0; i < moves.length; i++) {
            int number = moves[i] -1;
            System.out.println("i " + i  + "  number : "+ number );

            for (int j = 0; j < board.length; j++) {
                int value = board[j][number];
                System.out.println("value " + value );

                if(value > 0){
                    basket.add(value);
                    board[j][number] = 0;
                    if(basket.size() > 1 ){
                        System.out.println( basket.toString());
                        System.out.println( basket.get(basket.size()-2));
                        System.out.println(  basket.get(basket.size()-1));

                        if(basket.get(basket.size()-2) == basket.get(basket.size()-1)){
                            basket.remove(basket.size()-1);
                            basket.remove(basket.size()-1);
                            System.out.println( basket.toString());

                            answer += 2;

                            // System.out.println(basket.get(basket.size()-1));
                        }

                    }

                    break;
                }

            }
            System.out.println("answer "+ answer);
            System.out.println();
        }
        // System.out.println(answer);
        // return answer;


    }

    private Map<String, Object > clearBaset(List<Integer> basket,int answer) {

        System.out.println( basket.get(basket.size()-1));
        System.out.println( basket.get(basket.size()-2));
        Map<String, Object > result  = new HashMap<>();
        int last =  basket.get(basket.size()-1);
        int lastBofore =  basket.get(basket.size()-2);

        result.put("result", false);
        result.put("basket", basket);

        if(last == lastBofore ){
            basket.remove(basket.size()-1);
            basket.remove(basket.size()-1);
            answer += 2;
            result.put("basket", basket);
            result.put("result", true);
            result.put("answer", answer);
        }


        System.out.println( basket.toString());
        return result;
    }


    @Test
    void coodinate(){
    // 1 ~ 12 의 좌표를 구하는 코드
        for (int i = 0; i < 12; i++) {

            int randomNum =  i+1; // (int)  (Math.random() * 10) +1;
            int x = Math.abs(randomNum -1) % 3;
            int y = Math.abs(randomNum -1) / 3;

            System.out.println(randomNum);
            System.out.printf("(%s, %s) ",x , y);
          //  System.out.println(y);
            System.out.println("\n");

        }

    }


    @Test
    void solution2() {
        String answer = "";
        String hand="right";
        String handDefault = hand.equals("right")  ? "R" : "L";
        int[] numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        // 1,4,7 ,*(10)-> left
        // 2,5,8 ,0(11) -> 가까운쪽  거리가 동일하면 주소 사용하는 손2
        // 3,6,9 ,#(12)-> right
        // LRLLLRLLRRL

        // LRLLLRLLRRL
        int lBefore = 10;
        int rBefore = 12;

        for (int i = 0; i <numbers.length ; i++) {
           int num  = numbers[i] == 0 ? 11 : numbers[i];

           if(num % 3 == 1){
               lBefore = num;
               answer += "L";
           }else if(num % 3 == 0){
               rBefore = num;
               answer += "R";

           }else{
                // 2,5,8, 11
               System.out.println("handDefault " + handDefault);
               System.out.println("i " + i);

               int diffFromLeft  = getDiff(lBefore, num);
               int diffFromRight  = getDiff(rBefore, num);


               System.out.println("diffFromLeft  +  "+ diffFromLeft);
               System.out.println("diffFromRight  +  "+ diffFromRight + "\n");


               if(diffFromLeft == diffFromRight){

                   if("right" == hand){
                       rBefore = num;
                   }else{
                       lBefore = num;
                   }
                   answer += handDefault;
               }else if(diffFromLeft > diffFromRight){

                   rBefore = num;
                   answer += "R";

               } else if(diffFromLeft < diffFromRight) {
                   lBefore = num;
                   answer += "L";
               }
//               System.out.println(getDiff(lBefore, num));
//               System.out.println(getDiff(rBefore, num));
           }
        }

        System.out.printf("answer "+ answer);
        // return answer;
    }
        // 손의 위치와 누를 번호의 거리는 차를 3으로 나눈 몫과 나머지의 합과 일치 한다.
    int getDiff(int prev, int num) {

        int prevX = Math.abs(prev -1) % 3;
        int prevY = Math.abs(prev -1) / 3;

        int numX = Math.abs(num -1) % 3;
        int numY = Math.abs(num -1) / 3;

        System.out.println("prev " + prev);
        System.out.printf("prev x %s , y %s" ,prevX, prevY);
        System.out.println();
        System.out.println("num " + num);
        System.out.printf("num x %s , y %s" ,numX , numY);
        System.out.println();

        System.out.println(Math.abs(prevX - numX));
        System.out.println(Math.abs(prevY - numY));
        // System.out.println("prev " + prev);

//        System.out.println("Math.abs(prev - num) / 3  : " + tem1);
//        System.out.println("Math.abs(prev - num) % 3  : " + tem2);

        return Math.abs(prevX - numX) + Math.abs(prevY - numY);
    }


    @Test
    void solution3() {
        int answer = 0;
        int max = 0;
        Set<Integer> numsSet = new HashSet<>();
        int[] nums = {3, 3, 3, 2, 2, 2}; // {3, 3, 3, 2, 2, 2}
        for (int i :nums) {
            numsSet.add(i);
        }

        max = nums.length /2;

        answer =numsSet.size();

        if(answer < max)
            answer = max;
        System.out.println(max);
        System.out.println(numsSet.size());

    }
}