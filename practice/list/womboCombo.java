String validCity = "";
        String validState = "";
        boolean cityStateFound = false;
        boolean cityFound = false;
        String[] words = hyphenatedCityState.split("-"); //words is the list of words in the hyphenatedCityState string
        List<String> combination = new ArrayList<String>(); //list that holds different combinations of " " or "-" in states and cities
        int comboLen; //length of the combination
        int cityIndex = 0; //ending index for state loop
        int k = 0; //starting index for combination
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

        if (!cityFound)
            return "invalid input";

        k = 0;
        if (ValidateState(words[words.length - 1])) {
            validState = words[words.length - 1];
            cityStateFound = true;
        } else {
            combination.add(words[words.length - 1]);
            for (int i = words.length - 2; i > cityIndex; i--) {
                comboLen = combination.size();
                for (int j = k; j < comboLen; j++) {
                    if (ValidateState(words[i] + " " + combination.get(j))) {
                        validState = words[i] + " " + combination.get(j);
                        cityStateFound = true;
                        break;
                    }
                    if (ValidateState(words[i] + "-" + combination.get(j))) {
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

        if (!cityStateFound) return "invalid input";

        return validCity + ", " + validState;

    }
