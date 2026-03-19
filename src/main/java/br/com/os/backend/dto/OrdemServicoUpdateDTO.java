package br.com.os.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class OrdemServicoUpdateDTO {
    public String numeroOS;
    public BigDecimal valor;
    public BigDecimal custo;
    public Long servicoId;
    public String observacao;
    public String situacao;


}
