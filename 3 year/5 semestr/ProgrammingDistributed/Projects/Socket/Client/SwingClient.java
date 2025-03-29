import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

public class SwingClient {
  private static final String SERVER_ADDRESS = "localhost";
  private static final int PORT = 12345;

  private JFrame frame;
  private JTextArea outputArea;
  private JTextField inputField;
  private JButton addButton, removeButton, updateButton, listButton;

  private PrintWriter out;
  private BufferedReader in;

  public SwingClient() {
    setupGUI();

    try {
      Socket socket = new Socket(SERVER_ADDRESS, PORT);
      out = new PrintWriter(socket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      Thread listenerThread = new Thread(() -> {
        try {
          String message;
          while ((message = in.readLine()) != null) {
            outputArea.append("Server: " + message + "\n");
          }
        } catch (IOException e) {
          outputArea.append("Connection lost: " + e.getMessage() + "\n");
        }
      });
      listenerThread.start();
    } catch (IOException e) {
      JOptionPane.showMessageDialog(
          frame, "Unable to connect to server: " + e.getMessage(), "Error",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  private void setupGUI() {
    frame = new JFrame("Client GUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 400);

    outputArea = new JTextArea();
    outputArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(outputArea);

    inputField = new JTextField();
    inputField.addActionListener(e -> sendCommand(inputField.getText()));

    addButton = new JButton("Add");
    removeButton = new JButton("Remove");
    updateButton = new JButton("Update");
    listButton = new JButton("List");

    addButton.addActionListener(e -> sendCommand(promptCommand("add")));
    removeButton.addActionListener(e -> sendCommand(promptCommand("remove")));
    updateButton.addActionListener(e -> sendCommand(promptCommand("update")));
    listButton.addActionListener(e -> sendCommand("list"));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1, 4));
    panel.add(addButton);
    panel.add(removeButton);
    panel.add(updateButton);
    panel.add(listButton);

    frame.setLayout(new BorderLayout());
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.add(inputField, BorderLayout.SOUTH);
    frame.add(panel, BorderLayout.NORTH);

    frame.setVisible(true);
  }

  private String promptCommand(String command) {
    String key = JOptionPane.showInputDialog(frame, "Enter key:", command);

    if (key == null || key.trim().isEmpty()) {
      return "";
    }

    String value = null;
    if (!command.equals("remove")) {
      value = JOptionPane.showInputDialog(frame, "Enter value:", "");
      if (value == null || value.trim().isEmpty()) {
        return "";
      }
    }

    return value == null ? command + " " + key
                         : command + " " + key + " " + value;
  }

  private void sendCommand(String command) {
    if (command == null || command.trim().isEmpty()) {
      return;
    }

    out.println(command);
    inputField.setText("");
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(SwingClient::new);
  }
}
