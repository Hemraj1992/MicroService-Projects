package Interview.Java.Generic;

import org.jodconverter.filter.Filter;
import org.jodconverter.filter.FilterChain;
import org.jodconverter.office.OfficeContext;

import com.sun.star.awt.Size;
import com.sun.star.beans.PropertyValue;
import com.sun.star.lang.XComponent;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.view.PaperFormat;
import com.sun.star.view.XPrintable;

public class MyFilter implements Filter{
	
	@Override
    public void doFilter(OfficeContext context, XComponent document, FilterChain chain) throws Exception {
        XPrintable xPrintable = UnoRuntime.queryInterface(XPrintable.class, document);
        PropertyValue[] props = new PropertyValue[2];

        PropertyValue p1 = new PropertyValue();
        p1.Name = "PaperFormat";
        p1.Value = PaperFormat.USER;
        props[0] = p1;

        PropertyValue p2 = new PropertyValue();
        p2.Name = "PaperSize";
        p2.Value = new Size(90000, 120000);  // width,height
        props[1] = p2;

//        PropertyValue p3 = new PropertyValue();
//        p3.Name = "PaperOrientation";
//        p3.Value = PaperOrientation.LANDSCAPE; // LANDSCAPE or PORTRAIT
//        props[0] = p3;

        xPrintable.setPrinter(props);
        chain.doFilter(context, document);
    }
	
	
	
	
	
}
