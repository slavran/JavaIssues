
class SudokuInputs {
	int[][] sudokuTable= new int[9][9];
	static int sudokuNumber = 0 ;
	
 SudokuInputs(int data[][]) {
		this.sudokuTable = data;
		this.sudokuNumber++;
	}
 
 	void sudokuSolver() {
 		boolean checkRows;
 		boolean checkColumn;
 		boolean checkTable;
 		int number = 1 ;
 		for (int i = 0 ; i < 9 ; i++) {
 			for (int j = 0 ; j < 9 ; j++) {
 				checkRows = sudokuRowsCheck(number,j); //CHECK HERE
 				checkColumn = sudokuColumnCheck(number,j); //HERE TOO
 				checkTable = sudokuSmallTableCheck(number,i,j);
 				if ((checkRows) && (checkColumn) && (checkTable) ) {
 					sudokuTable[i][j] = number;
 				}
 				number++;
 			}
 			number = 1;
 		}
	  
	//  return sudokuTable;
  }
 	boolean sudokuSmallTableCheck(int number,int row , int column) {
 		int i = 0;
 		int j = 0;
 		if ((row >= 6) && (column >= 6)) { //9
 			i = 6;
 			j = 6;
 		}else if ((row >= 3) && (column >=3)) { //5
 			i = 3;
 			j = 3;
 		}else if ((row <= 3) && (column <= 3) )  { //1
 			i = 0;
 			j = 0;
 		}else if ((row >= 6) && (column >= 3)) { // 8
 			i = 6;
 			j = 3;
 		}else if ((row >= 6) && (column <= 3)) { // 7 
 			i = 6;
 			j = 0;
 		}else if ((row >= 3) && (column >= 6)) { // 6
 			i = 3;
 			j = 6;
 		}else if ((row <= 3) && (column >=3)) { //2
 			i = 0;
 			j = 3;
 		}else if ((row <= 3) && (column >= 6)) { //3
 			i= 0;
 			j= 6;
 		}else {
 			i= 3;
 			j= 0;
 		}
 		for (int p = i ; p < i + 2 ; p++) {
 			for(int k = j ; k < j + 2 ; k++) {
 				if (this.sudokuTable[p][k] == number) {
 					return false;
 				}
 			}
 		}
 		return true;
 	}



 	boolean sudokuRowsCheck(int number,int row) {
 		for (int i = 0 ; i < 9 ; i++) {
 			if (this.sudokuTable[i][row] == number) {
 				return false;
 			} 
 		}
 		return true;
 	}
 	
 	boolean sudokuColumnCheck(int number , int column) {
 		for (int i = 0 ; i < 9 ; i++) {
 			if (this.sudokuTable[column][i] == number) {
 				return false;
 			}
 		}
 		return true;
 	}
 	void show() {
 		for (int i = 0 ; i < 9 ; i++) {
 			for (int j = 0 ; j < 9 ; j++) {
 				System.out.printf(" %d ",this.sudokuTable[i][j]);
 			}
 			System.out.println();
 		}
 	}
}