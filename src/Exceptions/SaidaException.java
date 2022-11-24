package Exceptions;
import javax.swing.*;

public class SaidaException extends Exception {

    public SaidaException() {
        JOptionPane.showMessageDialog(null, "Programa finalizado!!", "Fim do programa", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
