package br.com.fiap.shift.desafio;

import br.com.fiap.shift.desafio.repository.ClienteCollectionRepository;
import br.com.fiap.shift.desafio.repository.EquipamentoCollectionRepository;
import br.com.fiap.shift.desafio.repository.ServicoCollectionRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Collection> repos = Arrays.asList(ServicoCollectionRepository.findAll(), EquipamentoCollectionRepository.findAll(), ClienteCollectionRepository.findAll());

        repos.forEach(


                r -> r.forEach(System.out::println)

        );


    }
}