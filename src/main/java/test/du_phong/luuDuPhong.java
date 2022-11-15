package test.du_phong;

import java.util.*;

public class luuDuPhong {
    private List<HocSinh> hocSinhList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    private void sortId() {
        Collections.sort(hocSinhList, new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
    }

    public void updateDelete() {
        sortId();
        System.out.print("Nhập ID cần tìm: ");
        String id = sc.nextLine();

        int min = 0;
        int max = hocSinhList.size() - 1;
        int mid;
        boolean index = false;
        while (min <= max) {
            mid = min + (max - min) / 2;

            if (hocSinhList.get(mid).getId().equals(id)) {
                System.out.print("Bạn muốn cập nhật (U) hay xóa (D) sinh viên " + id + ": ");
                String choise;
                while (true) {
                    choise = sc.nextLine();
                    if (choise.equalsIgnoreCase("u") || choise.equalsIgnoreCase("d")) {
                        break;
                    }
                    System.out.print("Nhập lại trong khoảng đã cho: ");
                }
                hocSinhList.remove(mid);
                if (choise.equalsIgnoreCase("u")) {
                    System.out.println("Cập nhật sinh viên " + id);
                    hocSinhList.add(mid, nhapThongTin());
                    System.out.println("Đã cập nhật thành công!");
                } else System.out.println("Đã xóa thành công!");
                index = true;
                break;

                //nếu giá trị mảng tại mid nhỏ hơn data
                //thì min = mid + 1 để lấy nữa phía sau của mảng
            } else if (hocSinhList.get(mid).getId().compareTo(id) < 0) {
                min = mid + 1;
                //ngược lại thì max = mid - 1
            } else {
                max = mid - 1;
            }
        }
        if (!index) {
            System.out.println("Không tìm thấy ID sinh viên!");
        }
    }

    private HocSinh nhapThongTin() {
        System.out.print("Nhập ID sinh viên: ");
        String id;
        while (true) {
            id = sc.nextLine();
            boolean dk = false;
            for (HocSinh hs : hocSinhList) {
                if (hs.getId().equals(id)) {
                    dk = true;
                    break;
                }
            }
            if (dk) {
                System.out.print("ID đã tồn tại, mời nhập lại: ");
            } else break;
        }
        System.out.print("Nhập tên sinh viên: ");
        String name = sc.nextLine();
        System.out.print("Nhập học kỳ: ");
        int hocKy;
        while (true) {
            try {
                hocKy = Integer.valueOf(sc.nextLine());
                if (hocKy > 0) {
                    break;
                }
                System.out.print("Học kỳ phải lớn hơn 0, mời nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("Học kỳ phải là số nguyên, mời nhập lại: ");
            }
        }
        System.out.print("Nhập khóa học: ");
        String course;
        while (true) {
            course = sc.nextLine();
            if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase(".Net") || course.equalsIgnoreCase("C/C++")) {
                break;
            }
            System.out.print("Khóa học không tồn tại, mời nhập lại: ");
        }
        return new HocSinh(id, name, hocKy, course);
    }
}
