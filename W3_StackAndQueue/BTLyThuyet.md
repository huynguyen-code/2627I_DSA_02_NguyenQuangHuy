### **Đề bài: Self-printing queue là loại hàng đợi chứa các số nguyên, được cài đặt bằng một danh sách liên kết và cứ sau ba thao tác (enqueue hoặc dequeue) lại tự in nội dung của queue ra input chuẩn. Ví dụ chuỗi enqueue(0), dequeue(), enqueue(0) sẽ in ra 0.**
**a. Bắt đầu từ một queue rỗng, chuỗi sau sẽ in ra nội dung gì??
enqueue(0), enqueue(1), dequeue(), enqueue(2), enqueue(3), dequeue(), enqueue(4), enqueue(5), dequeue(), enqueue(6), enqueue(7), dequeue()**

enqueue(0) -> [0] ; enqueue(1) -> [0 1]; dequeue() -> [0] 

-> Output: 0

enqueue(2) -> [0 2]; enqueue(3) -> [0 2 3]; dequeue() -> [0 2] 

-> Output: 0 2

enqueue(4) -> [0 2 4]; enqueue(5) -> [0 2 4 5]; dequeue() -> [0 2 4] 

-> Output: 0 2 4

enqueue(6) -> [0 2 4 6]; enqueue(7) -> [0 2 4 6 7]; dequeue() -> [0 2 4 6] 

-> Output: 0 2 4 6

Sau khi chạy hết các lệnh, output cuối cùng sẽ là tổng của các output riêng lẻ -> Output cuối cùng là: **0 0 2 0 2 4 0 2 4 6**

**(b) Thao tác enqueue của self-printing queue chứa n phần tử có thời gian chạy trong trường hợp tồi nhất là loại nào?**

Đáp án câu b là: **O(n)**

Enqueue sẽ tốn O(1). Tuy nhiên, trong self printing queue thì sẽ tự in sau mỗi 3 thao tác.

Trong trường hợp xấu nhất, enqueue vào các phần tử 3,6,9,... sau khi thêm phần tử, phải in n phần tử trong queue, tốn 0(n) thời gian.

Tổng thời gian là O(1) + O(n) = O(n)

**(c) Thời gian chạy trung bình (amortized) trên mỗi thao tác đối với n thao tác `enqueue()` và `dequeue()` trên một hàng đợi loại self-printing queue ban đầu rỗng là bao nhiêu? Biết rằng đại lượng này được định nghĩa là tổng thời gian chạy trong trường hợp xấu nhất của bất kỳ chuỗi hỗn hợp nào gồm n thao tác `enqueue()` và `dequeue()` bắt đầu từ một hàng đợi tự in rỗng, chia cho n.**

Đáp án câu c là: **O(n)**

Chi phí cơ bản cho mỗi lần in là O(1), qua n thao tác thì thành O(n)

Chi phí bổ sung: Cứ sau 3 thao tác -> in ra toàn bộ nội dung queue, trong trường hợp xấu nhất thì sẽ người dùng toàn gọi enqueue, khiến queue tăng dần lên n

Khi đó các lần in ấn xảy ra ở lần 3,6,9,...,n với chi phí là 3,6,9,...,n

Lúc đó, tổng chi phí là: 3 + 6 + 9 + ... + n = 3(1+2+3+...+n/3) = 3 * (n/3) (n/3+1)/2 = n^2/6 => tổng tg là O(n^2)

Lúc đó, tổng chi phí chuỗi n thao tác là: O(n) + O(n^2) = O(n^2)

Chi phí trung bình là: O(n^2) / n = O(n)