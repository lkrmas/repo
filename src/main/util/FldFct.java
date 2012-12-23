package main.util;

import java.util.List;

import main.Context;
import main.Locality;
import main.data.Auaste;
import main.data.BaseEntity;
import main.data.Piirivalvur;
import main.data.Piirivalvurauaste;
import main.data.Vahtkond;
import main.data.Vahtkonnaliige;
import main.service.GeneralService;

import com.vaadin.data.Item;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.IntegerValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.data.util.BeanItem;

@SuppressWarnings("serial")
public class FldFct extends DefaultFieldFactory {

    GeneralService gs = new GeneralService();

    @Override
    public Field createField(Item item, Object propertyId, Component uiContext) {
        Locality loc = Context.getApp().getLocality();
        Field field;

        if (propertyId.equals("auaste")) {
            Select select = new Select();
            List<BaseEntity> es = gs.retrieveActive(Auaste.class);
            Piirivalvurauaste b = (Piirivalvurauaste) ((BeanItem<?>) item).getBean();
            for (BaseEntity e : es) {
                if ((b != null) && (b.getAuaste() != null) && (b.getAuaste().getId() == e.getId()))
                    e = b.getAuaste();
                select.addItem(e);
                select.setItemCaption(e, ((Auaste) e).getNimetus());
            }
            field = select;
        }
        else if (propertyId.equals("piirivalvur")) {
            Select select = new Select();
            List<BaseEntity> es = gs.retrieveActive(Piirivalvur.class);
            if (((BeanItem<?>) item).getBean().getClass() == Piirivalvurauaste.class) {
                Piirivalvurauaste b = (Piirivalvurauaste) ((BeanItem<?>) item).getBean();
                for (BaseEntity e : es) {
                    if ((b != null) && (b.getPiirivalvur() != null) && (b.getPiirivalvur().getId() == e.getId()))
                        e = b.getPiirivalvur();
                    select.addItem(e);
                    select.setItemCaption(e, ((Piirivalvur) e).getEesnimi() + " " + ((Piirivalvur) e).getPerekonnanimi());
                }
            }
            else {
                Vahtkonnaliige b = (Vahtkonnaliige) ((BeanItem<?>) item).getBean();
                for (BaseEntity e : es) {
                    if ((b != null) && (b.getPiirivalvur() != null) && (b.getPiirivalvur().getId() == e.getId()))
                        e = b.getPiirivalvur();
                    select.addItem(e);
                    select.setItemCaption(e, ((Piirivalvur) e).getEesnimi() + " " + ((Piirivalvur) e).getPerekonnanimi());
                }
            }
            field = select;
        }
        else if (propertyId.equals("vahtkond")) {
            Select select = new Select();
            List<BaseEntity> es = gs.retrieveActive(Vahtkond.class);
            Vahtkonnaliige b = (Vahtkonnaliige) ((BeanItem<?>) item).getBean();
            for (BaseEntity e : es) {
                if ((b != null) && (b.getVahtkond() != null) && (b.getVahtkond().getId() == e.getId()))
                    e = b.getVahtkond();
                select.addItem(e);
                select.setItemCaption(e, ((Vahtkond) e).getNimetus());
            }
            field = select;
        }
        else if (propertyId.equals("sugu")) {
            Select select = new Select();
            select.addItem(0);
            select.setItemCaption(0, loc.locMsg("layout.selection.gender.m"));
            select.addItem(1);
            select.setItemCaption(1, loc.locMsg("layout.selection.gender.f"));
            select.setNullSelectionAllowed(false);
            field = select;
        }
        else if (propertyId.equals("kommentaar")) {
            TextArea ta = new TextArea();
            field = ta;
        }
        else {
            field = super.createField(item, propertyId, uiContext);

            if (propertyId.equals("email")) {
                field.addValidator(new EmailValidator(loc.locMsg("layout.validation.email")));
            }
            else if (propertyId.equals("telefon")) {
                field.addValidator(new IntegerValidator(loc.locMsg("layout.validation.phone")));
            }
            else if (propertyId.equals("isikukood")) {
                field.addValidator(new RegexpValidator("[3-6][0-9]{10}", loc.locMsg("layout.validation.idcode")));
                field.setRequired(true);
                field.setRequiredError(loc.locMsg("layout.validation.idcode"));
            }
            else if (propertyId.equals("alates") || propertyId.equals("kuni")) {
                if (propertyId.equals("alates")) {
                    field.setRequired(true);
                    field.setRequiredError(loc.locMsg("layout.validation.requiredate"));
                }
                DateField df = (DateField) field;
                df.setDateFormat("dd/MM/yyyy");
                df.setResolution(DateField.RESOLUTION_DAY);
                df.setParseErrorMessage(loc.locMsg("layout.validation.parsedate"));
            }
            else {
                int min = 2;
                int max = 22;
                field.addValidator(new StringLengthValidator(loc.locMsg("layout.validation.textline", new Object[] {min, max}), min, max, false));
                field.setRequired(true);
                field.setRequiredError(loc.locMsg("layout.validation.textline", new Object[] {min, max}));
            }
        }

        if (field.getClass() == TextField.class) {
            TextField tf = (TextField) field;
            tf.setNullRepresentation("");
        }
        else if (field.getClass() == TextArea.class) {
            TextArea ta = (TextArea) field;
            ta.setNullRepresentation("");
        }

        field.setCaption(loc.locMsg("entity." + ((BeanItem<?>) item).getBean().getClass().getSimpleName().toLowerCase() + "." + propertyId));
        field.setWidth("100%");
        return field;
    }

}
