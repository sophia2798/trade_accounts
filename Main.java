import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import constants.TradeAccountType;
import constants.Transaction;
import pojo.CashAccount;
import pojo.MarginAccount;
import pojo.TradeAccount;
import repository.TradeAccountRepository;
import service.CashAccountService;
import service.MarginAccountService;
import service.TradeAccountService;

public class Main {

    static Path[] paths = new Path[] {Paths.get("data/accounts.txt"), Paths.get("data/transactions.txt")};


    static TradeAccountRepository tradeAccountRepository = new TradeAccountRepository();
    static CashAccountService cashAccountService = new CashAccountService(tradeAccountRepository);
    static MarginAccountService marginAccountService = new MarginAccountService(tradeAccountRepository);

    public static void main(String[] args) {



    }

    public static void loadTradeAccounts() throws IOException {
        Files.lines(paths[0])
            .forEach(line -> {
                String[] words = line.split(" ");
                Boolean isCashAccount = words[0].equals(TradeAccountType.CASH.toString());
                if (isCashAccount) cashAccountService.createTradeAccount(new CashAccount(words[1], new BigDecimal(words[2])));
                else marginAccountService.createTradeAccount(new MarginAccount(words[1], new BigDecimal(words[2])));
            });
    }

    public static void applyTransactions() throws IOException {
        Files.lines(paths[1])
            .forEach(line -> {
                String[] words = line.split(" ");
                Boolean isCash = words[0].equals(TradeAccountType.CASH.toString());
                TradeAccountService accountService = isCash ? cashAccountService : marginAccountService;
                Transaction transaction = Transaction.valueOf(words[2]);
                if (transaction.equals(Transaction.DEPOSIT)) accountService.deposit(words[1], new BigDecimal(words[3]));
                else accountService.withdraw(words[1], new BigDecimal(words[3]));
            });
    }
}