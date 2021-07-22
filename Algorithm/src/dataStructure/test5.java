package dataStructure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;



public class test5 {

	public void algorithm(){

//		String[] seoul = {"Jane", "Kim"};
//		int[] []  board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//		int[] []  board = {{0,0,1,1},{1,1,1,1}};
//		int[] []  board = {{0,1,1,1,1},{1,1,1,1,0},{1,1,1,1,0},{0,0,1,0,1}};
//		int[] []  board = {{0,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{0,1,1,1,1}};

		//solution(seoul);
		//solution2(3);
		//System.out.println(solution3(board));

//		solution4(15);


//		String[] participant = {"mislav", "stanko", "mislav", "ana"};
//		String[] completion = { "stanko", "mislav", "ana"};

//		solution5(participant, completion);

//		int[] answers = {1,3,2,4,2};

//		solution6(answers);

		int n= 5;
		int[] lost = {2, 4};
		int[] reserve = {3};

		// 예상 결과 값은 4
		int result = solution7(n, lost, reserve);

		System.out.println(result);
	}

	// 체육복
    public int solution7(int n, int[] lost, int[] reserve) {
        int answer = n;
        int cnt = 0;

        for (int i = 1; i < lost.length+1; i++) {

        	for (int j = 0; j < reserve.length; j++) {
        		if(lost[i] == reserve[j]) {

        			reserve[j] = -1;
        			lost[i] = -1;

        		}
			}
		}

        for (int i = 1; i < lost.length+1; i++) {
	        for (int j = 0; j < reserve.length; i++) {
	        	if(lost[i] == reserve[j] - 1
	        			|| lost[i] == reserve[j] + 1) {
        			reserve[j] = -1;
        			lost[i] = -1;
	        	}
			}
        }

        for(int i = 1; i <lost.length+1; i++) {
        	if(lost[i] > 0 ) {
        		cnt++;
        	}
        }
        return answer-cnt;
    }



    public int[] solution6(int[] answers) {

    	int[] supo1 = {1, 2, 3, 4, 5}; // 5
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        int[] score = new int[3];


        for (int i = 0; i < answers.length; i++) {
        	int num = answers[i];

        	// 정답
        	if(supo1[i % supo1.length] == num)
        		score[0]++;

        	if(supo2[i % supo2.length] == num)
        		score[1]++;

			if(supo3[i % supo3.length] == num)
				score[2]++;

		}

        ArrayList<Integer> list = new ArrayList<>();

        int frist = Math.max(score[0], Math.max(score[1], score[2]));

        if(frist == score[0]) {list.add(1);}
        if(frist == score[1]) {list.add(2);}
        if(frist == score[2]) {list.add(3);}
//        list.stream().mapToInt(mapper)

        return list.stream().mapToInt(i -> i.intValue()).toArray();


    }

// import java.util.*;
	public String solution5(String[] participant, String[] completion) {

		String answer = "";
		HashMap <String,Integer> map = new HashMap<>();

		Arrays.sort(participant);

		for(int i = 0; i < completion.length; i++) {

			if(map.containsKey(completion[i])) {

				int count = map.get(completion[i]);
				map.put(completion[i], count +1);
			}else {
				map.put(completion[i], 1);
			}
		}

		for (int i = 0; i < participant.length; i++) {
			if(map.containsKey(participant[i])) {
				if(map.get(participant[i]) == 1 ) {
					map.remove(participant[i]);
				}else {
					int count = map.get(participant[i]);
					map.put(participant[i], count -1);
				}
			}else {
				answer = participant[i];
			}
		}
		System.out.println(map);

		System.out.println(answer);

		return answer;



	}


	public void solution4(int n) {

		int cnt = 1;
		int end = (n/2) + 1;

		int sum;

		for (int i = 1; i < end; i++) {

			sum = i;

			for (int j = i+1; j <= end && sum < n ; j++) {
				sum += j;
				if(sum == n)
					cnt += 1;

			}
		}

	}

	public void solution(String[] s) {
		 for (int i = 0; i < s.length; i++) {

			 if(s[i].equals("Kim")) {
				 System.out.println("김서방은 " +i+"에 있다");
				 break;
			 }
		 }

	}

	public void solution2 (int n) {

			String result = n % 2 == 0 ? "even" : "odd";
	}



	/**
	 * 1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
	 * 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요.
	 * (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)
	 *
	 * [[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]	=> 9
	 * [[0,0,1,1],[1,1,1,1]]	=> 4
	 *
	 */

	public int solution3 (int[][] board) {

		int min;
		int answer = 0;

		for (int i = 1; i < board.length; i++) {

			for (int j = 1; j < board[i].length; j++) {

				if(board[i][j] == 1) {
					min =  Math.min(board[i-1][j] , board[i][j-1]);
					min = Math.min(min, board[i-1][j-1]);
					board[i][j] = min + 1;
				}

				if(answer < board[i][j])
					answer = board[i][j];
			}

		}

		return answer *= answer;

	}

}

