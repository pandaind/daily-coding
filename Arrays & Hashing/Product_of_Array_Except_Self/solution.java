class Solution {
public int[] productExceptSelf(int[] nums) {
    int[] arr = new int[nums.length];  // Step 1: Create an output array of the same length as the input array
    int right = 1, left = 1;           // Step 2: Initialize two variables 'right' and 'left' to 1

    // Step 3: Compute the product of all elements to the left of each index
    for (int i = 0; i < nums.length; i++) {
        arr[i] = left;                // Set arr[i] to the product of all elements to the left of 'i'
        left *= nums[i];              // Update 'left' to include the current element 'nums[i]'
    }

    // Step 4: Compute the product of all elements to the right of each index
    for (int i = nums.length - 1; i >= 0; i--) {
        arr[i] *= right;              // Multiply the current value of arr[i] by the product of all elements to the right of 'i'
        right *= nums[i];             // Update 'right' to include the current element 'nums[i]'
    }

    return arr;  // Step 5: Return the output array
}

}