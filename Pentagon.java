package project_euler;

import java.util.Arrays;

public class Pentagon 
{
		public static void main(String[] args) {
			long start = System.nanoTime();

			int[] pentagonal = new int[10000];

			for (int i = 1; i < 10000; i++) {
				pentagonal[i] = (i * 3 * i - i) / 2;
			}

			for (int i = 1; i < 10000; i++) {
				for (int j = 1; j < i; j++) {
					if (isPentagonal(pentagonal, pentagonal[i] + pentagonal[j])
							&& isPentagonal(pentagonal, pentagonal[i]
									- pentagonal[j])) {
						long end = System.nanoTime();
						long runtime = end - start;
						System.out.println(pentagonal[i] - pentagonal[j]);
						System.out.println("Runtime: " + runtime / 1000000 + "ms ("
								+ runtime + "ns)");
						System.exit(0);
					}
				}
			}
		}

		public static boolean isPentagonal(int[] pentagonal, int value) {
			if (Arrays.binarySearch(pentagonal, value) >= 0)return true;
				return false;
		}
	}


