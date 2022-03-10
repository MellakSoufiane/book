package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.formation.domain.BookDO;
import fr.formation.exception.EntityNotFoundException;
import fr.formation.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	

	@GetMapping("/{bookId}")
	@ResponseBody
	public BookDO getCar(@PathVariable long bookId) throws EntityNotFoundException {
		return bookService.find(bookId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public BookDO createBook(@RequestBody BookDO bookDO) {
		return bookService.create(bookDO);
	}
	
	@DeleteMapping("/{bookId}")
	@ResponseBody
	public void deleteBook(@PathVariable long bookId) throws EntityNotFoundException{
		bookService.delete(bookId);
	}
	
	@PutMapping("{/bookId}")
	@ResponseBody
	public void updateBook(@PathVariable long bookId, @RequestBody BookDO bookDO) throws EntityNotFoundException{
		bookService.updateBook(bookId, bookDO);
	}
}
