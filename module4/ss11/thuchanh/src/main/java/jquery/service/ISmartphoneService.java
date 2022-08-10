package jquery.service;

import jquery.entity.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    Smartphone findById1(Long id);


    void remove(Long id);
}
