package Lab10;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClockApp {
    private JLabel timeLabel;
    private Timer timer;

    public DigitalClockApp() {
        JFrame frame = new JFrame("Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new BorderLayout());

        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Serif", Font.BOLD, 50));
        timeLabel.setForeground(Color.BLACK);

        frame.add(timeLabel, BorderLayout.CENTER);

        timer = new Timer(1000, e -> updateTime());

        timer.start();

        updateTime();

        frame.setVisible(true);
    }

    private void updateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = dateFormat.format(new Date());

        timeLabel.setText(time);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalClockApp::new);
    }
}
