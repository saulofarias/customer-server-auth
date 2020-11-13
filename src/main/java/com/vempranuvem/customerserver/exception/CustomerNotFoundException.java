package com.vempranuvem.customerserver.exception;

import com.vempranuvem.customerserver.constants.MessagesConst;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String id) {
		super(MessagesConst.CUSTOMER_NOT_FOUND + id);
	}

}
