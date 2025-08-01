package day34;

public class complex_num_mul {
    public String complexNumberMultiply(String num1, String num2) {
        // (a1 + a2i)*(b1 + b2i)
        // 复数乘法公式：(a1*b1-a2*b2) + (a1*b2+a2*b1)i
        String[] parts1 = num1.split("\\+");
        String[] parts2 = num2.split("\\+");
        int real1 = Integer.parseInt(parts1[0]);
        int imag1 = Integer.parseInt(parts1[1].replace("i",""));
        int real2 = Integer.parseInt(parts2[0]);
        int imag2 = Integer.parseInt(parts2[1].replace("i",""));
        String res = String.format("%d+%di", real1*real2-imag1*imag2, real1*imag2+real2*imag1);
        return res;
    }
}
