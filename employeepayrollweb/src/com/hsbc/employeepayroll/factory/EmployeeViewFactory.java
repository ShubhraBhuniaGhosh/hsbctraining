package com.hsbc.employeepayroll.factory;

import com.hsbc.employeepayroll.view.View;
import com.hsbc.employeepayroll.view.impl.EmployeeConsoleView;

public abstract class EmployeeViewFactory {

	public static View getEmployeeView() {
		View view = new EmployeeConsoleView();
		return view;
	}
}
