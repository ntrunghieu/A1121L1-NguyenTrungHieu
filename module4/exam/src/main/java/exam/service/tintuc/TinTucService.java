package exam.service.tintuc;

import exam.entity.TinTuc;
import exam.repository.ITinTucRepository;
import exam.service.tintuc.impl.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TinTucService implements ITinTucService {

    private ITinTucRepository tinTucRepository;
    @Autowired
    public TinTucService(ITinTucRepository tinTucRepository) {
        this.tinTucRepository = tinTucRepository;
    }

    @Override
    public Iterable<TinTuc> findAll() {
        return tinTucRepository.findAll();
    }

    @Override
    public Optional<TinTuc> findById(Long id) {
        return tinTucRepository.findById(id);
    }

    @Override
    public TinTuc save(TinTuc tinTuc) {
        return tinTucRepository.save(tinTuc);
    }

    @Override
    public TinTuc findById1(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {
        tinTucRepository.deleteById(id);
    }

    @Override
    public Page<TinTuc> findAll(Pageable pageable) {
        return tinTucRepository.findAll(pageable);
    }

    @Override
    public Page<TinTuc> findAllByTieuDeContaining(String tieude, Pageable pageable) {
        return tinTucRepository.findAllByTieuDeContaining(tieude,pageable);
    }

    @Override
    public List<TinTuc> findAllAPI(Pageable pageable) {
        return tinTucRepository.findAll();
    }

//    @Override
//    public List<TinTuc> findAllByTieuDeContaining(String name, Pageable pageable) {
//        return tinTucRepository.findAllByTieuDeContaining(name,pageable);
//    }

    @Override
    public Page<TinTuc> search(String tieuDe, String noiDung, String danhMuc, Pageable pageable) {
        return tinTucRepository.findAllByTieuDeAndNoiDungAndDanhMuc(tieuDe,noiDung,danhMuc,pageable);
    }

    @Override
    public Page<TinTuc> timKiemTheoTenDanhMuc(Long id, Pageable pageable) {
        return tinTucRepository.findAllByDanhMucContaining(id,pageable);
    }

}
