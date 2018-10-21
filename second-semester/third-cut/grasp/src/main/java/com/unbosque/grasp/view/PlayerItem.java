package com.unbosque.grasp.view;

import com.unbosque.grasp.model.PlayerModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerItem extends JPanel {

  public static final String UPDATE_BUTTON_COMMAND = "34jk5h34j";
  public static final String REMOVE_BUTTON_COMMAND = "534jk534j";
  
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel levelLabel;
	private JButton updateButton;
	private JButton removeButton;
	private JPanel informationPanel;
	private PlayerModel player;

	public PlayerItem(ActionListener listener) {
		this.idLabel = new JLabel();
		this.nameLabel = new JLabel();
		this.levelLabel = new JLabel();
		this.updateButton = new JButton("update");
		this.updateButton.setActionCommand(UPDATE_BUTTON_COMMAND);
		this.updateButton.addActionListener(listener);
		this.removeButton = new JButton("remove");
		this.removeButton.setActionCommand(REMOVE_BUTTON_COMMAND);
		this.updateButton.addActionListener(listener);
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		
		this.add(updateButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;

		this.add(removeButton, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;

		this.add(this.idLabel, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 2;

		this.add(this.nameLabel);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;

		this.add(this.levelLabel);
	}

	void setPlayer(PlayerModel player) {
		this.player = player;
		this.idLabel.setText("id: " + this.player.getId());
		this.idLabel.setText("name: " + this.player.getName());
		this.idLabel.setText("level: " + this.player.getLevel());
	}

	void clear() {
		this.idLabel.setText("id: ");
		this.idLabel.setText("name: ");
		this.idLabel.setText("level: ");
	}

	PlayerModel getPlayer() {
		return this.player;
	}

}
