package service.blog;

import entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.IBlogRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }


    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

//    @Override
//    public Blog findById(Long id) {
//        return blogRepository.findById(id).orElse(null);
//    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

//    @Override
//    public boolean insertWithStoredProcedure(Blog blog) {
//        return false;
//    }

//    @Override
//    public void update(Blog blog) {
//
//    }
//
//
//    @Override
//    public Blog findById(int id) {
//        return null;
//    }

    @Override
    public Page<Blog> findAllByCategory(int id, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Blog> search(String title, Pageable pageable) {
        return null;
    }
}
