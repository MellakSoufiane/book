package fr.formation.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.BookRepository;
import fr.formation.domain.BookDO;



@Transactional
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookDO find(Long bookId) throws EntityNotFoundException {
		BookDO bookDo=null;
		bookDo=bookRepository.findById(bookId)
				.orElseThrow(
						()-> new EntityNotFoundException("Impossible de trouver un livre avec l'id : " + bookId));
		return new BookDO(bookDo.getId(), bookDo.getNom(), bookDo.getAuteur(), bookDo.getAnnee(), bookDo.getDomaine());
	}

	@Override
	public BookDO create(BookDO bookDO) {
		BookDO bookDo=new BookDO();
		bookDo.setNom(bookDO.getNom());
		bookDo.setAnnee(bookDO.getAnnee());
		bookDo.setAuteur(bookDO.getAuteur());
		bookDo.setDomaine(bookDO.getDomaine());
		
		bookRepository.save(bookDo);
		bookDO.setId(bookDo.getId());
	 return bookDO;
	}

	@Override
	public void delete(Long bookId) throws EntityNotFoundException {
		BookDO bookDo=bookRepository.findById(bookId)
				.orElseThrow(
						()-> new EntityNotFoundException("Impossible de trouver un livre avec l'id : " + bookId));
		bookRepository.delete(bookDo);
	}

	@Override
	public void updateBook(long bookId, BookDO bookDO) throws EntityNotFoundException {
	BookDO bookDo=bookRepository.findById(bookId)
				.orElseThrow(
						()-> new EntityNotFoundException("Impossible de trouver un livre avec l'id : " + bookId));
	bookDo.setNom(bookDO.getNom());
	bookDo.setAnnee(bookDO.getAnnee());
	bookDo.setAuteur(bookDO.getAuteur());
	bookDo.setDomaine(bookDO.getDomaine());
	
	bookRepository.save(bookDo);
	}

}
