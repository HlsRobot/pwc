package com.pwc.cmaas.recruiting.interview;

import com.pwc.cmaas.recruiting.interview.outofscope.OutOfScopeSqlMock;

public class SqlRequest {
    // bad naming
    final private String connStr;

    public SqlRequest(final String connStr) {
        this.connStr = connStr;
        System.out.println("LOG: Created a connection to DB "
            + this.connStr + "!");
    }

    // can be package-private
    Users execute(String sql, final Type type) throws RuntimeException {

        //replace with switch case
        switch (type) {
            case TYPE_ONE:
                this.prepareSql(sql, "Manager");
                break;
            case TYPE_TWO:
                this.prepareSql(sql, "Tester");
                break;
            case TYPE_TRE:
                this.prepareSql(sql, "Dev");
                break;
            default:
                this.prepareSql(sql, "Student");
                break;
        }

        ///////////////////////////////////////////////////////////////////////////////////////////
        //
        // The scope of this exercise ends here!
        //
        //
        //
        // Assume that this actually does IO now by reaching out to an SQL DB over
        // the network and parses the response
        //
        ///////////////////////////////////////////////////////////////////////////////////////////

        return OutOfScopeSqlMock.execute(type.getTypeNum(), sql, Users.class);
    }

    private void prepareSql(String sql, final String role) {
        sql += "WHERE role = " + role;
        System.out.println("LOG: SELECTING " + sql);
    }
}
