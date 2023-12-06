package module6.backend.repository;
import module6.backend.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

}
