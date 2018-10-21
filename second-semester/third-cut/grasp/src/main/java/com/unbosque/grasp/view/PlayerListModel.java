package com.unbosque.grasp.view;

import com.unbosque.grasp.model.PlayerModel;
import javax.swing.*;
import java.util.*;

public class PlayerListModel extends AbstractListModel {

	private ArrayList<PlayerModel> players;

	public PlayerListModel() {
		this.players = new ArrayList<PlayerModel>();
	}

	@Override
	public int getSize() {
		return this.players.size();
	}

	@Override
	public Object getElementAt(int index) {
		PlayerModel player = this.players.get(index);
		return player;
	}

	public void addPlayer(PlayerModel player) {
		this.players.add(player);
		this.fireIntervalAdded(this, this.getSize(), this.getSize());
	}

	public void removePlayer(PlayerModel player) {
		this.players.remove(player);
		this.fireIntervalRemoved(this, 0, this.getSize());
	}

	public void updateList() {
		this.fireContentsChanged(this, 0, this.getSize());
	}
	
}
