package mergesortalgorithm;

import java.util.Arrays;
import java.util.Random;

/*
 * @author Ongeziwe Mtolo (221205276)
 */
public class MergeSortAlgorithm {

    public static void main(String[] args) {
        
        Random random = new Random();
        int[] numbers = new int [10];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(50);
        }
        
        System.out.println("Array before merge sort: " + Arrays.toString(numbers) + "\n");

        mergeSort(numbers);
        System.out.println("Array after merge sort: " + Arrays.toString(numbers));
    }
    
    private static void mergeSort(int [] inputArray){
        
        //when the inpuArray reaches a point with 1 element, that element is already sorted
        int inputLength = inputArray.length; //variable inputLenght is for the lenght of the whole array when broken down step by step
        if (inputLength < 2){ //when lenght is if an array is broken down to 1 element,  that element must be returned
            return;
        }
        
        int midIndex = inputLength / 2;
        //creating 2 arrays from the original array by dividing the inputArray into two arrays
        int[] leftArray = new int[midIndex]; //first array starts from the 1st element(index 0) of the whole array to the middle index of the array.
        int[] rightArray = new int[inputLength - midIndex]; //second array starts right after the middle index of the whole array to the end of the array.
        
        //filling the leftArray with elemenets
        //for the leftArray, it will start from the beginning up to the half of the inputArray(Original Array) 
        for(int i = 0; i < midIndex; i++){ 
            leftArray[i] = inputArray[i];
        }
        
        //filling the rightArray with elements
        //for the rightArray, it wwill start after the midIndex up to the end of the inputArray. hence[i - midIndex]
        for(int i = midIndex; i < inputLength; i++){
            rightArray[i - midIndex] = inputArray[i];
        }
        System.out.println("Left Array: " + Arrays.toString(leftArray) + "......" + Arrays.toString(rightArray) + " : Right Array");
                
        mergeSort(leftArray);
        mergeSort(rightArray);
        
        //meging the leftArray and the rightArray to create one sorted inputArray
        mergeArrays(inputArray, leftArray, rightArray);
    }
    
    private static void mergeArrays(int[] inputArray, int[] leftArray, int[] rightArray){
        
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        
        //iterator variables for 1. moving through the leftArray, 2. moving through the rightArray, 3. moving through merged array from the left and right arrays
        int i = 0; 
        int j = 0;
        int k = 0;
        
        //compare elements from leftArray and element from rightArray, the smallest goes to the inputArray(ascending order)
        //increment whichever iterator (i and j)to look again and compare elements
        //lastly increment the inputArray, iterator(k)
        while(i < leftSize && j < rightSize){
            if(leftArray[i] <= rightArray[j]){
                inputArray[k] = leftArray[i];
                i++;
            }else{
                inputArray[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        //taking into account element left alone in the leftArray to be added to the inputArray
        while(i < leftSize){
            inputArray[k] = leftArray[i];
            i++;
            k++;
        }
        
        //taking into account element left alone in the rightArray to be added to the inputArray
        while(j < rightSize){
            inputArray[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
