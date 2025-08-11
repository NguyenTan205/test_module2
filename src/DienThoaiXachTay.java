public class DienThoaiXachTay extends SmartPhone{
    private String quocGiaXachTay;
    private String trangThai;

    public DienThoaiXachTay(int id, String name, double price, int quantity, String brand,  String quocGiaXachTay, String trangThai) {
        super(id, name, price, quantity, brand);
        this.quocGiaXachTay = quocGiaXachTay;
        this.trangThai = trangThai;
    }

    public String getQuocGiaXachTay() {
        return quocGiaXachTay;
    }

    public void setQuocGiaXachTay(String quocGiaXachTay) {
        this.quocGiaXachTay = quocGiaXachTay;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String info() {
        return ", quốc gia xách tay: " + quocGiaXachTay + "," + "trạng thái: " + trangThai;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + info();
    }
}
