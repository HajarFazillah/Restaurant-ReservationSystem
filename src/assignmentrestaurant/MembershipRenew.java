package assignmentrestaurant;

import java.util.*;

    public class MembershipRenew {
        private int memberID;
        private String name,address,contact;

    public MembershipRenew(int i,String n,String a,String c) {
       memberID = i;
       name = n;
       address = a;
       contact = c;
    }
    
    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int i) {
        memberID = i;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String a) {
        address = a;
    }
    
    public String getContact() {
        return contact;
    }

    public void setContact(String c) {
        contact = c;
    }
  
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return String.format("%s\n%s\n%s\n%s",memberID,name,address, contact);
    }
    
    public boolean search(int i ){
        return getMemberID() == i;
    }
    
}