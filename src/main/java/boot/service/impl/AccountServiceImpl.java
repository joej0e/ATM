package boot.service.impl;

import boot.repository.AccountRepository;
import boot.service.AccountService;
import boot.service.AtmService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AtmService atmService;

    private static boolean checkBanknote(String banknote) {
        return banknote.equals(AtmService.FIVE100)
                || banknote.equals(AtmService.TWO100)
                || banknote.equals(AtmService.ONE100);
    }

    @Override
    public void topUpAccount(Long accountId, String banknote) {
        if (checkBanknote(banknote)) {
            atmService.depositCashToAtm(banknote, 1L);
        }
    }

    @Override
    public void withdraw(Long accountId, Long amount) {
        if (amount <= accountRepository.getOne(accountId).getBalance()) {
            HashMap<String, Long> banknoteQuantities = atmService.getBanknoteQuantities();
            banknoteQuantities.forEach((k, v) -> {
                if (amount <= v && amount % Integer.parseInt(k) == 0
                        && amount / Integer.parseInt(k) < AtmService.LIMIT) {
                    atmService.withdrawCashFromAtm(AtmService.ONE100, amount / Integer.parseInt(k));
                }
            });
        }
    }
}
