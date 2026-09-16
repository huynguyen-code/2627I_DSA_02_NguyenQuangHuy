public void union (int p, int q) {
    for (int i = 0; i < leader.length; i++)
        if (leader[i] == leader[p])
            leader[i] = leader[q];
}

/*  Vấn đề: không lưu lại giá trị của leader[p]
-> khi leader[p] thay đổi thành leader[q]
-> những phần tử khác thuộc tập cùng leader[p] sẽ không được union
- Test case chạy sai:
1. Khởi tạo mảng n = 5 phần tử [0,1,0,1,1],p = 3, q = 2
    Sau khi chạy for:
    i = 0: leader[0] == leader[p] -> 0 == 1 (Sai).
    i = 1: leader[1] == leader[p] -> 1 == 1 (Đúng)
     -> Cập nhật leader[1] = leader[q] = 0. Mảng lúc này là: [0, 0, 0, 1, 1].
    i = 2: leader[2] == leader[p] -> 0 == 1 (Sai).
    i = 3 (Điểm mấu chốt): leader[3] == leader[p] -> 1 == 1 (Đúng)
     -> Cập nhật leader[3] = 0. Mảng lúc này là: [0, 0, 0, 0, 1].
    i = 4 (Hậu quả): Lệnh if kiểm tra leader[4] == leader[p]. leader[4] đang là 1.
    Tuy nhiên, p = 3 mà leader[3] bước trước đã bị thay đổi thành 0 -> 1 == 0 (Sai). Vòng lặp bỏ qua phần tử 4.

2. Sau khi chạy xong, nó sẽ biến thành [0,0,0,0,1]
3. Nhưng mà 1-3-4 cùng 1 nối -> Đứt gãy
 */