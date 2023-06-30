package service;

import java.math.BigDecimal;

import pojo.CashAccount;
import repository.TradeAccountRepository;

public class CashAccountService implements TradeAccountService{

    private TradeAccountRepository repository;

    public CashAccountService(TradeAccountRepository repository) {
        this.repository = repository;
    }

    public CashAccount retrieveTradeAccount(String id) {
        return (CashAccount) this.repository.retrieveTradeAccount(id);
    }

    public void createTradeAccount(CashAccount cashAccount) {
        this.repository.createTradeAccount(cashAccount);
    }

    public void updateTradeAccount(CashAccount cashAccount) {
        this.repository.updateTradeAccount(cashAccount);
    }

    public void deleteTradeAccount(String id) {
        this.repository.deleteTradeAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        CashAccount cashAccount = retrieveTradeAccount(id);
        cashAccount.setCashBalance(cashAccount.getCashBalance().add(amount));
        updateTradeAccount(cashAccount);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        CashAccount cashAccount = retrieveTradeAccount(id);
        cashAccount.setCashBalance(cashAccount.getCashBalance().subtract(amount));
        updateTradeAccount(cashAccount);
    }

}
