package main;

public class OutputArray {

	public static void output(Integer[][] arr){
		for(int i=0; i<arr.length;i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j]);
				if(j!=arr[i].length-1){
					System.out.print(" ");
				}else{
					System.out.println("");
				}
			}
		}
	}

	public static void main(String[] args) {
		Integer[][] arr = new Integer[][]{{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};

		OutputArray.output(arr);
	}
}
