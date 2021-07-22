package dataStructure;

import java.util.HashSet;

public class sort {

	public static void main(String[] args) {

		int[] a = {254,3,213,64,75,56,4,324,65,78,9,5,76,3410,8,342,76};

		// selection(a);

		// bubble(a);

		// insertion(a);

		// quick(a);

		int n= 5;
		int[] lost = {2, 4};
		int[] reserve = {3};

		// 예상 결과 값은 4
		int result = solution(n, lost, reserve);

		System.out.println(result);
	}


	// 체육복
	/*
	 * https://ju-nam2.tistory.com/4
	 * https://velog.io/@sw7190/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AC%B8%EC%A0%9C-%EC%B2%B4%EC%9C%A1%EB%B3%B5-%ED%92%80%EC%9D%B4
	 * 이중 for 문을 피하는 방법을 찾아야함. 시간 복잡도를 낮추기 위해서.
	 * HashSet에 reserve를 담아놓고 사용하는 풀이가 있었음.
	*/
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int cnt = 0;
        HashSet<Integer> ko = new HashSet<Integer>();


        // 2개 가지고 온 사람이 도둑맞음 자기가 자기것입음;
        for (int i = 0; i < lost.length; i++) {

        	for (int j = 0; j < reserve.length; j++) {
        		if(lost[i] == reserve[j]) {

        			reserve[j] = -1;
        			lost[i] = -1;
        			break;
        		}
			}
		}

        for (int i = 0; i < lost.length; i++) {
	        for (int j = 0; j < reserve.length; j++) {
	        	if(lost[i] == reserve[j]+1
	        			|| lost[i] == reserve[j]-1) {

	        		// 절대값이 1인지 확인
	        		// Math.abs(lost[i]-reserve[j]) == 1;

        			reserve[j] = -1;
        			lost[i] = -1;
        			break;
	        	}
			}
        }

        for(int i = 0; i <lost.length; i++) {
        	if(lost[i] > 0 ) {
        		cnt++;
        	}
        }
        return answer-cnt;
    }


	private static void quick(int[] a) {
		int left = 0;
		int right = a.length;
		int pivot = left;

		for (int i = 0; i < a.length; i++) {

			if(a[pivot] > a[pivot+1] ) {



			}

		}

	}









	private static void insertion(int[] a) {
		int temp ,j;

		for (int i = 1; i < a.length; i++) {

			temp = a[i];

			for (j = i-1; j >= 0 && temp < a[j] ; j--) {

//				if() {

					a[j+1] = a[j];
//				}
					System.out.println("i : " + i);
					System.out.println("j : " + j + "\n");
			}

			a[j+1] = temp;
		}

		for(int i = 0 ; i <  a.length ; i ++) {
//			System.out.println(a[i]);
		}
	}



	private static void bubble(int[] a) {
		int temp;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length -1 -i; j++) {

				if( a[j] > a[j+1]) {

					temp = a[j+1];
					a[j +1] = a[j];
					a[j] = temp;
				}
			}
		}

		for(int i = 0 ; i <  a.length ; i ++) {
			System.out.println(a[i]);
		}
	}


	private static void selection(int[] a) {


		int temp;

		for (int i = 0; i < a.length -1; i++) {

			for (int j = i + 1; j < a.length; j++) {

				if(a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
 				}

			}
		}

		for(int i = 0 ; i <  a.length ; i ++) {
			System.out.println(a[i]);
		}
	}

}
