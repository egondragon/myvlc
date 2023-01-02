package org.example;

import javax.swing.*;
import java.awt.event.ActionListener;

public class myMenuItem {
    private String sz_title;
    private String sz_iconPath;
    private ActionListener myListener;
    private String sz_accelerator;
    private JMenuItem jmenuItem;

    public myMenuItem(String sz_title,
                      String iconPath,
                      ActionListener myListener,
                      String accel_) {
        this.sz_title = sz_title;
        this.sz_iconPath = iconPath;
        this.myListener = myListener;
        this.sz_accelerator = accel_;
    }

    public String getTitle() {
        return this.sz_title;
    }

    public String getIconPath() {
        return this.sz_iconPath;
    }

    public ActionListener getActionListener() {
        return this.myListener;
    }
    public String getAccelerator() {
        return this.sz_accelerator;
    }

    public void setJMenuItem(JMenuItem jmenuItem_) {
        this.jmenuItem = jmenuItem_;
    }

    public JMenuItem getJmenuItem() {
        return this.jmenuItem;
    }
}
