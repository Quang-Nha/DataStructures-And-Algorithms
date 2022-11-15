package exercise.exercise6.queen;

public class Queen {
    int n, count = 0;
    boolean dk = true;
    int x[];// chỉ số là các hàng, giá trị tại chỉ số là vị trí cột cho phép đặt được quân hậu

    public Queen(int n, int[] x) {
        this.n = n;
        this.x = x;
    }

    void result() {
        System.out.printf("\n%3d: ", ++count);
        for (int i = 1; i <=n; i++) System.out.printf("%3d", x[i]);
    }

    /**
     * Hàm thuật toán tìm nghiệm, k là hàng trên bàn cờ
     * mỗi 1 hàng sẽ gọi vòng lặp cột j, thử tất cả các vị trí cột j của quân hậu tại hàng đó
     * mỗi hàng chỉ cần đặt 1 quân hậu là gọi đệ quy chuyển sang hàng tiếp theo vì 1 hàng ko thể có 2 quân hậu
     */
    void test(int k) {
        //nếu k lớn hơn n thì gọi hàm in ra và kết thúc
        if (k == n + 1) {
            result();
        } else {
            //lặp các giá trị trong khoảng cho phép
            // chạy chỉ số cột j từ cột 1 đến cột n
            for (int j = 1; j <= n; j++) {
                dk = true;
                // lặp qua các hàng đã gán được quân hậu 1 đến k - 1 bằng biến i
                // từ 1 đến hàng gán trước đó là hàng k - 1 và lấy các giá trị mảng tại
                // vị trí lặp này x[i] tức vị trí quân hậu đã gán tại hàng i
                // cột đang xét là j trong vòng lặp
                // nếu biến j thỏa mãn dk cho phép thì gán cho dk = false tức là với các điều kiện này đúng
                // thì không thể đặt được quân hậu tại vị trí cột j trong hàng k này
                // đk = false sẽ không cho phép gọi đệ quy đến hàng tiếp theo nữa và kết thúc hàm quay trở
                // lại đệ quy trước đó là hàng k - 1 và thử tiếp tăng vị trí quân hậu thêm 1 cột nữa tại hàng k - 1 đó
                for (int i = 1; i <= k - 1; i++) {
                    // x[i] == j: tức là vị trí quân hậu tại hàng i là cột x[i] lại trùng với cột j đang xét
                    // thì không thể đặt dk tại cột j này và cho dk = false

                    // x[i] == j + k - i: cột j tại hàng k đang xét nằm tại vị trí đường chéo /
                    // của vị trí quân hậu là cột x[i] tại hàng i thì không thể đặt dk tại cột j này và cho dk = false

                    // x[i] == j - k + i: cột j tại hàng k đang xét nằm tại vị trí đường chéo \
                    // của vị trí quân hậu là cột x[i] tại hàng i thì không thể đặt dk tại cột j này và cho dk = false
                    if (x[i] == j || x[i] == j + k - i || x[i] == j - k + i) {
                        dk = false;
                        break;
                    }
                }
                // kết thúc vòng lặp i trên mà dk vần true thì tức tại cột j hàng k này có thể đặt được quân hậu
                // gọi đệ quy đến hàng tiếp theo và thử đặt quân hậu tại hàng đó

                // đầu tiên tại hàng 1/ k = 1 cho quân hậu ở vị trí j = 1

                // nếu dk vẫn là true thì gán cho mảng tại k = j
                // tức là hàng thứ k sẽ đặt quân hậu tại vị trí cột j
                // rồi gọi đệ quy k + 1 để tìm vị trí đặt trên hàng thứ k + 1
                // nếu k + 1 ko tìm thấy kết quả phù hợp nó sẽ kết thúc mà không gọi đệ quy nữa rồi quay lại
                // hàng k này tức phép thử đặt quân hậu tại vị trí j của hàng k này đã thất bại
                // nên hàng k + 1 không thể đặt được quân hậu bất cứ cột nào nữa và tại hàng k này tiếp tục chạy
                // j tiếp theo trong vòng lặp j bên ngoài để thử vị trí j + 1 nếu được lại gọi đệ quy hàng tiếp theo
                // k + 1, không được thì nó lại không gọi đệ quy và quay lại hàng phía dưới k - 1 có thể sẽ quay
                // lại hàng đầu tiên thì tức là vị trí quân hậu tại hàng đầu tiên cũng sai, lại sang vòng lặp
                // tiếp với vị trí cột j tiếp theo j + 1 tại hàng 1 và thử đến các hàng tiếp
                // vứ thử như vậy đến khi
                // các điều kiện đúng liên tục nên nó được gọi đệ quy đến hàng cuối cùng mà các kết quả vẫn phù hợp
                // lại gọi đệ quy tiếp và nó gặp điều kiện dừng là hàm xử lý hàng lớn hơn cả hàng cuối cùng của bàn cờ
                // tức các hàng trong bàn cờ đã đúng thì in ra
                // kết quả vị trí quân hậu tại các hàng là xong 1 cách xắp xếp
                // và lại quay lại lần đệ quy đầu tiên ở hàng 1/k = 1, j = 1 chạy tiếp vòng lặp cho quân hậu ở
                // vị trí j = 2 tìm cách xắp xếp tiếp theo nếu lại khả thi thì lại in...
                if (dk) {
                    x[k] = j;
                    test(k + 1);
                }
            }
        }

    }
}
