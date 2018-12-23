/* Greg Murashige

For this problem, we have  types of queries you can perform on a List:

Insert  at index :

Insert
x y
Delete the element at index :

Delete
x
Given a list, , of  integers, perform  queries on the list. Once all queries are completed, print the modified list as a single line of space-separated integers.

Input Format

The first line contains an integer,  (the initial number of elements in ).
The second line contains  space-separated integers describing .
The third line contains an integer,  (the number of queries).
The  subsequent lines describe the queries, and each query is described over two lines:

If the first line of a query contains the String Insert, then the second line contains two space separated integers , and the value  must be inserted into  at index .
If the first line of a query contains the String Delete, then the second line contains index , whose element must be deleted from .
Constraints



Each element in is a 32-bit integer.
Output Format

Print the updated list  as a single line of space-separated integers.
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        //initialize scanner
        Scanner scan = new Scanner(System.in);

        //create list
        int n = scan.nextInt();//size of list
        List<Integer> data = new ArrayList<Integer>(n); //initialize list of data
        while (n-- > 0){ //loop through input n times
            try{
                data.add(scan.nextInt()); //add element to list
            }catch (Exception e){
                System.out.println("There was an error initializing data list");
            }
        }

        //Query class to store queries
        class Query{
            private String type;
            private int value;
            private int position;

            public Query(){}

            public Query(String type, int value, int position){
                this.type = type;
                this.value = value;
                this.position = value;
            }
            public void setType(String s){
                this.type = s;
            }
            public void setValue(int v){
                this.value = v;
            }
            public void setPosition(int p){
                this.position = p;
            }
            public String getType(){
                return this.type;
            }
            public int getValue(){
                return this.value;
            }
            public int getPosition(){
                return this.position;
            }
        }

        int q = scan.nextInt(); //amount of queries
        List<Query> queries = new ArrayList<Query>(q); //initialize list of queries
        while (q-- > 0){ //loop through input q times
            Query query = new Query(); // initialize query
            try{
                query.setType(scan.next());
                query.setPosition(scan.nextInt());
                if (query.getType().equals("Insert")){
                    query.setValue(scan.nextInt());
                }
            }catch (Exception e){
                System.out.println("There was an error initializing queries");
            }
            queries.add(query); //add query to queries list
        }

        //do queries
        for (Query curQuery : queries){
            if (curQuery.getType().equals("Insert")){
                data.add(curQuery.getPosition(), curQuery.getValue());
            }else if (curQuery.getType().equals("Delete")){
                data.remove(curQuery.getPosition());
            }else {
                System.out.println("Query had a type other than Insert or Delete");
            }
        }


        //output final list
        scan.close(); //close scanner

        for (Integer i : data){
            System.out.print((int) i + " ");
        }
    }
}
