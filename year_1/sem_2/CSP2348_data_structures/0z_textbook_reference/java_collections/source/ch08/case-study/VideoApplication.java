import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class VideoApplication extends JFrame
    implements WindowListener, ListSelectionListener, ActionListener {

    private Video video;
    private JList list;

    private JTextField titleField, channelField, durationField;
    private JRadioButton standardButton, longButton;
    private JButton addButton, eraseButton;

    public VideoApplication () {
        video = new Video("Tape 54", 180 * 60);
        createGUI();
    }

    private static void addToGridBag(JPanel panel, Component comp,
            int x, int y, int w, int h, double weightx, double weighty) {

        GridBagLayout gbl = (GridBagLayout) panel.getLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.weightx = weightx;
        c.weighty = weighty;
        panel.add(comp);
        gbl.setConstraints(comp, c);
    }

    private void createGUI () {
        setTitle("Video Tape Catalog: " + video.getTitle());
        addWindowListener(this);

        titleField    = new JTextField("", 25);
        channelField  = new JTextField("", 5);
        durationField = new JTextField ("0", 5);

        JPanel p1 = new JPanel(new GridBagLayout());
        addToGridBag(p1, new JLabel("Title:"),    0, 0, 1, 1, 0.0, 0.0);
        addToGridBag(p1, new JLabel("Channel:"),  0, 1, 1, 1, 0.0, 0.0);
        addToGridBag(p1, new JLabel("Duration:"), 0, 2, 1, 1, 0.0, 0.0);

        int rem = GridBagConstraints.REMAINDER;
        addToGridBag(p1, titleField,    1, 0, rem, 1, 0.0, 0.0);
        addToGridBag(p1, channelField,  1, 1, 1,   1, 0.0, 0.0);
        addToGridBag(p1, durationField, 1, 2, 1,   1, 0.0, 0.0);

        addToGridBag(p1, new JLabel(""), 2, 1, rem, 1, 1.0, 0.0);
        addToGridBag(p1, new JLabel(""), 2, 2, rem, 1, 1.0, 0.0);

        standardButton = new JRadioButton("Standard");
        longButton     = new JRadioButton("Long");

        ButtonGroup g  = new ButtonGroup();
        g.add(standardButton);
        g.add(longButton);

        addToGridBag(p1, new JLabel("Record speed:"), 0, 3, 1, 1, 0.0, 0.0);
        addToGridBag(p1, standardButton, 1, 3, 1,   1, 0.0, 0.0);
        addToGridBag(p1, longButton,     2, 3, rem, 1, 0.0, 0.0);

        standardButton.setSelected(true);

        addButton   = new JButton("Add");
        eraseButton = new JButton("Erase");

        addButton.addActionListener(this);
        eraseButton.addActionListener(this);

        addToGridBag(p1, addButton,   0, 4, 1, 1, 0.0, 0.0);
        addToGridBag(p1, eraseButton, 1, 4, 1, 1, 0.0, 0.0);

        getContentPane().add(p1, "South");

        list = new JList(video.getListModel());
        list.addListSelectionListener(this);
        list.setFixedCellWidth(380);
        list.setSelectedIndex(0);
        list.setFont(new Font("monospaced", Font.PLAIN, 12));

        JScrollPane pane = new JScrollPane(list,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        getContentPane().add(pane, "Center");

        pack();
    }

///////////////////////////////////////////////////////////////////////////////

    public void valueChanged (ListSelectionEvent e) {
        int index = list.getSelectedIndex();
        Segment seg = (Segment) video.getContents().get(index);
        if (seg != null && seg.isBlank()) {
            titleField.setText("BLANK");
            channelField.setText("");
            durationField.setText("" + (seg.getLength() / 60));
            standardButton.setSelected(true);
            longButton.setSelected(false);
        } else if (seg != null && ! seg.isBlank()) {
            VideoProgram prog = seg.getProgram();
            titleField.setText(prog.getTitle());
            channelField.setText(prog.getChannel());
            durationField.setText("" + (prog.getDuration() / 60));
            standardButton.setSelected(!prog.isLongPlay());
            longButton.setSelected(prog.isLongPlay());
        }
    }

///////////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent e) {
        int currentSelection;
        if (e.getSource() == addButton) {
            int duration = Integer.parseInt(durationField.getText());
            boolean isLongPlay = longButton.isSelected();
            currentSelection = video.add(new VideoProgram(titleField.getText(),
                channelField.getText(), duration * 60, isLongPlay));
            if (currentSelection != -1) {
                list.setSelectedIndex(currentSelection);
            } else {
                    JOptionPane.showMessageDialog(null,
                "No space left on tape for that program.",
                "Tape full", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == eraseButton) {
            currentSelection = list.getSelectedIndex();
            video.erase(currentSelection);
            if (currentSelection > 0)
                list.setSelectedIndex(currentSelection - 1);
            else
                list.setSelectedIndex(0);
        }
        LinkedListModel m = (LinkedListModel) list.getModel();
        m.listChanged();
        list.ensureIndexIsVisible(list.getSelectedIndex());
    }

///////////////////////////////////////////////////////////////////////////////

    public void windowOpened      (WindowEvent e) { }
    public void windowClosed      (WindowEvent e) { }
    public void windowClosing     (WindowEvent e) { System.exit(0); }
    public void windowActivated   (WindowEvent e) { }
    public void windowDeactivated (WindowEvent e) { }
    public void windowIconified   (WindowEvent e) { }
    public void windowDeiconified (WindowEvent e) { }

///////////////////////////////////////////////////////////////////////////////

    public static void main (String[] args) {
        VideoApplication app = new VideoApplication();
        app.show();
    }
}
