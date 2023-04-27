import exc.BankException;

public class BankMain {

   public static void main(String[] args) throws BankException {
      Bank bank = new Bank();
      int sel=0;
Loop:      while(true) {
         try {
         sel=bank.menu();
         switch(sel) {
         case 0: break Loop;
         case 1: bank.selAccMenu(); break;
         case 2: bank.deposit(); break;
         case 3: bank.withdraw(); break;
         case 4: bank.accInfo(); break;
         case 5: bank.allAccInfo();
         }
      } catch (NumberFormatException e) {
         System.out.println("숫자입력만 가능합니다.");
         }catch(BankException e) {
            System.out.println(e);
         }
      }
   }
}
/*
 * 계좌번호:10001, 이름:홍길동, 잔액:100000
 * 계좌번호:10001, 이름:홍길동, 잔액:110000
 * 계좌번호:10001, 이름:홍길동, 잔액:105000
*/