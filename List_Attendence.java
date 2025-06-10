import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;

public class List_Attendence extends JFrame implements ActionListener {

    JTable j1;
    JButton b1;
    DefaultTableModel model;

    List_Attendence() {
        super("View Employee Attendance");
        setSize(1000, 400);
        setLocation(450, 200);

        // Table headers
        String[] columns = {"Emp id", "Date Time", "First Half", "Second Half"};
        model = new DefaultTableModel(columns, 0);
        j1 = new JTable(model);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM attendence");

            // Dynamically add rows
            while (rs.next()) {
                String[] row = {
                    rs.getString("id"),
                    rs.getString("date_tm"),
                    rs.getString("f_half"),
                    rs.getString("s_half")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add table inside scroll pane
        JScrollPane s1 = new JScrollPane(j1);
        add(s1);

        b1 = new JButton("Print");
        add(b1, BorderLayout.SOUTH);

        b1.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            j1.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new List_Attendence();
    }
}

        
      
