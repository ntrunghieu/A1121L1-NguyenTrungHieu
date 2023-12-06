package module6.backend.repository;

import module6.backend.entity.Import;
import module6.backend.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    // HuyenNTD - Thong ke khach hang tiem nang

    @Query(value = "select `customer`.customer_code , `customer`.customer_name , count(`cart`.cart_customer_id), sum(`cart`.cart_total_money) from `customer` join `cart` on `cart`.cart_customer_id = `customer`.customer_id group by `cart`.cart_customer_id", nativeQuery = true)
    Page<String> findAllCustomer(Pageable pageable);

    @Query(value = "select customer_code , customer_name , count(cart_customer_id), sum(cart_total_money) from customer\n" +
            "join cart on cart.cart_customer_id = customer.customer_id\n" +
            "group by cart_customer_id", nativeQuery = true)
    String[] findAllPotentialCustomer();

    @Query(value = "SELECT * FROM CUSTOMER WHERE customer_code = :code", nativeQuery = true)
    Customer getCustomerByCode(@Param("code") String codeCustomer);

    @Query(value = "SELECT * FROM CUSTOMER WHERE customer_email = :email", nativeQuery = true)
    Customer getCustomerByEmail(@Param("email") String email);

    @Query(value = "SELECT customer_email FROM customer ", nativeQuery = true)
    String[] getAllEmail();

    @Query(value = "SELECT customer_phone FROM customer ", nativeQuery = true)
    String[] getAllPhone();

    // Thắng code tìm kiếm Nhà cung cấp theo customer code
    Customer findByCustomerCode(String codeCustomer);

    // Thắng code thêm mới Nhà cung cấp (Import)
    @Query(value = "INSERT INTO `customer` (`customer_name`, `customer_code`, `customer_address`, `customer_phone`, `customer_email`, `customer_type_id`, `customer_avatar`) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7);", nativeQuery = true)
    @Transactional
    @Modifying
    void createCustomerImport(String name, String code, String address, String phone, String email, Long customerTypeId, String customerAvatar);

    // Thắng code tìm kiếm nhà cung cấp
    @Query(value = "SELECT * FROM customer where customer_type_id = 3 and customer_id > 0;", nativeQuery = true)
    List<Customer> findAllCustomerImport();

    // Thắng code tìm kiếm kiểm tra code customer có tồn tại không
    @Query(value = "SELECT customer_code FROM customer;", nativeQuery = true)
    List<String> findAllCustomerImportString();

    // Thắng code tìm kiếm kiểm tra phone customer có tồn tại không
    @Query(value = "SELECT customer_phone FROM customer;", nativeQuery = true)
    List<String> findAllCustomerPhoneImportString();

    // Thắng code tìm kiếm kiểm tra email customer có tồn tại không
    @Query(value = "SELECT customer_email FROM customer;", nativeQuery = true)
    List<String> findAllCustomerEmailImportString();



    @Query(value = "select * from customer where customer_type_id  > 0 and customer_flag = 0", nativeQuery = true)
    List<Customer> getAllCustomer();

    @Query(value = "SELECT * from customer  left join customer_type on customer_type.customer_type_id = customer.customer_id where customer.customer_flag = 0 group by customer.customer_id limit ?1,5", nativeQuery = true)
    List<Customer> getAllCustomerWithPagination(int index);

    @Query(value = "select * from customer where customer_type_id  > 0 and customer_flag = 0", nativeQuery = true)
    Page<Customer> findAllICustomer1(Pageable pageable);



    //    HieuNT xoa khach hang bang id
    @Query(value = "UPDATE customer SET customer_flag = 1 , customer_id = ?1  WHERE (customer_id = ?2)", nativeQuery = true)
    @Transactional
    @Modifying
//    @Query(value = "UPDATE customer SET customer_flag=1, customer_id = ?1 WHERE customer_id = ?2", nativeQuery = true)
    void deleteCustomerById(Long id1, Long id2);

//    HieuNT tim tim khach hang theo ten va so dien thoai
    @Query(value = "select * from customer where customer_name like %:name% and customer_phone like %:phone% and customer_type_id  > 0 and customer_flag = 0", nativeQuery = true)
    List<Customer> searchCustomerByNameAndPhone(@Param("name") String name, @Param("phone") String phone);

    @Query(value = "select * from customer where customer_name like %:name% and customer_phone like %:phone% and customer_type_id  > 0 and customer_flag = 0", nativeQuery = true)
    Page<Customer> searchCustomer(@Param("name") String name, @Param("phone") String phone, Pageable pageable);

    @Query(value = "select * from customer where customer_name like %:name%  and customer_type_id  > 0 and customer_flag = 0", nativeQuery = true)
    Page<Customer> searchCustomerName(@Param("name") String name, Pageable pageable);

//    HieuNT tim khach hang theo id xem khach hang co ton tai hay khong?
    @Query(value = "select * from customer where customer_id = ?1 and customer_type_id > 0 and customer_flag = 0 ", nativeQuery = true)
    Optional<Customer> findCustomerById(Long id);


    @Query(value = "UPDATE customer set customer_name =?1, customer_code=?2, customer_avatar=?3, customer_address=?4, customer_phone=?5, customer_email=?6,customer_type_id=?7 WHERE customer_id=?8", nativeQuery = true)
    @Modifying
    void updateCustomer(String name, String code, String avatar, String address, String phone, String email, Long typeId, Long id);

    @Modifying
    @Query(value = "insert into customer (customer_name, customer_code, customer_avatar, customer_address, customer_phone, customer_email, customer_type_id) values (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void createCustomer(String name, String code, String avt, String address, String phone, String email, Long customerType);

    @Query(value = "select customer_code, customer_name, count(cart_customer_id) as SLDonHang, sum(cart_total_money) as TongGiaTri from customer\n" +
            "join cart on cart.cart_customer_id = customer.customer_id\n" +
            "join cart_status on cart_status.cart_status_id = cart.cart_status_id\n" +
            "where (month(cart_date_create) between :fromMonth and :toMonth) and year(cart_date_create) = :year and cart_status_name = 'đã thanh toán'\n" +
            "group by cart_customer_id", nativeQuery = true)
    String[] findForPotentialCustomers(@Param("fromMonth") String fromMonth,
                                       @Param("toMonth") String toMonth,
                                       @Param("year") String year);
}


//@Query(value = "select customer_code, customer_name, count(cart_customer_id) as SLDonHang, sum(cart_total_money) as TongGiaTri from customer\n" +
//        "join cart on cart.cart_customer_id = customer.customer_id \n" +
//        "join cart_status on cart_status.cart_status_id = cart.cart_status_id\n" +
//        "group by cart_customer_id", nativeQuery = true)
