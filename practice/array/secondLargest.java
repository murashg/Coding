//seconod Largest
/*
array={2,4,7,-20,20,30}
return the second largist element of the array = 20
array={}  return null;
*/
//array={1,-1,0,200}
public static int secondLargestElement(int[] array){
    if (array.length == 0 || array.length == 1) return null;
    int max = 0, secondLargest = 0;
    if (array[0] > array[1]){
        max = array[0];
        secondLargest = array[1];
    }else{
        max = array[1];
        secondLargest = array[0];
    }
    for (int i = 2; i < array.length; i++){
        if (array[i] > secondLargest){
            if (array[i] > max){
                secondLargest = max;
                max = array[i];
            }else{
                secondLargest = array[i];
            }
        }
    }
    return secondLargest;
}
