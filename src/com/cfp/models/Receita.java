package com.cfp.models;

//Sessão de importação.
import java.util.Objects;

/**
 * Classe que define o modelo ~ Receita.
 * @author Vinicius Tavano Ferreira.
 * @since Classe criada em 07/09/2018.
 */
public class Receita {

    private Integer intCodigo;
    private String strDescricao;
    private String strAtivo;

    public Receita() {

    }

    public Receita(Integer codigo, String descricao, String ativo) {
        this.intCodigo = codigo;
        this.strDescricao = descricao;
        this.strAtivo = ativo;
    }

    Receita(String projeto) {
        this.strDescricao = projeto;
    }
    
    public Integer getIntCodigo() {
        return intCodigo;
    }

    public void setIntCodigo(Integer intCodigo) {
        this.intCodigo = intCodigo;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

    public String getStrAtivo() {
        return strAtivo;
    }

    public void setStrAtivo(String strAtivo) {
        this.strAtivo = strAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.strDescricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Receita other = (Receita) obj;
        if (!Objects.equals(this.strDescricao, other.strDescricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Receita{" + "codigo=" + intCodigo + ", descricao=" + strDescricao
                + ", ativo=" + strAtivo + '}';
    }

    public Object[] getValueAsObject() {
        return new String[]{this.intCodigo.toString(), this.strDescricao, this.strAtivo};
    }
    
}//Fim da classe
