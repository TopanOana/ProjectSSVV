package ssvv.example.repository;

import ssvv.example.domain.*;
import ssvv.example.validation.*;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCRUDRepository<ID, E extends HasID<ID>> implements CRUDRepository<ID, E>{
    Map<ID, E> entities;
    Validator<E> validator;

    public AbstractCRUDRepository(Validator validator) {
        entities = new HashMap<ID, E>();
        this.validator = validator;
    }

    @Override
    public E findOne(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID-ul nu poate fi null! \n");
        }
        else {
            return entities.get(id);
        }
    }

    @Override
    public Iterable<E> findAll() { return entities.values(); }

    @Override
    public E save(E entity) throws ValidationException {
        try {
            validator.validate(entity);
            if (entities.containsKey(entity.getID()))
                throw new Exception("Entitatea deja exista");
            entities.put(entity.getID(), entity);
            return entities.putIfAbsent(entity.getID(), entity);
        }
        catch (ValidationException ve) {
            System.out.println("Entitatea nu este valida! \n");
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public E delete(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID-ul nu poate fi null! \n");
        }
        else {
            return entities.remove(id);
        }
    }

    @Override
    public E update(E entity) {
        try {
            validator.validate(entity);
            return entities.replace(entity.getID(), entity);
        }
        catch (ValidationException ve) {
            System.out.println("Entitatea nu este valida! \n");
            return null;
        }
    }
}
