package org.dao;

import org.entities.Report;
import org.entities.Vote;
import org.idao.IDaoVote;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VoteDAO extends GenericDAO implements IDaoVote {

    public VoteDAO() {

    }

    public void add(Vote vote) {
        try {
            String queryString = "INSERT INTO votes(vote_id, init_id, user_id) VALUES(?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, vote.getIdentifier());
            ptmt.setInt(2, vote.getInit_id());
            ptmt.setInt(3, vote.getUser_id());
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
            String queryString = "DELETE FROM votes WHERE vote_id=?";
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


    public List<Vote> findAll() {
        List<Vote> voteList = new ArrayList<>();

        try {
            String queryString = "SELECT * FROM votes";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Vote vote = new Vote();

                vote.setIdentifier(resultSet.getInt("vote_id"));
                vote.setInit_id(resultSet.getInt("init_id"));
                vote.setUser_id(resultSet.getInt("user_id"));

                voteList.add(vote);
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
        return voteList;
    }
}
