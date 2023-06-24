/**
 * Created By Krishna Shinde
 * Date : 24-06-2023
 * Time : 19:11
 * Project: OneToOneMappingRelational
 **/

package com.mahagan.onetoonemappingrelational.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Pancard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pancard_Id;
    private String agency;
    private String issue_Date;

    @OneToOne(mappedBy = "pancard")
    @Cascade(value = CascadeType.ALL)
    private Person person;

    public int getPancard_Id() {
        return pancard_Id;
    }

    public void setPancard_Id(int pancard_Id) {
        this.pancard_Id = pancard_Id;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getIssue_Date() {
        return issue_Date;
    }

    public void setIssue_Date(String issue_Date) {
        this.issue_Date = issue_Date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}


