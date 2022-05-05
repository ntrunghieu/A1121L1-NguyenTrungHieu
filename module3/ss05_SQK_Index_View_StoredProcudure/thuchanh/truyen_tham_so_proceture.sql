-- Tham số loại IN
DELIMITER //
drop procedure if exists `get_cus_by_id`//
create procedure get_cus_by_id(in cus_num int(11))
begin
	SELECT * FROM customers WHERE customerNumber = cus_num;
end //

call get_cus_by_id(175);

-- Tham số loại OUT
// DELIMITER ;

CREATE PROCEDURE GetCustomersCountByCity(

	IN  in_city VARCHAR(50),

    OUT total INT

)

BEGIN

    SELECT COUNT(customerNumber)

    INTO total

    FROM customers

    WHERE city = in_city

END//

DELIMITER ;

CALL GetCustomersCountByCity('Lyon',@total);

SELECT @total;

-- Tham số loại INOUT

DELIMITER //
create procedure set_counter(

	inout counter int,
    
    in inc int
    
)
begin
	
    set counter = counter + inc;

end //
delimiter ;

set @counter = 1; 
call set_counter(@counter , 1);
CALL set_counter(@counter,1); -- 3

CALL set_counter(@counter,5); -- 8

select @counter;

