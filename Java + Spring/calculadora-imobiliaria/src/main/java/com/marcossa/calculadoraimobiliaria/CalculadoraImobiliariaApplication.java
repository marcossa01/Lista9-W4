package com.marcossa.calculadoraimobiliaria;

import com.marcossa.calculadoraimobiliaria.domain.Casa;
import com.marcossa.calculadoraimobiliaria.domain.Comodo;
import com.marcossa.calculadoraimobiliaria.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CalculadoraImobiliariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculadoraImobiliariaApplication.class, args);
    }

}
