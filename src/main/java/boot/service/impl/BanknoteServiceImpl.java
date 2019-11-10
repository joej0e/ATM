package boot.service.impl;

import boot.entity.Banknote;
import boot.repository.BanknoteRepository;
import boot.service.BanknoteService;
import org.springframework.beans.factory.annotation.Autowired;

public class BanknoteServiceImpl implements BanknoteService {

    @Autowired
    private BanknoteRepository banknoteRepository;

    @Override
    public void addBanknote(Banknote banknote) {
        banknoteRepository.save(banknote);
    }

    @Override
    public void deleteBanknote(Banknote banknote) {
        banknoteRepository.delete(banknote);
    }
}
