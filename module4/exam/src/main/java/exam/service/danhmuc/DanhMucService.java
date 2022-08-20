package exam.service.danhmuc;

import exam.entity.DanhMuc;
import exam.repository.IDanhMucRepository;
import exam.service.danhmuc.impl.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DanhMucService implements IDanhMucService {
    private IDanhMucRepository iDanhMucRepository;

    @Autowired
    public DanhMucService(IDanhMucRepository iDanhMucRepository) {
        this.iDanhMucRepository = iDanhMucRepository;
    }

    @Override
    public Page<DanhMuc> findAll( Pageable pageable) {
        return iDanhMucRepository.findAll(pageable);
    }

    @Override
    public Iterable<DanhMuc> findAll() {
        return iDanhMucRepository.findAll();
    }

    @Override
    public Optional<DanhMuc> findById(Long id) {
        return iDanhMucRepository.findById(id);
    }

    @Override
    public Page<DanhMuc> findAllByTenDanhMucContaining(String name, Pageable pageable) {
        return iDanhMucRepository.findAllByTenDanhMucContaining(name,pageable);
    }
}
