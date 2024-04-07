package com.projeto.ada.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Produto {
    private Long idProduto;
    private String nomeProduto;
    private Integer quantidadeProduto;
    private String categoriaProduto;
    private BigDecimal precoProduto;
}
