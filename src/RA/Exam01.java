package RA;

import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        Scanner scanner = new Scanner(System.in);
        int choice;
        int n = 0;
        do {
            System.out.println("\n************************MENU**************************\n" +
                    "1. Nhập giá trị n phần tử của mảng (n nhập từ bàn phím)\n" +
                    "2. In giá trị các phần tử trong mảng\n" +
                    "3. Tính trung bình các phần tử dương (>0) trong mảng\n" +
                    "4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong mảng (k nhập từ bàn phím)\n" +
                    "5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần\n" +
                    "6. Tính số lượng các phần tử là số nguyên tố trong mảng\n" +
                    "7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng\n" +
                    "dần, các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần,\n" +
                    "các phần tử còn lại ở giữa mảng theo thứ tự tăng dần\n" +
                    "8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí\n" +
                    "9. Thoát");
            System.out.print("Nhap lua chon:");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhap so gia tri phan tu cua mang:");
                    n = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhap cac gia tri phan tu cua mang:");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("arr[%d] = ", i);
                        arr[i] = Integer.parseInt(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Cac gia tri phan tu trong mang:");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%3d ", arr[i]);
                    }
                    break;
                case 3:
                    int sum = 0;
                    int countPositive = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] > 0) {
                            countPositive++;
                            sum += arr[i];
                        }
                    }
                    System.out.printf("\nTrung binh cac phan tu duong trong mang = %f", (float) sum / countPositive);
                    break;
                case 4:
                    System.out.print("Nhap gia tri k:");
                    int k = Integer.parseInt(scanner.nextLine());
                    System.out.printf("Chi so cac phan tu co gia tri bang %d la:", k);
                    for (int i = 0; i < n; i++) {
                        if (arr[i] == k) {
                            System.out.printf("%3d ", i);
                        }
                    }
                    break;
                case 5:
                    int temp;
                    System.out.printf("Sap xep mang giam dan theo thuat toan sap xep noi bot:ln");
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (arr[i] < arr[j]) {
                                temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sap xep thanh cong! Moi bam phim 2 de xem ket qua!");
                    break;
                case 6:
                    System.out.println("Số lượng các phần tử là số nguyên tố: ");
                    int countPrime = 0;
                    boolean isPrime = true;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] <= 1) isPrime = false;
                        for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                            if (arr[i] % j == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                        if (isPrime) countPrime++;
                    }
                    System.out.printf("%d",countPrime);
                    break;

                case 7:
                    System.out.println("Sap xep cac phan tu chan chia het cho 3 o dau theo thu tu tang dan" +
                            ",cac phan tu le chia het cho 3 o cuoi theo thu tu giam dan" +
                            ",cac phan tu con lai o giua theo thu tu tang dan");
                    int[] newArray1 = new int[n];
                    int[] newArray2 = new int[n];
                    int[] newArray3 = new int[n];
                    int[] newArray4 = new int[n];
                    int count1 = 0;
                    int count2 = 0;
                    int count3 = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] % 3 == 0) {
                            if (arr[i] % 2 == 0) {
                                newArray1[count1] = arr[i];
                                count1++;
                            } else {
                                newArray2[count2] = arr[i];
                                count2++;
                            }
                        } else {
                            newArray3[count3] += arr[i];
                            count3++;
                        }
                    }

                    int temp2 = 0;
                    for (int i = 0; i < count1 - 1; i++) {
                        for (int j = i + 1; j < count1; j++) {
                            if (newArray1[i] > newArray1[j]) {
                                temp2 = newArray1[i];
                                newArray1[i] = newArray1[j];
                                newArray1[j] = temp2;
                            }
                        }
                    }
                    for (int i = 0; i < count2 - 1; i++) {
                        for (int j = i + 1; j < count2; j++) {
                            if (newArray2[i] > newArray2[j]) {
                                temp2 = newArray2[i];
                                newArray2[i] = newArray2[j];
                                newArray2[j] = temp2;
                            }
                        }
                    }
                    for (int i = 0; i < count3 - 1; i++) {
                        for (int j = i + 1; j < count3; j++) {
                            if (newArray3[i] > newArray3[j]) {
                                temp2 = newArray3[i];
                                newArray3[i] = newArray3[j];
                                newArray3[j] = temp2;
                            }
                        }
                    }
                    int pos = 0;
                    for (int i = 0; i < count1; i++) {
                        newArray4[pos] = newArray1[i];
                        pos++;
                    }
                    for (int i = 0; i < count3; i++) {
                        newArray4[pos] = newArray3[i];
                        pos++;
                    }
                    for (int i = count2 - 1; i >= 0; i--) {
                        newArray4[pos] = newArray2[i];
                        pos++;
                    }

                    for (int i = 0; i < n; i++) {
                        System.out.printf("%3d ", newArray4[i]);
                    }

                    break;
                case 8:
                    System.out.print("Nhap gia tri m tu ban phim:");
                    int m = Integer.parseInt(scanner.nextLine());

                    int[] extraArray = new int[n + 1];
                    for (int i = 0; i < n; i++) {
                        extraArray[i] = arr[i];
                    }
                    extraArray[n] = m;

                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n + 1; j++) {
                            if (extraArray[i] < extraArray[j]) {
                                temp = extraArray[i];
                                extraArray[i] = extraArray[j];
                                extraArray[j] = temp;
                            }
                        }
                    }
                    System.out.printf("Cac phan tu cua mang khi them %d va sap xep theo giam dan la:",m);
                    for (int i = 0; i < n + 1; i++) {
                        System.out.printf("%3d",extraArray[i]);
                    }
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Moi nhap tu 1 den 9");
                    break;
            }
        } while (true);
    }
}
