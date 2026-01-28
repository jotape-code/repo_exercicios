package exercicio_2.entities;

public class PessoaFisica extends Pessoa{
    private Double saude;

    public PessoaFisica(String name, Double renda, Double saude){
        super(name, renda);
        this.saude = saude;
    }
    public Double getSaude(){
        return saude;
    }
    public void setSaude(Double saude){
        this.saude = saude;
    }
    public Double imposto(){
        Double imposto = 0.0;
        if(renda < 20000.00){
            imposto = 0.15 * renda;
        }
        else{
            imposto = 0.25 * renda;
        }
        if (saude > 0){
                imposto -= 0.5 * saude;
        }   
        
        return imposto;
   }
}
