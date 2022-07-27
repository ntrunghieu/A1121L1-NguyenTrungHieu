package service.blog;

import entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import service.IGeneralService;

public interface IBlogService extends IGeneralService<Blog> {
//    Blog findById(int id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByCategory(int id, Pageable pageable);
    Page<Blog> search(String title,Pageable pageable);
}
