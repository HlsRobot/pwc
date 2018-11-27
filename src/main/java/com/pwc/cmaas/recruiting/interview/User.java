package com.pwc.cmaas.recruiting.interview;

//create new file User that does not need to be static
public class User {
    //change the public to private
    public String name;
    public String birth;
    public Integer salary;
    public String department;
    public String role;

    // no need for default parameter since it is not used
    public User() {
    }

    public User(String name, String birth, Integer salary,
                String department) {
        // it does not extend anything to super()
        super();
        this.name = name;
        this.birth = birth;
        this.salary = salary;
        this.department = department;
    //no need of ;
    };

    //normally needs to be overridden
    public String toString() {
        return name + " " + birth + " " + department + " " + salary + " "
                + role;
    }
}
