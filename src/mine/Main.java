package mine;

import java.util.Scanner;

public class Main implements CellContent {
	private static int col = 16;
	private static int row = 16;
	private static int qty = 32;

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		Matrix minesweeper = new Matrix(row, col, qty);
		printMatrix(minesweeper);
		do {
			System.out.println();
			System.out.print("enter X:");
			int digX = sc.nextInt();
			System.out.print("enter Y:");
			int digY = sc.nextInt();
			System.out.println("dig:(" + digX + ", " + digY + ")");
			System.out.println();
			minesweeper.dig(digX, digY);
			printMatrix(minesweeper);
		} while (true);
	}

	private static void printMatrix(Matrix minesweeper) {
		for (CellBean[] row : minesweeper.getMatrixs()) {
			for (CellBean cell : row) {
				if (cell.isFazzy()) {
					System.out.print("* ");
				} else if (cell.getContent() == 雷) {
					System.out.print("M" + " ");
				} else {
					System.out.print(cell.getContent() + " ");
				}
			}
			System.out.println();
		}
	}

}
