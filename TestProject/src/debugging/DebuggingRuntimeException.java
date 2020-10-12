package debugging;

import java.util.ArrayList;
import java.util.Date;

public class DebuggingRuntimeException {
	
	static ArrayList<Date> dates = new ArrayList<Date>();
	
	public static void main(String[] args) {
		String[] dateStrings = {"13/07/1982","15/01/1982","12/08/1985","05/02/1988","09/04/1988","03/08/1990","03/97/1991","25/01/1995","03/06/1995","29/09/1997","08\06/1998","31/5/2000","05/12/2000","30/06/2001","30/10/2002","24/07/2003","31/05/2004","02/05/2006","14/12/2007","17/05/2008","15/08/2008","08/02.2009","16/03/2011","01/08/2011","06/05/2016"};
		for(String date : dateStrings) {
			dates.add(new Date(Date.parse(date)));
		}
		dates.forEach((d)-> System.out.println(d));
	}

}
