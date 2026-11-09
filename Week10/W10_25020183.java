static int[] maxMin(int[] a, int i, int j) {
    if (i == j) {
        return new int[]{a[i],a[i]};
    }
    if (j == i + 1) {
        if(a[i] < a[j]) {
            return new int[]{a[j],a[i]};
        } else {
            return new int[]{a[i], a[j]};
        }
    }
    int mid = (i + j) / 2;
    int[] left = maxMin(a, i, mid);
    int[] right = maxMin(a, mid+1, j);
    int max = Math.max(left[0], right[0]);
    int min = Math.min(left[1], right[1]);
    return new int[]{max,min};
}

public static void main(String[] args) {
    int[] a = {3, 15, 67, 28, 50, 45, 69, 32, 93, 71};
    int[] r = maxMin(a, 0, a.length - 1);
    System.out.println("max = " + r[0] + ", min = " + r[1]);
}