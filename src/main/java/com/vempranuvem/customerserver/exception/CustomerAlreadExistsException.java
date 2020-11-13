package com.vempranuvem.customerserver.exception;

import com.vempranuvem.customerserver.constants.MessagesConst;

public class CustomerAlreadExistsException extends RuntimeException {

	public CustomerAlreadExistsException() {
		super(MessagesConst.CUSTOMER_ALREAD_EXISTS);
	}

}
