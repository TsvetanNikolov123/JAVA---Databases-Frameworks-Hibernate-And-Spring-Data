package app.orm;

import java.sql.SQLException;

public interface DbContext {

    <E>boolean persist(E entity) throws IllegalAccessException, SQLException;

    <E>Iterable<E> find(Class<E> table) throws SQLException;

    <E>Iterable<E> find(Class<E> table, String where) throws SQLException;

    <E>E findFirst(Class<E> table) throws SQLException, IllegalAccessException, InstantiationException;

    <E>E findFirst(Class<E> table, String where) throws SQLException, IllegalAccessException, InstantiationException;
}
