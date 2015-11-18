package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by wdumas on 2/11/2015.
 */
public class Guardian extends FamilyMember {
    private String mOccupation;


    public Guardian(){
        super();
        setFirstName("Roger");
        setLastName("Dumas");
    }

    public Guardian(String firstName, String lastName) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
    }

    public Guardian(JSONObject json) throws JSONException {
        mFirstName = json.getString(JSON_FIRST_NAME);
        mLastName = json.getString(JSON_LAST_NAME);
    }
    public String getOccupation() {
        return mOccupation;
    }

    public void setOccupation(String occupation) {
        mOccupation = occupation;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_FIRST_NAME, mFirstName);
        json.put(JSON_LAST_NAME, mLastName);
        return json;
    }
}
