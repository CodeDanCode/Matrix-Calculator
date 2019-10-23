// Created by Daniel Leach

public class Matrix {
	
	private int row;
	private int column;
	private double [] x; 
	private double [][] data;
		
	// 3 input constructor that creates a 2d array from the parameters given
	// and throws a custom exception if the arguments don't meet the requirements.
	public Matrix(int row, int column, double x[]) {
		if(row >= 0 && column >= 0 && x.length == (row*column)) {
			this.row = row;
			this.column = column;
			this.x = x;
			this.data = new double[row][column];
			int count = 0; 
			while(count < x.length) {
			for (int i = 0; i < row; i++)
				for (int j = 0; j < column; j++) {
					this.data[i][j] =x[count];
					count++;
				}
			}
					
		}else throw new MatrixFormatException("Matrix Format is unacceptable");
		
	}
	
	// row number getter
	public int getNumberRows(){
	    return this.row;
	}
	// column number getter
	public int getNumberColumns(){
	    return this.column;
	}
	// transpose getter method that uses a non-primitive data type
	// to reference the matrix class.
	public Matrix getTranspose() {
		
		Matrix temp = new Matrix(column,row,x);	
		for (int i = 0; i < column; i++) 
            for (int j = 0; j < row; j++) 
                temp.data[i][j] = this.data[j][i];
		
        return temp;
    }
	
	// a boolean method that checks equality between the current
	// class object and another class object.
	public boolean equals(Matrix B) {
        if (this.row != B.row || this.column != B.column)
        	return false;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                if (this.data[i][j] != B.data[i][j])
                	return false;
        return true;     
    }

}
