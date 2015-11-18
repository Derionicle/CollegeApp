package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

public interface ApplicantData {

    public static final int PROFILE = 0;

    public JSONObject toJSON() throws JSONException;
}
