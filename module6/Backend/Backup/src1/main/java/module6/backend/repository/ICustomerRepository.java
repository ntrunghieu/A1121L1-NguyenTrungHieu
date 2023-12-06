package module6.backend.repository;

import module6.backend.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select * from customer where customer_type_id  > 0 and customer_flag = 0", nativeQuery = true)
    List<Customer> getAllCustomer();

    @Query(value = "SELECT * from customer  left join customer_type on customer_type.customer_type_id = customer.customer_id where customer.customer_flag = 0 group by customer.customer_id limit ?1,5", nativeQuery = true)
    List<Customer> getAllCustomerWithPagination(int index);


    @Query(value = "UPDATE customer SET customer_flag = 1 , customer_id = ?1  WHERE (customer_id = ?2)", nativeQuery = true)
    @Transactional
    @Modifying
    void deleteCustomerById(Long id1, Long id2);

    @Query(value = "select * from customer where customer_name like %:name% and customer_phone like %:phone% and customer_type_id  > 0 and customer_flag = 0", nativeQuery = true)
    List<Customer> searchCustomerByNameAndPhone(@Param("name") String name, @Param("phone") String phone);

    @Query(value = "select * from customer where customer_id = ?1 and customer_type_id > 0 and customer_flag = 0 ", nativeQuery = true)
    Optional<Customer> findCustomerById(Long id);


    @Query(value = "UPDATE customer set customer_name =?1, customer_code=?2, customer_avatar=?3, customer_address=?4, customer_phone=?5, customer_email=?6,customer_type_id=?7 WHERE customer_id=?8", nativeQuery = true)
    @Modifying
    void updateCustomer(String name, String code, String avatar, String address, String phone, String email, Long typeId, Long id);

    @Modifying
    @Query(value = "insert into customer (customer_name, customer_code, customer_avatar, customer_address, customer_phone, customer_email, customer_type_id) values (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void createCustomer(String name, String code, String avt, String address, String phone, String email, Long customerType);
}
