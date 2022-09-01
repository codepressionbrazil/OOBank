import javax.swing.*;

public class Login extends JFrame implements Runnable {
    private JPanel login;
    private JTextField usuario;
    private JPasswordField senha;
    private JButton loginButton;
    private JButton cadastrarSeButton;

    public Login() {
        criarComponentes();
    }

    private void criarComponentes() {
        setContentPane(login);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void run() {
        if (!isVisible()) {
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "A janela já está aberta!");
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.run();
    }
}
