package module6.backend.service.Impl;

import module6.backend.entity.account.Role;
import module6.backend.entity.employee.Position;
import module6.backend.repository.IPositionRepository;
import module6.backend.repository.IRoleRepository;
import module6.backend.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findRoleByRoleName(String name) {
        return roleRepository.findRoleByRoleName(name);
    }

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }
}
