package desafio.model.cliente.dto;

import desafio.model.cliente.CEP;
import jakarta.validation.constraints.NotBlank;

public record PutCEP(

        Long id,
        @NotBlank
        String cep


) {

    public PutCEP(CEP cep) {
        this(cep.getId(), cep.getCep());
    }
}
