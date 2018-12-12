/*
Credit https://stackoverflow.com/questions/5849154/can-we-write-our-own-iterator-in-java

making our own Iterator in Java

This class implements the Iterable interface using Generics. Considering you have elements to the array, you will be able to get an instance of an Iterator, which is the needed instance used by the "foreach" loop, for instance.

*/

import java.util.Iterator;

public class SOList<Type> implements Iterable<Type> {

    private Type[] arrayList;
    private int currentSize;

    public SOList(Type[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
    }

    @Override
    public Iterator<Type> iterator() {
        Iterator<Type> it = new Iterator<Type>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public Type next() {
                return arrayList[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
/*
You can just create an anonymous instance of the iterator without creating extending Iterator and take advantage of the value of currentSize to verify up to where you can navigate over the array (let's say you created an array with capacity of 10, but you have only 2 elements at 0 and 1). The instance will have its owner counter of where it is and all you need to do is to play with hasNext(), which verifies if the current value is not null, and the next(), which will return the instance of your currentIndex. Below is an example of using this API...
*/
public static void main(String[] args) {
    // create an array of type Integer
    Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};

    // create your list and hold the values.
    SOList<Integer> stackOverflowList = new SOList<Integer>(numbers);

    // Since our class SOList is an instance of Iterable, then we can use it on a foreach loop
    for(Integer num : stackOverflowList) {
        System.out.print(num);
    }

    // creating an array of Strings
    String[] languages = new String[]{"C", "C++", "Java", "Python", "Scala"};

    // create your list and hold the values using the same list implementation.
    SOList<String> languagesList = new SOList<String>(languages);

    System.out.println("");
    // Since our class SOList is an instance of Iterable, then we can use it on a foreach loop
    for(String lang : languagesList) {
        System.out.println(lang);
    }
}

/*
f you want, you can iterate over it as well using the Iterator instance:

*/
// navigating the iterator
while (allNumbers.hasNext()) {
    Integer value = allNumbers.next();
    if (allNumbers.hasNext()) {
        System.out.print(value + ", ");
    } else {
        System.out.print(value);
    }
}
// will print 1, 2, 3, 4, 5
