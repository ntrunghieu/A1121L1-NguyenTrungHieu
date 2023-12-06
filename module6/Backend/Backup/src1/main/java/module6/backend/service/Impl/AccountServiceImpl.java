package module6.backend.service.Impl;
import module6.backend.repository.IAccountRepository;
import module6.backend.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
}
