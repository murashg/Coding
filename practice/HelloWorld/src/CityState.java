import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CityState {


    static String ParseCityState(String hyphenatedCityState) {
        //  @param - "city-state"
        //  @return - "city, state"
        // alg -
        //  1) go through string first looking for city
        //  2) when hyphen is found look for city
        //  3) if is valid city then the rest of the string will be the state
        //  4) remove hyphens then take the two substrings and return then formatted correctly

        String possible;
        String validCity = "";
        String validState = "";
        boolean cityStateFound = false;
        boolean cityFound = false;
        String[] words = hyphenatedCityState.split("-");
        List<String> combination = new ArrayList<String>();
        int cityIndex = 0;
        int comboLen;
        int k = 0;
        if (ValidateCity(words[0])) {
            cityFound = true;
            validCity = words[0];
        } else {

            combination.add(words[0]);
            for (int i = 1; i < words.length; i++) {
                comboLen = combination.size();
                for (int j = k; j < comboLen; j++) {
                        if (ValidateCity(combination.get(j) + " " + words[i])) {
                            validCity = combination.get(j) + " " + words[i];
                            cityFound = true;
                            cityIndex = i;
                            break;

                        }
                        if (ValidateCity(combination.get(j) + "-" + words[i])) {
                            validCity = combination.get(j) + "-" + words[i];
                            cityFound = true;
                            cityIndex = i;
                            break;


                        }

                    combination.add(combination.get(j) + " " + words[i]);
                    combination.add(combination.get(j) + "-" + words[i]);
                }

                    k += (2 * i) - i;

            }
        }

        if (!cityFound) return "invalid input";

        if (ValidateState(words[words.length-1])) {
            validState = words[words.length-1];
            cityStateFound = true;
        }else{
            combination.add(words[words.length-1]);
            for (int i = words.length-2; i > cityIndex; i--) {
                comboLen = combination.size();
                for (int j = k; j < comboLen; j++) {
                        if (ValidateState(words[i]+ " "+combination.get(j))) {
                            validState = words[i] + " " + combination.get(j);
                            cityStateFound = true;
                            break;
                        }
                    if (ValidateState(words[i]+ "-"+combination.get(j))){
                        validState = words[i] + "-" + combination.get(j);
                        cityStateFound = true;
                        break;
                    }


                    combination.add(combination.get(j) + " " + words[i]);
                    combination.add(combination.get(j) + "-" + words[i]);
                }
                k += (2 * i) - i;
            }
        }


/*
        //String possible;
        String validCity = "";
        String validState = "";
        boolean cityStateFound = false;
        int len = hyphenatedCityState.length();
        hyphenatedCityState = hyphenatedCityState.replace('-',' ');
        for (int i = 0; i < len; i++){
            if (hyphenatedCityState.charAt(i) == ' '){
                possible = hyphenatedCityState.substring(0, i);
                if (ValidateCity(possible)){
                    validCity = possible;
                    possible = hyphenatedCityState.substring(i + 1);
                    if (!ValidateState(possible)) {
                        return "invalid input";
                    }else{
                        validState = possible;
                        cityStateFound = true;
                        break;
                    }
                }
            }
        }
*/
        if (!cityStateFound) return "invalid input";

        return validCity + ", " + validState;

    }
    /*
     * you can add cases here if you wish.  We've already put in the full list of united states for ValidateState()
     */
    static void addUserDefinedTestCities()
    {
        addValidCity("Portland");
        addValidCity("Seattle");
        addValidCity("New York");
        addValidCity("Winston-Salem");
        addValidCity("Minneapolis-Saint Paul");
        //add any other test cities you like
    }

    static void addValidCity(String city)
    {
        m_sourceData.Cities.add(city.toLowerCase());
    }
    static boolean ValidateState(String state)
    {
        //this is the full list of all 50 united stats plus district of columbia
        return false;
    }

    /// <summary>
    /// checks the list of valid cities. not case-sensitive
    /// </summary>
    static boolean ValidateCity(String city)
    {
        //this is a list of city names including those given in the problem statement and examples
        return false;
    }

    private class ValidationData { public HashSet<String> States;  public HashSet<String> Cities; }
    static ValidationData m_sourceData;

    /*static void DeserializeData() {
        String jsonString = "{\"States\": [\"alabama\", \"alaska\", \"arizona\", \"arkansas\", \"california\", \"colorado\", \"connecticut\", \"delaware\", \"district of columbia\", \"florida\", \"georgia\", \"hawaii\", \"idaho\", \"illinois\", \"indiana\", \"iowa\", \"kansas\", \"kentucky\", \"louisiana\", \"maine\", \"maryland\", \"massachusetts\", \"michigan\", \"minnesota\", \"mississippi\", \"missouri\", \"montana\", \"nebraska\", \"nevada\", \"new hampshire\", \"new jersey\", \"new mexico\", \"new york\", \"north carolina\", \"north dakota\", \"ohio\", \"oklahoma\", \"oregon\", \"pennsylvania\", \"rhode island\", \"south carolina\", \"south dakota\", \"tennessee\", \"texas\", \"utah\", \"vermont\", \"virginia\", \"washington\", \"west virginia\", \"wisconsin\", \"wyoming\"],\"Cities\": [\"george\", \"george west\", \"highland park\", \"new york\", \"portland\", \"san francisco\", \"holly view forest\", \"holly view forest-highland park\", \"minneapolis-saint paul\", \"west\", \"winston-salem\", \"y\", \"carmel-by-the-sea\"]}";
        JSONObject json;
        try {
            json = (JSONObject)new JSONParser().parse(jsonString);
        } catch (ParseException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
            return;
        }
        JSONArray citiesJson = (JSONArray)json.get("Cities");
        JSONArray statesJson = 	(JSONArray)json.get("States");

        m_sourceData = new CityState().new ValidationData();
        m_sourceData.Cities = new HashSet<String>(citiesJson);
        m_sourceData.States = new HashSet<String>(statesJson);
    }*/

    static void Output(String output) {
        String fileName = System.getenv().get("OUTPUT_PATH");
        PrintWriter tw = null;

        try {
            tw = new PrintWriter(fileName);
            tw.println(output);
            tw.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static String GetUserInput() {
        InputStreamReader sr =new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(sr);
        String inputData;
        try {
            inputData = br.readLine();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            return null;
        }
        return inputData;
    }

    public static void main(String[] args) {
        //DeserializeData();
        String inputData = "New-York-New-York";
        //addUserDefinedTestCities();
        String res = ParseCityState(inputData);
        Output(res);
    }
}