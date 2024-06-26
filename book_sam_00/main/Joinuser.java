package main;
//회원가입
import java.util.Scanner;
import dto.UserVo;

public class Joinuser {

	private static UserVo user[] = new UserVo[10];	//객체 배열 선언 및 생성
	

	public static void join(Scanner sc) {		
		// NullpointerException방지 배열 초기화
		// 무엇을 선택해도 첫번째 배열부터 나오는 코드
		for(int i=0;i<10;i++) {
			user[i] = new UserVo(); 
		}
		UserVo users = new UserVo();
				
		boolean run = true;

		do {
			 System.out.printf("\n *** 회원가입창 *** \n");
		 	 System.out.println(" =================================================");
			 System.out.printf(" \n 1. 회원가입 	 2. 연령대별 책 추천     3. 종료 ");
			 System.out.println(" \n =================================================");
			 System.out.print(" ▶");
			 
			 int select = sc.nextInt();			
//			 //회원가입 선택 
			 if(select == 1) {
				 users = createAccount(sc);
				 Insert.insertUsers(users.getId(), users.getAge(), 0, 0);
				 OperatingSystem.main(null);
			 }else if(select ==2) {
					System.out.println();
					System.out.print(" 나이를 입력해 주세요");
					System.out.println(" ");
					System.out.print(" ▶ ");
					int memAge = sc.nextInt();
					int bookAge = memAge/10 ;
					System.out.println(" ");
					System.out.println(" *회원에게 맞는 책을 추천합니다. *");
					System.out.println(" =================================================");
				 if (bookAge == 0) {
					 BkInsert.selectBook(0);
					 System.out.println("==1111=====");
				 }else if(bookAge == 1) {
					 BkInsert.selectBook(1);
					 System.out.println("====22222=====");
				 }else { 
					 BkInsert.selectBook(2);
					 System.out.println("=====33333=====");
				 }
			 }else {
				 run = false;
			 }
			 	}while (run);
					System.out.println();
					System.out.println("프로그램 종료");
		}

	//  회원가입 선택
	    private static UserVo createAccount(Scanner sc) {
		UserVo users = new UserVo();
		
		System.out.print(" 아이디를 입력하세요 : ");
		String id = sc.next();
		System.out.println(" ");
		users.setId(id);
		System.out.println(users.getId());
		
		System.out.print(" \n나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.println(" ");
		users.setAge(age);
		System.out.println(users.getAge());
		
	
		System.out.println("");
		System.out.println(" >> 회원가입이 완료되었습니다.");
		System.out.print("");
		return users;
	}
}

