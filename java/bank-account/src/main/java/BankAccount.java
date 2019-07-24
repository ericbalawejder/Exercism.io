import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class BankAccount {

    private int balance;
    private boolean open;
    private final ReadWriteLock lock;

    BankAccount() {
        this.balance = 0;
        this.open = false;
        this.lock = new ReentrantReadWriteLock();
    }

    void open() {
        this.open = true;
    }

    void close() {
        this.open = false;
    }

    int getBalance() throws BankAccountActionInvalidException {
        isOpen();
        lock.readLock().lock();
        try {
            return this.balance;
        } finally {
            lock.readLock().unlock();
        }
    }

    void deposit(int amount) throws BankAccountActionInvalidException {
        isOpen();
        isValidAmount(amount);
        lock.writeLock().lock();
        try {
            setBalance(this.balance + amount);
        } finally {
            lock.writeLock().unlock();
        }
    }

    void withdraw(int amount) throws BankAccountActionInvalidException {
        isOpen();
        isValidAmount(amount);
        sufficientFunds(amount);
        lock.writeLock().lock();
        try {
            setBalance(this.balance - amount);
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }

    private void isOpen() throws BankAccountActionInvalidException {
        if (!this.open) {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    private void sufficientFunds(int amount) throws BankAccountActionInvalidException {
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
