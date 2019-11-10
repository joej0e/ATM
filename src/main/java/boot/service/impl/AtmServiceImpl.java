package boot.service.impl;

import boot.entity.Banknote;
import boot.repository.AccountRepository;
import boot.repository.BanknoteRepository;
import boot.service.AtmService;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AtmServiceImpl implements AtmService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BanknoteRepository banknoteRepository;

    public void depositCashToAtm(String inputBanknote, Long quantity) {
        Long currentQuantity = banknoteRepository
                .findByName(inputBanknote)
                .getQuantity();
        banknoteRepository.findByName(inputBanknote).setQuantity(currentQuantity + quantity);
    }

    @Override
    public void withdrawCashFromAtm(String inputBanknote, Long quantity) {
        Long currentQuantity = banknoteRepository
                .findByName(inputBanknote)
                .getQuantity();
        banknoteRepository.findByName(inputBanknote).setQuantity(currentQuantity - quantity);
    }

    @Override
    public HashMap<String, Long> getBanknoteQuantities() {
        List<Banknote> banknotes = banknoteRepository.findAll();
        HashMap<String, Long> mapQuantities = new HashMap<>();
        for (Banknote banknote : banknotes) {
            mapQuantities.put(banknote.getName(),
                    banknote.getQuantity() * Integer.parseInt(banknote.getName()));
        }
        return mapQuantities;
    }
}
