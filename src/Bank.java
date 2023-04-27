
import java.util.Scanner;

import acc.Account;
import acc.SpecialAccount;
import exc.BankException;
import exc.ERR;

//public을 붙여주면 다른 패키지에서도 접근이 가능
public class Bank { //Bank 클래스 생성
   Account[] accs = new Account[100]; //객체 100개가 아니라 레퍼런스 100개 생성된 것임
   int cnt; //int 타입으로 cnt 선언
   Scanner sc = new Scanner(System.in);//스캐너: 아래 콘솔창에 작성할 수 있게 함
   

   void makeAccount() throws BankException { //void=return되는 타입 없음 makeAccount안에 들어갈 정보
      System.out.println("[계좌개설]");
      System.out.print("계좌번호:");
      String id=sc.nextLine();//스캐너이용해서 글자 읽은 문자를 string id에 넣는다
      System.out.print("이름:");
      String name=sc.nextLine();
      System.out.print("입금액:");
      int money = Integer.parseInt(sc.nextLine());
      
      Account acc =searchAccById(id);
      if(acc!=null) {
         throw new BankException ("계좌개설오류", ERR.EXIST_ACC);
         
      }
      accs[cnt++]=new Account(id, name, money);//accs배열에 cnt(0)번째에 어카운트 객체가 들어감
   }
   void makeSpecialAccount() throws BankException{
      System.out.println("[특수계좌개설]");
      System.out.print("계좌번호:");
      String id=sc.nextLine();
      System.out.print("이름:");
      String name=sc.nextLine();
      System.out.print("입금액:");
      int money=Integer.parseInt(sc.nextLine());
      System.out.println("등급(VIP:V, Gold:G, Silver:S, Normal:N): ");
      String grade = sc.nextLine();
      accs[cnt++] = new SpecialAccount(id,name,money,grade);
      Account acc =searchAccById(id);
      if(acc!=null) {
         throw new BankException ("계좌개설오류", ERR.EXIST_ACC);
         
      }
      accs[cnt++]=new Account(id, name, money);//accs배열에 cnt(0)번째에 어카운트 객체가 들어감
   }
   

   
   Account searchAccById(String id) {//어카운트 객체반환
      for(int i=0; i<cnt; i++) { //i값이 0일때, cnt값(초기0)보다 작은 경우, 참이면 if문으로 
         if(accs[i].getId().equals(id)) {//=매개변수 아이디, accs에 있는 아이디, 두 아이디가 같은지 
            return accs[i]; //참일때 //return은 함수를 끝내버리는 기능을 함, 있으면 그냥 호출하고 끝
      }
   }
      return null;//거짓일때//계좌번호 틀렸을때 출력
   }
   
   void deposit() throws BankException {//은행입장// account에서 가져오면 됨
      System.out.println("[입금]");
      System.out.println("계좌번호:");
      String id=sc.nextLine();
      System.out.println("입금액:");
      int money=Integer.parseInt(sc.nextLine());
//      searchAccById(id).deposit(돈);//계좌번호가 틀렸을때 확인할 수 있는 기능을 넣어줘야 함
       Account acc = searchAccById(id);
       if(acc==null){
          throw new BankException("계좌오류", ERR.NOT_ACC);
//       System.out.println("계좌번호가 틀립니다.");
      } else {
       if(acc.deposit(money)){
       System.out.println("입금성공");
       }else {
//       System.out.println("입금실패");
          throw new BankException("계좌오류", ERR.DEPOSIT);
       }
      }
      
}
   

   void withdraw() throws BankException {//은행입장// account에서 가져오면 됨
      System.out.println("[출금]");
      System.out.println("계좌번호:");
      String id=sc.nextLine();
      System.out.println("출금액:");
      int money=Integer.parseInt(sc.nextLine());
//      searchAccById(id).withdraw(돈);
      Account acc = searchAccById(id);
      if(acc==null){
      System.out.println("계좌번호가 틀립니다.");
   }else {
      if(acc.withdraw(money)) {
         System.out.println("출금에 성공했습니다.");
      } else {
         throw new BankException("계좌오류", ERR.WITHDRAW);
//         System.out.println("잔액이 부족합니다.");
      }
   }
   }
   void accInfo() {
      System.out.println("[계좌조회]");
      System.out.println("계좌번호:");
      String id=sc.nextLine();
//      System.out.println(searchAccById(id).info());
      Account acc = searchAccById(id);
      if(acc==null) {
         System.out.println("계좌번호가 틀립니다.");
      }else {
         System.out.println(acc.info());
      }
      
   }
   
   void allAccInfo() {
      System.out.println("[전체계좌조회]");
      for(int i=0; i<cnt; i++) {
         System.out.println(accs[i].info());
      }
      
   }
   int menu() throws BankException {//이걸실행 //처리해주기
      System.out.println("[웰컴은행]");
      System.out.println("0. 종료");
      System.out.println("1. 계좌개설");
      System.out.println("2. 입금");
      System.out.println("3. 출금");
      System.out.println("4. 계좌조회");
      System.out.println("5. 전체계좌조회");
      System.out.println("선택>>");
      int sel = Integer.parseInt(sc.nextLine()); //입력받을 '숫자'
      if(sel<0||sel>5)
         throw new BankException("메뉴오류", ERR.MENU);//던지고
      return sel;//셀 값 변환
   }
   
   void selAccMenu() throws BankException {
      System.out.println("[계좌종류선택]");
      System.out.println("1.일반계좌");
      System.out.println("2.특수계좌");
      System.out.print("선택>>");
      int sel = Integer.parseInt(sc.nextLine());
      if(sel==1) makeAccount();
      else if(sel==2) makeSpecialAccount();
      else throw new BankException("메뉴오류", ERR.ACC_MENU);
   }


      
   

   }