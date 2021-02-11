package uz.ssd.locationsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ssd.locationsender.domain.entity.asdum.Stolcha;
import uz.ssd.locationsender.domain.entity.locsender.Stol;
import uz.ssd.locationsender.repository.asdum.StolchaRepository;
import uz.ssd.locationsender.repository.locsender.StolRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bosh")
public class MyController {

    @Autowired
    StolRepository stolRepository;

    @Autowired
    StolchaRepository tableRepository;

    @GetMapping
    public HttpEntity<?> saveTable() {
        List<Stolcha> tableList = new ArrayList<>();
        tableList.add(new Stolcha("18"));
        tableList.add(new Stolcha("19"));
        tableList.add(new Stolcha("20"));
        tableList.add(new Stolcha("luks"));
        tableList.add(new Stolcha(":)"));
        try {
            tableRepository.saveAll(tableList);
        } catch (Exception e) {
            System.out.println("Table saqlashda Xatolik");
        }
        return ResponseEntity.ok(tableList);
    }

    @GetMapping("/455")
    public HttpEntity<?> saveStol() {
        List<Stol> stolList = new ArrayList<>();
        stolList.add(new Stol("18"));
        stolList.add(new Stol("19"));
        stolList.add(new Stol("20"));
        stolList.add(new Stol("luks"));
        stolList.add(new Stol(":)"));
        try {
            stolRepository.saveAll(stolList);
        } catch (Exception e) {
            System.out.println("Table saqlashda Xatolik");
        }
        return ResponseEntity.ok(stolList);
    }

    @GetMapping("/test")
    public HttpEntity<?> testing() {
        try {
            List<Stolcha> all = tableRepository.findAll();
            for (Stolcha table : all) {
                stolRepository.save(new Stol(table.getId(), table.getName()));
            }
        } catch (Exception e) {
            System.out.println("Error Testing Api");
        }
        return ResponseEntity.ok("ffff");
    }
}
