package model;

//Sessão de importação.
import java.util.Objects;

/**
 * Classe que define o modelo ~ Projeto.
 * @author Vinicius Tavano Ferreira.
 * @since Classe criada em 07/09/2017.
 */
public class Projeto {

    private Integer codigo;
    private String nome;
    private String etapa;

    public Projeto() {

    }

    public Projeto(Integer codigo, String nome, String etapa) {
        this.codigo = codigo;
        this.nome = nome;
        this.etapa = etapa;
    }

    Projeto(String projeto) {
        this.nome = projeto;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
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
        final Projeto other = (Projeto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Projeto{" + "codigo=" + codigo + ", nome=" + nome
                + ", etapa=" + etapa + '}';
    }

    public Object[] getValueAsObject() {
        return new String[]{this.codigo.toString(), this.nome, this.etapa};
    }
    
}//Fim da classe
