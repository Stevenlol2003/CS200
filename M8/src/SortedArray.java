public class SortedArray {
   
   public static boolean inOrder(int [] nums) {
      boolean order = false;
      for (int i = 0; i < nums.length-1; ++i) {
         if (nums[i + 1] > nums[i]) {
            order = true;
         }
         if (nums[nums.length - 1] < nums[nums.length - 2]) {
            order = false;
         }
      }
      return order;
   }
   
   public static void main(String[] args) {
      
      // Test out-of-order example.
      int [] nums1 = {5, 6, 7, 8, 3};
      
      if(inOrder(nums1)){
         System.out.println("In order");
      }else{
         System.out.println("Not in order");
      }
      
      // Test in-order example.
      int [] nums2 = {5, 6, 7, 8, 10};
      
      if(inOrder(nums2)){
         System.out.println("In order");
      }else{
         System.out.println("Not in order");
      }
   }
}
