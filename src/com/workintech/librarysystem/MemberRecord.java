package com.workintech.librarysystem;

import java.time.LocalDate;
import java.util.LinkedHashMap;

public class MemberRecord {


    private LinkedHashMap<Long,Member> members = new LinkedHashMap<>();

    public void addNewMember(Member member) {
        members.put(member.getMemberID(),member);
    }
    public void removeMember(Long id) {
        members.remove(id);
    }
    public Member getMember(Long id){
      return members.get(id);

    }


}
