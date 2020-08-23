package com.luke.algorithm.sparsearray;

import main.OutputArray;

public class SparseArray {
	/**
	 * 稀疏数组是一种压缩数组，当一个二维数组存在大量的重复值时，
	 * 通过稀疏数组可以对原数组进行压缩，
	 * 稀疏数组只有三列，
	 * 稀疏数组的第一行保存原数组的总行数、总列数和有多少个非重复值
	 * 从第二行开始，分别保存行下标、列下标和对应的值
	 */

	/**
	 * 韩顺平视频
	 * 当前进度 P8
	 */


	public static void main(String[] args) {

//		Integer[][] demoArr = new Integer[][]{{6, 6, 4}, {3, 2, 8}, {4, 4, 7}, {2, 2, 2}, {0, 4, 10}};
//		OutputArray.output(convertToTwoDimensionalArray(demoArr));

		Integer[][] demoArr1 = new Integer[][]{{0, 0, 0, 0, 10, 0}, {0, 0, 0, 0, 0, 0},
				{0, 0, 2, 0, 0, 0}, {0, 0, 8, 0, 0, 0}, {0, 0, 0, 0, 7, 0},{0, 0, 0, 0, 0, 0},};
		OutputArray.output(convertToSparseArray(demoArr1));
	}

	public static Integer[][] convertToSparseArray(Integer[][] dimArray){
		int sum = 0;
		for(int i=0; i<dimArray.length; i++){
			for(int j=0; j<dimArray[i].length; j++){
				if(dimArray[i][j] == 0){
					continue;
				}else{
					sum++;
				}
			}
		}

		Integer[][] spaArr = new Integer[sum+1][3];
		int row = 1;


		for(int i=0; i<dimArray.length; i++){
			for(int j=0; j<dimArray[i].length; j++){
				if(dimArray[i][j] == 0){
					continue;
				}else{
					spaArr[row][0] = i;
					spaArr[row][1] = j;
					spaArr[row][2] = dimArray[i][j];
					row++;
				}
			}
		}

		spaArr[0][0] = dimArray.length;
		spaArr[0][1] = dimArray.length;
		spaArr[0][2] = row - 1;

		return spaArr;
	}

	public static Integer[][] convertToTwoDimensionalArray(Integer[][] sparseArray){

		int row = sparseArray[0][0];
		int col = sparseArray[0][1];

		Integer[][] dimenArr = new Integer[row][col];
		for(int x=0; x<dimenArr.length; x++){
			for(int y=0; y<dimenArr[x].length; y++){
				dimenArr[x][y] = 0;
			}
		}

		for(int i=1; i<sparseArray.length; i++){
			dimenArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}

		return dimenArr;
	}
}
