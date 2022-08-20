package exam2.service;

import exam2.entity.KhuyenMai;
import exam2.repository.IKhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class KhuyenMaiService implements IKhuyenMaiService{
    private IKhuyenMaiRepository iKhuyenMaiRepository;
    @Autowired
    public KhuyenMaiService(IKhuyenMaiRepository iKhuyenMaiRepository) {
        this.iKhuyenMaiRepository = iKhuyenMaiRepository;
    }

    @Override
    public Iterable<KhuyenMai> findAll() {
        return iKhuyenMaiRepository.findAll();
    }

    @Override
    public Optional<KhuyenMai> findById(Long id) {
        return iKhuyenMaiRepository.findById(id);
    }

    @Override
    public void save(KhuyenMai khuyenMai) {
        iKhuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public KhuyenMai findById1(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {
        iKhuyenMaiRepository.deleteById(id);

    }

    @Override
    public Page<KhuyenMai> findAll(Pageable pageable) {
        return iKhuyenMaiRepository.findAll(pageable);
    }

    @Override
    public Page<KhuyenMai> findAllByTieuDeContaining(String tieude, Pageable pageable) {
        return iKhuyenMaiRepository.findAllByTieuDeContaining(tieude,pageable);
    }

    @Override
    public Page<KhuyenMai> findAllByMucGiamGiaAndBatDauAndKetThucContaining(Integer mucgiam, Date batdau, Date ketthuc, Pageable pageable) {
        return iKhuyenMaiRepository.findAllByMucGiamGiaAndBatDauAndKetThucContaining(mucgiam, batdau, ketthuc, pageable);
    }

    @Override
    public Page<KhuyenMai> findAllByMucGiamGiaContaining(String mucgiam, Pageable pageable) {
        return iKhuyenMaiRepository.findAllByMucGiamGiaContaining(mucgiam,pageable);
    }

    @Override
    public Page<KhuyenMai> findAllByBatDauContaining(Date batdau, Pageable pageable) {
        return iKhuyenMaiRepository.findAllByBatDauContaining(batdau,pageable);
    }

    @Override
    public Page<KhuyenMai> findAllByKetThucContaining(Date ketthuc, Pageable pageable) {
        return iKhuyenMaiRepository.findAllByKetThucContaining(ketthuc, pageable);
    }
}
