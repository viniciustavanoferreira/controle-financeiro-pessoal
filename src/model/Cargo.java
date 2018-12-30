package model;

//Sessão de importação.
import java.util.Objects;

/**
 * Classe que define o modelo ~ Cargo.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 14/09/2017
 */
public class Cargo {

    private Integer codigo;
    private String nome;

    public Cargo(String tipo) {
        this.nome = tipo;
    }

    public Cargo(Integer codigo, String tipo) {
        this.codigo = codigo;
        this.nome = tipo;
    }

    public Cargo() {

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

    public Object[] getValueAsObject() {
        return new String[]{this.nome};
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nome);
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
        final Cargo other = (Cargo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}
