package module6.backend.service.Impl;

import module6.backend.repository.ICartStatusRepository;
import module6.backend.service.ICartStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartStatusServiceImpl implements ICartStatusService {
    @Autowired
    private ICartStatusRepository cartStatusRepository;


}
