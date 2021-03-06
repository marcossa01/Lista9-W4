package com.marcossa.calculadoraimobiliaria.config;

import com.marcossa.calculadoraimobiliaria.domain.Casa;
import com.marcossa.calculadoraimobiliaria.domain.Comodo;
import com.marcossa.calculadoraimobiliaria.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private CasaService casaService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Teste");

        Casa casa1 = new Casa("Casa1", "QNP 28 CONJUNTO U CASA 12");
        casaService.salvarCasa(casa1);

        Casa casa2 = new Casa("Casa2", "QNP 32 CONJUNTO V CASA 18");
        casaService.salvarCasa(casa2);

        Casa casa3 = new Casa("Casa3", "SHPS 103 CONJUNTO B CASA 07");
        casaService.salvarCasa(casa3);

        Comodo comodo1 = new Comodo("Quarto", 10.5, 20.0);
        Comodo comodo2 = new Comodo("Cozinha", 10.5, 20.0);
        Comodo comodo3 = new Comodo("Sala", 10.5, 20.0);

        Comodo comodo4 = new Comodo("Banheiro", 5.0, 10.0);
        Comodo comodo5 = new Comodo("Quarto", 7.0, 10.5);
        Comodo comodo6 = new Comodo("Cozinha", 10.5, 15.0);

        Comodo comodo7 = new Comodo("Quarto", 10.0, 20.0);
        Comodo comodo8 = new Comodo("Cozinha", 10.5, 16.0);
        Comodo comodo9 = new Comodo("Sala", 15.5, 20.0);

        casa1.getComodos().addAll(Arrays.asList(comodo1, comodo2, comodo3));
        casa2.getComodos().addAll(Arrays.asList(comodo4, comodo5, comodo6));
        casa3.getComodos().addAll(Arrays.asList(comodo7, comodo8, comodo9));

    }
}
