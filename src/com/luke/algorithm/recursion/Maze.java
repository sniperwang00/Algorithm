package com.luke.algorithm.recursion;

public class Maze {
	/**
	 * 求最短路径方法？
	 * 罗列出所有的寻路策略， 取总值最小的策略就是最短路径。。。
	 *
	 */
	public static void main(String[] args) {
		int[][] map = new int[8][7];

		for(int i=0; i<7; i++){
			map[0][i] = 1;
			map[7][i] = 1;
		}

		for(int j=0; j<8; j++){
			map[j][0] = 1;
			map[j][6] = 1;
		}

		map[3][1] = 1;
		map[3][2] = 1;

//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 7; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println("");
//		}

		setWay(map, 1, 1);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static boolean setWay(int[][] map, int i, int j) {
		if(map[4][1]==2){
			return true;//终点
		}else{
			if(map[i][j]==0){
				map[i][j] = 2;
				if(setWay(map, i+1, j)){
					return true;
				}else if(setWay(map, i, j+1)){
					return true;
				} else if (setWay(map, i - 1, j)) {
					return true;
				} else if (setWay(map, i, j - 1)) {
					return true;
				}else{
					map[i][j] = 3;
					return false;
				}
			}else{
				return false;
			}
		}
	}

}
