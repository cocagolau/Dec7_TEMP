package client;

import user.User;

public class Client {
	
	public void exec(User user) {
		if (user.login()) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
		if (user.logout()) {
			System.out.println("로그아웃 성공");
		}
		else {
			System.out.println("로그아웃 실패");
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		
		System.out.println("1st");
		client.exec(new User("Dec7"));
		
		System.out.println("--------");
		System.out.println();
		
		System.out.println("2nd");
		client.exec(new User("dec7"));
	}

}
