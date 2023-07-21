
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Nhap {
  ArrayList<Integer> emptyIndex = new ArrayList<>();
  

//print the arr2D
 public void print(int[][] arr2D){
	for(int i = 0; i < 6; i++){
		System.out.print("_          ");
	  }
	  System.out.println();
	  for(int i = 0; i < 4; i++) {
		for(int j = 0; j < 4; j++) {
		  if(j == 0){
			if(arr2D[i][j] == 0){
			  System.out.print(String.format("| %10s ", "*"));
			} else {
			  System.out.print(String.format("| %10d ", arr2D[i][j]));
			}
		  } else if(j == arr2D.length-1){
			if(arr2D[i][j] == 0){
			  System.out.print(String.format("%10s          |", "*"));
			} else {
			  System.out.print(String.format("%10d          |", arr2D[i][j]));
			}
		  } else {
			if(arr2D[i][j] == 0){
			  System.out.print(String.format("%10s ", "*"));
			} else {
			  System.out.print(String.format("%10d ", arr2D[i][j]));
			}
		  }
		}
		if(i != 3){
		System.out.println();
		System.out.println();
		System.out.println();
		}
	  }
	  System.out.println();
	  for(int i = 0; i < 6; i++){
		System.out.print("_          ");
	  }
 }
//check if the array is empty or not + add number to random position in the array
  public boolean addNum(int[][] arr2D) {
	  boolean isEmpty = false;
	  for(int i = 0; i < 4; i++) {
		  for(int j = 0; j < 4; j++) {
			  if(arr2D[i][j] == 0) {
				  isEmpty = true;
				  emptyIndex.add(i*10+j);
			  }
		  }
	  }
	  if(isEmpty == true) {
		  Random rand = new Random();
		  int num = rand.nextInt(emptyIndex.size());
		  int row = emptyIndex.get(num)/10;
		  int col = emptyIndex.get(num)%10;
		  emptyIndex.clear();
		  double random = rand.nextDouble();
		  if(random < 0.8) {
			  arr2D[row][col] = 2;
		  }
		  else arr2D[row][col] = 4;
	  }
	  return isEmpty;
	  }
  
  //method to indicate if you can still move or not
  public boolean canMove(int[][] arr2D) {
	    for (int i = 0; i < arr2D.length; i++) {
	        for (int j = 0; j < arr2D[0].length; j++) {
	            if (i > 0 && arr2D[i][j] == arr2D[i-1][j]) {
	                return true;
	            }
	            if (j > 0 && arr2D[i][j] == arr2D[i][j-1]) {
	                return true;
	            }
	            if (i < arr2D.length-1 && arr2D[i][j] == arr2D[i+1][j]) {
	                return true;
	            }
	            if (j < arr2D[0].length-1 && arr2D[i][j] == arr2D[i][j+1]) {
	                return true;
	            }
	            if(arr2D[i][j] == 0) {
	            	return true;
	            }
	        }
	    }
	    return false;
	}

//method to move right
  public void moveNumRight(int[][] arr2D) {
	  int row = 0;
	  while(row < 4) {
		  
		  // move all numbers to the right		  
	    int count = arr2D.length-1;
		for(int i = arr2D.length-1; i >= 0; i--) {
			if(arr2D[row][i] != 0) {
				arr2D[row][count] = arr2D[row][i];
				count--;
			} 
		}
		while(count >= 0) {
			arr2D[row][count] = 0;
			count--;
		} 
			//add up the numbers
		for(int i = arr2D.length-1; i > 0; i--) {
			if(arr2D[row][i] == arr2D[row][i-1]) {
				arr2D[row][i] = arr2D[row][i]*2;
				arr2D[row][i-1] = 0;
				for(int j = i-1; j > 0; j--) {
					arr2D[row][j] = arr2D[row][j-1];
					arr2D[row][j-1] = 0;
				}
			}
		}
		row++;
	  }
  }
  
//method to move down
  public void moveNumDown(int[][] arr2D) {
	  int col = 0;
	  while(col < 4) {
		  	//move all numbers down
		  int count = arr2D.length-1;
		  for(int i = arr2D.length-1; i>=0; i--) {
			  if(arr2D[i][col] != 0) {
				  arr2D[count][col] = arr2D[i][col];
				  count--;
			  }
		  }
		  while(count >= 0) {
			  arr2D[count][col] = 0;
			  count--;
		  }
		  	//add up the numbers
		  for(int i = arr2D.length-1; i > 0; i--) {
			  if(arr2D[i][col] == arr2D[i-1][col]) {
				  arr2D[i][col] = arr2D[i][col]*2;
				  arr2D[i-1][col] = 0;
				  for(int j = i-1; j > 0; j--) {
					  arr2D[j][col] = arr2D[j-1][col];
					  arr2D[j-1][col] = 0;
				  }
			  }
		  }
		  col++;
	  }
  }
  
//method to move left
  public void moveNumLeft(int[][] arr2D) {
	  int row = 0;
	  while(row < 4) {
		  //move all numbers to the left
		int count = 0;
	  	for(int i = 0; i < arr2D.length; i++) {
		  if(arr2D[row][i] != 0) {
			  arr2D[row][count] = arr2D[row][i];
			  count++;
		  }
	  	}
	  	while(count < arr2D.length) {
	  		arr2D[row][count] = 0;
	  		count++;
	  	}
	  	  //add up the numbers
	  	for(int i = 0; i < arr2D.length-1; i++) {
	  		if(arr2D[row][i] == arr2D[row][i+1]) {
	  			arr2D[row][i] = arr2D[row][i]*2;
	  			arr2D[row][i+1] = 0;
	  			for(int j = i+1; j < arr2D.length-1; j++) {
	  				arr2D[row][j] = arr2D[row][j+1];
	  				arr2D[row][j+1] = 0;
	  			}
	  		}
	  	}
	  	row++;
	  }
  }
  
//method to move up
  public void moveNumUp(int[][] arr2D) {
	  int col = 0;
	  while(col < 4) {
		  	//move all numbers up
		  int count = 0;
		  for(int i = 0; i < arr2D.length; i++) {
			  if(arr2D[i][col] != 0) {
				  arr2D[count][col] = arr2D[i][col];
				  count++;
			  }
		  }
		  while(count < arr2D.length) {
			  arr2D[count][col] = 0;
			  count++;
		  }
		  	//add up the numbers
		  for(int i = 0; i < arr2D.length-1; i++) {
			  if(arr2D[i][col] == arr2D[i+1][col]) {
				  arr2D[i][col] = arr2D[i][col]*2;
				  arr2D[i+1][col] = 0;
				  for(int j = i+1; j < arr2D.length-1; j++) {
					  arr2D[j][col] = arr2D[j+1][col];
					  arr2D[j+1][col] = 0;
				  }
			  }
		  }
		  col++;
	  }
  }
  
////adding first 2 numbers to the array 2D
  public void startGame(int[][] arr2D) {
	  Random rand = new Random();
	  int x1 = rand.nextInt(4);
	  int y1 = rand.nextInt(4);
	  int x2 = rand.nextInt(4);
	  int y2 = rand.nextInt(4);
	  while(x1 == x2 || y1 == y2) {
		  x2 = rand.nextInt(4);
		  y2 = rand.nextInt(4);
	  }
	  for(int i = 0; i < 4; i++) {
		  for(int j = 0; j < 4; j++) {
			  if(i == x1 && j == y1) {
				  double random = rand.nextDouble();
			  	  if(random < 0.8) {
			  		  arr2D[i][j] = 2;
			  	  }
			  	  else arr2D[i][j] = 4;
			  }
			  if(i == x2 && j == y2) {
				  double random = rand.nextDouble();
			  	  if(random < 0.8) {
			  		  arr2D[i][j] = 2;
			  	  }
			  	  else arr2D[i][j] = 4;
			  }
          }
	  	}
		  for(int i = 0; i < 6; i++){
			System.out.print("_          ");
		  }
		  System.out.println();
		  for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
			  if(j == 0){
				if(arr2D[i][j] == 0){
				  System.out.print(String.format("| %10s ", "*"));
				} else {
				  System.out.print(String.format("| %10d ", arr2D[i][j]));
				}
			  } else if(j == arr2D.length-1){
				if(arr2D[i][j] == 0){
				  System.out.print(String.format("%10s          |", "*"));
				} else {
				  System.out.print(String.format("%10d          |", arr2D[i][j]));
				}
			  } else {
				if(arr2D[i][j] == 0){
				  System.out.print(String.format("%10s ", "*"));
				} else {
				  System.out.print(String.format("%10d ", arr2D[i][j]));
				}
			  }
			}
			if(i != 3){
			System.out.println();
			System.out.println();
			System.out.println();
			}
		  }
		  System.out.println();
		  for(int i = 0; i < 6; i++){
			System.out.print("_          ");
		  }
  	}

//max number in the array2D
  	public int maxNum(int[][]arr2D) {
	  int max = 0; 
	  for(int i = 0; i < arr2D.length; i++) {
		  for(int j = 0; j < arr2D.length; j++) {
			  if(arr2D[i][j] > max) {
				  max = arr2D[i][j];
			  }
		  }
	  }
	  return max;
  	}
  
//clear the console
  public void clearConsole() {
	  for(int i = 0; i < 20; i++) {
		  System.out.println();
	  }
  }

  public static void main(String[] args) {
	  Nhap nhap = new Nhap();

//creating 2D array
	  int[][] arr2D = new int[4][4];
	  
	  
	  System.out.println("Welcome to 2048!");
	  System.out.println("Press 'a' to move left, 's' to move down, 'd' to move right, 'w' to move up");
	  System.out.println();
	  nhap.startGame(arr2D);
	  
//allowing user to play using a,w,s,d in the keyboard
	  Scanner sc = new Scanner(System.in);
	  int count = 0;
	  while(true) {
		  
		  String input = sc.nextLine();
//if press "s"
		  if(input.equals("s")){
			  boolean same = true;
			  int[][] sample = new int[4][4];
			  for(int i = 0; i < arr2D.length; i++) {
					for(int j = 0; j < arr2D.length; j++) {
						sample[i][j] = arr2D[i][j];
					}
			  }
			  nhap.moveNumDown(arr2D);
			  for(int i = 0; i < arr2D.length; i++) {
					for(int j = 0; j < arr2D.length; j++) {
						if(sample[i][j] != arr2D[i][j]) {
							same = false;
						}
					}
			  }
			  if(same == false) {
				  count++;
				  nhap.addNum(arr2D);
				  nhap.clearConsole();
				  System.out.println();
				  nhap.print(arr2D);
				System.out.println();
				  System.out.println("Key pressed: s (Valid Move)" );
				  System.out.println("Max number: " + nhap.maxNum(arr2D));
				  System.out.println("Number of Valid Move: " + count);
			  }
			  else {
				  System.out.println("Invalid move");
			  }
		  }
//if press "a"
		  if(input.equals("a")){
			  boolean same = true;
			  int[][] sample = new int[4][4];
			  for(int i = 0; i < arr2D.length; i++) {
					for(int j = 0; j < arr2D.length; j++) {
						sample[i][j] = arr2D[i][j];
					}
			  }
			  nhap.moveNumLeft(arr2D);
			  for(int i = 0; i < arr2D.length; i++) {
					for(int j = 0; j < arr2D.length; j++) {
						if(sample[i][j] != arr2D[i][j]) {
							same = false;
						}
					}
			  }
			  
			  if(same == false) {
				  count++;
				  nhap.addNum(arr2D);
				  nhap.clearConsole();
				  System.out.println();
				  nhap.print(arr2D);
				System.out.println();
				  System.out.println("Key pressed: a (Valid Move)" );
				  System.out.println("Max number: " + nhap.maxNum(arr2D));
				  System.out.println("Number of Valid Move: " + count);
			  }
			  else {
				  System.out.println("Invalid move");
			  }
		  }
//if press "w"
		  if(input.equals("w")){
			  boolean same = true;
			  int[][] sample = new int[4][4];
			  for(int i = 0; i < arr2D.length; i++) {
					for(int j = 0; j < arr2D.length; j++) {
						sample[i][j] = arr2D[i][j];
					}
			  }
			  nhap.moveNumUp(arr2D);
			  for(int i = 0; i < arr2D.length; i++) {
					for(int j = 0; j < arr2D.length; j++) {
						if(sample[i][j] != arr2D[i][j]) {
							same = false;
						}
					}
			  }
			  
			  if(same == false) {
				  count++;
				  nhap.addNum(arr2D);
				  nhap.clearConsole();
				  System.out.println();
				  nhap.print(arr2D);
				System.out.println();
				  System.out.println("Key pressed: w (Valid Move)" );
				  System.out.println("Max number: " + nhap.maxNum(arr2D));
				  System.out.println("Number of Valid Move: " + count);
			  }
			  else {
				  System.out.println("Invalid move");
			  }
		  }
//if press "d"
		  if(input.equals("d")){
			  boolean same = true;
			  int[][] sample = new int[4][4];
			  for(int i = 0; i < arr2D.length; i++) {
					for(int j = 0; j < arr2D.length; j++) {
						sample[i][j] = arr2D[i][j];
					}
			  }
			  nhap.moveNumRight(arr2D);
			  for(int i = 0; i < arr2D.length; i++) {
					for(int j = 0; j < arr2D.length; j++) {
						if(sample[i][j] != arr2D[i][j]) {
							same = false;
						}
					}
			  }
			  
			  if(same == false) {
				  count++;
				  nhap.addNum(arr2D);
				  nhap.clearConsole();
				  System.out.println();
				  nhap.print(arr2D);
				System.out.println();
				  System.out.println("Key pressed: d (Valid Move)" );
				  System.out.println("Max number: " + nhap.maxNum(arr2D));
				  System.out.println("Number of Valid Move: " + count);
			  }
			  else {
				  System.out.println("Invalid move");
			  }
		  }
//if press "q" to quit
		  if(input.equals("q")) {
			  System.out.println("Are you sure? Press 'q' again to quit");
			  System.out.println("Press any other key to confirm and continue the game");
			  String input2 = sc.nextLine();
			  if(input2.equals("q")) {
				  System.out.println("Game Over!!");
				  System.out.println("Max number: " + nhap.maxNum(arr2D));
				  System.out.println("Number of Valid Move: " + count);
				  break;
			  	}
				else {
					System.out.println("Game continues!");
				}
		  	}
//if press "r" to restart the game
		  if(input.equals("r")) {
			  System.out.println("Are you sure? Press 'r' again to restart the game");
			  System.out.println("Press any other key to confirm and continue the game");
			  String input3 = sc.nextLine();
			  if(input3.equals("r")) {
				System.out.println("New Game");
				  for(int i = 0; i < arr2D.length; i++) {
					  for(int j = 0; j < arr2D.length; j++) {
						 arr2D[i][j] = 0; 
					  	}
					}
				nhap.startGame(arr2D);
			  }
			  else {
				System.out.println("Game continues!");
			  }
		  }
//when you win
		  for(int i = 0; i < arr2D.length; i++) {
			  for(int j = 0; j < arr2D.length; j++) {
				  if(arr2D[i][j] == 2048) {
					  System.out.println("You win!!!");
					  System.out.println("Number of Valid Move: " + count);
					  break;
				  }
			  }
		  }
//when the game is over
		  if(nhap.canMove(arr2D) == false) {
			  System.out.println("Game Over!!!");
			  break;
		  }
	  }
  }
  
}




