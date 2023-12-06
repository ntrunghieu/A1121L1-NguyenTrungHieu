package module6.backend.repository;

import module6.backend.entity.account.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRoleRepository extends JpaRepository<AccountRole, Long> {
}
