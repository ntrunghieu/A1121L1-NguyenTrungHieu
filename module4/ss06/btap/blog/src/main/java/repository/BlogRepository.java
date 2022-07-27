package repository;

import entity.Blog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

//@Repository
//@Transactional
//public class BlogRepository implements IBlogRepository{
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public List<Blog> findAll() {
//        TypedQuery<Blog> query = em.createQuery("SELECT c FROM Blog c", Blog.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public Blog findById(Long id) {
//        TypedQuery<Blog> query=em.createQuery("select c FROM Blog c where c.id=:id", Blog.class);
//        query.setParameter("id", id);
//        try {
//            return query.getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
//    }
//
//    @Override
//    public void save(Blog blog) {
//        if (blog.getId() != null) {
//            em.merge(blog);
//        } else {
//            em.persist(blog);
//        }
//    }
//
//    @Override
//    public void remove(Long id) {
//
//    }
//
//    @Override
//    public boolean insertWithStoredProcedure(Blog blog) {
//        return false;
//    }
//
//    @Modifying
//    @Override
//    public void update( Blog blog) {
////        String hql = "UPDATE Blog c set c.title = :title , c.img = :img, c.description = :des, c.content = :content  "  +
////                "WHERE c.id = :blog_id ";
////        TypedQuery<Blog> query = em.createQuery(hql,Blog.class);
////        query.setParameter("title", blog.getTitle());
////        query.setParameter("img", blog.getImg());
////        query.setParameter("des", blog.getDescription());
////        query.setParameter("content", blog.getContent());
////        query.setParameter("blog_id", blog.getId());
////        query.getSingleResult();
////
////
////        Query createQuery(hql)
////    TypedQuery<Blog> createQuery(hql, Blog.class)
//
//        em.merge(blog);
//
//    }
//}
