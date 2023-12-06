package module6.backend.service.Impl;

import module6.backend.repository.IImportRepository;
import module6.backend.service.IImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportServiceImpl implements IImportService {
    @Autowired
    private IImportRepository importRepository;
}
