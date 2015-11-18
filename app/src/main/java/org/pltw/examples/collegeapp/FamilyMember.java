package org.pltw.examples.collegeapp;


public abstract class FamilyMember implements ApplicantData{
    String mFirstName;
    String mLastName;
    static final String JSON_FIRST_NAME = "firstName";
    static final String JSON_LAST_NAME = "lastName";

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }
}
