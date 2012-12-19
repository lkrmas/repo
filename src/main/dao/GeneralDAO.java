package main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import main.data.BaseEntity;
import manage.Management;

public class GeneralDAO {

    private EntityManager em;

    public GeneralDAO() {
        em = Management.NewEntityManager();
        em.getTransaction().begin();
    }

    @SuppressWarnings("unchecked")
    public List<BaseEntity> retrieveAll(Class<? extends BaseEntity> cls) {
        TypedQuery<? extends BaseEntity> q = em.createNamedQuery(cls.getSimpleName() + ".selectAll", cls);
        List<? extends BaseEntity> entities = q.getResultList();
        return (List<BaseEntity>) entities;
    }

    @SuppressWarnings("unchecked")
    public List<BaseEntity> retrieveActive(Class<? extends BaseEntity> cls) {
        TypedQuery<? extends BaseEntity> q = em.createNamedQuery(cls.getSimpleName() + ".selectActive", cls);
        List<? extends BaseEntity> entities = q.getResultList();
        return (List<BaseEntity>) entities;
    }

    public BaseEntity insert(BaseEntity entity) {
        em.persist(entity.getClass().cast(entity));
        return entity;
    }

    public BaseEntity update(BaseEntity entity) {
        if (em.find(entity.getClass(), entity.getId()) != null)
            entity = em.merge(entity);
        return entity;
    }

    public void terminate() {
        em.getTransaction().commit();
        em.close();
    }

}
