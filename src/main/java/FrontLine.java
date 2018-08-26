/*
Задача 120:  Линия Фронта
Задача: на карте боевых действий есть прямоугольный участок, где идут самые ожесточенные бои. 
Прямоугольник задан символьной матрицей. Элемент матрицы обозначает территорию 1х1, ктр захвачена либо армией 'R', либо 'F'. 
Необходимо определить линию фронта в условных единицах, а также общий периметр каждой из сторон.
Входные данные: area[] - символьная матрица, состоящая из символов 'R' и 'F'. Размер матрицы NxM, где N, M - от 1 до 1000.
Захваченные территории каждой из сторон это связные области.
Вывод: линия фронта, общие периметры каждой из сторон.
Пример: 
area = [ { 'R', 'R' }, { 'R', 'F' } ]
Answer: FrontLine = 2; PerimeterR = 8; PerimeterF = 4
*/

/*
 * Алгоритм: 
 * Перебираем все элементы матрицы и для каждого расматриваем 4-х соседей. 
 * Если соседние элементы разные - то между ними линия фронта. 
 * В данном алгоритме в расчете длинны линии фронта и периметра, линия фронта учитывается дважды.
 * Поэтому после всех расчетов необходимо из периметра вычесть "задвоенную линию фронта".
 * */
public class FrontLine {
	private char[][] area;
	private int N = 0;
	private int M = 0;
	private int frontLineLength;
	private int perimeterR;
	private int perimeterF;
	
	public FrontLine(char[][] area) {
		this.area = area;
		N = area.length;
		if (N > 0) {
			M = area[0].length;
		}
		
		this.process();		
	}
	
	private void process() {
		this.frontLineLength = 0;
		this.perimeterR = 0;
		this.perimeterF = 0;		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				processRightNeighbor(i, j);
				processLeftNeighbor(i, j);
				processUpNeighbor(i, j);
				processDownNeighbor(i, j);				
			}
		}
		this.frontLineLength = this.frontLineLength / 2;
		this.perimeterF = this.perimeterF - this.frontLineLength;
		this.perimeterR = this.perimeterR - this.frontLineLength;
	}
	
	private void processRightNeighbor(int i, int j) {
		if (j < M - 1) {
			if (area[i][j] != area[i][j+1]) {
				processFrontLine();
			}
		} else {
			processBound(area[i][j]);
		}
	}
	
	private void processLeftNeighbor(int i, int j) {
		if (j > 0) {
			if (area[i][j] != area[i][j - 1]) {
				processFrontLine();
			}
		} else {
			processBound(area[i][j]);
		}
	}
	
	private void processUpNeighbor(int i, int j) {
		if (i > 0) {
			if (area[i][j] != area[i - 1][j]) {
				processFrontLine();
			}
		} else {
			processBound(area[i][j]); 
		}
	}
	
	private void processDownNeighbor(int i, int j) {
		if (i < N - 1) {
			if (area[i][j] != area[i + 1][j]) {
				processFrontLine();
			}
		} else {
			processBound(area[i][j]);
		}
	}
	
	private void processFrontLine() {
		this.frontLineLength++;
		this.perimeterF++;
		this.perimeterR++;
	}
	
	private void processBound(char c) {
		if (c == 'R') {
			this.perimeterR++;
		} else {
			this.perimeterF++;
		} 
	} 

	public int getFrontLineLength() {
		return frontLineLength;
	}

	public int getPerimeterR() {	
		return this.perimeterR;
	}

	public int getPerimeterF() {		
		return this.perimeterF;
	}
	
	public static void main(String[] srgs) {		
		char[][] area = new char[][] 
				{{'R', 'R'},
				 {'R', 'F'}};
		FrontLine fl = new FrontLine(area);
		System.out.println("Front line length: " + fl.getFrontLineLength());
		System.out.println("Perimeter R: " + fl.getPerimeterR());
		System.out.println("Perimeter F: " + fl.getPerimeterF());			
	}

}
