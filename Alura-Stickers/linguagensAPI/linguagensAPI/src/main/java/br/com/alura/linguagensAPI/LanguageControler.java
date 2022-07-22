package br.com.alura.linguagensAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageControler {

    @Autowired
    private LanguageRepository repository;

    // os @ são mecanismos de notação, os meta dados
    
    // retornar as linguagens para o navegador

    @GetMapping("/languages")
    public List<Language> getLanguages(){
        List<Language> languages = repository.findAll();
        return languages;
    }
    @PostMapping("/languages")
    public Language createLanguage(@RequestBody Language language){
        Language saveLanguage = repository.save(language);
        return saveLanguage;
    }
}
