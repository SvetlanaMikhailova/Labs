package ru.az.sample.dao;

import jdk.nashorn.internal.objects.Global;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.az.sample.model.Category;
import ru.az.sample.model.Item;


import javax.annotation.Resource;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by smikhailova on 23.11.2015.
 */

@Repository
public class InMemoryItemDao implements ItemDao {


    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public List<Item> getAllItems () {return sessionFactory.getCurrentSession().createCriteria(Item.class).list();}



    public Item findById(Long id) {
        return (Item) sessionFactory.getCurrentSession().get(Item.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Item> sortByCategory (Long catID) { return
            sessionFactory.getCurrentSession().createCriteria(Item.class).add(Restrictions.eq("category", sessionFactory.getCurrentSession().get(Category.class, catID))).list();}

    public void update(Item item) {
        sessionFactory.getCurrentSession().update(item);
    }


}
