/**
 * Created By Krishna Shinde
 * Date : 24-06-2023
 * Time : 19:11
 * Project: OneToOneMappingRelational
 **/

package com.mahagan.onetoonemappingrelational.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Person {
    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name="gen",strategy = "foreign",parameters = {@org.hibernate.annotations.Parameter(name = "property",value = "pancard")})
    private int person_Id;
    private String person_Name;
    private String birth_Date;
    private String address;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Pancard pancard;

    public int getPerson_Id() {
        return person_Id;
    }

    public void setPerson_Id(int person_Id) {
        this.person_Id = person_Id;
    }

    public String getPerson_Name() {
        return person_Name;
    }

    public void setPerson_Name(String person_Name) {
        this.person_Name = person_Name;
    }

    public String getBirth_Date() {
        return birth_Date;
    }

    public void setBirth_Date(String birth_Date) {
        this.birth_Date = birth_Date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Pancard getPancard() {
        return pancard;
    }

    public void setPancard(Pancard pancard) {
        this.pancard = pancard;
    }
}


