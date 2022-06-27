package service;

import org.springframework.stereotype.Service;

@Service
public interface IDictionaryService {
    String translate(String search);
}
