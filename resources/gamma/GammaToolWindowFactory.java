package com.adp.z2x.idea.plugin.gamma;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: Alexey.Chursin
 * Date: Aug 25, 2010
 * Time: 2:09:00 PM
 */
public class GammaToolWindowFactory implements ToolWindowFactory {

    private JButton refreshToolWindowButton;
    private JButton hideToolWindowButton;
    private JLabel currentDate;
    private JLabel currentTime;
    private JLabel timeZone;
    private JPanel gammaToolWindowContent;
    private ToolWindow gammaToolWindow;


    public GammaToolWindowFactory() {
        hideToolWindowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gammaToolWindow.hide(null);
            }
        });
        refreshToolWindowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GammaToolWindowFactory.this.currentDateTime();
            }
        });
    }

    // Create the tool window content.
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        gammaToolWindow = toolWindow;
        this.currentDateTime();
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(gammaToolWindowContent, "", false);
        toolWindow.getContentManager().addContent(content);

    }

    public void currentDateTime() {
        // Get current date and time
        Calendar instance = Calendar.getInstance();
        currentDate.setText(String.valueOf(instance.get(Calendar.DAY_OF_MONTH)) + "/"
                + String.valueOf(instance.get(Calendar.MONTH) + 1) + "/" +
                String.valueOf(instance.get(Calendar.YEAR)));
        currentDate.setIcon(new ImageIcon(getClass().getResource("Calendar-icon.png")));
        int min = instance.get(Calendar.MINUTE);
        String strMin;
        if (min < 10) {
            strMin = "0" + String.valueOf(min);
        } else {
            strMin = String.valueOf(min);
        }
        currentTime.setText(instance.get(Calendar.HOUR_OF_DAY) + ":" + strMin);
        currentTime.setIcon(new ImageIcon(getClass().getResource("Time-icon.png")));
        // Get time zone
        long gmt_Offset = instance.get(Calendar.ZONE_OFFSET); // offset from GMT in milliseconds
        String str_gmt_Offset = String.valueOf(gmt_Offset / 3600000);
        str_gmt_Offset = (gmt_Offset > 0) ? "GMT + " + str_gmt_Offset : "GMT - " + str_gmt_Offset;
        timeZone.setText(str_gmt_Offset);
        timeZone.setIcon(new ImageIcon(getClass().getResource("Time-zone-icon.png")));


    }

}