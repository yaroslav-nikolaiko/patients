package yaroslav.patients.database.web.controller;

/**
 * Created by yaroslav on 6/29/14.
 */
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class CalendarView implements Serializable {

    private Date date2;


//    public void onDateSelect(SelectEvent event) {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
//    }
//
//    public void click() {
//        RequestContext requestContext = RequestContext.getCurrentInstance();
//
//        requestContext.update("form:display");
//        requestContext.execute("PF('dlg').show()");
//    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }
}
