package dataStructure;
import java.util.ArrayList;
import java.util.HashMap;


public class test2 {

	public void algorithmTest(){

		try {

			boolean Flag = false;
			Flag = encodePossible("AAB","FOO");
			System.out.println("Flag +++ "+ Flag);


			int[] arrElmt = new	int[] {1, 2, 3, 4, 5};
			int[] arrResult = new int[arrElmt.length];

			arrResult = remainMultiply(arrElmt);

		} catch (Exception e) {

			 e.printStackTrace();
		}

	}

	/* Given an integer array, make each element a product of all element values without itself.
	 *
	 * input: [1, 2, 3, 4, 5]
	 * output: [120, 60, 40, 30, 24]
	 *
	*/

	private int[] remainMultiply(int[] arrElmt) {

		int max = arrElmt.length;
		int[] One = new int[max];
		int[] Two = new int[max];
		int[] arrResult = new int[max];

		int init = 1;

		for (int i = 0; i < max; i++) {

			One[i] = init;
			init *= arrElmt[i];
			System.out.println(init);
		}

		init = 1;
		for (int i = max -1; i >= 0; i--) {

			Two[i] = init;
		    init *= arrElmt[i];
		    System.out.println(init);
		}

		for (int i = 0; i < arrResult.length; i++) {
			arrResult[i] = One[i] *Two[i];
			System.out.println("arrResult +++ " +arrResult[i]);
		}

		return arrResult;
	}

	/* 길이가 같은 두 문자열(string) A 와 B가 주어지면, A 가 B 로 1:1 암호화 가능한지 찾으시오.
	 * Given two strings of equal length, check if two strings can be encrypted 1 to 1.
	 *
	 * Input: “EGG”, “FOO”
	 * Output: True // E->F, G->O
	 *
	 * Input: “ABBCD”, “APPLE”
	 * Output: True // A->A, B->P, C->L, D->E
	 *
	 * Input: “AAB”, “FOO”
	 * Output: False
	 *
	*/

	private boolean encodePossible(String src, String trgt) {
		HashMap<String, String> Map = new HashMap<String, String>();

		String[] srcArr = src.split("");
		String[] trgtArr = trgt.split("");

		System.out.println(srcArr);
		System.out.println(trgtArr);
		boolean result  = true;

		for (int i = 0; i < srcArr.length; i++) {
			System.out.println(srcArr[i]+" "+ trgtArr[i]);
			System.out.println();

			if(!Map.containsKey(srcArr[i])) {
				Map.put(srcArr[i], trgtArr[i]);

			}else {
				if(!trgtArr[i].equals( Map.get(srcArr[i]))) {
					result = false;
					break;
				}

			}

		}

		return result;

	}

}
