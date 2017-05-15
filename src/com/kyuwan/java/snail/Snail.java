package com.kyuwan.java.snail;

public class Snail {

	public static void main(String[] args) {
		printSnail(makeSnail(5));
		printSnail(drawSnail(6));
		printSnail(makeSnail(7));

	}

	public static int[][] drawSnail(int count) {
		int[][] result = new int[count][count];
		int x = -1; // 배열의 가로축
		int y = 0; // 배열의 세로축
		int direction = 0; // 0 오른쪽, 1아래, 2왼쪽, 3위
		int number = 1; // 출력되는 숫자값

		int size = count; // 매번 반복되어야하는 가로 세로 크기

		while (size > 0) {
			for (int i = 0; i < size; i++) {
				if (direction == 0)
					x++;
				else if (direction == 1)
					y++;
				else if (direction == 2)
					x--;
				else if (direction == 3)
					y--;
				result[y][x] = number;
				number++;
			}
			// 방향이 오른쪽 에서 아래로 , 왼쪽에서 위로 변할때 size는 1씩 감소한다.
			if (direction == 0 || direction == 2)
				size--;
			// 방향전환
			direction++;
			if (direction > 3)
				direction = 0;
		}

		return result;
	}

	// 2. +, - 증감을 사용하는 알고리즘
	public static int[][] makeSnail(int count) {
		int result[][] = new int[count][count];

		int increase = 1; // 증감값
		int x = 0; // 좌표
		int y = 0;

		int number = 0;

		int snail = count * 2 - 1; // 반복하는 크기 = 가로 + 세로 -1

		for (int i = snail; i > 0; i = i - 2) {
			for (int j = 0; j < i; j++) {
				if (j <= i / 2) {
					if (i != snail || j != 0)
						x += increase;
				} else {
					y += increase;
				}
				result[y][x] = ++number;
			}
			increase *= -1;
		}
		return result;
	}

	public static void printSnail(int result[][]) {
		System.out.println("--------- count " + result.length + " -----------");
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				String temp = result[i][j] < 10 ? "0" + result[i][j] : "" + result[i][j];
				System.out.printf("[%s]", temp);
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
