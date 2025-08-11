import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmartPhoneManager manager = new SmartPhoneManager("mobiles.csv");
        int choice = -1;

        do {
            System.out.println("======CHƯƠNG TRÌNH QUẢN LÍ ĐIỆN THOẠI======");
            System.out.println("1. Thêm mới điện thoại chính hãng");
            System.out.println("2. Thêm mới điện thoại xách tay");
            System.out.println("3. Xoá");
            System.out.println("4. Hiển thị toàn bộ danh sách điện thoại");
            System.out.println("5. TÌm kiếm điện thoại");
            System.out.println("0. Thoát chương trình");
            System.out.println("Chọn chức năng: ");

            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Bạn chưa nhập gì. Vui lòng nhập chức năng");
                continue;
            }
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println("Lựa chọn không hợp lệ" + e.getMessage());
                continue;
            }
            switch (choice) {
                case 1:
                    themChinhHang(manager, sc);
                    break;
                case 2:
                    themXachTay(manager, sc);
                    break;
                case 3:
                    System.out.print("Nhập ID cần xóa: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    System.out.print("Bạn có chắc chắn muốn xóa điện thoại này? (Y/N): ");
                    String confirm = sc.nextLine().trim().toLowerCase();
                    if (confirm.equals("y")) {
                        manager.deleteById(deleteId);
                    } else {
                        System.out.println("Hủy thao tác xóa.");
                    }
                    break;
                case 4:
                    manager.displayAllSmartPhones();
                    break;
                case 5:
                    System.out.print("Nhập từ khóa ID cần tìm: ");
                    String keyword = sc.nextLine();
                    manager.searchPhoneByIdKeyword(keyword);
                    break;
                case 0:
                    System.out.println("Thank you!!!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }

    // Hàm nhập điện thoại chính hãng
    public static void themChinhHang(SmartPhoneManager manager, Scanner sc) {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập hãng: ");
        String brand = sc.nextLine();
        System.out.print("Nhập thời gian bảo hành: ");
        String thoiGianBaoHanh = sc.nextLine();
        System.out.print("Nhập phạm vi bảo hành: ");
        String phamViBaoHanh = sc.nextLine();

        manager.addSmartPhone(new DienThoaiChinhHang(id, name, price, quantity, brand, thoiGianBaoHanh, phamViBaoHanh));
        System.out.println("Đã thêm điện thoại chính hãng!");
    }

    // Hàm nhập điện thoại xách tay
    public static void themXachTay(SmartPhoneManager manager, Scanner sc) {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập hãng: ");
        String brand = sc.nextLine();
        System.out.print("Nhập quốc gia xách tay: ");
        String quocGiaXachTay = sc.nextLine();
        System.out.print("Nhập trạng thái: ");
        String trangThai = sc.nextLine();

        manager.addSmartPhone(new DienThoaiXachTay(id, name, price, quantity, brand, quocGiaXachTay, trangThai));
        System.out.println("Đã thêm điện thoại xách tay!");
    }
}