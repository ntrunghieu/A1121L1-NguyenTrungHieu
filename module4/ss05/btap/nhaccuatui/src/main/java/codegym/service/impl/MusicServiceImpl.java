package codegym.service.impl;

import codegym.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import codegym.repository.MusicRepository;
import codegym.repository.impl.MusicRepositoryImpl;
import codegym.service.MusicService;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepository getMusicRepository = new MusicRepositoryImpl();

    @Override
    public void save(Music music) {
        getMusicRepository.save(music);
    }

    @Override
    public List<Music> list() {
        return getMusicRepository.list();
    }

    @Override
    public void update(Music music) {
         getMusicRepository.update(music);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Music findById(Integer id) {
        return getMusicRepository.findById(id);
    }


}
