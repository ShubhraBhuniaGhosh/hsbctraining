package com.hsbc.employeepayroll.factory;

import com.hsbc.employeepayroll.view.EmployeeConsoleView;
import com.hsbc.employeepayroll.view.View;

public abstract class EmployeeViewFactory {

	public static View getEmployeeView() {
		EmployeeConsoleView view = new EmployeeConsoleView();
		return view;
	}
}
