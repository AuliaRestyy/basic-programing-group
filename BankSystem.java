import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        System.out.println("Welcome! Your current balance is $" + balance);

        int failedTransaction = 0;
        int choice;

        do {
            System.out.println("Choose an option: ");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
             
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double deposit = sc.nextDouble();

                    if (deposit <= 0) {
                        System.out.println("Error: You can't deposit a negative amount. Please try again.");
                        failedTransaction++;
                    } else {
                        balance += deposit;
                        System.out.println("Deposit successful! Your new balance is $" + balance);
                        failedTransaction = 0;
                    }
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();

                    if (withdraw > 500) {
                        System.out.println("Error: You can't withdraw more than $500 at once.");
                        failedTransaction++;
                    } else if (withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("Withdrawal successful! Your new balance is $" + balance);
                        failedTransaction = 0;
                    } else if (withdraw > balance) {
                        System.out.println("Error: Insufficient balance.");
                        failedTransaction++;
                    }
                    break;
                case 3:
                    System.out.println("Your current balance is $" + balance);
                    break;
                case 4:
                    System.out.println("Thank you! Your final balance is $" + balance);
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error: Invalid choice. Please try again.");
                    break;
            }
        
        if (failedTransaction >=3) {
            System.out.println("Too many invalid attempts. Your account has been temporarily locked for security reasons.");
            System.exit(0);
        }

        System.out.println();
        
        } while (choice != 4);

        sc.close();
    }
}