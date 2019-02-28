package model;

import classes.Car;
import classes.CarBodyType;
import classes.CarShop;
import classes.Mechanic;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static jdk.nashorn.internal.objects.NativeMath.log;

public class CarDao {
    //Data Access Object - dostęp do danych z bazy

    public static boolean createEntity(CarEntity carEntity){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.saveOrUpdate(carEntity);

            transaction.commit();
            return true;
        }catch (HibernateException | RollbackException e){
            log(Level.SEVERE, "Error saving object.");
            if (transaction != null){
                transaction.rollback();
            }
        }

        return false;

    }

    public static <T> List<T> getAll(Class<T> tClass){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            String className = tClass.getSimpleName();
            Query<T> query = session.createQuery("from "+className+" s", tClass);
            List<T> objectList = query.list();
            return objectList;
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }

        return new ArrayList<>();
    }

    public static Car getById(Long id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            String className = Car.class.getSimpleName();
            Query<Car> query = session.createQuery("from "+className+" s where id = :id", Car.class);
            query.setParameter("id",id);

            Car car = query.getSingleResult();
            return car;
        }catch (NoResultException nre){
            log(Level.SEVERE, "No results");
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }
        return null;
    }

    public static Mechanic getByMechId(Long id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            String className = Mechanic.class.getSimpleName();
            Query<Mechanic> query = session.createQuery("from "+className+" s where id = :id", Mechanic.class);
            query.setParameter("id",id);

            Mechanic mechanic = query.getSingleResult();
            return mechanic;
        }catch (NoResultException nre){
            log(Level.SEVERE, "No results");
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }
        return null;
    }


    public static boolean changeCarParameters(Long id, String brand, String model, CarBodyType carBodyType, String color, long km){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Car car = CarDao.getById(id);

            if (car != null) {
                car.setBrand(brand);
                car.setModel(model);
                car.setCarBodyType(carBodyType);
                car.setColor(color);
                car.setKm(km);
                car.setModifiedDate(LocalDateTime.now());
            }

            session.saveOrUpdate(car);
            transaction.commit();
            return true;
        } catch (NoResultException nre) {
            log(Level.SEVERE, "No results.");
        } catch (HibernateException he) {
            log(Level.SEVERE, "Error loading objects.");
        }
        return false;
    }


    public static boolean deleteById(Long id){
        Car car = getById(id);

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(car);
                transaction.commit();
                return true;
            } catch (NoResultException nre) {
                log(Level.SEVERE, "No results");
            } catch (HibernateException he) {
                log(Level.SEVERE, "Error loading objects.");
            }

        return false;
    }

    public static <T> List<T> getAllsortedBy (Class<T> tClass){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            String className = tClass.getSimpleName();
            Query<T> query = session.createQuery("from "+className+" s", tClass);
            List<T> objectList = query.list();
            return objectList;
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }

        return new ArrayList<>();
    }


    public static Car getByBrand(String brand){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            String className = Car.class.getSimpleName();
            Query<Car> query = session.createQuery("from "+className+" s where brand = :brand", Car.class);
            query.setParameter("brand",brand);

            Car car = query.getSingleResult();
            return car;
        }catch (NoResultException nre){
            log(Level.SEVERE, "No results");
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }
        return null;
    }

    public static CarShop getByCarshopName(String carshopName){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            String className = CarShop.class.getSimpleName();
            Query<CarShop> query = session.createQuery("from "+className+" s where name = :name", CarShop.class);
            query.setParameter("name",carshopName);

            CarShop carShop = query.getSingleResult();
            return carShop;
        }catch (NoResultException nre){
            log(Level.SEVERE, "No results");
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }
        return null;
    }

    public static Mechanic getByMechanicSurName(String mechanicSurname){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            String className = Mechanic.class.getSimpleName();
            Query<Mechanic> query = session.createQuery("from "+className+" s where surname = :surname", Mechanic.class);
            query.setParameter("surname",mechanicSurname);

            Mechanic mechanic = query.getSingleResult();
            return mechanic;
        }catch (NoResultException nre){
            log(Level.SEVERE, "No results");
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }
        return null;
    }

    public static Car getByBodyType (CarBodyType carBodyType){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            String className = Car.class.getSimpleName();
            Query<Car> query = session.createQuery("from "+className+" s where carBodyType = :carBodyType", Car.class);
            query.setParameter("carBodyType",carBodyType);

            Car car = query.getSingleResult();
            return car;
        }catch (NoResultException nre){
            log(Level.SEVERE, "No results");
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }
        return null;
    }

    public static Car getByProductionDate(LocalDate productionDate){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            String className = Car.class.getSimpleName();
            Query<Car> query = session.createQuery("from "+className+" s where carBodyType = :carBodyType", Car.class);
            query.setParameter("productionDate",productionDate);

            Car car = query.getSingleResult();
            return car;
        }catch (NoResultException nre){
            log(Level.SEVERE, "No results");
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }
        return null;
    }

    public static boolean setCarToMechanic(Long idCar, Long idMechanic){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Car car = CarDao.getById(idCar);
            Mechanic mechanic = getByMechId(idMechanic);

            assert mechanic != null;
            mechanic.getCars().add(car);
            assert car != null;
            car.setMechanic(mechanic);

            session.saveOrUpdate(car);
            session.saveOrUpdate(mechanic);

            transaction.commit();
            return true;
        }catch (NoResultException nre){
            log(Level.SEVERE, "No results");
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }
        return false;
    }

    public static boolean setCarShopToMechanic(String carShopName, String mechanicSurname){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            CarShop carShop = CarDao.getByCarshopName(carShopName);
            Mechanic mechanic = CarDao.getByMechanicSurName(mechanicSurname);

            assert mechanic != null;
            mechanic.setCarShop(carShop);
            assert carShop != null;
            carShop.getMechanics().add(mechanic);

            session.saveOrUpdate(carShop);
            session.saveOrUpdate(mechanic);

            transaction.commit();
            return true;
        }catch (NoResultException nre){
            log(Level.SEVERE, "No results");
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }
        return false;
    }

    public static boolean deleteCarFromMechanicSet(Long idCar, Long idMechanic){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Car car = CarDao.getById(idCar);
            Mechanic mechanic = getByMechId(idMechanic);

            assert mechanic != null;
            mechanic.getCars().remove(car);
            assert car != null;
            car.setMechanic(null);

            session.saveOrUpdate(car);
            session.saveOrUpdate(mechanic);

            transaction.commit();
            return true;
        }catch (NoResultException nre){
            log(Level.SEVERE, "No results");
        }catch (HibernateException he){
            log(Level.SEVERE,"Error loading objects.");
        }
        return false;
    }

}
