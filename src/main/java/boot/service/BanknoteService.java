package boot.service;

import boot.entity.Banknote;

public interface BanknoteService {

    void addBanknote(Banknote banknote);

    void deleteBanknote(Banknote banknote);
}
