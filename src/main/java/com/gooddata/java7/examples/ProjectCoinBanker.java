/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gooddata.java7.examples.exceptions.AccountClosedException;
import com.gooddata.java7.examples.exceptions.AccountFrozenException;
import com.gooddata.java7.examples.exceptions.ComplianceViolationException;

public class ProjectCoinBanker {

    private static final Integer ONE_MILLION = 1_000_000;
    private static final String RICH_MSG = "You need more than $%,d to be considered rich.";
    private static final String AVERAGE_DAILY_BALANCE_QUERY = null;

    public static void main(String[] args) throws Exception {
        System.out.println(String.format(RICH_MSG, ONE_MILLION));

        String requestType = args[0];
        String accountId = args[1];
        switch (requestType) {
        case "displayBalance":
            printBalance(accountId);
            break;
        case "lastActivityDate":
            printLastActivityDate(accountId);
            break;
        case "amIRich":
            amIRich(accountId);
            break;
        case "lastTransactions":
            printLastTransactions(accountId, Integer.parseInt(args[2]));
            break;
        case "averageDailyBalance":
            printAverageDailyBalance(accountId);
            break;
        default:
            break;
        }
    }

    private static void printLastActivityDate(String accountId) {
        // TODO Auto-generated method stub

    }

    private static void printAverageDailyBalance(String accountId) {
        String sql = String.format(AVERAGE_DAILY_BALANCE_QUERY, accountId);
        Connection _conn = getConnection();
        try (PreparedStatement s = _conn .prepareStatement(sql); ResultSet rs = s.executeQuery();) {
            while (rs.next()) {
                // print the average daily balance results
            }
        } catch (SQLException e) {
            // handle exception, but no need for finally to close resources
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed exception message is " + t.getMessage());
            }
        }
    }

    private static Connection getConnection() {
        return null;
    }

    private static void printLastTransactions(String accountId, int numberOfTransactions) {
        @SuppressWarnings({ "unused", "rawtypes" })
        List transactions = new ArrayList<>();
        // ... handle fetching/printing transactions
    }

    private static void printBalance(String accountId) {
        try {
            BigDecimal balance = getBalance(accountId);
            System.out.println(balance);
        } catch (AccountFrozenException | ComplianceViolationException | AccountClosedException e) {
            System.err.println("Please see your local branch for help with your account.");
        }
    }

    private static void amIRich(String accountId) {
        try {
            @SuppressWarnings("unused")
            BigDecimal balance = getBalance(accountId);
            // find out if the account holder is rich
        } catch (AccountFrozenException | ComplianceViolationException | AccountClosedException e) {
            System.out.println("Please see your local branch for help with your account.");
        }
    }

    private static BigDecimal getBalance(String acccountId) throws AccountFrozenException, AccountClosedException, ComplianceViolationException {
        // ... getBalance functionality
        return null;
    }

}