public class BankingLedger {

    // Instance variables
    String accountHolderName;
    String accountNumber;
    double balance;
    double totalDeposits;
    double totalWithdrawals;

    // Constructor to initialize the account
    public BankingLedger(String name, String accNum, double initialBalance) {
        // String manipulation: trim spaces
        this.accountHolderName = name.trim();
        this.accountNumber = accNum;
        this.balance = initialBalance;
        this.totalDeposits = 0;
        this.totalWithdrawals = 0;
    }

    // Overloaded deposit method with amount only
    public void deposit(double amount) {
        balance += amount;
        totalDeposits += amount;
        System.out.println("Deposit Amount      : Rs. " + amount);
        System.out.println("Transaction Status  : Deposit Successful");
        System.out.println("Updated Balance     : Rs. " + balance);
        System.out.println();
    }

    // Overloaded withdraw method with amount only
    public void withdraw(double amount) {
        System.out.println("Withdrawal Amount   : Rs. " + amount);
        
        // Validation check
        if (amount > balance) {
            System.out.println("Transaction Status  : Insufficient Balance");
            System.out.println("Available Balance   : Rs. " + balance);
        } else {
            balance -= amount;
            totalWithdrawals += amount;
            System.out.println("Transaction Status  : Withdrawal Successful");
            System.out.println("Updated Balance     : Rs. " + balance);
        }
        System.out.println();
    }

    // String manipulation method to verify name
    public void verifyName(String testName) {
        System.out.println("--------- ACCOUNT SUMMARY ---------");
        System.out.println("Account Holder      : " + accountHolderName);
        System.out.println("Account Number      : " + accountNumber);
        System.out.println("Total Deposits      : Rs. " + totalDeposits);
        System.out.println("Total Withdrawals   : Rs. " + totalWithdrawals);
        System.out.println("Final Balance       : Rs. " + balance);
        System.out.println();

        // Compare names ignoring uppercase/lowercase differences
        if (accountHolderName.equalsIgnoreCase(testName.trim())) {
            System.out.println("Account Holder Verification: Names Match");
        } else {
            System.out.println("Account Holder Verification: Names Do Not Match");
        }
    }

    public static void main(String[] args) {
        // Printing the header and initial details
        System.out.println("========== PERSONAL BANKING LEDGER ==========");
        System.out.println("Account Holder Name : RAVI KUMAR");
        System.out.println("Account Number      : 1234567890");
        System.out.println("Initial Balance     : Rs. 10000.00");
        System.out.println();

        // Create object matching the sample data
        BankingLedger account = new BankingLedger("RAVI KUMAR", "1234567890", 10000.00);

        System.out.println("--------- TRANSACTION DETAILS ---------");
        
        // 1. Successful Deposit
        account.deposit(5000.00);

        // 2. Successful Withdrawal
        account.withdraw(2000.00);

        // 3. Failed Withdrawal (Insufficient funds)
        account.withdraw(20000.00);

        // 4. Verify name and print the final account summary
        account.verifyName("ravi kumar");
        
        System.out.println("==========================================");
    }
}