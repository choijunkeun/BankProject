package acc;
public class Account {
	String id; //굳이 id=100; 선언 안해줘도 된다는 말. 
	String name;
	int balance;
	
	public String getId() {
		return id;
	}

	public Account() {}
	public Account(String id, String name, int balance) { //package를 다르게 해서  public 붙임. 
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public boolean deposit(int money) {
		if (money > 0) {
			this.balance += money;
			return true;
		}
		return false;
	}

	public boolean withdraw(int money) {
		if (balance >= money) {
			balance -= money;
			return true;
		}
		return false;
	}

	public String info() {
		return "계좌변호: " + id + ", 이름: " + name + ", 잔액: " + balance;
	}

}
