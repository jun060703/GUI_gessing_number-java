import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessingGame extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton guessButton;
    private JLabel promptLabel, attemptLabel;
    private int randomNumber, attempts;

    public GuessingGame() {
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("숫자 맞추기 게임");
        this.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        promptLabel = new JLabel("1에서 10까지 숫자를 맞춰보세요: ");
        textField = new JTextField(10);
        guessButton = new JButton("추측");
        attemptLabel = new JLabel("시도 횟수: 0");

        guessButton.addActionListener(this);

        panel.add(promptLabel);
        panel.add(textField);
        panel.add(guessButton);
        panel.add(attemptLabel);

        this.add(panel);
        this.setVisible(true);

        generateRandomNumber();
    }

    private void generateRandomNumber() {
        randomNumber = (int) (Math.random() * 10) + 1;
        attempts = 0;
        updateAttemptLabel();
    }

    private void updateAttemptLabel() {
        attemptLabel.setText("시도 횟수: " + attempts);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            int guess = Integer.parseInt(textField.getText());
            attempts++;
            updateAttemptLabel();
            if (guess == randomNumber) {
                JOptionPane.showMessageDialog(null, "정답입니다! 축하합니다!");
                generateRandomNumber();
            } else if (guess < randomNumber) {
                JOptionPane.showMessageDialog(null, "너무 작아요! 다시 시도하세요.");
            } else {
                JOptionPane.showMessageDialog(null, "너무 커요! 다시 시도하세요.");
            }
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new GuessingGame();
    }
}
