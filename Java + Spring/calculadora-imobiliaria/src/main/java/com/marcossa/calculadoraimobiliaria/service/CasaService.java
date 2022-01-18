package com.marcossa.calculadoraimobiliaria.service;

import com.marcossa.calculadoraimobiliaria.domain.Casa;
import com.marcossa.calculadoraimobiliaria.domain.Comodo;
import com.marcossa.calculadoraimobiliaria.domain.dto.CasaDto;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CasaService {

    List<Casa> casas = new ArrayList<>();

    public List<CasaDto> findAll() {
        List<CasaDto> list = casas.stream().map(x -> new CasaDto(x.getNome(), x.getEndereco())).collect(Collectors.toList());
        return list;
    }

    public Casa findByNome(String nome) {
        Optional<Casa> casa = casas.stream().filter(x -> x.getNome().equals(nome)).findFirst();
        return casa.orElse(null);
    }

    public String getAreaCasa(String nome) {
        Casa casa = findByNome(nome);
        Double area = 0.0;
        for (Comodo c : casa.getComodos()) {
            area += c.getLargura() * c.getComprimento();
        }
        return "A área total da casa é de: " + area + " metros.";
    }

    public String getValorCasa(String nome, Integer valorMetro) {
        Casa casa = findByNome(nome);
        Double area = 0.0;
        Double valorCasa;
        for (Comodo c : casa.getComodos()){
            area += c.getLargura() * c.getComprimento();
        }
        valorCasa = area * valorMetro;
        return "O valor da casa é: " + NumberFormat.getCurrencyInstance().format(valorCasa);
    }

    public String getMaiorComodo(String nome) {
        Casa casa = findByNome(nome);
        Double maiorComodo = 0.0;
        Double comodo;
        String nomeCasa = null;
        for (Comodo c : casa.getComodos()) {
            comodo = c.getLargura() * c.getComprimento();
            if(comodo > maiorComodo) {
                maiorComodo = comodo;
                nomeCasa = c.getNome();
            }
        }
        return "O maior comodo da casa: " + nomeCasa + " com " + maiorComodo + " metros quadrados.";
    }

    public String areaComodos(String nome) {
        StringBuilder areaComodos = new StringBuilder();
        Casa casa = findByNome(nome);
        for ( Comodo c : casa.getComodos() ) {
            areaComodos.append("Comodo: ").append(c.getNome()).append(" possui ").append(c.areaComodo()).append(" metros quadrados. \n");
        }
        return "A area de cada comodo da casa " + nome + " é : \n" + areaComodos;
    }

    public void salvarCasa(Casa casa) {
        casas.add(casa);
    }
}