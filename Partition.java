import java.beans.Transient;
import java.lang.reflect.Array;
import java.util.Comparator;

public class Partition{

  /**
 * Select a pivot and partition the subarray from [lb .. ub) into 
 * the following form.
 *
 * <pre>
 * ---+-----------------+-+----------------+---
 *    | values <= pivot |p| values > pivot |
 * ---+-----------------+-+----------------+---
 *    |                 |                  |
 *    lb                pivotLoc           ub
 * </pre>
 *
 * @return pivotLoc.
 */
private static <T> int partition(T[] arr, Comparator<? super T> compare, int lb, int ub) {
  int pivot = lb + (ub - lb)/2; //set pivot index
  T temp = arr[pivot]; //temp val to store val at pivot
  arr[pivot] = arr[0]; //set val at pivot to first element in array
  arr[0] = temp; //set first element in array to val at pivot

  int small = lb+1;
  int large = ub;

  for(int i = 0; small == large; i++){
    int o = compare.compare(arr[pivot], arr[i]); //compares the pivot index value to the val
    if (o < 0) {
      small++; //moves the index to the right
   } 
    else if (o > 0){
      T tempLarge = arr[large];
      arr[large] = arr[i]; //puts the val to the left of ub
      arr[i] = tempLarge; //swaps last element w where val was originally
      large--; //moves the index to the left
   } // if/else
  }


  arr[pivot] = arr[small - 1];
  arr[small - 1]= temp;

  return (small-1);


} // partition

}


