package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        int size = 0;
        Integer occur = 0;

        if(maxNumberOfDuplications == 1 || maxNumberOfDuplications == 0){
            return new String[]{};
        }

        for(String s : array){
            occur = getNumOfOccurances(s);
            if(occur < maxNumberOfDuplications){
                size++;
            }
        }

        if(size == 0){
            return new String[]{};
        }

        String[] newArr = new String[size];
        int index = 0;

        for(String s : array){
            occur = getNumOfOccurances(s);
            if(occur < maxNumberOfDuplications){
                newArr[index] = s;
                index++;
            }
        }
        return newArr;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int size = 0;

        for(String s : array){
            if(!getNumOfOccurances(s).equals(exactNumberOfDuplications)){
                size++;
            }
        }

        int index = 0;
        String[] newArr = new String[size];

        for(String s : array) {
            if(!getNumOfOccurances(s).equals(exactNumberOfDuplications)) {
                newArr[index] = s;
                index++;
            }
        }

        return newArr;
    }

    public Integer getNumOfOccurances(String string){
        Integer counter = 0;
        for(String s : array){
            if(s.equals(string)){
                counter++;
            }
        }
        return counter;
    }
}
