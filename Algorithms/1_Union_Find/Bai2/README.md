### **Đề bài: Giả sử ta khởi tạo một cấu trúc dữ liệu union-find với n phần tử. Sau đó, ta thực hiện chuỗi các thao tác union() sau: union(0, 1), union(0, 2), union(0, 3), ..., union(0, n-1). Trả lời các câu hỏi sau:**
___
**A. Cấu trúc dữ liệu thu được chứa tổng cộng bao nhiêu thành phần liên thông (tức là các tập hợp rời nhau)?**

Ban đầu có n thành phần, Sau mỗi lệnh union(0,i) -> gộp 2 thành phần thành 1 -> giảm 1 thành phần -> Sau n-1 lệnh union, còn lại 1 thành phần

**B. Giả sử cấu trúc dữ liệu được cài đặt theo phương pháp quick-find. Có bao nhiêu lần cập nhật mảng được thực hiện bởi các thao tác union() này (biểu diễn dưới dạng hàm của n theo ký hiệu xấp xỉ ~)? (Lưu ý: cài đặt quick-find cho union(p,q) của chúng ta không bao giờ thay đổi giá trị leader[q].)** 

Quick find: Union(p,q) duyệt mảng leader[] và đổi leader = leader[p] -> leader[q]

Khi gọi union(0,i), nhóm chứa 0 có sẵn kích thước i -> Cập nhật i phần tử

Tổng số lần cập nhật: 1 + 2 + 3 + .. + (n-1) = n(n-1)/2 -> Thời gian chạy: O(n^2)

**C. Giả sử cấu trúc dữ liệu được cài đặt theo phương pháp quick-union, và ta gọi find(0) sau chuỗi thao tác nêu trên. Thao tác find(0) sẽ thực hiện bao nhiêu lần truy cập mảng (biểu diễn dưới dạng hàm của n theo ký hiệu Θ)? (Lưu ý: cài đặt quick-union cho union(p,q) của chúng ta không bao giờ thay đổi parent[q].)**

Quick union: Union(p,q) đặt parent[root(p)] = root(q), root(q) giữ nguyên

Kết quả sau khi chạy sẽ là một linked list: 0 -> 1 -> 2 -> 3 -> ... -> (n-1)

Gọi find(0) -> duyệt từ 0 -> gốc n-1, tổng cộng n lần truy cập

-> Thơi gian chạy: O(n)

**D. Giả sử cấu trúc dữ liệu được cài đặt theo phương pháp weighted quick-union, và ta gọi find(0) sau chuỗi thao tác nêu trên. Thao tác find(0) sẽ thực hiện bao nhiêu lần truy cập mảng (biểu diễn dưới dạng hàm của n theo ký hiệu Θ)?**

Weighted quick union: Cây nhỏ hơn đc gắn dưới gốc cây lớn hơn, kích thước bằn -> parent[q] đổi. 

Nó sẽ ra kết quả cuối cùng là một cây hình sao, sâu 1

Gọi find(0) -> thời gian chạy: O(1)