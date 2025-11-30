package JDBC_Hibernate.Intro.DAO.dao;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        }catch (ClassNotFoundException e){
            System.out.println("Not found class mySql");
        }
    }

    public static synchronized DaoFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public CarDAO getCarDAO(){
        return new ServiceCar();
    }
}
