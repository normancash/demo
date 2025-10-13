package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Sucursal;

import java.util.List;

public class ImplDAOSucursal implements IDAOSucursal {

    @Override
    public  List<Sucursal> getAll(String nameQuery) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try {
            TypedQuery<Sucursal> query = em.createNamedQuery(nameQuery
                    , Sucursal.class);
            return query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        return null;
    }

    @Override
    public void insert(Sucursal entity) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.flush();
            em.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
}
