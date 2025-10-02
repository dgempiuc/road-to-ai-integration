package io.denizg.tarih.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class TarihUtils {
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public long gunFarkiHesapla(String tarih1, String tarih2) {
        if (tarih1 == null || tarih2 == null) {
            throw new IllegalArgumentException("Tarih değerleri null olamaz");
        }

        try {
            LocalDate date1 = LocalDate.parse(tarih1, FORMATTER);
            LocalDate date2 = LocalDate.parse(tarih2, FORMATTER);
            return ChronoUnit.DAYS.between(date1, date2);
        } catch (Exception e) {
            throw new IllegalArgumentException("Geçersiz tarih formatı. Format: dd/MM/yyyy", e);
        }
    }
}