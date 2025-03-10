package exam;

import java.util.Random;
import java.util.Scanner;

public class ex1 {
	//Random : 자동으로 PC 생성되는 원리 => 기본 소수점
	//Math.random()
	public static void main(String[] args) {
		/*
		for(int i=0; i<5; i++) {
			double rd = Math.random();
			//char word = (char)((rd * 26) + 97);  //소문자 random, a(97)
			char word = (char)((rd * 26) + 65);  //대문자 random, A(65)
			System.out.println(word);
		}
		*/
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 하나를 입력하세요 : ");
		int no = sc.nextInt();
		for(int f=1; f<=no; f++) {
			int free = rand.nextInt(99);	
			System.out.println(free);
		}
		sc.close();
	}
}
