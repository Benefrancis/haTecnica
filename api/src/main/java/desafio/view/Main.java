package desafio.view;

import desafio.repository.ClienteCollectionRepository;
import desafio.repository.EquipamentoCollectionRepository;
import desafio.repository.ServicoCollectionRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Collection> repos = Arrays.asList(

//                ServicoCollectionRepository.findAll(),
//                EquipamentoCollectionRepository.findAll(),
                ClienteCollectionRepository.findAll());

        repos.forEach(
                r -> r.forEach(System.out::println)
        );
    }
}