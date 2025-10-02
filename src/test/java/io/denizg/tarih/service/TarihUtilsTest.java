package io.denizg.tarih.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TarihUtilsTest {
    
    private final TarihUtils tarihUtils = new TarihUtils();
    
    @Test
    public void testGunFarkiHesapla_PositiveDifference() {
        long sonuc = tarihUtils.gunFarkiHesapla("01/01/2024", "15/01/2024");
        assertEquals(14, sonuc);
    }
    
    @Test
    public void testGunFarkiHesapla_NegativeDifference() {
        long tersYon = tarihUtils.gunFarkiHesapla("15/01/2024", "01/01/2024");
        assertEquals(-14, tersYon);
    }
    
    @Test
    public void testGunFarkiHesapla_SameDate() {
        long ayniTarih = tarihUtils.gunFarkiHesapla("01/01/2024", "01/01/2024");
        assertEquals(0, ayniTarih);
    }
    
    @Test
    public void testGunFarkiHesapla_AcrossYear() {
        long yilAsi = tarihUtils.gunFarkiHesapla("31/12/2023", "01/01/2024");
        assertEquals(1, yilAsi);
    }
    
    @Test
    public void testGunFarkiHesapla_LargeTimeDifference() {
        long buyukFark = tarihUtils.gunFarkiHesapla("01/01/2024", "01/01/2025");
        assertEquals(366, buyukFark); // 2024 artık yıl
    }
}