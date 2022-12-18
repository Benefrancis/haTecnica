package desafio.domain.cliente.dto;

import jakarta.validation.constraints.NotBlank;

public record PostTelefone(
        @NotBlank
        String ddi,
        @NotBlank
        String ddd,
        @NotBlank
        String numero
) {

        public PostTelefone(@NotBlank
                            String ddi, @NotBlank
                            String ddd, @NotBlank
                            String numero) {
                this.ddi = ddi;
                this.ddd = ddd;
                this.numero = numero;
        }
}
