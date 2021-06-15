import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
	double balance;
	DecimalFormat f = new DecimalFormat("0.00");
	double eurobalance;
	double yenbalance;
	double poundsbalance;
	double audbalance;
	double cadbalance;
	double francbalance;
	double yuanbalance;
	String customerName;
	String customerID;
		
	App(String cname, String cid){
		customerName = cname;
		customerID = cid;
	}
		
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
		}
	}
		
	void withdraw(int amount) {
		if (amount!= 0) {
			balance = balance - amount;
		}
	}
	void exchange() {
			int optionn = '\0';
			Scanner sc = new Scanner(System.in);
			System.out.println("Current exchange rates: ");
			System.out.println("1. (EUR) Euro ~ 0.82 $");
			System.out.println("2. (YPY) Yen ~ 109.70 $");
			System.out.println("3. (GBP) Pound sterling ~ 0.71 $");
			System.out.println("4. (AUD) Australian dollar ~ 1.30 $");
			System.out.println("5. (CAD) Canadian dollar ~ 1.22 $");
			System.out.println("6. (CHF) Swiss franc ~ 0.90 $");
			System.out.println("7. (CNY) Yuan ~ 6.40 $");
			System.out.println("0. Exit currency exchange");
			double euro = 0.825351;
			double yen = 109.67127;
			double pound = 0.709828;
			double aud = 1.296363;
			double cad = 1.215788;
			double franc = 0.899102;
			double yuan = 6.398408;
			
			do {
				System.out.println();
				System.out.println("To which currency you wish to exchange? ");
				int ans = sc.nextInt();
				if (ans != 1 & ans != 2 & ans != 3 & ans != 4 & ans != 5 & ans != 6 & ans != 7 & ans != 0) {
					System.out.println("Error: invalid option. Please enter 1, 2, 3, 4, 5, 6 or 7.");
					System.out.println();
					exchange();
					break;
				}else if (ans == 0) {
					showMenu();
					break;
				}
				System.out.println();
				System.out.println("How much would you like to exchange?");
				int amount3 = sc.nextInt();
				if (amount3 <= balance) {
				balance = balance - amount3;
				switch(ans) {
				// Case 1 exchanges for euro
				case 1:
					eurobalance = (amount3 * euro);
					System.out.println("Your current balance is: " + f.format(eurobalance) + " euro");
					break;
				
				// Case 2 exchanges for yen
				case 2:
					yenbalance = (amount3 * yen);
					System.out.println("Your current balance is: " + f.format(yenbalance) + " yen");
					break;
					
				// Case 3 exchanges for pound sterling
				case 3:
					poundsbalance = (amount3 * pound);
					System.out.println("Your current balance is: " + f.format(poundsbalance) + " pound sterling");
					break;
					
				// Case 4 exchanges for Australian dollars
				case 4:
					audbalance = (amount3 * aud);
					System.out.println("Your current balance is: " + f.format(audbalance) + " australian dollars");
					break;
					
				// Case 5 exchanges for Canadian dollars
				case 5:
					cadbalance = (amount3 * cad);
					System.out.println("Your current balance is: " + f.format(cadbalance) + " canadian dollars");
					break;
					
				// Case 6 exchanges for Swiss franc
				case 6:
					francbalance = (amount3 * franc);
					System.out.println("Your current balance is: " + f.format(francbalance) + " swiss franc");
					break;
					
				// Case 7 exchanges for Chinese yuan 
				case 7:
					yuanbalance = (amount3 * yuan);
					System.out.println("Your current balance is: " + f.format(yuanbalance) + " yuan");
					break;
					
				}
					
				}else if (amount3 > balance) {
					System.out.println("Error: Incorrect amount to exchange.");
					exchange();
				}
			} while(optionn != 0);
			System.out.println("==================");
			System.out.println("Thank you for banking with us!");
			
			
			
		}
		
		
	void calculateInterest(int years) {
		double interestRate = .0185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current rate is " + f.format(100 * interestRate));
		System.out.println("After " + years + "years, your balance will be: " + newBalance);
	}
		
	void showMenu() {
		char option = '\0';
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A - Check your balance,");
		System.out.println("B - Make a deposit,");
		System.out.println("C - Make a withdrawal,");
		System.out.println("D - Calculate interest,");
		System.out.println("E - Currency exchange,");
		System.out.println("Q - Quit.");
			
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = sc2.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
				
			switch(option) {
			// Case A allows to check balance
			case 'A':
				System.out.println("==================");
				System.out.println("Balance = " + f.format(balance) + " USD");
				System.out.println("          " + f.format(eurobalance) + " EUR");
				System.out.println("          " + f.format(yenbalance) + " YPY");
				System.out.println("          " + f.format(poundsbalance) + " GBP");
				System.out.println("          " + f.format(audbalance) + " AUD");
				System.out.println("          " + f.format(cadbalance) + " CAD");
				System.out.println("          " + f.format(francbalance) + " CHF");
				System.out.println("          " + f.format(yuanbalance) + " CNY");
				System.out.println("==================");
				System.out.println();
				break;
				
			// Case B allows to deposit money to account
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = sc2.nextInt();
				deposit(amount);
				System.out.println();
				break;
		
			// Case C allows to withdraw money from account
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = sc2.nextInt();
				if (amount2 <= balance) {
					withdraw(amount2);
					System.out.println();
					break;
				}else if (amount2 > balance) {
					System.out.println("Error: Incorrect amount of funds.");
					System.out.println("==================");
					showMenu();
					break;
				}
				
					

			// Case D allows to exchange currencies
			case 'D':
				System.out.println("Enter how many years of accrued interest: ");
				int years = sc2.nextInt();
				calculateInterest(years);
				break;
				
					
			// Case E calculates the accrued interest on the account after a number of years
			case 'E':
				System.out.println("==================");
				exchange();
				break;
				
			// Case Q exits the user from the account
			case 'Q':
				System.out.println("==================");
				break;
				
			// Default case let's user know he entered invalid character
			default:
				System.out.println("Error: invalid option. Please enter A, B, C, D, E, Q");
				break;
			}
			
		} while(option != 'Q');
		System.out.println("Thank you for banking with us!");
	}
		
}

