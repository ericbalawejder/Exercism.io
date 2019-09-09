class BankAccount {

    private int balance = 0;
    private boolean open = false;

    void open() {
        this.open = true;
    }

    void close() {
        this.open = false;
    }

    synchronized int getBalance() throws BankAccountActionInvalidException {
        isOpen();
        return this.balance;
    }

    synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        isOpen();
        isValidAmount(amount);
        setBalance(this.balance + amount);
    }

    synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        isOpen();
        isValidAmount(amount);
        hasSufficientFunds(amount);
        setBalance(this.balance - amount);
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }

    private void isOpen() throws BankAccountActionInvalidException {
        if (!this.open) {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    private void hasSufficientFunds(int amount) throws BankAccountActionInvalidException {
        if (this.balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        } else if (this.balance < amount) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
    }

    private void isValidAmount(int amount) throws BankAccountActionInvalidException {
        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
    }

}
