package boot.service;

public interface AccountService {

    void topUpAccount(Long accountId, String faceValue);

    void withdraw(Long accountId, Long amount);
}
