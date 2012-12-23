package main.wrap;

import java.io.Serializable;

import main.Context;
import main.Locality;
import main.data.BaseEntity;

import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings("serial")
public abstract class BaseWrapper implements Serializable {

    protected Class<? extends BaseEntity> cls;
    protected BeanItemContainer<? extends BaseEntity> container;
    protected int layoutCos;
    protected int layoutRos;
    protected int[][] layout;
    protected String name;
    protected String[] tblColOrdr;
    protected String[] tblColHead;
    protected String[] frmFldOrdr;
    protected String[] frmFldHead;

    public abstract void refreshLocale();

    protected String localise() {
        Locality loc = Context.getApp().getLocality();
        return loc.locMsg("entity." + cls.getSimpleName().toLowerCase());
    }

    protected String localise(String id) {
        Locality loc = Context.getApp().getLocality();
        return loc.locMsg("entity." + cls.getSimpleName().toLowerCase() + "." + id);
    }

    protected String[] localise(String[] ids) {
        Locality loc = Context.getApp().getLocality();
        String[] texts = new String[ids.length];
        for (int i = 0; i < ids.length; i ++)
            texts[i] = loc.locMsg("entity." + cls.getSimpleName().toLowerCase() + "." + ids[i]);
        return texts;
    }

    public BeanItem<? extends BaseEntity> newItem() {
        try {
            return new BeanItem<BaseEntity>(cls.newInstance());
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Class<? extends BaseEntity> getCls() {
        return cls;
    }

    public BeanItemContainer<? extends BaseEntity> getContainer() {
        return container;
    }

    public String getName() {
        return name;
    }

    public String[] getTblColOrdr() {
        return tblColOrdr;
    }

    public String[] getTblColHead() {
        return tblColHead;
    }

    public String[] getFrmColOrdr() {
        return frmFldOrdr;
    }

    public String[] getFrmColHead() {
        return frmFldHead;
    }

    public int getLayoutCos() {
        return layoutCos;
    }

    public int getLayoutRos() {
        return layoutRos;
    }

    public int[][] getLayout() {
        return layout;
    }

}
