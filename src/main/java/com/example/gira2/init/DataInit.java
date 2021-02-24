package com.example.gira2.init;

import com.example.gira2.service.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    private final ClassificationService classificationService;

    public DataInit(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {

        initData();
    }

    public void initData() {
        this.classificationService.initClassifications();
    }
}
