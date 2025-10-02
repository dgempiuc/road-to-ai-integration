package io.denizg.string.service;

import org.springframework.stereotype.Service;

@Service
public class StringUtils {
    
    public String terstenYaz(String metin) {
        if (metin == null || metin.isEmpty()) {
            return metin;
        }
        
        StringBuilder sb = new StringBuilder(metin);
        return sb.reverse().toString();
    }
}