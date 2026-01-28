package exercicio_2.entities;

public class PessoaJuridica extends Pessoa {
    private Integer funcionarios;

    public PessoaJuridica(String name, Double renda, Integer funcionarios){
        super(name, renda);
        this.funcionarios = funcionarios;
    }
    public Integer getFuncionarios(){
        return funcionarios;
    }
    public void setFuncionarios(Integer funcionarios){
        this.funcionarios = funcionarios;
    }
    public Double imposto(){
        if(funcionarios < 10){
            return renda * 0.16;
        }
        else{
            return renda * 0.14;
        }
    }
}
