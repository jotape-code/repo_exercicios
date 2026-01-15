package Teste_1.Entities;

public class Product{
    protected String name;
    protected Double price;

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }

    public String priceTag(){
        StringBuilder st = new StringBuilder();
        st.append(name);
        st.append(" $ ");
        st.append(price);
        return st.toString();
    }
}