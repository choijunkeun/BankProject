package exc;

public class BankException extends Exception {
	ERR code;

	public BankException(String message) {
		super(message);
	}

	public BankException(String message, ERR code) {
		super(message);
		this.code = code;
	}

	@Override
	public String toString() {
		String errMessage="";
		switch(code) {
		case NOT_ACC: errMessage+="계좌번호가 틀립니다."; break;
		case DEPOSIT: errMessage+="입금을 실패하였습니다."; break;
		case WITHDRAW: errMessage+="잔액이 부족합니다."; break;
		case MENU: errMessage+="0~5 선택해주세요."; break;
		case ACC_MENU: errMessage+="1,2 선택해주세요"; break;
		}
		return errMessage;
	}

}
