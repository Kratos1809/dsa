public class RBS {

    public static void main(String[] args) {
       int[]arr = {2,5,6,0,0,0,1,2};
       int target = 2;
       System.out.println(search(arr, target));
    }

    public static int search(int[] nums, int target) {
        
        int pivot = FindpivotwithDuplicates(nums);
        
        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length-1);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(nums[0] <= target){
            return binarySearch(nums, target, 0, pivot-1);
        }
        return binarySearch(nums, target, pivot+1, nums.length-1);
    }
        
         static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
        //this will not work if there are duplicate elements
        public static int Findpivot(int[]arr){
            int start = 0;
            int end = arr.length-1;
            
            while(start <= end){
                int mid = start + (end-start)/2;
                if(mid < end && arr[mid] > arr[mid +1]){
                    return mid;
                }
                if(mid > start && arr[mid] < arr[mid-1]){
                    return mid-1;
                }
                if(arr[mid] <= arr[start]){
                    end = mid-1;
                }else{
                    start = mid + 1;
                }
            }
            return -1;
        }

        public static int FindpivotwithDuplicates(int[]arr){
            int start = 0;
            int end = arr.length-1;
            
            while(start <= end){
                int mid = start + (end-start)/2;
                if(mid < end && arr[mid] > arr[mid +1]){
                    return mid;
                }
                if(mid > start && arr[mid] < arr[mid-1]){
                    return mid-1;
                }
               if(arr[start] == arr[mid] && arr[end] == arr[mid]){
                   //check whether start is pivot 
                   if(arr[start] > arr[start + 1]){
                       return start;
                   }
                   start++;
                   //check whether end is pivot
                   if(arr[end] < arr[end - 1]){
                       return end-1;
                   }
                   end--;
               }
               else if(arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]){
                   start = mid + 1;
               }
               else{
                   end = mid - 1;
               }
            }
            return -1;
        }
}
