package com.pwc.cmaas.recruiting.interview.outofscope;

import com.pwc.cmaas.recruiting.interview.Application;
import com.pwc.cmaas.recruiting.interview.User;
import com.pwc.cmaas.recruiting.interview.Users;

/***
 * 
 * 
 *               THIS CLASS IS OUT OF SCOPE FOR THIS EXCERSIZE!
 * 
 * 
 */
public class OutOfScopeSqlMock {

    public static <T> T execute(String type, String sql, Class<T> returntype) {
        Application app = new Application();

        if (type.equals(app.TYPE_ONE)) { // Mgrs

            return returntype.cast(new Users() {
                private static final long serialVersionUID = 1L;

                {
                    add(new User("Adam", "01.05.1980", 85000, "Marketing"));
                    add(new User("Bob", "21.06.1977", 105000, "R&D"));
                    add(new User("Aubrey", "09.01.1978", 127000, "Sales"));
                    add(new User("Liam", "21.06.1987", 163000, "Engineering"));
                }
            });
        } else if (type.equals(app.TYPE_TWO)) { // Tests

            return returntype.cast(new Users() {
                private static final long serialVersionUID = 1L;

                {
                    add(new User("Thomas", "01.05.1980", 40000, "Engineering"));
                    add(new User("Erik", "17.11.1983", 40000, "Engineering"));
                    add(new User("Sinclair", "21.06.1977", 50000, "R&D"));
                    add(new User("Ulf", null, 150000, "R&D"));
                }
            });
        } else if (type.equals(app.TYPE_TRE)) { // Devs

            return returntype.cast(new Users() {
                private static final long serialVersionUID = 1L;

                {
                    add(new User("Emil", "07.08.1993", 140000, "Engineering"));
                    add(new User("Eduard", "22.10.1984", 90000, "Engineering"));
                    add(new User("Rolf", "01.05.1980", 100000, "R&D"));
                    add(new User("Ulf", "21.06.1977", 150000, "R&D"));
                    add(new User("Dimi", "09.01.1978", 127000, "Engineering"));
                    add(new User("Omri", "21.06.1987", 63000, "Engineering"));
                    add(new User("Stanton", "09.01.1990", 80000, "Sales"));
                    add(new User("Clint", "31.01.1999", 74000, "Engineering"));
                    add(new User("Sam", "27.05.1981", 63000, "Sales"));
                    add(new User("Sam", "27.05.1981", 63000, "Marketing"));
                }
            });
        } else if (type.equals(app.TYPE_FUR)) { // Studs

            return returntype.cast(new Users() {
                private static final long serialVersionUID = 1L;

                {
                    add(new User("Sandra", "29.03.1998", 0, "Marketing"));
                    add(new User("Venice", "11.07.1993", 0, "R&D"));
                    add(new User("Stanton", "09.01.1990", 0, "Sales"));
                    add(new User("Clint", "31.01.1999", 0, "Engineering"));
                    add(new User("Vatican", "13.06.2000", 0, "Engineering"));
                }
            });
        }

        return null;
    }
}
