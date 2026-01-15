package Teste_1.Entities;

public class ImportedProduct extends Product{
    private Double customFee;

    public ImportedProduct(String name, Double price, Double customFee){
        super(name, price);
        this.customFee = customFee;
    }
    public Double getCustomFee(){
        return customFee;
    }
    public void setCustomFee(Double customFee){
        this.customFee = customFee;
    }
    @Override
    public String priceTag(){
        StringBuilder st = new StringBuilder();
        st.append(name + " $ ");
        st.append(price + customFee);
        st.append(" (Custom Fee: $ ");
        st.append(String.format("%.2f)", price));
        return st.toString();
    }

}