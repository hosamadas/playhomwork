
package controllers;


import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	DynamicForm form = Form.form().bindFromRequest();
    	String txt_a = form.data().get("txt_a");
    	String txt_b = form.data().get("txt_b");
    	String txt_c = form.data().get("txt_c");
    	
    	Double a =0.0, b = 0.0, c = 0.0;
    	
    	if (txt_a != null ){
    		a = Double.parseDouble(txt_a);
    	}
    	
    	if (txt_b != null ){
    		b = Double.parseDouble(txt_b);
    	}
    	
    	if (txt_c != null ){
    		c = Double.parseDouble(txt_c);
    	}
		
		Double D = b*b - 4*a*c;
		
		String txt_result = "";
		if(D >= 0){
			Double x1 = (-b + Math.sqrt(D) ) / 2 * a ;
			Double x2 = (-b - Math.sqrt(D) ) / 2 * a ;
			
			txt_result = "X1 = " + x1 + " , X2 = " + x2;
			
		}else if(D <  0){
			txt_result = "Can't be Solved ...";
		}
		
		
        return ok(index.render(txt_result));
    }

}


