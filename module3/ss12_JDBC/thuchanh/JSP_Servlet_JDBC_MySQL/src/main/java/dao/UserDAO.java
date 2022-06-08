package dao;

import model.bean.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/jdbc";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Ntrunghieu27";


    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";
    private static final String SET_ID = "select * from users where name = ? and email = ? and address = ?;";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String DELETE_TRUNCATE_TABLE = "truncate table users";
    private static final String SEARCH_BY_COUNTRY = "select * from users where country like ? ;";
    private static final String SORT_USERS_SQL_NAME = "select * from users order by name ASC;";
    private static final String SORT_USERS_SQL_EMAIL = "select * from users order by email ASC;";
    private static final String SORT_USERS_SQL_COUNTRY = "select * from users order by country ASC;";
    private static final String SQL_INSERT = "INSERT INTO employee (name, salary, created_date) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE employee SET salary=? WHERE name=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE employee"

            + "("

            + " id serial,"

            + " name varchar(100) NOT NULL,"

            + " salary numeric(15, 2) NOT NULL,"

            + " created_date timestamp,"

            + " PRIMARY KEY (id)"

            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS employee";

    public UserDAO() {
    }

    protected Connection getConnect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);Statement statement = connection.createStatement();) {
//            statement.execute(DELETE_TRUNCATE_TABLE);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> selectAllUsers() {

        List<User> usersList = new ArrayList<>();
        try (Connection connection = getConnect();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//            statement.execute(DELETE_TRUNCATE_TABLE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                usersList.add(new User(id, name, email, country));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usersList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnect(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;


        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnect(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public User accountUser(String name, String email, String country) {
        try (Connection connection = getConnect(); PreparedStatement ps = connection.prepareStatement(DELETE_TRUNCATE_TABLE);) {
            ps.setString(1, null);
            ps.setString(2, null);
            ps.setString(3, null);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException x) {
            x.printStackTrace();
        }

        return null;
    }

    @Override
    public User getById(int id) {
        User user = null;
        String query = "{call get_user_by_id(?)}";
        try (Connection connection = getConnect(); CallableStatement
                callableStatement = connection.prepareCall(query)) {

            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                user = new User(id, name, email, country);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> searByCountry(String nameCountry) {
        List<User> userList = new ArrayList<>();
        //cach 1
        try (Connection connection = getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_COUNTRY)) {
            preparedStatement.setString(1, "%" + nameCountry + "%");
            System.out.println(SEARCH_BY_COUNTRY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                userList.add(new User(id, name, email, country));
            }
            connection.close();
        } catch (SQLException x) {
            x.printStackTrace();
        }
//cach2
//        for (User user: userList1) {
//            if (user.getCountry().toLowerCase().contains(nameCountry)){
//                userList1.add(user);
//            }
//        }
        return userList;
    }

    @Override
    public List<User> sortListUser(String sortType) {
        List<User> users = new ArrayList<>();
        User user = null;
        switch (sortType) {
            case "name":
                try (Connection connection = getConnect();
                     PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_SQL_NAME);) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        String country = resultSet.getString("country");
                        user = new User(id, name, email, country);
                        users.add(user);
                    }
//                    return users;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

            case "email":
                try (Connection connection = getConnect();
                     PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_SQL_EMAIL);) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        String country = resultSet.getString("country");
                        user = new User(id, name, email, country);
//                        users.add(user);
                    }
                    return users;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

            case "country":
                try (Connection connection = getConnect();
                     PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_SQL_COUNTRY);) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        String country = resultSet.getString("country");
                        user = new User(id, name, email, country);
                        users.add(user);
                    }
//                    return users;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
        return users;
    }

    @Override
    public void addUserTransaction(User user, int[] permissions) {
        Connection conn = null;

        // for insert a new user

        PreparedStatement pstmt = null;

        // for assign permision to user

        PreparedStatement pstmtAssignment = null;

        // for getting user id

        ResultSet rs = null;
        try {
            conn = getConnect();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();

            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt(1);
            }
            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_Permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);
                for (int permisionId : permissions) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permisionId);

                    pstmtAssignment.executeUpdate();

                }

                conn.commit();
            } else {
                conn.rollback();
            }


        } catch (SQLException throwables) {
            try {

                if (conn != null)

                    conn.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(throwables.getMessage());
        }finally {

            try {

                if (rs != null){
                    rs.close();
                }

                if (pstmt != null){
                    pstmt.close();
                }

                if (pstmtAssignment != null){
                    pstmtAssignment.close();
                }

                if (conn != null){
                    conn.close();
                }

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }
    }

    @Override
    public User setIdUser(String name, String email, String address) {
        try (Connection connection = getConnect(); PreparedStatement ps = connection.prepareStatement(SET_ID);) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                return new User(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException x) {
            x.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertUpdateWithoutTransaction() {

        try (Connection conn = getConnect();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {



            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);



            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();



            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();



            // Run list of update commands



            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.

            psUpdate.setBigDecimal(2, new BigDecimal(999.99));



            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();



        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void insertUpdateUseTransaction() {
        try (Connection conn = getConnect();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {

            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);

            // start transaction block

            conn.setAutoCommit(false); // default true

            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();



            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();



            // Run list of update commands



            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.

            //psUpdate.setBigDecimal(2, new BigDecimal(999.99));

            psUpdate.setBigDecimal(1, new BigDecimal(999.99));



            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();



            // end transaction block, commit changes

            conn.commit();

            // good practice to set it back to default true

            conn.setAutoCommit(true);



        } catch (Exception e) {

            System.out.println(e.getMessage());

            e.printStackTrace();

        }

    }
}
