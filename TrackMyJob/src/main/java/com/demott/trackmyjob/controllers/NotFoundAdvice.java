package com.demott.trackmyjob.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demott.trackmyjob.exceptions.NotFoundException;

@ControllerAdvice
class NotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String notFoundHandler(NotFoundException e) {
		return e.getMessage();
	}
}
