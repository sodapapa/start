import org.junit.jupiter.api.Test;
import java.util.*;


class SolutionTest {
    /*
    소수만들기
    https://programmers.co.kr/learn/courses/30/lessons/12977?language=java
    주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
    숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,
    nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

    풀이과정
    1. 주어진 배열을 모든 요소의 합을 최대값으로 갖는다.
    2. 2부터 최대값까지의 소수를 list로 담아둔다.
    3. 주어진 배열 중에서 요소 3개의 합을 구하여 Set에 담는다. 그리고 리스트로 변환한다.
    4.  2,3에서 구한 리스트를 비교하여 교집합을 구하고 교집합의 사이즈를 반환한다.

    어려움
    1. 주어진 배열 중에서 3개 요소의 합을 구해야하는 데 어떻게 구해야할지 감이 오지않았다.
        구글링 해보니 삼중 for 문으로 대부분 구현했길래 따라했다.
    2. 코드를 채점 해보니 정확도가 21% 밖에 되지 않았다. 검색으로 찾아본 테스트 케이스와 내가 임의로 넣어본 값에서는 에러가 나지 않았다.
        그러다가 질문하기 메뉴에서 값이 중복되더라도 값을 구성하는 요소의 값이 이전 것과 다르다면 중복으로 처리해서는 안된다는 글을 봤다.
        그래서 set으로 중복없이 합을 구하던 로직을 List로 변경해 중복이 되는 자료형으로 변경후에
        두개의 리스트를 비교하여 각 리스트의 요소 값이 같아지는 경우에 answer 값을 1씩 증가 시켰다.

    개선점
    1. 굳이 max 값과 그 값보다 작은 수의 소수를 구할 필요가 없었다. 다른 사람들의 풀이를 보니. 대부분이 3개요소의 합이 소수인지 아닌지만 확인 하는 경우가 많았다.
        리스트를 두개나 만들고 비교할 필요는 없었다.
        그치만 arrayList의 addAll, removeAll, retainAll 파악해볼 수 있어서 좋았다.
    */


    @Test
    public void makdPrime(){
        int[] num = {1,2,3,4,5};
        int answer= 0;
        int maxNum = 0;
        for (int k : num) {

            maxNum += k;
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
        int[] arr = new int[num + 1];   // 지워졌으면 true

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
   /*
        3진법 뒤집기
        자연수 n이 매개변수로 주어집니다.
        n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
        n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
        45	1200	0021	7

        n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
        125	11122	22111	229

       풀이과정
       1. n을 3진수로 변경한다 n/3 ..... n이 3보다 작아질때 까지 (공식 활용)
       2. 몫,나머지,나머지 ... 를 String 으로 append 한다.
       3. 스트링 버퍼로 생성한 후에 뒤집는다. 이번엔 3진수를 10진수로 변경한다.
          22111 의 경우 식은 (3^4 * 2) + (3^3 * 2) + (3^2 * 1) + (3^1 * 1) + 1 이 된다.

        어려움
        진법을 변환하는 공식을 명확하게 알지 못해서 처음에 고생했다.
        처음에 10진수를 3진수로 치환할때 int[]를 사용했는데 구지 그럴 필요가 없는 것 같아서 String으로 변환했다.
        얼마나 큰 숫자가 들어와서 얼마나 배열이 필요할지 알 수 없기 때문이다.
        또 단순히 진법만 바꾸는 문제라면 생성한 String을 뒤집어서 출력해야 했지만 문제에서
        3진법으로 생성한 수를 뒤집어 다시 10진수로 반환해야했기 때문에 아예 뒤집을 필요조차 없었다.
        다만, 3진법에서 다시 10진법으로 변환할 때 제곱이 앞에서 뒤로 작아지기 떄문에  반복문을 내림차순 형태로 반복하였다.

        문제풀이를 하던 도중에 Integer 클래스의 parseInt 메서드를 이용하면 해당 진법으로 변경 할 수 있었다.
        단순히 답을 맞추기 위해서라면 혹은 진법 변환을 코드로 구현하는 데
        어려움이 없다면 해당 메서드를 통해서 답을 제출하는 게 편리할 수 있지만 나는 둘다 해당되지 않아 식을 찾아 코드로 짰다.

        원하는 답을 얻은 후에는 java api를 충분히 활용하는 코드도 작성하였다.

    */
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