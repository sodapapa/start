package dataStructure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class test3 {
	// 피보나치, 팩토리얼; 재귀함수

	public void algorithm(){

		/* 피보나치 수열 반복문을 활용 */
		fibonacciSolution(10);

		/* 피보나치 수열 재귀 함수를 활용 */
		ArrayList<Integer> fibo = new ArrayList<>();

		for(int i = 0 ; i < 10 ; i++ ){
	    	fibo.add(fiboSolution2(i));
	    }
		System.out.println(fibo.toString());

		/* */
		int f = factorial(5);
		System.out.println(f);

		/* 카운트 다운 */
		countDown(5);
	}


	public void countDown(int n) {

		if(n == 0) {

			System.out.println("booom");
		}else {

			System.out.println(n);
			countDown(n-1);
		}

	}

	public int fiboSolution2(int n) {
/*	    최초로 작성한 코드
 *    if(n == 0) return 0;
 *
 *    else
 *        if(n == 1) return 1;
 *
 *        else
 *            return fiboSolution2(n-1) + fiboSolution2(n-2);
 *
 */

		return (n == 0 || n == 1 ) ? n :  fiboSolution2(n-2) + fiboSolution2(n-1);

	}


	// 1에서 n까지의 피보나치 수열을 반환하는 메서드를 작성하라.
	// 0 , 1 , 1 , 2 , 3 , 5 , 8 , 13 , 21
	public ArrayList<Integer> fibonacciSolution(int i) {

		if(i < 0 )
			throw new IllegalArgumentException("n must be less than 0");

        if(i == 0) {
            return new ArrayList<Integer>();
        }
        if(i == 1) {
            return (ArrayList<Integer>) Arrays.asList(0);
        }
        if(i == 2) {
            return (ArrayList<Integer>) Arrays.asList(0, 1);
        }

        ArrayList<Integer> fibo = new ArrayList<>();
        fibo.add(0);
        fibo.add(1);

        for (int j = 0; j < i-2; j++) {
        	int a = fibo.get(j);
        	int b = fibo.get(j+1);
        	fibo.add(a+b);

		}

        System.out.println(fibo.toString());

        return fibo;

	}

	private int factorial(int n) {
		  return (n == 0 || n == 1 ) ? n : n * factorial(n-1);
	}
}
