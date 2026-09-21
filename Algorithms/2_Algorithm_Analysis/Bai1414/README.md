Ý tưởng giải quyết (Thuật toán Two Pointers)

Sắp xếp mảng theo thứ tự tăng dần. Việc này giúp dễ dàng bỏ qua các phần tử trùng lặp và sử dụng kỹ thuật hai con trỏ.

Dùng vòng lặp thứ nhất cho phần tử thứ nhất (i) và vòng lặp thứ hai cho phần tử thứ hai (j). Bỏ qua các giá trị trùng lặp của i và j.

Với mỗi cặp i và j, đặt con trỏ trái left = j + 1 và con trỏ phải right = n - 1.

Tính tổng tổng bốn số: sum = nums[i] + nums[j] + nums[left] + nums[right].

Nếu sum == target, thêm bộ 4 số vào kết quả, sau đó dịch chuyển left và right đồng thời bỏ qua các giá trị trùng lặp.

Nếu sum < target, tăng `left lên để làm tổng lớn hơn.