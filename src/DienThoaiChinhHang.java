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
        try {
            int ngay = Integer.parseInt(thoiGianBaoHanh);
            if (ngay <= 0) {
                throw new IllegalArgumentException("Thời gian bảo hành phải là số dương!");
            }
            if (ngay > 730) {
                throw new IllegalArgumentException("Thời gian bảo hành không được quá 730 ngày!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Thời gian bảo hành phải là số nguyên!");
        }
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        String lower = phamViBaoHanh.trim().toLowerCase();
        if (!lower.equals("toan quoc") && !lower.equals("quoc te")) {
            throw new IllegalArgumentException("Phạm vi bảo hành chỉ được là 'toan quoc' hoặc 'quoc te'!");
        }
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
