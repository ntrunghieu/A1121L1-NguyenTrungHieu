package model.bean;

public class Product {
    private String tenSanPham;
    private int gia;
    private int soLuong;
    private String mau;
    private int loai;

    public Product() {
    }

    public Product(String tenSanPham, int gia, int soLuong, String mau, int loai) {
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mau = mau;
        this.loai = loai;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }
}
