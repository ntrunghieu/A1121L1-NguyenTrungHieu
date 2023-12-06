package module6.backend.repository;

import module6.backend.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Long> {
    @Query(value = "select * from `position` where position_flag = 0 ", nativeQuery = true)
    List<Position> findAllPosition();

    //NhiVP code lay danh sach chuc vu tru quan ly
    @Query(value = "select * from position where position_id <> 1 and position_flag = 0", nativeQuery = true)
    List<Position> findPositionNotManager();
}
