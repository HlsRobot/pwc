package com.pwc.cmaas.recruiting.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Takes as a first argument a name of an executive and prints out which users work under
 * him and what their departments, salaries and roles are.
 *
 * It collects data from several tables, correlates different user types by name and fills in 
 * the blanks if a user has missing information on a table.
 * Students don't get a salary even if they have other roles with values in their salary 
 * field.
 *
 * Read the codebase and understand it.
 *
 * Things to think about:
 * - Is this good code?
 * - Is the output of the application suited for an executive tool?
 * - How would you test this code?
 * - Is the code intuitive?
 * - Are there things that should be refactored?
 * - Are there error cases that must be dealt with?
 *
 */
public class Application {

    // could be on its own file
    public static void main(final String[] args) {
        if (args.length > 0) {
            new Application().runLogic(args[0]);
        } else {
            System.out.println("provide arguments");
        }
    }

//    // can be enum with better naming
    public final String TYPE_ONE = "1";
    public final String TYPE_TWO = "2";
    public final String TYPE_TRE = "3";
    public final String TYPE_FUR = "4";
//
    // no need to be public
    private void runLogic(final String executive) {
        String sql = "Select name, birth, dept FROM users WHERE  supervisor='"
            + executive + "';";
        // use better variable naming

        final SqlRequest sqlRequest = new SqlRequest("sql://users.db/users");
        Users managers = sqlRequest.execute(sql, Type.TYPE_ONE);

        for (User manager : managers) {
            // can be replaced with a local variable
            String where = this.addWhereFilter(manager);
            Users testers = sqlRequest.execute("Select name, birth, dept FROM users" + where, Type.TYPE_TWO);
            Users developers = sqlRequest.execute("Select name, birth, dept FROM users" + where, Type.TYPE_TRE);
            Users students = sqlRequest.execute("Select name, birth, dept FROM users" + where, Type.TYPE_FUR);

            System.out.print("\n\n\n");
            System.out.println("Manager " + manager.name + " " + manager.salary + " (" + manager.department + ")  manages:");

            Map<String, User> persons = new HashMap<String, User>();
            testers.forEach(tester -> this.checkForDuplicatesAndPut("Tester", persons, tester));
            developers.forEach(developer -> this.checkForDuplicatesAndPut("Developer", persons, developer));
            students.forEach(student -> {
                this.checkForDuplicatesAndPut("Student", persons, student);
                persons.get(student.name).salary = 0;
            });

            System.out.print("\n\n");

            for (User person : persons.values()) {
                if (person.department.matches(".*" + manager.department + ".*"))
                    System.out.println(person);
            }

            System.out.print("\n\n\n\n");
        }
    }

    private String addWhereFilter(final User user) {
        // can be done in one line or with a stringBuilder
       return " WHERE supervisor='" + user.name + "'";
    }

    private void checkForDuplicatesAndPut(final String role, final Map<String, User> persons, final User person) {
        person.role = role;
        User existing = persons.get(person.name);
        if (existing == null) {
            persons.put(person.name, person);
        } else {
            mergeUser(person, existing);
        }
    }

    // Merges information from User firstUser into user secondUser
    private void mergeUser(final User firstUser, final User secondUser) {
        System.out.println("LOG: Merging: " + firstUser + " into: " + secondUser + " ");
        if (firstUser.name != null) {secondUser.name = firstUser.name;}
        if (firstUser.birth != null) {secondUser.birth = firstUser.birth;}
        secondUser.salary += firstUser.salary;
        secondUser.role += " " + firstUser.role;
        if (!secondUser.department.equals(firstUser.department)) {
            secondUser.department += " " + firstUser.department;
        }
    }
}
