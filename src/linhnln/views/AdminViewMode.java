/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnln.views;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import linhnln.dtos.DepartmentDTO;
import linhnln.dtos.DeviceDTO;
import linhnln.dtos.DeviceRelateMaintainanceDTO;
import linhnln.dtos.EmployeeDTO;
import linhnln.dtos.EmployeeRelateMaintainanceDTO;
import linhnln.logger.LogFileText;
import linhnln.models.DepartmentDAO;
import linhnln.models.DeviceDAO;
import linhnln.models.DeviceRelateMaintainanceDAO;
import linhnln.models.EmployeeDAO;
import linhnln.models.EmployeeRelateMaintainanceDAO;
import mdlaf.MaterialLookAndFeel;

/**
 *
 * @author Liam Nguyen
 */
public class AdminViewMode extends javax.swing.JFrame {

    private DefaultTableModel tblModelEmployee = null;
    private DefaultTableModel tblModelDev = null;
    private DefaultTableModel tblModelDep = null;
    private DefaultTableModel tblModelHistory = null;
    private DefaultTableModel tblModelStatistic = null;
    private String imagefileChooser = null;

    /**
     * Creates new form AdminViewMode
     */
    public AdminViewMode() {
        initComponents();
        tblModelEmployee = (DefaultTableModel) tblViewEmployee.getModel();
        tblModelDev = (DefaultTableModel) tblViewDev.getModel();
        tblModelDep = (DefaultTableModel) tblViewDep.getModel();
        tblModelHistory = (DefaultTableModel) tblViewHistory.getModel();
        tblModelStatistic = (DefaultTableModel) tblViewStatistic.getModel();
        showListEmployee();
        showListDevice();
        showListDep();
        showListHistory();
        showDeviceToStatistic();
        rdMale.setSelected(true);
        this.setLocation(50, 50);

    }

    private void viewImg(String path) throws IOException { //para la string path
        BufferedImage imgIO = ImageIO.read(new File(path));
        Image dimg = imgIO.getScaledInstance(deviceImageLable.getWidth(), deviceImageLable.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        deviceImageLable.setIcon(icon);
    }

    private void viewAllEmp(List<EmployeeDTO> list) {
        tblModelEmployee.setRowCount(0);
        for (EmployeeDTO employeeDTO : list) {
            tblModelEmployee.addRow(employeeDTO.toVector());
        }
    }

    private void viewAllDev(List<DeviceDTO> list) {
        tblModelDev.setRowCount(0);
        for (DeviceDTO deviceDTO : list) {
            tblModelDev.addRow(deviceDTO.toVectorForAdmin());
        }
    }

    private void viewAllDep(List<DepartmentDTO> list) {
        tblModelDep.setRowCount(0);
        for (DepartmentDTO departmentDTO : list) {
            tblModelDep.addRow(departmentDTO.toVector());
        }
    }

    private void viewAllHistory(List<EmployeeRelateMaintainanceDTO> dto) {
        tblModelHistory.setRowCount(0);
        for (EmployeeRelateMaintainanceDTO empReMainDTO : dto) {
            tblModelHistory.addRow(empReMainDTO.toVector());
        }
    }

    private void viewAllDeviceForStatistic(List<DeviceDTO> dto) {
        tblModelStatistic.setRowCount(0);
        for (DeviceDTO deviceDTO : dto) {
            tblModelStatistic.addRow(deviceDTO.toVectorForStatistic());
        }
    }

    private void showListEmployee() {
        try {
            EmployeeDAO dao = new EmployeeDAO();
            List<EmployeeDTO> listEmpDTO = dao.showAllEmployee();
            viewAllEmp(listEmpDTO);
        } catch (Exception e) {
//            e.printStackTrace();
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }
    }

    private void showListDevice() {
        try {
            DeviceDAO dao = new DeviceDAO();
            List<DeviceDTO> listDevDTO = dao.getAllListDevice();
            viewAllDev(listDevDTO);
        } catch (Exception e) {
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }
    }

    private void showListDep() {
        try {
            DepartmentDAO dao = new DepartmentDAO();
            List<DepartmentDTO> dto = dao.getListAllDep();
            viewAllDep(dto);
        } catch (Exception e) {
//            e.printStackTrace();
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }
    }

    private void showListHistory() {
        try {
            EmployeeRelateMaintainanceDAO dao = new EmployeeRelateMaintainanceDAO();
            List<EmployeeRelateMaintainanceDTO> dto = dao.getHistoryAllDevice();
            viewAllHistory(dto);
        } catch (Exception e) {
//            e.printStackTrace();
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }
    }

    private void showDeviceToStatistic() {
        try {
            DeviceDAO dao = new DeviceDAO();
            List<DeviceDTO> dto = dao.getAllListDeviceForStatisticTab();
            viewAllDeviceForStatistic(dto);
        } catch (Exception e) {
//            e.printStackTrace();
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGroupEmp = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewEmployee = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmpID = new javax.swing.JTextField();
        txtEmpName = new javax.swing.JTextField();
        txtEmpDepID = new javax.swing.JTextField();
        dateChooserEmpDOB = new com.toedter.calendar.JDateChooser();
        btCreateEmp = new javax.swing.JButton();
        btUpdateEmp = new javax.swing.JButton();
        btNewEmp = new javax.swing.JButton();
        btDeleteEmp = new javax.swing.JButton();
        rdFemale = new javax.swing.JRadioButton();
        rdMale = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        DeviceDetailPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDevID = new javax.swing.JTextField();
        txtDevName = new javax.swing.JTextField();
        txtDevDepID = new javax.swing.JTextField();
        dateChooserDevBuyingDate = new com.toedter.calendar.JDateChooser();
        btCreateDev = new javax.swing.JButton();
        btUpdateDev = new javax.swing.JButton();
        btNewDev = new javax.swing.JButton();
        btDeleteDev = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDevDes = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        btOpenFileDev = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtDevCateID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDevStatus = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblViewDev = new javax.swing.JTable();
        deviceImagePanel = new javax.swing.JPanel();
        deviceImageLable = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblViewDep = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDepID = new javax.swing.JTextField();
        txtDepName = new javax.swing.JTextField();
        btCreateDep = new javax.swing.JButton();
        btUpdateDep = new javax.swing.JButton();
        btNewDep = new javax.swing.JButton();
        btDeleteDep = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtDepStatus = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblViewHistory = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblViewStatistic = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btGetSortByNumberOfRepairingByAscStatisticTBL = new javax.swing.JButton();
        btGetSortByNumberOfRepairingByDescStatisticTBL = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        cbStatusForStatistic = new javax.swing.JComboBox<>();
        yearStartChooserForStatistic = new com.toedter.calendar.JYearChooser();
        yearEndChooserForStatistic = new com.toedter.calendar.JYearChooser();
        btExecuteStatusAndYearFilterForStatisticTBL = new javax.swing.JButton();
        btGetBackViewTBLStatistic = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        cbStatusForHistory = new javax.swing.JComboBox<>();
        yearStartChooserForHistory = new com.toedter.calendar.JYearChooser();
        yearEndChooserForHistory = new com.toedter.calendar.JYearChooser();
        btExecuteStatusAndYearForHistoryTBL = new javax.swing.JButton();
        btGetBackViewTBLHistory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 76, 103));
        jLabel1.setText("Admin Management System");

        tblViewEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmployeeID", "EmployeeName", "Sex", "DOB", "DepID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblViewEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblViewEmployee);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee's Detail"));

        jLabel2.setText("EmployeeID: ");

        jLabel3.setText("EmployeeName:");

        jLabel4.setText("Sex:");

        jLabel5.setText("DOB:");

        jLabel6.setText("DepID:");

        btCreateEmp.setText("Create");
        btCreateEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreateEmpActionPerformed(evt);
            }
        });

        btUpdateEmp.setText("Update");
        btUpdateEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateEmpActionPerformed(evt);
            }
        });

        btNewEmp.setText("New");
        btNewEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewEmpActionPerformed(evt);
            }
        });

        btDeleteEmp.setText("Delete");
        btDeleteEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteEmpActionPerformed(evt);
            }
        });

        btGroupEmp.add(rdFemale);
        rdFemale.setText("Female");

        btGroupEmp.add(rdMale);
        rdMale.setText("Male");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btCreateEmp)
                        .addGap(18, 18, 18)
                        .addComponent(btNewEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rdMale, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdFemale, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                            .addComponent(txtEmpName)
                            .addComponent(txtEmpID)
                            .addComponent(dateChooserEmpDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmpDepID)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btUpdateEmp)
                        .addGap(18, 18, 18)
                        .addComponent(btDeleteEmp)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdFemale)
                    .addComponent(rdMale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(dateChooserEmpDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmpDepID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCreateEmp)
                    .addComponent(btNewEmp)
                    .addComponent(btUpdateEmp)
                    .addComponent(btDeleteEmp))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Employee", jPanel1);

        DeviceDetailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Image's Detail"));

        jLabel7.setText("DeviceID: ");

        jLabel8.setText("DeviceName:");

        jLabel10.setText("BuyingDate:");

        jLabel11.setText("DepID:");

        btCreateDev.setText("Create");
        btCreateDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreateDevActionPerformed(evt);
            }
        });

        btUpdateDev.setText("Update");
        btUpdateDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateDevActionPerformed(evt);
            }
        });

        btNewDev.setText("New");
        btNewDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewDevActionPerformed(evt);
            }
        });

        btDeleteDev.setText("Delete");
        btDeleteDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteDevActionPerformed(evt);
            }
        });

        jLabel12.setText("Description:");

        txtDevDes.setColumns(20);
        txtDevDes.setRows(5);
        jScrollPane2.setViewportView(txtDevDes);

        jLabel13.setText("Image: ");

        btOpenFileDev.setText("Open File");
        btOpenFileDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpenFileDevActionPerformed(evt);
            }
        });

        jLabel14.setText("CateID:");

        jLabel15.setText("Status:");

        javax.swing.GroupLayout DeviceDetailPanelLayout = new javax.swing.GroupLayout(DeviceDetailPanel);
        DeviceDetailPanel.setLayout(DeviceDetailPanelLayout);
        DeviceDetailPanelLayout.setHorizontalGroup(
            DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeviceDetailPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DeviceDetailPanelLayout.createSequentialGroup()
                        .addComponent(btCreateDev)
                        .addGap(18, 18, 18)
                        .addComponent(btNewDev, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btUpdateDev)
                        .addGap(18, 18, 18)
                        .addComponent(btDeleteDev))
                    .addGroup(DeviceDetailPanelLayout.createSequentialGroup()
                        .addGroup(DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7))
                        .addGap(27, 27, 27)
                        .addGroup(DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btOpenFileDev, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDevName, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateChooserDevBuyingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDevCateID, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDevID, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DeviceDetailPanelLayout.createSequentialGroup()
                                .addComponent(txtDevDepID, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel15)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDevStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        DeviceDetailPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCreateDev, btDeleteDev, btNewDev, btUpdateDev});

        DeviceDetailPanelLayout.setVerticalGroup(
            DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeviceDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDevID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btOpenFileDev, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeviceDetailPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDevName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(21, 21, 21)
                .addGroup(DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(dateChooserDevBuyingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDevCateID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(23, 23, 23)
                .addGroup(DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDevDepID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtDevStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeviceDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCreateDev)
                    .addComponent(btNewDev)
                    .addComponent(btUpdateDev)
                    .addComponent(btDeleteDev))
                .addGap(27, 27, 27))
        );

        tblViewDev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DeviceID", "Description", "DeviceName", "BuyingDate", "CateID", "DepID", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblViewDev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewDevMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblViewDev);

        deviceImagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Device's Image"));

        javax.swing.GroupLayout deviceImagePanelLayout = new javax.swing.GroupLayout(deviceImagePanel);
        deviceImagePanel.setLayout(deviceImagePanelLayout);
        deviceImagePanelLayout.setHorizontalGroup(
            deviceImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deviceImagePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deviceImageLable, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        deviceImagePanelLayout.setVerticalGroup(
            deviceImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deviceImagePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(deviceImageLable, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DeviceDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deviceImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(deviceImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeviceDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Device", jPanel2);

        tblViewDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DepartmentID", "DepartmentName", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblViewDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewDepMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblViewDep);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Department's Detail"));

        jLabel9.setText("DepartmentID:");

        jLabel16.setText("DepartmentName:");

        btCreateDep.setText("Create");
        btCreateDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreateDepActionPerformed(evt);
            }
        });

        btUpdateDep.setText("Update");
        btUpdateDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateDepActionPerformed(evt);
            }
        });

        btNewDep.setText("New");
        btNewDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewDepActionPerformed(evt);
            }
        });

        btDeleteDep.setText("Delete");
        btDeleteDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteDepActionPerformed(evt);
            }
        });

        jLabel17.setText("Status:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btCreateDep)
                        .addGap(18, 18, 18)
                        .addComponent(btNewDep, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btUpdateDep)
                        .addGap(18, 18, 18)
                        .addComponent(btDeleteDep))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDepStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addComponent(jLabel9))
                            .addGap(28, 28, 28)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtDepName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDepID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDepID, txtDepName, txtDepStatus});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDepID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtDepName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCreateDep)
                    .addComponent(btNewDep)
                    .addComponent(btUpdateDep)
                    .addComponent(btDeleteDep))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel16, jLabel17});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Department", jPanel3);

        tblViewHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmployeeName", "DeviceName", "RequirementTime", "RequirementContent", "RepairEndDate", "RepairContent", "Result", "StaffName"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblViewHistory);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Statistic"));

        tblViewStatistic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DeviceID", "Description", "DeviceName", "BuyingDate", "Status", "NoOfRepairing"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblViewStatistic);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Statistic by number of times repairing"));

        btGetSortByNumberOfRepairingByAscStatisticTBL.setText("Execute By Ascending");
        btGetSortByNumberOfRepairingByAscStatisticTBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGetSortByNumberOfRepairingByAscStatisticTBLActionPerformed(evt);
            }
        });

        btGetSortByNumberOfRepairingByDescStatisticTBL.setText("Execute By Descending");
        btGetSortByNumberOfRepairingByDescStatisticTBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGetSortByNumberOfRepairingByDescStatisticTBLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btGetSortByNumberOfRepairingByDescStatisticTBL, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btGetSortByNumberOfRepairingByAscStatisticTBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btGetSortByNumberOfRepairingByAscStatisticTBL)
                .addGap(18, 18, 18)
                .addComponent(btGetSortByNumberOfRepairingByDescStatisticTBL)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Statistic by: "));

        cbStatusForStatistic.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status", "inuse", "Disabled" }));
        cbStatusForStatistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusForStatisticActionPerformed(evt);
            }
        });

        btExecuteStatusAndYearFilterForStatisticTBL.setText("Execute");
        btExecuteStatusAndYearFilterForStatisticTBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExecuteStatusAndYearFilterForStatisticTBLActionPerformed(evt);
            }
        });

        btGetBackViewTBLStatistic.setText("Go back");
        btGetBackViewTBLStatistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGetBackViewTBLStatisticActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btExecuteStatusAndYearFilterForStatisticTBL, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btGetBackViewTBLStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(yearStartChooserForStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatusForStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearEndChooserForStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(cbStatusForStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yearStartChooserForStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yearEndChooserForStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGetBackViewTBLStatistic)
                    .addComponent(btExecuteStatusAndYearFilterForStatisticTBL))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Statistic by: "));

        cbStatusForHistory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Result", "Done", "Required", "Ongoing" }));

        btExecuteStatusAndYearForHistoryTBL.setText("Execute");
        btExecuteStatusAndYearForHistoryTBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExecuteStatusAndYearForHistoryTBLActionPerformed(evt);
            }
        });

        btGetBackViewTBLHistory.setText("Go back");
        btGetBackViewTBLHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGetBackViewTBLHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btExecuteStatusAndYearForHistoryTBL, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btGetBackViewTBLHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbStatusForHistory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yearStartChooserForHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yearEndChooserForHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {yearEndChooserForHistory, yearStartChooserForHistory});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(cbStatusForHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yearStartChooserForHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yearEndChooserForHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGetBackViewTBLHistory)
                    .addComponent(btExecuteStatusAndYearForHistoryTBL))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("History And Statistic", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewEmpActionPerformed
        // TODO add your handling code here:
        txtEmpDepID.setText("");
        txtEmpID.setText("");
        txtEmpName.setText("");
        txtEmpID.setEditable(true);
        txtEmpDepID.setEditable(true);
        showListEmployee();

    }//GEN-LAST:event_btNewEmpActionPerformed

    private void btCreateEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreateEmpActionPerformed
        String invalid = "";
        int depID = 0;
        int empID = 0;
        
        try {
            empID = Integer.parseInt(txtEmpID.getText());
            if (empID < 1) {
                throw new Exception("empID must start from 1");
            }
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            invalid += "ID must be a digit ";
            JOptionPane.showMessageDialog(this, invalid);
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        } catch (Exception e) { 
//            ex.printStackTrace();
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

        String empName = txtEmpName.getText();

        String sex = "M";

        if (rdFemale.isSelected()) {
            sex = "F";
        }

        Calendar cal = dateChooserEmpDOB.getCalendar();
        Timestamp dob = new Timestamp(cal.getTimeInMillis());
        System.out.println(cal);

        try {
            depID = Integer.parseInt(txtEmpDepID.getText());
            if (depID < 1) {
                throw new Exception("ID must start from 1");
            }
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            invalid += "depID must be a digit ";
            JOptionPane.showMessageDialog(this, invalid);
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

        //validate
        if (empName.trim().length() == 0) {
            invalid += "EmployeeName can't be blank! ";
        }
//        if (dob == null) {
//            invalid += "DOB can't be blank";
//        }

        //operate
        EmployeeDTO dto = null;
        
        if (invalid.equals("")) {
            dto = new EmployeeDTO(empID, depID, empName, sex, dob);
            System.out.println(dto.getEmpID());

        } else {
            JOptionPane.showMessageDialog(this, invalid);
           
        }

        try {
            EmployeeDAO dao = new EmployeeDAO();
            if (dao.insertEmp(dto)) {
                JOptionPane.showMessageDialog(this, "Insert sucess");
                //cap nhat lai bang sau khi cap nhat lai dabase
                tblModelEmployee.addRow(dto.toVector());
            } else {
                JOptionPane.showMessageDialog(this, "Insert failed");
            }

        } catch (Exception e) {
//            e.printStackTrace();
            if (e.getMessage().contains("duplicate")) {
                JOptionPane.showMessageDialog(this, empID + " is already existed!");
            }

            if (e.getMessage().contains("FOREIGN KEY")) {
                JOptionPane.showMessageDialog(this, empID + " or " + depID + " is not valid");
            }
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }
    }//GEN-LAST:event_btCreateEmpActionPerformed

    private void tblViewEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewEmployeeMouseClicked
        // TODO add your handling code here:
        txtEmpID.setEditable(false);

        int row = tblViewEmployee.getSelectedRow();
        int empID = (Integer) tblModelEmployee.getValueAt(row, 0);
//        System.out.println(empID); test
        try {
            EmployeeDAO dao = new EmployeeDAO();
            EmployeeDTO dto = dao.findByPrimaryKey(empID);

            txtEmpID.setText(dto.getEmpID() + "");
            txtEmpDepID.setText(dto.getDepID() + "");
            txtEmpName.setText(dto.getEmpName());
            //default la M
            if (dto.getSex().equals("F")) {
                rdFemale.setSelected(true);
            } else {
                rdMale.setSelected(true);
            }
            Date date = new Date(dto.getDob().getTime());
            dateChooserEmpDOB.setDate(date);
        } catch (Exception e) {
//            e.printStackTrace();
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

    }//GEN-LAST:event_tblViewEmployeeMouseClicked

    private void btUpdateEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateEmpActionPerformed
        // TODO add your handling code here:
        txtEmpID.setEditable(false);
        String invalid = "";
        int depID = 0;
        int empID = 0;
        try {
            empID = Integer.parseInt(txtEmpID.getText());
            if (empID < 1) {
                throw new Exception(" ID must start from 1");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        } 

        String empName = txtEmpName.getText();

        String sex = "M";

        if (rdFemale.isSelected()) {
            sex = "F";
        }

        Calendar cal = dateChooserEmpDOB.getCalendar();
        Timestamp dob = new Timestamp(cal.getTimeInMillis());
//        System.out.println(cal); TEST

        try {
            depID = Integer.parseInt(txtEmpDepID.getText());
            if (depID < 1) {
                throw new Exception("ID must start from 1");
            }
        } catch (NumberFormatException e) {

            invalid += " ID must be a digit";
            JOptionPane.showMessageDialog(this, invalid);
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

        //validate
        
        if (empName.length() == 0) {
            invalid += " EmployeeName can't be blank!";
        }

        //operate
        EmployeeDTO dto = null;
        if (invalid.equals("")) {
            dto = new EmployeeDTO(empID, depID, empName, sex, dob);
//            System.out.println(dto.getEmpID()); test
        } else {
            JOptionPane.showMessageDialog(this, invalid);
        }

        try {
            EmployeeDAO dao = new EmployeeDAO();
            if (dao.updateEmployee(dto)) {
                JOptionPane.showMessageDialog(this, "update sucess");
                //cap nhat lai bang sau khi cap nhat lai dabase
                showListEmployee();

            } else {
                JOptionPane.showMessageDialog(this, "update failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().contains("FOREIGN KEY")) {
                JOptionPane.showMessageDialog(this, depID + " is not valid");
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

    }//GEN-LAST:event_btUpdateEmpActionPerformed

    private void btDeleteEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteEmpActionPerformed
        // TODO add your handling code here:
        int row = tblViewEmployee.getSelectedRow();
        int empID = Integer.parseInt(txtEmpID.getText());
        EmployeeDAO dao = new EmployeeDAO();

        try {
            if (dao.delete(empID)) {
                JOptionPane.showMessageDialog(this, "Delete sucess");
                tblModelEmployee.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Delete Failed");
            }
        } catch (Exception e) {
//            ex.printStackTrace();
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }
    }//GEN-LAST:event_btDeleteEmpActionPerformed

    private void btCreateDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreateDevActionPerformed
        txtDevID.setEditable(true);
//        int row = tblViewDev.getSelectedRow();
        int devID = 0, cateID = 0, depID = 0;
        String description, devName, status;
        Timestamp buyingDate = null;
        DeviceDTO dto = null;
        String invalid = "";
        try {
            devID = Integer.parseInt(txtDevID.getText());
            if (devID < 0) {
                throw new Exception("ID must begin from 1");
            }
        } catch (NumberFormatException e) {
            invalid += "devID must be a digit";
            JOptionPane.showMessageDialog(this, invalid);
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        } catch (Exception e) {
//            e.printStackTrace();

            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

        try {
            depID = Integer.parseInt(txtDevDepID.getText());
            if (depID < 0) {
                throw new Exception("depID must begin from 1");
            }
        } catch (NumberFormatException ex) {
            invalid += "depID must be a digit";
            JOptionPane.showMessageDialog(this, invalid);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        
        try {
            cateID = Integer.parseInt(txtDevCateID.getText());
            if (cateID < 0) {
                throw new Exception("cateID must begin from 1");
            }
        } catch (NumberFormatException e) {
            invalid += "cateID must be a digit";
            JOptionPane.showMessageDialog(this, invalid);
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

        description = txtDevDes.getText();
        devName = txtDevName.getText();
        status = "inuse";
        Date date = dateChooserDevBuyingDate.getDate();
        buyingDate = new Timestamp(date.getTime());
        String img = imagefileChooser;

        if (description.length() == 0) {
            invalid += "description can't be blank";
        }
        if (devName.length() == 0) {
            invalid += "DeviceName can't be blank";
        }

        if (invalid.equals("")) {
            DeviceDAO dao = new DeviceDAO();
            dto = new DeviceDTO(devID, depID, img, description, devName, cateID, buyingDate, status);
            try {
                if (dao.insertDev(dto)) {
                    JOptionPane.showMessageDialog(this, "Insert success");
                    //cap nhat lai table
                    showListDevice();
                    viewImg(imagefileChooser);
                } else {
                    JOptionPane.showMessageDialog(this, "Insert failed");
                }
            } catch (Exception e) {
//                e.printStackTrace();
                 if (e.getMessage().contains("insert duplicate key")){
                    JOptionPane.showMessageDialog(this, devID + " is already existed");
                } if (e.getMessage().contains("FOREIGN KEY")) {
                    JOptionPane.showMessageDialog(this, depID + " or "+ cateID + " is not exist!");
                } else {
                     JOptionPane.showMessageDialog(this, "Something wrong with your input");
                }
               
                LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, invalid);
        }
    }//GEN-LAST:event_btCreateDevActionPerformed

    private void btUpdateDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateDevActionPerformed
        // TODO add your handling code here:
        txtDevID.setEditable(false);
//        int row = tblViewDev.getSelectedRow();
        int devID = 0, cateID = 0, depID = 0;
        String description, devName, status;
        Timestamp buyingDate = null;
        DeviceDTO dto = null;

        try {
            devID = Integer.parseInt(txtDevID.getText());
            if (devID < 0) {
                throw new Exception("ID must begin from 1");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

        try {
            depID = Integer.parseInt(txtDevDepID.getText());
            if (devID < 0) {
                throw new Exception("ID must begin from 1");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

        try {
            cateID = Integer.parseInt(txtDevCateID.getText());
            if (cateID < 0) {
                throw new Exception("ID must begin from 1");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

        description = txtDevDes.getText();
        devName = txtDevName.getText();
        status = txtDevStatus.getText();
        Date date = dateChooserDevBuyingDate.getDate();
        buyingDate = new Timestamp(date.getTime());
        String img = imagefileChooser;
        String invalid = "";
        if (description.length() == 0) {
            invalid += "description can't be blank";
        }
        if (devName.length() == 0) {
            invalid += "DeviceName can't be blank";
        }

        if (invalid.equals("")) {
            DeviceDAO dao = new DeviceDAO();
            dto = new DeviceDTO(devID, depID, img, description, devName, cateID, buyingDate, status);
            try {
                if (dao.updateDeviceForAdmin(dto)) {
                    JOptionPane.showMessageDialog(this, "Update success");
                    //cap nhat lai table
                    showListDevice();
                    viewImg(imagefileChooser);
                } else {
                    JOptionPane.showMessageDialog(this, "Update failed");
                }
            } catch (Exception e) {
//                e.printStackTrace();
            if (e.getMessage().contains("FOREIGN KEY")) {
                JOptionPane.showMessageDialog(this, depID + " or " + cateID + " is not exist");
            } else {
                JOptionPane.showMessageDialog(this, "Something wrong with your input");
            }
                LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, invalid);
        }

    }//GEN-LAST:event_btUpdateDevActionPerformed

    private void btNewDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewDevActionPerformed
        // TODO add your handling code here:
        txtDevID.setEditable(true);
        txtDevID.setText("");
        txtDevDes.setText("");
        txtDevName.setText("");
        txtDevDepID.setText("");
        txtDevCateID.setText("");
        dateChooserDevBuyingDate.setDate(null);
        showListDevice();

    }//GEN-LAST:event_btNewDevActionPerformed

    private void btDeleteDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteDevActionPerformed
        // TODO add your handling code here:
//        int row = tblViewDev.getSelectedRow();
        int devID = Integer.parseInt(txtDevID.getText());
        DeviceDAO dao = new DeviceDAO();
        try {
            if (dao.delete(devID)) {
                JOptionPane.showMessageDialog(this, "Delete sucess");
                //ko can cap nhat lai bang, no la chinh sua cot nen chi can 
                // cap nhat lai view
                deviceImageLable.setIcon(null); //cập nhật lại ảnh
                showListDevice();
            } else {
                JOptionPane.showMessageDialog(this, "Delete failed");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

    }//GEN-LAST:event_btDeleteDevActionPerformed

    private void btOpenFileDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpenFileDevActionPerformed
        // TODO add your handling code here:  
        JFileChooser filedlg = new JFileChooser();
        filedlg.showOpenDialog(null);
        File selected = filedlg.getSelectedFile();
        imagefileChooser = selected.getName();
    }//GEN-LAST:event_btOpenFileDevActionPerformed


    private void tblViewDevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewDevMouseClicked
        // TODO add your handling code here:
        txtDevID.setEditable(false);

        int row = tblViewDev.getSelectedRow();
        int devID = (Integer) tblModelDev.getValueAt(row, 0);
//        System.out.println(empID); test
        try {
            DeviceDAO dao = new DeviceDAO();
            DeviceDTO dto = dao.findByPrimaryKeyForAdmin(devID);

            txtDevID.setText(dto.getDevID() + "");
//            System.out.println(dto.getImg());
            viewImg(dto.getImg());

            txtDevDes.setText(dto.getDescription());
            txtDevName.setText(dto.getDevName());
            //BuyingDate
            Date date = new Date(dto.getBuyingDate().getTime());
            dateChooserDevBuyingDate.setDate(date);
            //
            txtDevCateID.setText(dto.getCateID() + "");
            txtDevDepID.setText(dto.getDevID() + "");
            txtDevStatus.setText(dto.getStatus());
        } catch (Exception e) {
//            e.printStackTrace();
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

    }//GEN-LAST:event_tblViewDevMouseClicked

    private void btCreateDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreateDepActionPerformed
        // TODO add your handling code here:
        int depID = 0;
        try {
            depID = Integer.parseInt(txtDepID.getText());
            if (depID < 0) {
                throw new Exception("Your ID is not valid");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            if (e.getMessage().contains("insert duplicate key")) {
                JOptionPane.showMessageDialog(this, depID + "has already existed!!!");
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

        String invalid = "";
        String depName = txtDepName.getText();
        String status = txtDepStatus.getText();
        if (depName.length() == 0) {
            invalid += "Department Name can't be blank";
        }
        if (status.length() == 0) {
            invalid += "Status can't be blank";
        }

        if (invalid.equals("")) {
            DepartmentDTO dto = new DepartmentDTO(depID, depName, status);
            DepartmentDAO dao = new DepartmentDAO();
            try {
                if (dao.insertNewDep(dto)) {
                    JOptionPane.showMessageDialog(this, "Insert sucess");
                    showListDep();
                } else {
                    JOptionPane.showMessageDialog(this, "Insert failed");
                }
            } catch (Exception e) {
//                e.printStackTrace();
                LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, invalid);
        }


    }//GEN-LAST:event_btCreateDepActionPerformed

    private void btUpdateDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateDepActionPerformed
        // TODO add your handling code here:
        txtDepID.setEditable(false);
        String depName = txtDepName.getText();
        String status = txtDepStatus.getText();
        int depID = Integer.parseInt(txtDepID.getText());
        String invalid = "";
        if (depName.length() == 0) {
            invalid += "Depart name can't be blank";
        }
        if (status.length() == 0) {
            invalid += "Status can't be blank";
        }

        if (invalid.equals("")) {
            DepartmentDAO dao = new DepartmentDAO();
            DepartmentDTO dto = new DepartmentDTO(depID, depName, status);
            try {
                if (dao.updateDep(dto)) {
                    JOptionPane.showMessageDialog(this, "Update sucess");
                    //cập nhật view
                    showListDep();
                } else {
                    JOptionPane.showMessageDialog(this, "Update failed");
                }
            } catch (Exception e) {
//                e.printStackTrace();
                LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, invalid);
        }


    }//GEN-LAST:event_btUpdateDepActionPerformed

    private void btNewDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewDepActionPerformed
        // TODO add your handling code here:
        txtDepID.setEditable(true);
        txtDepID.setText("");
        txtDepName.setText("");
        txtDepStatus.setText("");
        showListDep();
    }//GEN-LAST:event_btNewDepActionPerformed

    private void btDeleteDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteDepActionPerformed
        // TODO add your handling code here:
        int row = tblViewDep.getSelectedRow();
        int depID = (Integer) tblModelDep.getValueAt(row, 0);
        try {
            DepartmentDAO dao = new DepartmentDAO();
            if (dao.deleteDep(depID)) {
                JOptionPane.showMessageDialog(this, "Deleted!");
                showListDep();
            } else {
                JOptionPane.showMessageDialog(this, "Something went wrong!");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }
    }//GEN-LAST:event_btDeleteDepActionPerformed

    private void tblViewDepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewDepMouseClicked
        // TODO add your handling code here:
        txtDepID.setEditable(false);
        int row = tblViewDep.getSelectedRow();
        int depID = (Integer) tblModelDep.getValueAt(row, 0);

        try {
            DepartmentDAO depDAO = new DepartmentDAO();
            DepartmentDTO dto = depDAO.findDepartmentByPrimaryKey(depID);
            txtDepID.setText(dto.getDepID() + "");
            txtDepName.setText(dto.getDepName());
            txtDepStatus.setText(dto.getStatus());
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }

    }//GEN-LAST:event_tblViewDepMouseClicked

    private void btGetSortByNumberOfRepairingByAscStatisticTBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGetSortByNumberOfRepairingByAscStatisticTBLActionPerformed
        // TODO add your handling code here:
//        System.out.println("a1");
        try {
            DeviceRelateMaintainanceDAO dao = new DeviceRelateMaintainanceDAO();
//            System.out.println("a2");
            List<DeviceRelateMaintainanceDTO> dto = dao.getAllListDeviceForStatisticTabByNumberOfRepairingInAsc();
//            System.out.println("a3");
            viewDeviceByNumberOfRepairing(dto);
        } catch (Exception e) {
//            e.printStackTrace();
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }
    }//GEN-LAST:event_btGetSortByNumberOfRepairingByAscStatisticTBLActionPerformed

    private void viewDeviceByNumberOfRepairing(List<DeviceRelateMaintainanceDTO> dto) {
        removeAllRowForTblStatistic();
        tblModelStatistic.setRowCount(0);
        for (DeviceRelateMaintainanceDTO devMainDTO : dto) {
            tblModelStatistic.addRow(devMainDTO.toVector());
        }
    }

    private void removeAllRowForTblStatistic() {
        int rowCount = tblModelStatistic.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tblModelStatistic.removeRow(i);
        }
    }
    


    private void btGetSortByNumberOfRepairingByDescStatisticTBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGetSortByNumberOfRepairingByDescStatisticTBLActionPerformed
        //        System.out.println("a1");
        try {
            DeviceRelateMaintainanceDAO dao = new DeviceRelateMaintainanceDAO();
//            System.out.println("a2");
            List<DeviceRelateMaintainanceDTO> dto = dao.getAllListDeviceForStatisticTabByNumberOfRepairingInDesc();
//            System.out.println("a3");
            viewDeviceByNumberOfRepairing(dto);
        } catch (Exception e) {
//            e.printStackTrace();
            LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
        }
    }//GEN-LAST:event_btGetSortByNumberOfRepairingByDescStatisticTBLActionPerformed

    private void btExecuteStatusAndYearFilterForStatisticTBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExecuteStatusAndYearFilterForStatisticTBLActionPerformed
        // TODO add your handling code here:
        String status = (String) cbStatusForStatistic.getSelectedItem();
//        System.out.println(status);

        int yearStart = yearStartChooserForStatistic.getValue();
//        System.out.println(yearStart);
        int yearEnd = yearEndChooserForStatistic.getValue();
//        System.out.println(yearEnd); 

        if (status.equals("Status")) {
            JOptionPane.showMessageDialog(this, "Please Choose status");
        } else {
            try {
                DeviceDAO dao = new DeviceDAO();
                List<DeviceDTO> dto = dao.getDevicesWithTimeRangeAndStatus(status, yearStart, yearEnd);
                viewAllDeviceForStatistic(dto);
            } catch (Exception e) {
//                e.printStackTrace();
                LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
            }
        }
                
    }//GEN-LAST:event_btExecuteStatusAndYearFilterForStatisticTBLActionPerformed
    
    private void removeAllRowForTblHistory() {
        int rowCount = tblModelHistory.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tblModelHistory.removeRow(i);
        }
    }
    
    private void viewAllDeviceForHistory(List<EmployeeRelateMaintainanceDTO> dto) {
        removeAllRowForTblHistory();
        tblModelHistory.setRowCount(0);
        for (EmployeeRelateMaintainanceDTO dtoObj : dto) {
            tblModelHistory.addRow(dtoObj.toVector());
        }
    }
    
    private void btExecuteStatusAndYearForHistoryTBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExecuteStatusAndYearForHistoryTBLActionPerformed
        // TODO add your handling code here:
        
        String status = (String) cbStatusForHistory.getSelectedItem();
//        System.out.println(status);
        int yearStart = yearStartChooserForHistory.getValue();
        int yearEnd = yearEndChooserForHistory.getValue();
        
        if (status.equals("Result")) {
            JOptionPane.showMessageDialog(this, "Please Choose Result");
        } else {
            try {
                EmployeeRelateMaintainanceDAO dao = new EmployeeRelateMaintainanceDAO();
                List<EmployeeRelateMaintainanceDTO> dto = dao.getAllListDeviceForHistoryTabByResultAndYear(status, yearStart, yearEnd);
                viewAllDeviceForHistory(dto);
            } catch (Exception e) {
//                e.printStackTrace();
                LogFileText.writeToLogFile("AdminViewMode", e.getMessage());
            }
        }
    }//GEN-LAST:event_btExecuteStatusAndYearForHistoryTBLActionPerformed

    private void btGetBackViewTBLHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGetBackViewTBLHistoryActionPerformed
        // TODO add your handling code here:
        removeAllRowForTblHistory();
        showListHistory();
    }//GEN-LAST:event_btGetBackViewTBLHistoryActionPerformed

    private void btGetBackViewTBLStatisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGetBackViewTBLStatisticActionPerformed
        // TODO add your handling code here:
        removeAllRowForTblStatistic();
        showDeviceToStatistic();
    }//GEN-LAST:event_btGetBackViewTBLStatisticActionPerformed

    private void cbStatusForStatisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusForStatisticActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatusForStatisticActionPerformed
    /*Qui trinh update Device: 
    xử lý img path: img path là 1 properties của viewm, sẽ bằng JFileChooser
    Nếu mà null (tức là user ko update hình, thì nó sẽ lấy lại đường dẫn cũ bằng 
    method getOldPath() từ devID trả về imgPath từ DB và get vô imgpath*/
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminViewMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminViewMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminViewMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminViewMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel (new MaterialLookAndFeel ());
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace ();
		}
                
                new AdminViewMode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DeviceDetailPanel;
    private javax.swing.JButton btCreateDep;
    private javax.swing.JButton btCreateDev;
    private javax.swing.JButton btCreateEmp;
    private javax.swing.JButton btDeleteDep;
    private javax.swing.JButton btDeleteDev;
    private javax.swing.JButton btDeleteEmp;
    private javax.swing.JButton btExecuteStatusAndYearFilterForStatisticTBL;
    private javax.swing.JButton btExecuteStatusAndYearForHistoryTBL;
    private javax.swing.JButton btGetBackViewTBLHistory;
    private javax.swing.JButton btGetBackViewTBLStatistic;
    private javax.swing.JButton btGetSortByNumberOfRepairingByAscStatisticTBL;
    private javax.swing.JButton btGetSortByNumberOfRepairingByDescStatisticTBL;
    private javax.swing.ButtonGroup btGroupEmp;
    private javax.swing.JButton btNewDep;
    private javax.swing.JButton btNewDev;
    private javax.swing.JButton btNewEmp;
    private javax.swing.JButton btOpenFileDev;
    private javax.swing.JButton btUpdateDep;
    private javax.swing.JButton btUpdateDev;
    private javax.swing.JButton btUpdateEmp;
    private javax.swing.JComboBox<String> cbStatusForHistory;
    private javax.swing.JComboBox<String> cbStatusForStatistic;
    private com.toedter.calendar.JDateChooser dateChooserDevBuyingDate;
    private com.toedter.calendar.JDateChooser dateChooserEmpDOB;
    private javax.swing.JLabel deviceImageLable;
    private javax.swing.JPanel deviceImagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JTable tblViewDep;
    private javax.swing.JTable tblViewDev;
    private javax.swing.JTable tblViewEmployee;
    private javax.swing.JTable tblViewHistory;
    private javax.swing.JTable tblViewStatistic;
    private javax.swing.JTextField txtDepID;
    private javax.swing.JTextField txtDepName;
    private javax.swing.JTextField txtDepStatus;
    private javax.swing.JTextField txtDevCateID;
    private javax.swing.JTextField txtDevDepID;
    private javax.swing.JTextArea txtDevDes;
    private javax.swing.JTextField txtDevID;
    private javax.swing.JTextField txtDevName;
    private javax.swing.JTextField txtDevStatus;
    private javax.swing.JTextField txtEmpDepID;
    private javax.swing.JTextField txtEmpID;
    private javax.swing.JTextField txtEmpName;
    private com.toedter.calendar.JYearChooser yearEndChooserForHistory;
    private com.toedter.calendar.JYearChooser yearEndChooserForStatistic;
    private com.toedter.calendar.JYearChooser yearStartChooserForHistory;
    private com.toedter.calendar.JYearChooser yearStartChooserForStatistic;
    // End of variables declaration//GEN-END:variables
}
