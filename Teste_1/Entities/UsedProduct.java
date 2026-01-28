package Teste_1.Entities;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
    public LocalDate manufactured;

    public UsedProduct(String name, Double price, LocalDate manufactured){
        super(name, price);
        this.manufactured = manufactured;
    }
    public LocalDate getManufactured(){
        return manufactured;
    }
    public void setManufactured(LocalDate manufactured){
        this.manufactured = manufactured;
    }
    @Override
    public String priceTag(){
        StringBuilder st = new StringBuilder();
        st.append(name + " (used) $ ");
        st.append(price);
        st.append(" (Manufactured date:  ");
        st.append(String.format("%s)", manufactured.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        return st.toString();
    }

}
