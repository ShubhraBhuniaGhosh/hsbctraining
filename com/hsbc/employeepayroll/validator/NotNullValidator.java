package com.hsbc.employeepayroll.validator;

public class NotNullValidator {

	public boolean accept(String input)
	{
		if(input!=null && input.trim().length()==0)
			return true;
		return false;
	}
}
