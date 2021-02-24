package org.dao;

import org.entities.Report;
import org.idao.IDaoReport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO extends GenericDAO implements IDaoReport {

    public ReportDAO() {

    }

    public void add(Report report) {
        try {
            String queryString = "INSERT INTO reports(report_id, init_id, description, implem_end_date, end_budget) VALUES(?,?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, report.getIdentifier());
            ptmt.setInt(2, report.getInit_id());
            ptmt.setString(3, report.getDescription());
            ptmt.setDate(4, report.getImplem_end_date());
            ptmt.setInt(5, report.getEnd_budget());
            ptmt.executeUpdate();
            System.out.println("Data Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void delete(int id) {
        try {
            String queryString = "DELETE FROM reports WHERE report_id=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, id);
            ptmt.executeUpdate();
            System.out.println("Data deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public List<Report> findAll() {
        List<Report> reportList = new ArrayList<>();

        try {
            String queryString = "SELECT * FROM reports";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Report report = new Report();

                report.setIdentifier(resultSet.getInt("report_id"));
                report.setInit_id(resultSet.getInt("init_id"));
                report.setDescription(resultSet.getString("description"));
                report.setImplem_end_date(resultSet.getDate("implem_end_date"));
                report.setEnd_budget(resultSet.getInt("end_budget"));

                reportList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return reportList;
    }
}
