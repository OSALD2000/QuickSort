import java.util.Random;

public class QuickSortDnfP{

    private int[] array;

    public void quicksort(){
        _quicksort(0,array.length-1);
    }

    private void _quicksort(int small, int larg){
        if(small-larg<50){
            bubbleSort(small, larg);
            return;
        }

        int divider=partioniereHoare(small, larg);
        
        _quicksort(small, divider);
        _quicksort(divider+1, larg);
    }

    private int partioniereHoare(int small, int larg){
        int pivot = array[small];
        
        int smallerArrow=small;
        int equleArrow=small+1;
        int largerArrow=larg;

        while(smallerArrow<largerArrow){
        while(array[equleArrow]<pivot){
            if(array[smallerArrow]>array[equleArrow]){
                swapAtIndex(smallerArrow, equleArrow);
                smallerArrow+=1;
                equleArrow+=1;
            }
        }
        while(array[largerArrow]>array[equleArrow]){
            if(largerArrow>smallerArrow){
                largerArrow-=1;
            }else{break;}
        }
        if(largerArrow>smallerArrow){
            swapAtIndex(largerArrow, equleArrow);
            largerArrow-=1;
        }

    }
        return largerArrow;
    }

    private void bubbleSort(int first, int last){
        int lastElementIDX = last;
        for(int j=first; j<last; j++){
            for(int i =0; i<last; i++){
                if(array[i]> array[i+1]){
                    swapAtIndex(i , i+1);
                }
            }
            lastElementIDX-=1;
        }
    }


    private void swapAtIndex(int i, int j){
        int value = array[i];
        array[i]=array[j];
        array[j]=value;
    }

    static int incCnt = 0;
    public void shuffle(boolean random)
    {
        Random dice;

        if (random)
            dice = new Random(System.currentTimeMillis()+incCnt++);
        else
            dice = new Random(42);

        // Knuth Band 2
        for (int i=0; i<array.length; i++)
        {
            int j = dice.nextInt(i+1);
			swapAtIndex(i,j);
		}
    }
    

    public boolean isSorted()
    {
        for (int i=0; i<array.length-1; i++)
            if (array[i] > array[i+1]) return false;
        return true;
    }


    public static void main(String[] args) {
            int[] test= new int[1000000];
            for(int i =0; i<1000000; i++ ){
                test[i]=i;
            }
            QuickSortDnfP sort = new QuickSortDnfP();
            sort.array = test;
            sort.shuffle(false);
            System.out.println(sort.isSorted());

            sort.quicksort();
            System.out.println(sort.isSorted());
   
            for(int i : sort.array){
                System.out.print(i + " ");
            }
            System.out.println(sort.isSorted() + " Time in ns : "+System.nanoTime());
    }
}