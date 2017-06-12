package web;

import java.sql.Timestamp;

public class CldCalc {
	Timestamp start;
	Timestamp end;
	
	public CldCalc() {
		super();
		this.start = new Timestamp(System.currentTimeMillis());
	}

	public double stopCalc(){
		end = new Timestamp(System.currentTimeMillis());
		double time = ((double) (end.getTime() - start.getTime()) / 1000);
		start = end;
		return time;
	}
}
