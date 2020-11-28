package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        int size = 0;
        Integer occur = 0;

        if(maxNumberOfDuplications == 1 || maxNumberOfDuplications == 0){
            return new Integer[]{};
        }

        for(Integer i : array){
            occur = getNumOfOccurances(i);
            if(occur < maxNumberOfDuplications){
                size++;
            }
        }

        if(size == 0){
            return new Integer[]{};
        }

        Integer[] newArr = new Integer[size];
        int index = 0;

        for(Integer i : array){
            if(getNumOfOccurances(i) < maxNumberOfDuplications){
                newArr[index] = i;
                index++;
            }
        }
        return newArr;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int size = 0;

        for(Integer i : array){
            if(!getNumOfOccurances(i).equals(exactNumberOfDuplications)){
                size++;
            }
        }

        int index = 0;
        Integer[] newArr = new Integer[size];

        for(Integer i : array) {
            if(!getNumOfOccurances(i).equals(exactNumberOfDuplications)) {
                newArr[index] = i;
                index++;
            }
        }

        return newArr;
    }

    public Integer getNumOfOccurances(Integer num){
        Integer counter = 0;
        for(Integer i : array){
            if(i.equals(num)){
                counter++;
            }
        }
        return counter;
    }
}
