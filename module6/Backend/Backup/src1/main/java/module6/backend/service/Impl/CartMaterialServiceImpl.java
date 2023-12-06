package module6.backend.service.Impl;

import module6.backend.repository.ICartMaterialRepository;
import module6.backend.service.ICartMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartMaterialServiceImpl implements ICartMaterialService {
    @Autowired
    private ICartMaterialRepository cartMaterialRepository;
}
