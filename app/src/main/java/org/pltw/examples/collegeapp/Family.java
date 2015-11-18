package org.pltw.examples.collegeapp;


import java.util.ArrayList;

public class Family {
    private static Family sFamily;
    ArrayList<FamilyMember> mFamily;
    private Family(){
        mFamily.add(new Guardian());
        mFamily.add(new Guardian("Has", "Trouble"));

    }
    public static Family makeFamily(){
        if (sFamily == null) {
            sFamily = new Family();
        }
        return sFamily;
    }
    public ArrayList<FamilyMember> returnFamilyArray(){
        return mFamily;
    }
    public void AddTomFamily(FamilyMember additive){
        mFamily.add(additive);
    }
    public void removeFrommFamily(FamilyMember removethis){
        int index = mFamily.indexOf(removethis);
        mFamily.remove(index);
    }
    public FamilyMember getSpecifcFamilyMember(int indexToRetrieve){
        return mFamily.get(indexToRetrieve);
    }
}
