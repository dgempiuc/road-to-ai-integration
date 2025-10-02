package io.denizg.string.controller;

import io.denizg.string.service.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.path.string.base}")
public class StringController {
    
    private static final String REVERSE_PATH = "${api.path.string.reverse}";
    
    private final StringUtils stringUtils;
    
    public StringController(StringUtils stringUtils) {
        this.stringUtils = stringUtils;
    }
    
    @GetMapping(REVERSE_PATH)
    public String terstenYaz(@RequestParam String metin) {
        String result = stringUtils.terstenYaz(metin);
        return "Orijinal: " + metin + ", Ters: " + result;
    }
}