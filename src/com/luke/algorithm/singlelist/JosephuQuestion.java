package com.luke.algorithm.singlelist;

public class JosephuQuestion {
	/*
	n个小孩排一圈， 从第k个小孩开始报数， 每次报到第m个数的小孩出圈， 输出最终出圈小孩的排序

	提示： 单向环形链表
	 */
	public static void main(String[] args) {
		CircleGame game = new CircleGame();
		game.initGame(10);
		game.printCircle();

		game.play(3, 4);
	}

}

class CircleGame{

	Child firstChild = new Child(1);

	Child point;

	public void initGame(int amount){
		point = firstChild;

		for(int i=2; i<=amount; i++){
			Child child = new Child(i);
			point.next = child;
			point = child;
			if(i==amount){
				child.next = firstChild;
			}

		}
	}

	public void printCircle(){
		boolean flag = true;
		System.out.printf("第%d个学生\n", firstChild.no);
		point = firstChild.next;
		while(flag){
			System.out.printf("第%d个学生\n", point.no);
			if(point.next.no!=1){
				point = point.next;
			}else{
				flag = false;
			}
		}
	}

	public void play(int k, int m){

		point = firstChild;
		boolean flag = true;
		while(flag){
			if(point.no!=k){
				point = point.next;
			}else{
				flag = false;
			}
		}
		System.out.printf("从第%d个学生开始报数\n", point.no);
		System.out.println("游戏开始!....");

		Child preChild = point;
		while(true){

			for(int i=1; i<=m; i++){
				if(i==m){
					preChild.next= point.next;
					System.out.printf("编号%d的学生出圈\n", point.no);
				}
				preChild = point;
				point = point.next;
			}

			if(point.next.no == point.no){
				break;
			}
		}
	}

}

class Child{
	int no;
	Child next;

	Child(int num){
		this.no = num;
	}
}
