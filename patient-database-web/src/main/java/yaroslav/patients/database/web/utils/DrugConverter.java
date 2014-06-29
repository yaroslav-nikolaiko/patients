package yaroslav.patients.database.web.utils;

import yaroslav.patients.database.model.entity.Drug;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by yaroslav on 6/29/14.
 */
@Named
public class DrugConverter implements Converter {
    @Inject
    List<Drug> drugs;


    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            for(Drug d : drugs)
                if(value.equals(String.valueOf( d.getId() )  )  )
                    return d;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Drug) object).getId());
        }
        else {
            return null;
        }
    }
}
