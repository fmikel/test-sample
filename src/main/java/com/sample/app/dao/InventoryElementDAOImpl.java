package com.sample.app.dao;

import com.sample.app.model.db.InventoryElement;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class InventoryElementDAOImpl implements InventoryElementDAO {
    private static Logger logger = Logger.getLogger(InventoryElementDAO.class);

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<InventoryElement> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from InventoryElement");
        return query.list();
    }

    @Override
    public InventoryElement findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(InventoryElement.class, id);
    }

    @Override
    public void save(InventoryElement inventoryElement) {
        Session session = sessionFactory.getCurrentSession();
        session.save(inventoryElement);
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        InventoryElement inventoryElement = session.get(InventoryElement.class, id);
        session.delete(inventoryElement);
    }
}
