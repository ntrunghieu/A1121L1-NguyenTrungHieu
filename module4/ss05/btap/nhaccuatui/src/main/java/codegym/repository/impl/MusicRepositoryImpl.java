package codegym.repository.impl;

import codegym.entity.Music;
import org.springframework.stereotype.Repository;
import codegym.repository.MusicRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MusicRepositoryImpl implements MusicRepository {
    @PersistenceContext
    private static EntityManager entityManager;

    @Override
    public void save(Music music) {
        // khi list chua co gia tri nao
        entityManager.persist(music);
    }

    @Override
    public List<Music> list() {

//        String queryStr = "SELECT c FROM Music AS c";
//        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
//        return query.getResultList();
        String strQuery = "SELECT m FROM Music AS m";
        return entityManager.createQuery(strQuery,Music.class).getResultList();

//        List<Music> musicList = entityManager.createQuery(" select s from Music s ", Music.class).getResultList();
//        return musicList;

    }

    @Override
    public void update(Music music) {
         entityManager.merge(music);
    }

    @Override
    public void remove(Integer id) {
        Music music = findById(id);
        entityManager.remove(music);
    }

    @Override
    public Music findById(Integer id) {
        return entityManager.find(Music.class,id);
    }




}
