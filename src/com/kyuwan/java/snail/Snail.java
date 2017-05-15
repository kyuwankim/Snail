package com.kyuwan.java.snail;

public class Snail {

	public static void main(String[] args) {
		printSnail(makeSnail(5));
		printSnail(drawSnail(6));
		printSnail(makeSnail(7));

	}

	public static int[][] drawSnail(int count) {
		int[][] result = new int[count][count];
		int x = -1; // �迭�� ������
		int y = 0; // �迭�� ������
		int direction = 0; // 0 ������, 1�Ʒ�, 2����, 3��
		int number = 1; // ��µǴ� ���ڰ�

		int size = count; // �Ź� �ݺ��Ǿ���ϴ� ���� ���� ũ��

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
			// ������ ������ ���� �Ʒ��� , ���ʿ��� ���� ���Ҷ� size�� 1�� �����Ѵ�.
			if (direction == 0 || direction == 2)
				size--;
			// ������ȯ
			direction++;
			if (direction > 3)
				direction = 0;
		}

		return result;
	}

	// 2. +, - ������ ����ϴ� �˰���
	public static int[][] makeSnail(int count) {
		int result[][] = new int[count][count];

		int increase = 1; // ������
		int x = 0; // ��ǥ
		int y = 0;

		int number = 0;

		int snail = count * 2 - 1; // �ݺ��ϴ� ũ�� = ���� + ���� -1

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
