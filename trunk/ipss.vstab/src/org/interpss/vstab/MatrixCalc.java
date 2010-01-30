package org.interpss.vstab;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

import Jama.Matrix;

public class MatrixCalc {
	/*
	 * Matrix2List 
	 * m here is a vector (Nx1 ,or 1X N) ,and Nx1 by default
	 */
/*
	public static void Matrix2Excel(Matrix m,String xlsFile) throws IOException, RowsExceededException, WriteException{
	final int ColumnLimit =256;
	int sheetNum =m.getColumnDimension()/ColumnLimit+1 ;
	System.out.print("sheetNum ="+sheetNum );
	WritableWorkbook book =Workbook.createWorkbook(new File(xlsFile));
	for (int sheetIdx =0;sheetIdx<sheetNum; sheetIdx++){
	WritableSheet sheet =book.createSheet("sheet"+sheetIdx+1, sheetIdx);
	  for (int row=ColumnLimit*sheetIdx;row<ColumnLimit*(sheetIdx+1);row++){
		 for(int col=ColumnLimit*sheetIdx;col<ColumnLimit*(sheetIdx+1);col++){
			if (col<m.getColumnDimension()&&row<m.getRowDimension()){
		    WritableCellFormat floatFormat = new WritableCellFormat (NumberFormats.FLOAT); 
			Label label = new Label(col, row, Double.toString(m.get(row, col))); 
			sheet.addCell(label); 
			}
		 }
	  }
	}
	book.write();
	book.close();
		
	}
	public static void Diag2Excel(Matrix m,String xlsFile) throws IOException, RowsExceededException, WriteException{
		
	    int sheetIdx =0;
		NumberFormat fourdps = new NumberFormat("#.###"); 
		WritableCellFormat fourdpsFormat = new WritableCellFormat(fourdps);
		WritableWorkbook book =Workbook.createWorkbook(new File(xlsFile));
		WritableSheet sheet =book.createSheet("sheet"+sheetIdx+1, sheetIdx);
		  for (int row=0;row<m.getRowDimension();row++){
			 for(int col=0;col<m.getColumnDimension();col++){
				if (col==row){
				Number num = new Number(0, row, m.get(row, col),fourdpsFormat); 
				sheet.addCell(num); 
				}
			 }
		}
		book.write();
		book.close();
		//
		System.out.print("row"+m.getRowDimension()+"  col"+m.getColumnDimension());
		//
		}
			*/
	public  void Matrix2File(Matrix m,String File) throws IOException{
	   StringBuffer temp=new StringBuffer();
	   DecimalFormat df = new DecimalFormat("0.000");
	   double[] rows;
	   double[][] tempArray=m.getArrayCopy();
	   String tempRows="";
	   File outF = new File(File); 
	   FileOutputStream outfile = new FileOutputStream(outF);
	   BufferedOutputStream out = new BufferedOutputStream(outfile);
	   
	   System.out.println("rows="+m.getRowDimension()+" cols="+m.getColumnDimension());
	   for (int row=0;row<m.getRowDimension();row++){
		    System.out.println("row="+row);
			// for(int col=0;col<m.getColumnDimension();col++){
	         //temp =Double.toString(m.get(row, col));
			 rows=tempArray[row];
			 //System.out.println("rows length ="+rows.length);
			 tempRows=Arrays.toString(rows);//.substring(1, endIndex)
	         temp.append(tempRows.substring(1, tempRows.length())); //df.format(m.get(row, col));
			 temp.append("\r\n");
	   }
	   String s =temp.toString();
	   out.write(s.getBytes());
	   out.flush();			
	   out.close();
	}
	

	public  void Matrix2File(SparseEqnMatrix2x2 S,String File) throws IOException{
		
	    int Dimension =S.getDimension();
	    Matrix tempM =new Matrix(Dimension*2,Dimension*2);
		System.out.println("Dimension ="+Dimension);
		 for (int row=1;row<=Dimension;row++){
			 for (int col=1;col<=Dimension;col++){
				 //System.out.println("r"+row+" c"+col);
				 Matrix_xy elem =S.getElement(row, col);
			 	 tempM.set(2*row-2, 2*col-2,elem.xx );
			 	 tempM.set(2*row-2, 2*col-1,elem.xy );
			 	 tempM.set(2*row-1, 2*col-2,elem.yx );
			 	 tempM.set(2*row-1, 2*col-1,elem.yy );
			 }
		 }
		 Matrix2File(tempM,File);
		
	}
	
	public  List Matrix2List(Matrix m){ 
		List<Integer> tempL = new ArrayList<Integer>();
		for(int i=0;i<m.getRowDimension();i++){
			int temp =(int) m.get(i, 0);
			tempL.add(temp);
		}
		return tempL;
	}
    public  double maxAbs(Matrix a){
		
    	// 
	    	  double max =0;
			  for  (int i =0; i< a.getRowDimension();i++){
				   for (int j =0;j< a.getColumnDimension();j++){
					   if (Math.abs(a.get(i, j))>max) max=Math.abs(a.get(i, j));
				    }
			  }
			   return max;
	   } //end of max method
	   
	   
	  public   double getMinAbs(Matrix a){
		  double min =Math.abs(a.get(0, 0));
		  for (int i =0; i< a.getRowDimension();i++){
			   for(int j =0;j< a.getColumnDimension();j++){
				   if (Math.abs(a.get(i, j))<min) min =Math.abs(a.get(i, j));		   
			   }
		   }
		   return min;
	   }  
	  public   int getLMinIdx(Matrix a){
		  double min =Math.abs(a.get(0, 0));
		  double  t;
		  int col=0; 
		  for (int i =0; i< a.getRowDimension();i++){
			        t=Math.abs(a.get(i, i));
				   if (t<min) {min =t;	col =i;}	   
			       
		   }
		   return col;
	   }
	  public   Matrix getDiag(Matrix a){
		  int rows=a.getRowDimension(); // assume it is a n*n matrix 
		  Matrix tempM=new Matrix(rows,1); // return a n*1 matrix saving the diag element ;
		
		  for (int i =0; i< a.getRowDimension();i++){
				   tempM.set(i, 0,a.get(i, i));		   
		   }
		   return tempM;
	   }
	  
      public  double sumOfElement(Matrix m){
		 double sum=0;
		    for (int i= 0;i<m.getRowDimension();i++){
				 for (int j= 0;j<m.getColumnDimension();j++){
					 sum+=m.get(i, j);
				   }
		     }
		 return sum;
	 }
	   
	public Matrix ones(int n,int m ){
	    	  Matrix a =new Matrix (n,m);
			     for (int i= 0;i<n;i++){
					 
					 for (int j= 0;j<m;j++){
						 a.set(i, j, 1);
					   }
			     }
			   return a;
		     }  // end of this method
	    
	 public  void printMatrix(Matrix m){
		   
			 for (int i= 0;i<m.getRowDimension();i++){
				 
				 for (int j= 0;j<m.getColumnDimension();j++){
					 System.out.print(m.get(i, j)+"  ");
				 } 
				 System.out.print("\n");
			 }  // end of for i
		}  // end of printMatrix
}
