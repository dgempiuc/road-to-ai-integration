package io.denizg.dosya.controller;

import io.denizg.dosya.service.DosyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dosya")
public class DosyaController {

    private final DosyaService dosyaService;

    public DosyaController(DosyaService dosyaService) {
        this.dosyaService = dosyaService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAll() {
        return ResponseEntity.ok(dosyaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable String id) {
        String result = dosyaService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody String data) {
        String result = dosyaService.create(data);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody String data) {
        String result = dosyaService.update(id, data);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        dosyaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
