package com.jersoe.aspectaddress;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Represents the view in MVC
public class View implements ActionListener, ListSelectionListener {

	private JFrame frmAspectaddress;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastname;
	private JTextField textFieldStreet;
	private JTextField textFieldCity;
	private JTextField textFieldZIP;
	private JComboBox comboBoxState;
	private State state = State.VIEW;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnOk;
	private JButton btnCancel;
	private JList listContacts;
	private Controller c;
	private JTextField textFieldPhone;
	private ArrayList<Contact> contacts;
	private DefaultListModel listModel = new DefaultListModel();

	//Constructor
	public View(Controller c, ArrayList<Contact> contacts) {
		this.c = c;
		initialize();
		this.setContacts(contacts);
		this.frmAspectaddress.setVisible(true);
		this.updateUI();
	}

	//Sets UI elements to correct mode
	private void updateUI() {
		if (this.state == State.VIEW) {
			this.textFieldFirstName.setEditable(false);
			this.textFieldLastname.setEditable(false);
			this.textFieldStreet.setEditable(false);
			this.textFieldCity.setEditable(false);
			this.textFieldZIP.setEditable(false);
			this.textFieldPhone.setEditable(false);
			this.comboBoxState.setEnabled(false);
			this.btnCancel.setEnabled(false);
			this.btnOk.setEnabled(false);
			this.btnAdd.setEnabled(true);
			if (this.listContacts.getModel().getSize() > 0) {
				this.btnEdit.setEnabled(true);
				this.btnDelete.setEnabled(true);
			} else {
				this.btnEdit.setEnabled(false);
				this.btnDelete.setEnabled(false);
			}
			this.listContacts.setEnabled(true);
		} else if (this.state == State.ADD || this.state == State.EDIT) {
			this.textFieldFirstName.setEditable(true);
			this.textFieldLastname.setEditable(true);
			this.textFieldStreet.setEditable(true);
			this.textFieldCity.setEditable(true);
			this.textFieldZIP.setEditable(true);
			this.textFieldPhone.setEditable(true);
			this.comboBoxState.setEnabled(true);
			this.btnCancel.setEnabled(true);
			this.btnOk.setEnabled(true);
			this.btnAdd.setEnabled(false);
			this.btnEdit.setEnabled(false);
			this.btnDelete.setEnabled(false);
			this.listContacts.setEnabled(false);
		}
	}

	// Initialize the contents of the frame.
	private void initialize() {
		frmAspectaddress = new JFrame();
		frmAspectaddress.setResizable(false);
		frmAspectaddress.setTitle("AspectAddress");
		frmAspectaddress.setBounds(100, 100, 716, 400);
		frmAspectaddress.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblFirstname = new JLabel("First name");

		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last name");

		textFieldLastname = new JTextField();
		textFieldLastname.setColumns(10);

		JLabel lblStreet = new JLabel("Street");

		textFieldStreet = new JTextField();
		textFieldStreet.setColumns(10);

		JLabel lblCity = new JLabel("City");

		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);

		JLabel lblState = new JLabel("State");

		JLabel lblZip = new JLabel("ZIP");

		textFieldZIP = new JTextField();
		textFieldZIP.setColumns(10);

		comboBoxState = new JComboBox();
		comboBoxState.setModel(new DefaultComboBoxModel(new String[] { "AA", "AP", "AZ", "AR", "AE", "CA", "CO", "CT",
				"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS",
				"MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD",
				"TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(this);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);

		btnOk = new JButton("Save");
		btnOk.addActionListener(this);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);

		JLabel lblPhone = new JLabel("Phone");

		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmAspectaddress.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblZip, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(textFieldZIP, GroupLayout.PREFERRED_SIZE, 322,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblState, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(comboBoxState, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, 322,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblStreet, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(textFieldStreet, GroupLayout.PREFERRED_SIZE, 322,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblFirstname)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textFieldFirstName,
										GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(textFieldLastname, GroupLayout.PREFERRED_SIZE, 322,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addComponent(btnAdd)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEdit)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnDelete)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnOk)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCancel))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(textFieldPhone, GroupLayout.PREFERRED_SIZE, 322,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING, false).addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblFirstname)
										.addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout.createSequentialGroup().addGap(2).addComponent(lblLastName))
										.addComponent(textFieldLastname, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblStreet))
										.addComponent(textFieldStreet, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblCity))
										.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(8).addComponent(lblState))
										.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(comboBoxState,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblZip))
										.addComponent(textFieldZIP, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(2).addComponent(lblPhone))
										.addComponent(textFieldPhone, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnAdd)
										.addComponent(btnEdit).addComponent(btnDelete).addComponent(btnOk)
										.addComponent(btnCancel)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(14, Short.MAX_VALUE)));

		listContacts = new JList(listModel);
		listContacts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContacts.addListSelectionListener(this);
		scrollPane.setViewportView(listContacts);
		frmAspectaddress.getContentPane().setLayout(groupLayout);
	}

	//Resets input
	private void emptyUI() {
		this.textFieldFirstName.setText(null);
		this.textFieldLastname.setText(null);
		this.textFieldStreet.setText(null);
		this.textFieldCity.setText(null);
		this.textFieldZIP.setText(null);
		this.textFieldPhone.setText(null);
		this.comboBoxState.setSelectedIndex(0);
	}

	//Implementation of actionListener
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "Add") {
			// Reset all input UI
			this.listContacts.clearSelection();
			this.emptyUI();
			// Set state to add mode
			this.state = State.ADD;
		} else if (e.getActionCommand() == "Edit") {
			this.state = State.EDIT;
		} else if (e.getActionCommand() == "Delete") {
			Contact selectedContact = (Contact) listContacts.getSelectedValue();
			if (selectedContact != null) {
				this.c.deleteContact(selectedContact.getId());
			}
			this.emptyUI();
			this.listContacts.setSelectedIndex(0);
		} else if (e.getActionCommand() == "Cancel") {
			// Reset all input UI
			this.emptyUI();
			// Change state to read-only
			this.state = State.VIEW;
		} else if (e.getActionCommand() == "Save") {
			if (this.state == State.ADD) {
				this.c.addContact(this.textFieldFirstName.getText(), this.textFieldLastname.getText(),
						this.textFieldStreet.getText(), this.textFieldCity.getText(),
						(String) this.comboBoxState.getSelectedItem(), this.textFieldZIP.getText(),
						this.textFieldPhone.getText());
				this.state = State.VIEW;
			}
			if (this.state == State.EDIT) {
				Contact toBeUpdated = (Contact) this.listContacts.getSelectedValue();

				this.c.updateContact(toBeUpdated.getId(), this.textFieldFirstName.getText(),
						this.textFieldLastname.getText(), this.textFieldStreet.getText(), this.textFieldCity.getText(),
						(String) this.comboBoxState.getSelectedItem(), this.textFieldZIP.getText(),
						this.textFieldPhone.getText());
				this.state = State.VIEW;

				// Select right contact after update
				this.selectContact(toBeUpdated);
			}
		}
		this.updateUI();
	}

	//Selects a contact in the contact jList
	private void selectContact(Contact c) {
		for (int i = 0; i < this.listContacts.getModel().getSize(); i++) {
			if (this.listContacts.getModel().getElementAt(i).equals(c)) {
				this.listContacts.setSelectedIndex(i);
			}
		}
	}

	//Setter for contacts
	public void setContacts(ArrayList<Contact> contacts) {
		this.listModel.removeAllElements();
		this.contacts = contacts;
		for (Contact contact : this.contacts) {
			this.listModel.addElement(contact);
		}
	}

	//Implementation of ListSelectionListener
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Contact selectedContact = (Contact) listContacts.getSelectedValue();
		if (selectedContact != null) {
			this.textFieldFirstName.setText(selectedContact.getFirstName());
			this.textFieldLastname.setText(selectedContact.getLastName());
			this.textFieldStreet.setText(selectedContact.getStreet());
			this.textFieldCity.setText(selectedContact.getCity());
			this.textFieldZIP.setText(selectedContact.getZip());
			this.textFieldPhone.setText(selectedContact.getPhone());
			this.comboBoxState.setSelectedItem(selectedContact.getState());
		}
	}
}
