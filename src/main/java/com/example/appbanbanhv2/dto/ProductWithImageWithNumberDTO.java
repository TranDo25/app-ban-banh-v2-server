package com.example.appbanbanhv2.dto;

public class ProductWithImageWithNumberDTO {
    private ProductWithImageDTO productWithImageDTO = new ProductWithImageDTO();
    private int soLuongMuonMua;
    private boolean isCheck = false;
    private int cartId;
    public ProductWithImageWithNumberDTO(ProductWithImageDTO productWithImageDTO, int soLuongMuonMua) {
        this.productWithImageDTO = productWithImageDTO;
        this.soLuongMuonMua = soLuongMuonMua;
    }


    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public ProductWithImageWithNumberDTO() {
    }

    public ProductWithImageDTO getProductWithImageDTO() {
        return productWithImageDTO;
    }

    public void setProductWithImageDTO(ProductWithImageDTO productWithImageDTO) {
        this.productWithImageDTO = productWithImageDTO;
    }

    public int getSoLuongMuonMua() {
        return soLuongMuonMua;
    }

    public void setSoLuongMuonMua(int soLuongMuonMua) {
        this.soLuongMuonMua = soLuongMuonMua;
    }
}
