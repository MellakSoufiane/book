package fr.formation.service;

import javax.persistence.EntityNotFoundException;

import fr.formation.domain.BookDO;


public interface BookService {
	BookDO find(Long bookId) throws  EntityNotFoundException;
	BookDO create(BookDO bookDO);
	
	void delete(Long bookId) throws EntityNotFoundException;
	void updateBook(long bookId, BookDO bookDO) throws EntityNotFoundException;

}
