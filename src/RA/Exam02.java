package RA;

import java.util.Scanner;

public class Exam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap hang doc cua mang:");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap hang ngang cua mang:");
        int m = Integer.parseInt(scanner.nextLine());

        int[][] array = new int[n][m];
        int choice;
        do {
            System.out.println("\n************************MENU**************************\n" +
                    "1. Nhập giá trị các phần tử của mảng\n" +
                    "2. In giá trị các phần tử trong mảng theo ma trận\n" +
                    "3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng\n" +
                    "4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và \n" +
                    "đường chéo phụ\n" +
                    "5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của \n" +
                    "mảng\n" +
                    "6. In ra các phần tử là số nguyên tố trong mảng\n" +
                    "7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính \n" +
                    "của mảng giảm dần\n" +
                    "8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng, \n" +
                    "thực hiện chèn vào mảng 2 chiều\n" +
                    "9. Thoát");
            System.out.print("Moi nhap lua chon:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập giá trị các phần tử mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("arr[%d][%d] =", i, j);
                            array[i][j] = Integer.parseInt(scanner.nextLine());
                        }
                    }
                    break;
                case 2:
                    System.out.println("In giá trị các phần tử trong mảng theo ma trận:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("%3d", array[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    int count = 0;
                    System.out.println("Số lượng các phần tử chia hết cho 2 và 3 trong mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (array[i][j] % 2 == 0 && array[i][j] % 3 == 0) {
                                count++;
                            }
                        }
                    }
                    System.out.printf("%d", count);
                    break;
                case 4:
                    System.out.println("In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và đường chéo phụ");
                    System.out.println("Các phần tử nằm trên đường biên:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                                System.out.printf("%4d", array[i][j]);
                            }
                        }
                    }
                    if (n != m) {
                        System.out.println("Khong co duong cheo chinh va cheo phu");
                    } else {
                        System.out.println("\nIn giá trị các phần tử trên đường chéo chính:");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                if (i == j) {
                                    System.out.printf("%4d", array[i][j]);
                                }
                            }
                        }
                        System.out.println("\nIn giá trị các phần tử trên đường chéo phu:");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                if (i + j == n - 1) {
                                    System.out.printf("%4d", array[i][j]);
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    int temp;
                    System.out.println("\n Sắp xếp mảng tăng dần theo cột:");
                    for (int j = 0; j < m; j++) {
                        for (int i = 0; i < n - 1; i++) {
                            for (int k = i + 1; k < n; k++) {
                                if (array[i][j] > array[k][j]) {
                                    temp = array[i][j];
                                    array[i][j] = array[k][j];
                                    array[k][j] = temp;
                                }
                            }
                        }
                    }
                    System.out.println("\n Sắp xếp thành công");
                    break;
                case 6:
                    System.out.println("\nCác phần tử là số nguyên tố trong mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            boolean isPrime = true;
                            if (array[i][j] <= 1) isPrime = false;
                            for (int k = 2; k <= Math.sqrt(array[i][j]); k++) {
                                if (array[i][j] % k == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                            if (isPrime) System.out.printf("%3d", array[i][j]);
                        }
                    }
                    break;
                case 7:
                    int temp2;
                    if (n != m) {
                        System.out.println("Khong co duong cheo chinh");
                    } else {
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                if (i == j) {
                                    for (int k = i + 1; k < n; k++) {
                                        for (int l = i; l < n - 1; l++) {
                                            if (array[k][k] > array[l][l]) {
                                                temp2 = array[k][k];
                                                array[k][k] = array[l][l];
                                                array[l][l] = temp2;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        System.out.println("\n Sắp xếp thành công");
                    }
                    break;
                case 8:
                    int[] newArray = new int[m];
                    System.out.printf("Nhập giá trị một mảng 1 chiều gồm %d phần tử:\n",m);
                    for (int i = 0;i<m;i++){
                        System.out.printf("newArr[%d] = ",i);
                        newArray[i] = Integer.parseInt(scanner.nextLine());
                    }

                    System.out.print("Nhập chỉ số dòng cần chèn:");
                    int index = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (index == i){
                                array[i][j] = newArray[j];
                            }
                        }
                    }

                    System.out.println("\n Chèn thành công");
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.print("Moi nhap tu 1 den 9");
                    break;
            }
        } while (true);
    }
}
