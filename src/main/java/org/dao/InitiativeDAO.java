package org.dao;

import org.entities.Initiative;
import org.entities.enums.InitiativeStatus;
import org.idao.IDaoInitiative;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InitiativeDAO extends GenericDAO implements IDaoInitiative {

    public InitiativeDAO() {

    }

    // addNew, add 'voting','implem','ended'
    public void add(Initiative initiative) {
        try {
            String queryString = "INSERT INTO initiatives(init_id, name, description, user_id, voting_days_left, implem_start_date, budget, votes_num, status) VALUES(?,?,?,?,?,?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, initiative.getIdentifier());
            ptmt.setString(2, initiative.getName());
            ptmt.setString(3, initiative.getDescription());
            ptmt.setInt(4, initiative.getUser_id());
            ptmt.setInt(5, initiative.getVoting_days_left());
            ptmt.setDate(6, initiative.getImplem_start_date());
            ptmt.setInt(7, initiative.getBudget());
            ptmt.setInt(8, initiative.getVotes_num());
            ptmt.setString(9, initiative.getStatus().name());
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

    @Override
    public void update() {
        try {
            String queryString = "UPDATE initiatives SET votes_num = (SELECT COUNT(*) FROM votes WHERE init_id=initiatives.init_id)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.executeUpdate();
            System.out.println("Data Updated Successfully");
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

    @Override
    public void addNew(Initiative initiative) {
        try {
            String queryString = "INSERT INTO initiatives(name, description, user_id, budget, votes_num, status) VALUES(?,?,?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, initiative.getName());
            ptmt.setString(2, initiative.getDescription());
            ptmt.setInt(3, initiative.getUser_id());
            ptmt.setInt(4, initiative.getBudget());
            ptmt.setInt(5, initiative.getVotes_num());
            ptmt.setString(6, initiative.getStatus().name());
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
            String queryString = "DELETE FROM initiatives WHERE init_id=?";
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


    public List<Initiative> findAll() {
        List<Initiative> initiativeList = new ArrayList<>();

        try {
            String queryString = "SELECT * FROM initiatives";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Initiative initiative = new Initiative();

                initiative.setIdentifier(resultSet.getInt("init_id"));
                initiative.setName(resultSet.getString("name"));
                initiative.setDescription(resultSet.getString("description"));
                initiative.setUser_id(resultSet.getInt("user_id"));
                initiative.setVoting_days_left(resultSet.getInt("voting_days_left"));
                initiative.setImplem_start_date(resultSet.getDate("implem_start_date"));
                initiative.setBudget(resultSet.getInt("budget"));
                initiative.setVotes_num(resultSet.getInt("votes_num"));
                initiative.setStatus(InitiativeStatus.valueOf(resultSet.getString("status")));

                initiativeList.add(initiative);
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
        return initiativeList;
    }
}
