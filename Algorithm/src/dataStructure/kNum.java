package dataStructure;

import java.awt.List;
import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class kNum {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
					// 1,2,3,4,5,6,7

		int[][] commands = {{2, 5, 3}, {4, 4, 1},{1, 7, 3}};

//		return [5, 6, 3]
//		solution2(array ,commands);
//		solution3(5, 16);
//		String param1 = "qwer";
//		solution(param1);

//		int[] arr = {5, 9, 7, 10};
//		int divisor = 5;
//		int[] arr2 = solution(arr,divisor);

//		int[] arr = {4, 4, 4, 3, 3};
//		int[] arr2 = solution(arr);

//		System.out.println(solution(3, 5));
		String[] strings = {"sun","bed","car"};
		solution("pPoooyY");
	}

    static boolean solution(String s) {
        boolean answer = true;
        s = s.toUpperCase();

        int n = s.length();
        int Cnt = 0;

        for (int i = 0; i < n; i++) {
        	if(s.charAt(i) == 'P')	{
        		Cnt++;
              }
        	else if(s.charAt(i) == 'Y'){
        		Cnt--;
            }
		}

        answer = Cnt  == 0  ?  true :false;

        return answer;
    }


	public static long solution7(int a, int b) {
		long answer = 0;

		if(a == b ) return a;

		int min = Math.min(a, b);
		int max = Math.max(a, b);

		System.out.println(min);
//		answer = min;
		for (int i = min; i <= max; i++) {
			answer += i;
		}
		System.out.println("min : " + min);
		System.out.println("answer : " +answer);

		return answer;
	}

	// Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
	public static int[] solution6(int []arr) {
		int[] answer = {};
		int j = 0;
		ArrayList <Integer> list = new ArrayList<>();
		list.add(arr[0]);

		for (int i = 1; i < arr.length; i++) {

			if(arr[i-1] != arr[i])
				list.add(arr[i]);

		}
		answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}


	 public static int[] solution5(int[] arr, int divisor) {
		 int quot, j= 0;
		 int[] answer = {};
		 ArrayList<Integer> list = new ArrayList<>();

		 for (int i = 0; i < arr.length; i++) {
	    	  quot = arr[i];
	    	  if( quot % divisor == 0 ) {

	    		  int num  = quot;
	    		  list.add(num);
	    	  }
		 }

		 if(list.size() > 0) {
			answer = new int[list.size()];
	 		for (Integer num : list) {

				answer[j] = num;
				j++;
			}

			}else {
				answer = new int[1];
				answer[0] = -1;
			}


		 Arrays.sort(answer);

	     return answer;
	  }


	private static String solution4(String param1) {

		int leng = param1.length();
		int mid = leng/2 ;
		String result = leng%2 == 1 ? param1.substring(mid,mid+1) : param1.substring(mid-1,mid+1);

		return result;


	}

	public static String solution3(int a, int b) {
	    String answer = "";

	    LocalDate targetDateTime = LocalDate.of(2016, a, b);

	    return  targetDateTime.getDayOfWeek().toString().substring(0, 3);
	}


    static int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        int start, end, index;
        int[] substrict;

        for(int i = 0 ; i < commands.length; i++) {
        	start = commands[i][0] -1;
        	end   = commands[i][1] ;
        	index = commands[i][2];

        	substrict = Arrays.copyOfRange(array, start, end);

        	Arrays.sort(substrict);

        	answer[i] =substrict[index-1];
        }

        return answer;
    }

}
