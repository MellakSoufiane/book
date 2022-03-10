package fr.formation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.formation.domain.BookDO;

@Repository
public interface BookRepository extends CrudRepository<BookDO, Long> {

}
