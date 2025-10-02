package io.denizg.tarih.controller;

import io.denizg.tarih.service.TarihUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.path.tarih.base}")
public class TarihController {
    
    private static final String GUN_FARKI_PATH = "${api.path.tarih.gun-farki}";
    
    private final TarihUtils tarihUtils;
    
    public TarihController(TarihUtils tarihUtils) {
        this.tarihUtils = tarihUtils;
    }
    
    @GetMapping(GUN_FARKI_PATH)
    public String gunFarkiHesapla(@RequestParam String tarih1, @RequestParam String tarih2) {
        long gunFarki = tarihUtils.gunFarkiHesapla(tarih1, tarih2);
        return "Tarih 1: " + tarih1 + ", Tarih 2: " + tarih2 + " arasındaki gün farkı: " + gunFarki;
    }
}