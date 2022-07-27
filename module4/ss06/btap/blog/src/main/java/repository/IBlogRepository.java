package repository;

import entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAllByOrderById(Pageable pageable);
    Page<Blog> findAllByCategory_CategoryId(int id, Pageable pageable);
    Page<Blog> findAllByTitleContains(String title, Pageable pageable);
}
