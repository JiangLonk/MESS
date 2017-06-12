package mine;

public class Matrix implements CellContent {
	private Long beginTime = System.currentTimeMillis();
	private int row;
	private int col;
	private int qty;
	private int square = col * row;
	private int clearArea = 0;
	private CellBean[][] matrixs;

	public Long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getSquare() {
		return square;
	}

	public void setSquare(int square) {
		this.square = square;
	}

	public CellBean[][] getMatrixs() {
		return matrixs;
	}

	public void setMatrixs(CellBean[][] matrixs) {
		this.matrixs = matrixs;
	}

	public Matrix() {

	}

	public Matrix(int row, int col, int qty) {
		setRow(row);
		setCol(col);
		setQty(qty);
		initMatrix();
	}

	private void initMatrix() {
		if (qty > (col - 2) * (row - 1)) {
			qty = (col - 2) * (row - 1);
		}
		this.matrixs = new CellBean[col][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrixs[i][j] = new CellBean(i, j);
			}
		}
		// 放置地雷
		for (int i = 0; i < qty; i++) {
			int x = (int) Math.floor(Math.random() * row);
			int y = (int) Math.floor(Math.random() * col);
			while (matrixs[x][y].getContent() == 雷 || (x == 0 && y == 0)) {
				x = (int) Math.floor(Math.random() * row);
				y = (int) Math.floor(Math.random() * col);
			}
			matrixs[x][y].setContent(雷);
		}
		// 放置数标
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int x = i;
				int y = j;
				int count = 0;
				if (matrixs[x][y].getContent() == 雷) {
					continue;
				}
				for (int n = x - 1; n < x + 2; n++) {
					for (int m = y - 1; m < y + 2; m++) {
						if (n < 0 || m < 0) {
							continue;
						}
						if (n > row - 1 || m > col - 1) {
							continue;
						}
						if (n == x && m == y) {
							continue;
						}
						if (matrixs[n][m].getContent() == 雷) {
							count++;
						}
					}
				}
				if (count != 0) {
					matrixs[x][y].setContent(count);
				}
			}
		}

	}

	public void dig(int x, int y) {
		matrixs[x][y].setFazzy(false);
		if (matrixs[x][y].getContent() != 雷) {
			clearArea++;
		}
		if (clearArea == square - qty) {
			victory();
			return;
		}
		if (matrixs[x][y].getContent() == 雷) {
			gameover();
		} else if (matrixs[x][y].getContent() == 空) {
			for (int n = x - 1; n < x + 2; n++) {
				for (int m = y - 1; m < y + 2; m++) {
					if (n < 0 || m < 0) {
						continue;
					} // 左侧上侧越界跳过
					if (n > row - 1 || m > col - 1) {
						continue;
					} // 右侧下侧越界跳过
					if (n == x && m == y) {
						continue;
					} // 跳过自身
					CellBean aroundCell = matrixs[n][m];
					if (aroundCell.isFazzy()) {
						dig(n, m);
					} // 跳过以清除方格
				}
			}
		}
	}

	private void gameover() {
		// TODO Auto-generated method stub

	}

	private void victory() {

	}
}
