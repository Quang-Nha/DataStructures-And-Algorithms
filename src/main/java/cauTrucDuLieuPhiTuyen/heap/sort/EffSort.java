package cauTrucDuLieuPhiTuyen.heap.sort;

//đổi mảng sang định dạng heap rồi heap sort trên mảng này
public class EffSort {
    int[] a;
    int n;

    EffSort() {
    }

    EffSort(int[] b) {
        int i;
        n = b.length;
        a = new int[n];
        for (i = 0; i < n; i++) a[i] = b[i];
    }

    // Set dữ liệu cho mảng
    void setData(int[] b) {
        int i;
        n = b.length;
        a = new int[n];
        for (i = 0; i < n; i++)
            a[i] = b[i];
    }

    void display() {
        int i;
        for (i = 0; i < n; i++)
            System.out.print("  " + a[i]);
        System.out.println();
    }

    //==================================================
  /*Sap xep bang HEAP: Heap la cay nhi phan gan day duoc cai dat bang
    mang mot chieu voi cac nut tren heap co noi dung nho hon nut goc
    va cac nhanh cay con cung la cac heap
  */
    void heapSort() {/*Chuyen danh sach thanh HEAP bang cach xem khoi dau heap gom nut
      a[0], sau do lan luot chuyen cac nut a[1],a[2],...,
      a[n-1] vao heap*/
        int i, s, f;
        int x;
        for (i = 1; i < n; i++) {
            x = a[i];//gán x = giá trị tại node con đang xét, x sẽ làm giá trị trung gian khi a[i] đổi giá trị với cha nó
            //Nut can them vao HEAP, ban dau heap co mot nut a[0].
          /*Insert x vao vi tri thich hop cua HEAP: xuat phat tu i, di dan ve
            goc de tim mot vi tri nut cha thich hop. Vay f se giam dan
          */
            s = i; //s la nut con, hien tai tren heap chua co a[i]
            //f=(s-1)/2 la nut cha
            //nếu giá trị node con(s) = x lớn hơn giá trị tại node cha ((s - 1) / 2) thì
            //cho giá trị tại node con(s) là giá trị node cha và tiếp tục so sánh
            while (s > 0 && x > a[(s - 1) / 2]) {//nếu giá trị node con(s) lớn hơn giá trị tại node cha ((s - 1) / 2) thì
                a[s] = a[(s - 1) / 2]; //Keo nut < x xuong 1 muc
                s = (s - 1) / 2;//chỉnh lại chỉ số node con thành chỉ số node cha nó vừa đổi giá trị
            }

            a[s] = x; //Dua nut x vao vi tri phu hop, gán lại giá trị node con ban đầu vào node cha cuối cùng nó hoán đổi
        }

        //Ket thuc chuyen danh sach thanh heap
        System.out.println(" Heap:");
        display();
        //Lan luot xoa nut a[0] tren HEAP, dua ve vi tri thich hop tren ds
        for (i = n - 1; i > 0; i--) {//chạy từ cuối mảng về i = 1
            x = a[i];//cho x là giá trị mảng tại i, đây là lá cuối cùng của heap
            a[i] = a[0];//đổi chỗ giá trị tại điểm đầu mảng heap với tại i, đây là root có giá trị lớn nhất
      /*O buoc i heap co i+1 nut, la a[0], a[1],...,a[i]
        Muc dich cua chung ta la dua nut a[0] ve vi tri a[i],
        dong thoi, chen a[i] vao heap sao cho cau truc heap van bao
        toan. De lam dieu nay ta bat dau tu
        nut f = 0, theo con duong cha - con trai hoac phai, tim mot vi tri
        de chen nut a[i]. De co duoc nut trong de chen a[i], ta can
        dich cac nut tren duong di len mot muc, bang cong thuc
        nutgoc=max(contrai,conphai,a[i])
      */
            f = 0; //f la nut cha, s la nut con lon hon
            s = 2 * f + 1; //Gan s la nut con ben trai
            if (s + 1 < i && a[s] < a[s + 1]) s = s + 1;/*Neu co nut phai va
     lon hon thi chon nut phai*/
            //nếu chỉ số tại s phải nhỏ hơn i, vì i đã gán = root và gái trị x là lá được đổi cho root nhỏ hơn nút con có giá trị lớn nhất
            //thì đổi giá trị cho lá, cập nhật lại vị trí f đang xét thành node lá, cập nhật node lá giá trị lớn nhất s
            //rồi tiếp tục so sánh với node và lá
            while (s < i && x < a[s]) {
                a[f] = a[s];//Con lon thay the cha
                f = s;//Chuyen den con lon tiep theo
                s = 2 * f + 1;
                if (s + 1 < i && a[s] < a[s + 1]) s = s + 1;
            }
            a[f] = x; //Nut a[k] duoc chen dung cho, khi giá trị tại node f không nhỏ hơn node con lớn nhất thì dừng lại
            //gán lại giá trị biến trung gian là giá trị lá cuối cùng cho node đang xét f
        }
    }

}
