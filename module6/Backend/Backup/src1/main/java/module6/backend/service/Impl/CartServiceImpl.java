package module6.backend.service.Impl;

import module6.backend.repository.ICartRepository;
import module6.backend.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private ICartRepository cartRepository;
}
