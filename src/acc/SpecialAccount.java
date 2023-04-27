package acc;

public class SpecialAccount extends Account{//이거써야 상속을 받고 오버라이딩 가능
	String grade;
	public SpecialAccount(String id, String name, int money, String grade) {
		super(id,name,money);
		setGrade(grade);
	}
	public String getGrade() { 
		return grade;
	}

	public void setGrade(String grade) {
		switch(grade.toUpperCase()) {
		case"V" : this.grade="VIP";break;
		case"G" : this.grade="Gold";break;
		case"S" : this.grade="Silver";break;
		case"N" : this.grade="Normal";break;
		}
	}
	@Override
	public boolean deposit(int money) {
		double rate = 0;
		switch(getGrade()) {
	case "VIP" : rate=0.04 ; break; 
	case "Gold" : rate=0.03 ; break;
	case "Silver" : rate=0.02 ; break;	
	case "Normal" : rate=0.01 ; break;
		}
	money +=(int)(money*rate);
	return super.deposit(money);
}
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+" 등급:"+getGrade();
	}
}



//class : SpecialAccount
//
//property
//id, name, balance, grade(VIP,Gold,Silver,Normal)
//
//method
//deposit, withdraw, info
//단, deposit은 Account의 deposit과 달리
//입금액에 등급에 따라 입금액을 더해준다.
//(VIP:입금액의 0.04, Gold:입금액의 0.03, Silver:입금액의 0.02, Normal:입금액의 0.01)
//또한 info도 등급까지 포함하여 출력한다. 