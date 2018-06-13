package linear;

public class Recursion {
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    /**
     *
     * @param arr 数组
     * @param i 结束
     * @return 返回值
     */
    private static int sum(int[] arr ,int i){
        if(i == arr.length){
            return 0;
        }
        return arr[i] +sum(arr,i+1);
    }
}
