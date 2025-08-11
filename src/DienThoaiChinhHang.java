public class DienThoaiChinhHang extends SmartPhone {
    private String thoiGianBaoHanh;
    private String phamViBaoHanh;

    public DienThoaiChinhHang(int id, String name, double price, int quantity, String brand, String thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, name, price, quantity, brand);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String info() {
        return ",thời gian bảo hành: " + thoiGianBaoHanh + "," + "Phạm vi bảo hành: " + phamViBaoHanh;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + info();
    }
}
