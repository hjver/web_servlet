package exam;

import java.util.Scanner;

public class ex6 {

	public static void main(String[] args) {
		String user[][] = {
				{"마동석", "01053514423"},
				{"김무열", "01010042223"},
				{"박지환", "01055553333"}
		};
		Scanner sc = new Scanner(System.in);
		System.out.println("고객명을 입려하세요 : ");
		String name = sc.nextLine().replaceAll(" ", "");
		int w = 0;
		while(w < user.length) {
			if(name.equals(user[w][0])){
				System.out.println(user[w][0] + "님 연락처 " + user[w][1] + "입니다.");
			}
		}
	}

}
