package module6.backend.service.Impl;

import module6.backend.repository.IAccountRoleRepository;
import module6.backend.service.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements IAccountRoleService {
    @Autowired
    private IAccountRoleRepository accountRoleRepository;
}
