package boot.service;

import java.util.HashMap;

public interface AtmService {

    String FIVE100 = "500";
    String TWO100 = "200";
    String ONE100 = "100";

    Long LIMIT = 40L;

    void depositCashToAtm(String inputBanknote, Long quantity);

    void withdrawCashFromAtm(String inputBanknote, Long quantity);

    HashMap<String, Long> getBanknoteQuantities();
}
