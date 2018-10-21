package com.unbosque.grasp.view;

import javax.swing.*;

import com.unbosque.grasp.model.PlayerModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public class PlayerView extends JPanel {

	private JList playerList;
	private PlayerListModel playerListModel;
	private PlayerItem playerItem;

	public PlayerView(ActionListener listener) {
		this.playerItem = new PlayerItem(listener);
		this.playerList = new JList();
		this.playerListModel = new PlayerListModel();
		this.playerList.setModel(this.playerListModel);
		this.setLayout(new BorderLayout());
		this.add(this.playerItem, BorderLayout.CENTER);
		this.add(this.playerList, BorderLayout.SOUTH);		
	}

	public void add(PlayerModel player) {
		this.playerListModel.addPlayer(player);
	}

	public void add(ArrayList<PlayerModel> players) {
		for (int i = 0; i < players.size(); i++) {
			this.playerListModel.addPlayer(players.get(i));
		}
	}

	public void remove(PlayerModel player) {
		this.playerListModel.removePlayer(player);
	}

	public void update() {
		this.playerListModel.updateList();
	}

}
