package dataStructure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class test4 {

	public void algorithm(){

		solution(100);
	}

	public void solution(int n) {
		int answer = 0;
		int sum = 2;

		for (int i = 3; i <= n ; i++) {
			int cnt = 0;

			for(int j = 2; j <= i; j++)

				if(i % j == 0)
					cnt+=1;

				if(cnt==0) {
					sum+=i;
					System.out.println(i);
				}

			}

			System.out.println("sum" + sum);
		}

	}

