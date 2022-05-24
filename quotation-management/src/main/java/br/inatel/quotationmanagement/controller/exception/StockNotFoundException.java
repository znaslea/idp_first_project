package br.inatel.quotationmanagement.controller.exception;

public class StockNotFoundException extends RuntimeException{

	public StockNotFoundException(String msg) {
		super(msg);
	}
}
