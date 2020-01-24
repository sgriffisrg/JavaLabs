package lab1;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int choice;
		Scanner input = new Scanner(System.in);
		System.out.print("Do you wanna run Location? Type 1. Otherwise 2 for Craps: ");
		choice = input.nextInt();
		if(choice == 2) {
			Craps play = new Craps();
			play.gameTime();
		}
		else {
			int c,r;
			System.out.print("Enter the number of rows: ");
			r = input.nextInt();
			System.out.print("Enter the number of columns: ");
			c = input.nextInt();
			double[][] userArr = new double[r][c];
			System.out.println("Please enter the values for the 2d Array: ");
			for(int i = 0; i < r; i++) 
				for(int j = 0; j < c; j++)
					userArr[i][j] = input.nextDouble();
			
			Location locale = locateInArr(r,c, userArr);
			locale.display();
		}
	}
	public static Location locateInArr(int row, int col, double[][] arr) {
		Location temp = new Location(row, col);
		double max = 0;
		for(int i = 0; i < row; i++) 
			for(int j = 0; j < col; j++) 
				if(max < arr[i][j])
					max = arr[i][j];
		temp.setMax(max);
		return temp;
		
	}
	
}

class Location {
	int row, col;
	double maxValue;
	Location(int x, int y){
		row = x;
		col = y;
	}
	void setMax(double max) {
		maxValue = max;
	}
	void display() {
		System.out.println("The max value for a 2d array with a row lengh of " + row + " and a column length of " + col
				+ " is: " + maxValue);
	}
}

class Craps {
	
	int value, point;
	
	void sum() {
		int sum;
		double roll1, roll2;
		roll1 = Math.random() * 6 + 1;
		roll2 = Math.random() * 6 + 1;
		sum = (int)(roll1 + roll2);
		System.out.println("You rolled " + (int)roll1 + " + " + (int)roll2 + " = " + sum);
		
		value = sum;
	}
		
	void gameTime(){
		sum();
		if(value == 7 || value == 11) {
			System.out.println("Congratulations, You Win!!");
		}
		else if (value == 2 || value == 3 || value == 12) {
			System.out.println("Better Luck Next Time, You lost!");
		}
		else {
			System.out.println("Point is set to " + value);
			point = value;
			sum();
			while(value != 7 && value != point) {
				sum();
			}

			if(value == point) {
				System.out.println("Congratulations, You Win!!");
			}
			else if (value == 7) {
				System.out.println("Better Luck Next Time, You lost!");
			}
		}
	}
	
}
