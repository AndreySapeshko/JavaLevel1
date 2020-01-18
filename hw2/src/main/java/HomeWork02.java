import java.util.Arrays;

public class HomeWork02 {
    public static void main(String[] args) {
        int[] zeroToOne = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(zeroToOne));
        for (int i = 0; i < zeroToOne.length; i++) {
            if (zeroToOne[i] == 1) {
                zeroToOne[i] = 0;
            } else {
                zeroToOne[i] = 1;
            }
        }
        System.out.println(Arrays.toString(zeroToOne));

        int[] arithmeticProgression = new int[8];
        int n = 0;
        for (int i = 0; i < arithmeticProgression.length; i++) {
            arithmeticProgression[i] = n;
            n += 3;
        }
        System.out.println(Arrays.toString(arithmeticProgression));

        int[] nums = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6) {
                nums[i] = nums[i] * 2;
            }
        }
        System.out.println(Arrays.toString(nums));

        int[][] squareArr = new int[5][5];
        for (int i = 0; i < squareArr.length; i++) {
            for (int j = 0; j < squareArr[i].length; j++) {
                if (i == j) {
                    squareArr[i][j] = 1;
                } else {
                    squareArr[i][j] = 0;
                }
                System.out.print("  " + squareArr[i][j]);
            }
            System.out.println();
        }

        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxNum < nums[i]) {
                maxNum = nums[i];
            }
        }
        System.out.println("Самое большое число в массиве: " + maxNum);

        int minNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (minNum > nums[i]) {
                minNum = nums[i];
            }
        }
        System.out.println("Самое меньшее число в массиве: " + minNum);
        int[] numers = {4, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(checkBalance(numers));;

        int[] arrForShift = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arrForShift));
        shiftArr(arrForShift, 3);
        System.out.println(Arrays.toString(arrForShift));
        shiftArr(arrForShift, -2);
        System.out.println(Arrays.toString(arrForShift));

    }
    static boolean checkBalance(int[] nums) {
        int sumBegin = 0, sumEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            sumEnd += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            sumBegin += nums[i];
            sumEnd -= nums[i];
            if (sumBegin == sumEnd) {
                break;
            }
        }
        return (sumBegin == sumEnd);
    }

    static int[] shiftArr(int[] arr, int shift) {
        shift = shift % arr.length;
        if (shift < 0) {
            shift = arr.length - shift;
        }
        for (int i = 0; i < shift; i++) {
            int buffer = arr[0];
            int buffer1;
            for (int j = 0; j < arr.length; j++) {
                if (j == arr.length - 1) {
                    arr[0] = arr[j];
                    arr[j] = buffer;
                } else {
                    buffer1 = arr[j];
                    arr[j] = buffer;
                    buffer = buffer1;
                }
            }
        }
        int[] arr1 = arr;
        return arr1;
    }
}
