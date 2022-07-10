package codegym.repository;

import codegym.entity.Music;

import java.util.List;

public interface MusicRepository {
    void save(Music music);
    List<Music> list();
    void update(Music music);
    void remove(Integer id);
    Music findById(Integer id);


}
