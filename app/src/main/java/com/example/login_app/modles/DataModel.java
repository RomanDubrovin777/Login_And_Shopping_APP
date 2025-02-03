package com.example.login_app.modles;

public class DataModel {
    private String ProductName;
    private int AmountOfProduct;
    private int image;

    private int id_;

    public  DataModel()
    {

    }
    public DataModel(String productName, int image, int amountOfProduct, int id_) {
        ProductName = productName;
        this.image = image;
        AmountOfProduct = amountOfProduct;
        this.id_= id_;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setAmountOfProduct(int amountOfProduct) {
        AmountOfProduct = amountOfProduct;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public String getProductName() {
        return ProductName;
    }

    public int getAmountOfProduct() {
        return AmountOfProduct;
    }



    public int getImage() {
        return image;
    }

}
