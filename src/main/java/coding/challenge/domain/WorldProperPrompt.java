package coding.challenge.domain;

import lombok.Data;

@Data
public class WorldProperPrompt {
   private int allElements;
    String term;
    String columnSearch;
    boolean matchCase = false;
    int elementsAfterSearch;
    String properString;

    public String properPrompt() {
        properString = "Showing " + elementsAfterSearch + " of " + allElements + " customers filtered by term \"" + term + "\" in " + columnSearch + " column";
        if (matchCase)
            properString += " with match case.";
        else properString += " without match case.";

        return properString;
    }


}
