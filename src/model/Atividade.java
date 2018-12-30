package model;

//Sessão de importação.
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Classe que define o modelo ~ Atividade.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 15/09/2017
 */
public class Atividade {
    private Integer codigo;
    private Projeto projeto;
    private Recurso funcionario;
    private Date inicio;
    private Date fim;
    private String atividade;
    private Integer status;
    private Integer horas;
    

    public Atividade() {

    }

    public Atividade(Projeto projeto, Recurso funcionario, Date inicio, Date fim, Integer status) {
        this.projeto = projeto;
        this.funcionario = funcionario;
        this.inicio = inicio;
        this.fim = fim;
        this.status = status;
    }

    Atividade(Integer codigo, Projeto projeto, Recurso funcionario, Date inicio, Date fim, String atividade, Integer status, Integer horas) {
        this.codigo = codigo;
        this.projeto = projeto;
        this.funcionario = funcionario;
        this.inicio = inicio;
        this.fim = fim;
        this.status = status;
        this.horas = horas;
        this.atividade = atividade;

    }

    public Integer getHoras() {
        return horas;
    }
    
    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Recurso getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Recurso funcionario) {
        this.funcionario = funcionario;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orçamento{" + "projeto=" + projeto + ", funcionario=" + funcionario
                + ", Data de início=" + inicio + ", Data do fim=" + fim + ", status=" + status.toString() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.projeto);
        hash = 59 * hash + Objects.hashCode(this.funcionario);
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
        final Atividade other = (Atividade) obj;
        if (!Objects.equals(this.projeto, other.projeto)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        return true;
    }

    public Object[] getValueAsObject() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return new String[]{this.projeto.getNome(), this.funcionario.getNome(), sdf.format(this.inicio), sdf.format(this.fim),
                            this.atividade, this.status.toString(), this.horas.toString()};
    }
    
    public Object[] getValueAsObjectPercent() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return new String[]{this.projeto.getNome(), sdf.format(this.inicio), sdf.format(this.fim),
                            this.atividade, this.status.toString(), this.horas.toString()};
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }
    
}//Fim da classe Atividade.
