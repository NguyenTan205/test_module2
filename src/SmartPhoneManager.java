import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SmartPhoneManager {
    List<SmartPhone> smartPhonesList = new ArrayList<>();
    private String filePath;

    // importDataFromFileCsv
    public List<SmartPhone> importDataFromFileCsv(String filePath) {
        List<SmartPhone> smartPhonesList = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Danh sách trống !!!");
            return smartPhonesList;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // bỏ qua tiêu đề
                    continue;
                }
                // tách CSV đơn giản, không cắt bên trong dấu ngoặc kép
                String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].replace("\"", "").trim(); // bỏ dấu ngoặc kép và trim
                }

                String type = fields[0];
                int id = Integer.parseInt(fields[1]);
                String name = fields[2];
                double price = Double.parseDouble(fields[3].replace(",", "."));
                int quantity = Integer.parseInt(fields[4]);
                String brand = fields[5];

                if ("chinhhang".equalsIgnoreCase(type)) {
                    String thoiGianBaoHanh = fields[6];
                    String phamViBaoHanh = fields[7];
                    smartPhonesList.add(new DienThoaiChinhHang(name, price, quantity, brand, thoiGianBaoHanh, phamViBaoHanh));
                } else if ("xachtay".equalsIgnoreCase(type)) {
                    String quocGiaXachTay = fields[6];
                    String trangThai = fields[7];
                    smartPhonesList.add(new DienThoaiXachTay(name, price, quantity, brand, quocGiaXachTay, trangThai));
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file" + e.getMessage());
        }
        return smartPhonesList;
    }

    // exportDatatoFileCsv
    public void exportDatatoFileCsv(String filePath) {
        try (java.io.FileWriter fw = new java.io.FileWriter(filePath)) {
            fw.write("type,id,name,price,quantity,brand,field6,field7\n");
            for (SmartPhone sp : smartPhonesList) {
                if (sp instanceof DienThoaiChinhHang) {
                    DienThoaiChinhHang dt = (DienThoaiChinhHang) sp;
                    fw.write(String.format("chinhhang,\"%d\",\"%s\",\"%.2f\",\"%d\",\"%s\",\"%s\",\"%s\"\n",
                            sp.getId(), sp.getName(), sp.getPrice(), sp.getQuantity(),
                            sp.getBrand(), dt.getThoiGianBaoHanh(), dt.getPhamViBaoHanh()));
                } else if (sp instanceof DienThoaiXachTay) {
                    DienThoaiXachTay dt = (DienThoaiXachTay) sp;
                    fw.write(String.format("xachtay,\"%d\",\"%s\",\"%.2f\",\"%d\",\"%s\",\"%s\",\"%s\"\n",
                            sp.getId(), sp.getName(), sp.getPrice(), sp.getQuantity(),
                            sp.getBrand(), dt.getQuocGiaXachTay(), dt.getTrangThai()));
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file" + e.getMessage());
        }
    }


    public SmartPhoneManager(String filePath) {
        this.filePath = filePath;
        this.smartPhonesList = importDataFromFileCsv(filePath);
    }

    // addSmartPhone
    public void addSmartPhone(SmartPhone smartPhone) {
        smartPhonesList.add(smartPhone);
        SmartPhone.counter++;
        exportDatatoFileCsv(filePath);
    }

    // displayAllPhone
    public void displayAllSmartPhones() {
        for (SmartPhone sp : smartPhonesList) {
            System.out.println(sp);
        }
    }

    // searchPhoneById
    public void searchPhoneByIdKeyword(String keyword) {
        boolean found = false;
        for (SmartPhone sp : smartPhonesList) {
            if (String.valueOf(sp.getId()).contains(keyword)) {
                System.out.println(sp);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy điện thoại với từ khóa ID: " + keyword);
        }
    }

    // searchPhoneByName
    public void searchPhoneByName(String keyword) {
        boolean found = false;
        for (SmartPhone sp : smartPhonesList) {
            if (sp.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(sp);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy điện thoại với từ khóa ID: " + keyword);
        }
    }

    // deletePhoneById
    public void deleteById(int id) {
        for (int i = 0; i < smartPhonesList.size(); i++) {
            if (smartPhonesList.get(i).getId() == id) {
                smartPhonesList.remove(i);
                exportDatatoFileCsv(filePath);
                break;
            }
        }
    }


}
