package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class ex2 {
	public static void main(String[] args) {
		new ex2_box().aaa();
	}
}

class ex2_box{
	ArrayList<Integer> user = null;
	ArrayList<Integer> pc = null;
	
	Scanner sc =null;
	
	public ex2_box() {
		this.sc = new Scanner(System.in);
		this.user = new ArrayList<Integer>();
	}
	public Integer pc_return() {
		Integer npc = (int)Math.ceil(Math.random()*46);
		if(this.pc.contains(npc) == true) {
			npc = pc_return();
		}
		return npc;
	}
	
	public void aaa() {
		try {
			while(true) {
				if(this.user.size() == 6) {
					break;
				}
				
				if(this.pc.size() < 7) {
					Integer npc = (int)Math.ceil(Math.random()*46);
					if(this.pc.contains(npc) == false) {
						this.pc.add(npc);
					}else { //중복 되었을 때
						//외부 return 메소드 재핸들링
						Integer result = this.pc_return();
						this.pc.add(result);
					}
				}
				
				System.out.println("숫자를 입력하세요 (1~46): ");
				Integer no = this.sc.nextInt();
				if(no > 0 && no <= 46) {
					if(this.user.contains(no) == false) {
						this.user.add(no);
					}
				}
			}
		}catch (Exception e) {
			System.out.println("제발 숫자만 입력하세요!!");
			this.aaa();
		}finally {
			this.sc.close();
		}
	}
	
}