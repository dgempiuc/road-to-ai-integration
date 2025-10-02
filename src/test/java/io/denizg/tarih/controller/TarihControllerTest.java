package io.denizg.tarih.controller;

import io.denizg.tarih.service.TarihUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TarihController.class)
public class TarihControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private TarihUtils tarihUtils;
    
    @Test
    public void testGunFarkiHesapla() throws Exception {
        when(tarihUtils.gunFarkiHesapla("01/01/2024", "15/01/2024")).thenReturn(14L);
        
        mockMvc.perform(get("/tarih/gun-farki")
                .param("tarih1", "01/01/2024")
                .param("tarih2", "15/01/2024"))
                .andExpect(status().isOk())
                .andExpect(content().string("Tarih 1: 01/01/2024, Tarih 2: 15/01/2024 arasındaki gün farkı: 14"));
    }
    
    @Test
    public void testGunFarkiHesapla_NegativeDifference() throws Exception {
        when(tarihUtils.gunFarkiHesapla("15/01/2024", "01/01/2024")).thenReturn(-14L);
        
        mockMvc.perform(get("/tarih/gun-farki")
                .param("tarih1", "15/01/2024")
                .param("tarih2", "01/01/2024"))
                .andExpect(status().isOk())
                .andExpect(content().string("Tarih 1: 15/01/2024, Tarih 2: 01/01/2024 arasındaki gün farkı: -14"));
    }
}