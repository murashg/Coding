/*
Credit https://stackoverflow.com/questions/1474954/working-with-a-list-of-lists-in-java
I recommend using "List" instead of "ArrayList" on the left side when creating list objects. It's better to pass around the interface "List" because then if later you need to change to using something like Vector (e.g. you now need synchronized lists), you only need to change the line with the "new" statement. No matter what implementation of list you use, e.g. Vector or ArrayList, you still always just pass around List<String>.

In the ArrayList constructor, you can leave the list empty and it will default to a certain size and then grow dynamically as needed. But if you know how big your list might be, you can sometimes save some performance. For instance, if you knew there were always going to be 500 lines in your file, then you could do:

List<List<String>> csvList = new ArrayList<List<String>>(500);


*/
import java.util.ArrayList;
import java.util.List;

public class ListExample
{
    public static void main(final String[] args)
    {
        //sample CSV strings...pretend they came from a file
        String[] csvStrings = new String[] {
                "abc,def,ghi,jkl,mno",
                "pqr,stu,vwx,yz",
                "123,345,678,90"
        };

        List<List<String>> csvList = new ArrayList<List<String>>();

        //pretend you're looping through lines in a file here
        for(String line : csvStrings)
        {
            String[] linePieces = line.split(",");
            List<String> csvPieces = new ArrayList<String>(linePieces.length);
            for(String piece : linePieces)
            {
                csvPieces.add(piece);
            }
            csvList.add(csvPieces);
        }

        //write the CSV back out to the console
        for(List<String> csv : csvList)
        {
            //dumb logic to place the commas correctly
            if(!csv.isEmpty())
            {
                System.out.print(csv.get(0));
                for(int i=1; i < csv.size(); i++)
                {
                    System.out.print("," + csv.get(i));
                }
            }
            System.out.print("\n");
        }
    }
}

/*

Iterating over list list

*/

Iterator<List<String>> iter = listOlist.iterator();
while(iter.hasNext()){
    Iterator<String> siter = iter.next().iterator();
    while(siter.hasNext()){
         String s = siter.next();
         System.out.println(s);
     }
}
