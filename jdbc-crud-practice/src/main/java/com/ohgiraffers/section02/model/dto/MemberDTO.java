package com.ohgiraffers.section02.model.dto;

import java.lang.reflect.Member;
import java.util.Date;

public class MemberDTO {
    private String memberID;
    private String memberName;
    private Date memberDate;

    public MemberDTO (){}
    public MemberDTO(String memberID, String memberName, Date memberDate) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberDate = memberDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(Date memberDate) {
        this.memberDate = memberDate;
    }
}
