package module6.backend.service.Impl;

import module6.backend.repository.IRoleRepository;
import module6.backend.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
}
