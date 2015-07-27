package user;


public class User implements Login, Logout {
	
	private String name;
	private Executor loginExecutor;
	private Executor logoutExecutor;

	public User(String name) {
		this.name = name;
		this.loginExecutor = new LoginExecutor();
		this.logoutExecutor = new LogoutExecutor();
	}
	
	public String getName() {
		
		return name;
	}

	@Override
	public boolean logout() {
		
		return logoutExecutor.exec(this);
	}

	@Override
	public boolean login() {
		
		return loginExecutor.exec(this);
	}
	
	
	/*
	 * 로그인 관련 클래스
	 */
	private interface Executor {
		
		boolean exec(User user);

	}
	
	private class LoginExecutor implements Executor {
		
		private Validator validator;
		
		{
			validator = new UserValidator();
		}

		@Override
		public boolean exec(User user) {
			
			return validator.valid(user);
		}

	}
	
	public class LogoutExecutor implements Executor {

		@Override
		public boolean exec(User user) {
			
			return true;
			
		}

	}
	
	/*
	 * 데이터 검증 클래스
	 */
	private interface Validator {
		
		boolean valid(User user);
		
	}
	
	private class UserValidator implements Validator {

		@Override
		public boolean valid(User user) {
			
			boolean result = "dec7".equals(user.getName());
			if (result) {
				System.out.println("데이터 검증 성공");
			}
			else {
				System.out.println("데이터 검증 실패");
			}
			
			return result;
		}

	}


}
