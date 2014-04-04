/*
 * DemoView.java
 */
package demo;

import java.awt.Toolkit;
import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * 演示程序主界面
 */
public class DemoView extends FrameView {

    public DemoView(SingleFrameApplication app) {
        super(app);
        initComponents();
        mainFrame = getFrame();
        mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("resources/konsole.png")));
//        mainFrame.setResizable(false);
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame demoFrame = DemoApp.getApplication().getMainFrame();
            aboutBox = new DemoAboutBox(demoFrame);
            aboutBox.setLocationRelativeTo(demoFrame);
        }
        DemoApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        welcomeMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        SJMenu = new javax.swing.JMenu();
        SJ01MenuItem = new javax.swing.JMenuItem();
        SJ02MenuItem = new javax.swing.JMenuItem();
        SJ03MenuItem = new javax.swing.JMenuItem();
        SJ04MenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        mainPanel = new DrawPanel();

        menuBar.setName("menuBar"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(demo.DemoApp.class).getContext().getResourceMap(DemoView.class);
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setFont(resourceMap.getFont("fileMenu.font")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(demo.DemoApp.class).getContext().getActionMap(DemoView.class, this);
        welcomeMenuItem.setAction(actionMap.get("init")); // NOI18N
        welcomeMenuItem.setFont(resourceMap.getFont("welcomeMenuItem.font")); // NOI18N
        welcomeMenuItem.setText(resourceMap.getString("welcomeMenuItem.text")); // NOI18N
        welcomeMenuItem.setName("welcomeMenuItem"); // NOI18N
        fileMenu.add(welcomeMenuItem);

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setFont(resourceMap.getFont("exitMenuItem.font")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        SJMenu.setText(resourceMap.getString("SJMenu.text")); // NOI18N
        SJMenu.setFont(resourceMap.getFont("SJMenu.font")); // NOI18N
        SJMenu.setName("SJMenu"); // NOI18N

        SJ01MenuItem.setAction(actionMap.get("showSJ01")); // NOI18N
        SJ01MenuItem.setFont(resourceMap.getFont("SJ01MenuItem.font")); // NOI18N
        SJMenu.add(SJ01MenuItem);

        SJ02MenuItem.setAction(actionMap.get("showSJ02")); // NOI18N
        SJ02MenuItem.setFont(resourceMap.getFont("SJ02MenuItem.font")); // NOI18N
        SJ02MenuItem.setText(resourceMap.getString("SJ02MenuItem.text")); // NOI18N
        SJ02MenuItem.setName("SJ02MenuItem"); // NOI18N
        SJMenu.add(SJ02MenuItem);

        SJ03MenuItem.setAction(actionMap.get("showSJ03")); // NOI18N
        SJ03MenuItem.setFont(resourceMap.getFont("SJ03MenuItem.font")); // NOI18N
        SJ03MenuItem.setText(resourceMap.getString("SJ03MenuItem.text")); // NOI18N
        SJ03MenuItem.setName("SJ03MenuItem"); // NOI18N
        SJMenu.add(SJ03MenuItem);

        SJ04MenuItem.setAction(actionMap.get("showSJ04")); // NOI18N
        SJ04MenuItem.setFont(resourceMap.getFont("SJ04MenuItem.font")); // NOI18N
        SJ04MenuItem.setText(resourceMap.getString("SJ04MenuItem.text")); // NOI18N
        SJ04MenuItem.setName("SJ04MenuItem"); // NOI18N
        SJMenu.add(SJ04MenuItem);

        menuBar.add(SJMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setFont(resourceMap.getFont("helpMenu.font")); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setFont(resourceMap.getFont("aboutMenuItem.font")); // NOI18N
        aboutMenuItem.setIcon(resourceMap.getIcon("aboutMenuItem.icon")); // NOI18N
        aboutMenuItem.setText(resourceMap.getString("aboutMenuItem.text")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(640, 429));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void showSJ01() {
        mainFrame.setContentPane(new SJ01Panel());
        mainFrame.pack();
    }

    @Action
    public void showSJ02() {
        mainFrame.setContentPane(new SJ02Panel());
        mainFrame.pack();
    }

    @Action
    public void showSJ04() {
        mainFrame.setContentPane(new SJ04Panel());
        mainFrame.pack();
    }

    @Action
    public void init() {
        mainFrame.setContentPane(new DrawPanel());
        mainFrame.pack();
    }

    @Action
    public void showSJ03() {
        mainFrame.setContentPane(new SJ03Panel());
        mainFrame.pack();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem SJ01MenuItem;
    private javax.swing.JMenuItem SJ02MenuItem;
    private javax.swing.JMenuItem SJ03MenuItem;
    private javax.swing.JMenuItem SJ04MenuItem;
    private javax.swing.JMenu SJMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem welcomeMenuItem;
    // End of variables declaration//GEN-END:variables

    private JDialog aboutBox;
    private JFrame mainFrame;
}