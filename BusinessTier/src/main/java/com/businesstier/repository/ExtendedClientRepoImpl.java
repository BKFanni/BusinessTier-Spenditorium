package com.businesstier.repository;


import com.businesstier.model.Bill;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Optional;


public abstract class ExtendedClientRepoImpl <T, Integer extends Serializable>
extends SimpleJpaRepository<T, Integer> implements ClientRepository<T, Integer> {
private EntityManager entityManager;
public ExtendedClientRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager){
    super(entityInformation, entityManager);
    this.entityManager=entityManager;
}


    public com.businesstier.model.Client findByUsername(String username){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());
        cQuery
                .select(root)
                .where(builder.equal(root.<String>get(username),username));
        TypedQuery<T> query = entityManager.createQuery(cQuery);

        return (com.businesstier.model.Client) query.getSingleResult();
    }


    public Boolean existsByUsername(String username){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());
        cQuery
                .select(root)
                .where(builder.equal(root.<String>get(username),username));
        TypedQuery<T> query = entityManager.createQuery(cQuery);
        if(query.getSingleResult()!=null){
            return true;
        }
        return false;
    }



    public Boolean existsByEmail(String email){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());
        cQuery
                .select(root)
                .where(builder.equal(root.<String>get(email),email));
        TypedQuery<T> query = entityManager.createQuery(cQuery);
        if(query.getSingleResult()!=null){
            return true;
        }
        return false;
    }


    public Boolean getAccessLogin(String username, String password){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());
        cQuery.select(root).where(builder.and(builder.equal(root.<String>get(username), username), builder.equal(root.<String>get(password),password)));
        TypedQuery<T> query = entityManager.createQuery(cQuery);
        if(query.getSingleResult()!=null){
            return true;
        }
        return false;
    }

    public Optional<Bill> getBillById(int id){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());
        cQuery
                .select(root)
                .where(builder.equal(root.<Integer>get(String.valueOf(id)),id));
        TypedQuery<T> query = entityManager.createQuery(cQuery);

        return (Optional<Bill>) query.getSingleResult();
    }

    public Bill addBill(Bill bill){
       /* CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<T> cUpdate = builder.createCriteriaUpdate(getDomainClass());
        Root<T> root = cUpdate.from(getDomainClass());
        cUpdate.set("billId",bill.getId());
        cUpdate.set("")
        TypedQuery<T> query = entityManager.createQuery(cQuery);*/

      //  return (Bill) query.getSingleResult();
        return null;
    }
}
