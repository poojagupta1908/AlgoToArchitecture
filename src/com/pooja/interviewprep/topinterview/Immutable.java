package com.pooja.interviewprep.topinterview;

import java.util.Date;

public class Immutable {

    public static void main(String[] args) {
        Date date = new Date();
        ImmutablePerson person = new ImmutablePerson(
                "Pooja",
                30,
                date
        );

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Joining Date: " + person.getJoiningDate());

        // Try to modify original Date
        date.setTime(0);

        System.out.println("After modifying original Date:");
        System.out.println("Joining Date from object: " +
                person.getJoiningDate());

        // Try to modify via getter
        Date fetchedDate = person.getJoiningDate();
        fetchedDate.setTime(0);

        System.out.println("\nAfter modifying fetched Date:");
        System.out.println("Joining Date from object: " +
                person.getJoiningDate());
    }
}

final class ImmutablePerson{

    private final String name;
    private final int age;
    private final Date joiningDate;

    //1.class final
    //2.instance variables final
    //3.no setters
    //4.Return deep copies of mutable objects (if any) instead of original references in constructor
    //5.Return a new copy, not the original in getter

    public ImmutablePerson(String name,int age,Date joiningDate){
        this.name=name;
        this.age=age;
        this.joiningDate=new Date(joiningDate.getTime());

    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public Date getJoiningDate(){
        return new Date(joiningDate.getTime());
    }

}
