import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomerViewer extends JFrame implements ActionListener {
    private JTextField idField, lastNameField, firstNameField, phoneField;
    private JButton previousButton, nextButton;

    private int currentIndex = 0;

    private List<Customer> customers;

    public CustomerViewer() {
        setTitle("Customer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        customers = new ArrayList<>();
        customers.add(new Customer("1", "Chenda", "Sovisal", "092888999"));
        customers.add(new Customer("2", "Kom", "Lina", "092080999"));
        customers.add(new Customer("3", "Chan", "Seyha", "092777666"));

        add(new JLabel("ID:"));
        idField = new JTextField();
        idField.setEditable(false);
        add(idField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        lastNameField.setEditable(false);
        add(lastNameField);

        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        firstNameField.setEditable(false);
        add(firstNameField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        phoneField.setEditable(false);
        add(phoneField);

        previousButton = new JButton("Previous");
        previousButton.addActionListener(this);
        add(previousButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton);

        showCustomerInfo(0);
    }

    private void showCustomerInfo(int index) {
        if (index >= 0 && index < customers.size()) {
            Customer customer = customers.get(index);
            idField.setText(customer.getId());
            lastNameField.setText(customer.getLastName());
            firstNameField.setText(customer.getFirstName());
            phoneField.setText(customer.getPhone());
            currentIndex = index;
        }
        updateButtons();
    }

    private void updateButtons() {
        previousButton.setEnabled(currentIndex > 0);
        nextButton.setEnabled(currentIndex < customers.size() - 1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previousButton) {
            showCustomerInfo(currentIndex - 1);
        } else if (e.getSource() == nextButton) {
            showCustomerInfo(currentIndex + 1);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CustomerViewer().setVisible(true);
            }
        });
    }

    class Customer {
        private String id;
        private String lastName;
        private String firstName;
        private String phone;

        public Customer(String id, String lastName, String firstName, String phone) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.phone = phone;
        }

        public String getId() {
            return id;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getPhone() {
            return phone;
        }
    }
}